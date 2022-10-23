package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.LoginService;
import com.example.demo.utils.response.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/customer")
public class CustomerController  {
    public static String picturePath = "E:\\db_images";

    public static final int MAX_PIC_FILE_SIZE = 10*1024*1024;//10M
    public static final HashSet<String> PIC_FILE_TYPE = new HashSet<String>(){{
        add("image/jpeg");
        add("image/png");
        add("image/gif");
    }}; //头像文件所支持的类型
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LoginService loginService;
    @GetMapping
    public String test(){
        return "hello world";
    }

    /**
     * 返回1表示注册成功，如果有重名注册不成功
     * @param customer
     * @return
     */

    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer){
        return customerMapper.insert(customer.getCustomerName(), customer.getLoginPwd())==1;
    }

    /**
     * true表示有重名
     * @param customer
     * @return
     */
    @PostMapping("/namecheck")
    public boolean nameCheck(@RequestBody Customer customer){
        return customerMapper.nameCheck(customer.getCustomerName()).size()>0;
    }

    @PostMapping("/info")
    public Customer getInfo(@Param("customerId")int customerId){
        System.out.println(customerId);
        return customerMapper.getInfo(customerId).get(0);
    }
    /*"customerId": 1,
            "customerName": "zjh",
            "email": "zjh@163.com",
            "birthday":2022-10-10,
            "phone": 123456789,
            "address": "thu"*/
    @PostMapping("/modifyInfo")
    public boolean modifyInfo(@RequestBody Customer customer){
        System.out.println("-----------------");
        System.out.println(customer.getCustomerId());
        System.out.println(customer.getCustomerName());

        return  customerMapper.modifyInfo(customer.getCustomerId(),
                customer.getCustomerName(), customer.getEmail(), customer.getBirthday(),
                customer.getPhone(),customer.getAddress())==1;
    }

    @PostMapping("/checkPwd")
    public boolean checkPwd(@Param("customerId")int customerId,@Param("loginPwd")String loginPwd){
        String realPwd = customerMapper.getPwdById(customerId);
        return Objects.equals(loginPwd, realPwd);
    }


    @PostMapping("/modifyPwd")
    public boolean modifyPwd(@Param("customerId")int customerId,@Param("loginPwd")String loginPwd){
        return customerMapper.updatePwd(customerId,loginPwd)==1;
    }


    @PostMapping("/pushProfilePic")
    public boolean updateProfilePic(HttpServletRequest request,
                                                   @RequestParam("customerId")int customerId,@RequestParam("img")MultipartFile upload) throws IOException {
        //String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(picturePath);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        upload.transferTo(new File("E:\\db_images",filename));
        //删除之前的头像文件 默认头像文件不能删
        String oldfilePath = customerMapper.getPicWay(customerId);
        if (!oldfilePath.equals("default.jpg")){
            File oldfile = new File(picturePath+"\\"+oldfilePath);
            oldfile.delete();
        }
        customerMapper.updatePicWay(filename,customerId);
        return true;
    }

    @PostMapping("/getProfilePic")
    public String getPicturePath(@RequestParam("customerId")int customerId){
        return picturePath+"\\"+customerMapper.getPicWay(customerId);
    }

}
