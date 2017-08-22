package cn.luoze.UserManage.action;

import cn.luoze.UserManage.entity.Care;
import cn.luoze.UserManage.entity.User;
import cn.luoze.UserManage.service.CareService;
import cn.luoze.UserManage.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by luoze on 2017/8/19.
 */

public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;
    @Resource
    CareService careService;

    private Care care;
    private List<Care> careList;

    public List<Care> getCareList() {
        return careList;
    }

    public void setCareList(List<Care> careList) {
        this.careList = careList;
    }

    public Care getCare() {
        return care;
    }

    public void setCare(Care care) {
        this.care = care;
    }

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

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    private List<User> userList;
    private User user;

    //上传文件
    private File headImg;
    private String headImagContentType;
    private String headImgFileName;


    public String listUI() {
        try {
            userList = userService.findObjects();
            System.out.println(userList.size());
            user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");

            System.out.println(user);
            for (int i=0;i<userList.size();i++){
                if (userList.get(i).getId().equalsIgnoreCase(user.getId())){
                    userList.remove(i);
                }
            }

        } catch (Exception e) {
           e.printStackTrace();
        }
        return "listUI";
    }

    public String addUI(){
        return "addUI";
    }
    //保存新增
    public String add(){
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
        return null;
    }
    //跳转到编辑页面
    public String editUI(){
        if (user != null && user.getId() != null) {
            user = userService.findObjectById(user.getId());
        }
        return "editUI";
    }
    //保存编辑
    public String edit() {
        System.out.println("1+:"+user);
        try {
            if (user != null) {
                    if (headImg != null) {
                        //取得绝对路径
                        String filepath = ServletActionContext.getServletContext().getRealPath("upload/user");
                        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
                        System.out.println(filepath + fileName);
                        FileUtils.copyFile(headImg, new File(filepath, fileName));
                        //设置用户头像路径
                        user.setHeadImg("user/" + fileName);
                    }
                userService.update(user);
                ServletActionContext.getRequest().getSession().setAttribute("user",user);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "list";
    }
    //删除
    public String delete(){
        if(user != null && user.getId() != null){
            userService.delete(user.getId());
        }
        return "list";
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String userinfo(){
       user=userService.findObjectById(user.getId());
        return "info";
    }

    public void care() throws IOException {

        String strResult = "false";
        user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
        care.setCare_id(user.getId());
        careList=careService.findObjectByIds(care.getCare_id(),care.getCared_id());
        System.out.println(careList.size());
        if(careList.size()==0){
            careService.save(care);
            strResult="true";
        }

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(strResult.getBytes());
        outputStream.close();
    }

    public void check() throws IOException {
        String strResult = "false";
        user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
        care.setCare_id(user.getId());
        careList=careService.findObjectByIds(care.getCare_id(),care.getCared_id());
        System.out.println(careList.size());
        if(careList.size()==0){
            strResult="true";
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(strResult.getBytes());
        outputStream.close();
    }
    public void caredelete() throws IOException {
        String strResult = "false";
        user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
        care.setCare_id(user.getId());
        careList=careService.findObjectByIds(care.getCare_id(),care.getCared_id());
        System.out.println(careList.size());
        for (int i=0;i<careList.size();i++){
            careService.delete(careList.get(i).getId());
        }
    }

public String  mycared(){
    careList=careService.findObjectByIds(user.getId(),null);
    userList=new ArrayList<User>();
       for (int i = 0;i<careList.size();i++) {
          userList.add( userService.findObjectById(careList.get(i).getCared_id()));
       }
        return "listUI";
}
    public String  careme(){
        careList=careService.findObjectByIds(null,user.getId());
        userList=new ArrayList<User>();
        for (int i = 0;i<careList.size();i++) {
            userList.add( userService.findObjectById(careList.get(i).getCared_id()));
        }
        return "listUI";
    }
}
