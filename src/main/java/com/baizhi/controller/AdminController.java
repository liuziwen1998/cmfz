package com.baizhi.controller;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/lg")
    public String  queryOne(String name, String password,String enCode, HttpSession session){
    String code = (String) session.getAttribute("code");
    if (!enCode.equalsIgnoreCase(code)){
     return  "redirect:/login.jsp";
    }
    Admin admin = new Admin(null,name,password);
    Admin adm = adminService.queryOne(admin);
    if (adm!=null){
        session.setAttribute("username",admin.getName());
        return  "redirect:/main/main.jsp";
    }else{
        return  "redirect:/login.jsp";
    }

    }

}
