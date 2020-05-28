package com.xuan.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shenxuan
 * @date 2019/3/22
 **/
@Controller
public class IndexController {
    @RequestMapping("index")
    public String getHome(){
        return "index";
    }

}
