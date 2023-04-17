package com.lin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: springmvc
 * @description: 测试modelAndView
 * @author: linsz
 * @create: 2022-06-27 15:55
 **/
@Controller
public class ModelAndViewController {

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("testModelAndViewScope", "hello, modelAndView");
        mv.setViewName("success");
        System.out.println("this is model and view");
        return mv;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testModelAndViewScope", "hello model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testModelAndViewScope", "hello ,map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testModelAndViewScope", "hello,modelMap");
        return "success";
    }

    /**
     * 测试请求转发
     *
     * @return 结果： http://localhost:8080/springmvc/testForward
     * 请求转发， 服务器内部使用 地址栏不发生改变到跳转后的路径
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/target";
    }

    /**
     * 测试重定向
     * 结果 http://localhost:8080/springmvc/target
     * 地址栏发生改变到重定向所规定的路径
     *
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/target";
    }
}
