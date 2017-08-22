package cn.luoze.login.action;

import cn.luoze.UserManage.entity.User;
import cn.luoze.UserManage.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by luoze on 2017/8/19.
 */
public class LoginAction extends ActionSupport {
    @Resource
    private UserService userService;
    private User user;
    private String loginResult;

    //上传文件
    private File headImg;
    private String headImagContentType;
    private String headImgFileName;

    public File getHeadImg() {
        return headImg;
    }

    public void setHeadImg(File headImg) {
        this.headImg = headImg;
    }

    public String getHeadImagContentType() {
        return headImagContentType;
    }

    public void setHeadImagContentType(String headImagContentType) {
        this.headImagContentType = headImagContentType;
    }

    public String getHeadImgFileName() {
        return headImgFileName;
    }

    public void setHeadImgFileName(String headImgFileName) {
        this.headImgFileName = headImgFileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public String toLoginUI(){
        return "loginUI";
    }

    public String login(){
        if(user!=null){
            if(StringUtils.isNotBlank(user.getAccount())&& StringUtils.isNotBlank(user.getPassword())){
                //根据账户 密码查询用户列表
                List<User> list=userService.findUserByAccountAndPass(user.getAccount(),user.getPassword());
                if(list!=null&&list.size()>0){
                    User user=list.get(0);
                    //将登陆信息存放到session域对象中
                    ServletActionContext.getRequest().getSession().setAttribute("user",user);
                    //将登陆记录到日志文件中去
                    Log log = LogFactory.getLog(getClass());
                    log.info("用户名称为"+user.getName()+" 的用户登陆了系统");
                    return "list";
                }else{
                    loginResult=" 账号或密码不正确!";
                }
            }else {
                loginResult="账号或密码不能为空！";
            }
        }else{
            loginResult="请输入账号和密码！";
        }
        return toLoginUI();
    }
    public String logout(){
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        return toLoginUI();
    }

    public String toregister(){
        return "toregister";
    }


    public String register(){
        System.out.println(user);
        try {
            if(user != null){
                if(headImg!=null){
                    //取得绝对路径
                    String filepath=ServletActionContext.getServletContext().getRealPath("upload/user");

                    String fileName= UUID.randomUUID().toString().replaceAll("-","")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
                    System.out.println(filepath+fileName);
                    FileUtils.copyFile(headImg,new File(filepath,fileName));
                    //设置用户头像路径
                    user.setHeadImg("user/"+fileName);
                    userService.save(user);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toLoginUI();
    }

}
