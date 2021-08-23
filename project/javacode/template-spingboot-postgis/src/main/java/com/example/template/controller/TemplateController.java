package com.example.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板controller
 * 标准restful标准的控制转发
 * <br>
 *
 * @author xianyu
 *  * @date 2021/1/12
 * @since JDK1.8
 */
@RestController//用于标注控制层组件@ResponseBody和@Controller的合集。指定为json传数据前后端分离模式
@RequestMapping("/template")

public class TemplateController {
    @GetMapping("/get")
    public Map<String,String>   template(){
        Map<String,String> template= new HashMap<>();
        template.put("1","11");
        template.put("2","24");
        template.put("23","2324");
        System.out.println(template);
        return template;
    }

}
