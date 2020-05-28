package com.xuan.business.controller;

import com.xuan.business.service.AdminService;
import com.xuan.business.util.CheckUtil;
import com.xuan.business.exception.CheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author shenxuan
 * @date 2019/3/22
 **/
@RequestMapping("admin")
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {

        //参数非空校验
        CheckUtil.notEmpty(name, "empty");
        CheckUtil.notEmpty(password, "empty");
        LOGGER.info("用户{}进行登录验证", name);
        if (adminService.login(name, password)) {
            session.setAttribute("manager", name);
            LOGGER.info("密码账号正确");
            return "list";
        }
        LOGGER.info("账号或密码错误");
        model.addAttribute("msg", "账号或密码错误");

        return "redirect:/index";
    }

    @ExceptionHandler(value = {CheckException.class})
    public String handlerException(HttpServletRequest req) {
        req.setAttribute("msg", "账号或者密码不能为空");
        return "admin/index";
    }
}
