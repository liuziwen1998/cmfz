package com.baizhi.controller;

import com.baizhi.config.CreateValidateCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("img")
public class imgController {


    @RequestMapping("/img")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception{
        CreateValidateCode createValidateCode = new CreateValidateCode();
        String code = createValidateCode.getCode();
        request.getSession().setAttribute("code",code);
        createValidateCode.write(httpServletResponse.getOutputStream());
    }
}
