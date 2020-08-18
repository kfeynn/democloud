package cn.grand.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DefaultController
{
    @RequestMapping("/")
    @ResponseBody
    public String index(Model model) {

        System.out.println("----------eeeeeeeeeeeeeeeeee------------");
        //跳转到默认首页
        return "redirect:Home/Default2";
    }
}
