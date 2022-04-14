package com.example.spmvc.basetest.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.example.spmvc.basetest.utils.javaweb.IpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author WangXu
 * @date 2020/10/23
 */
@Tag(name = "初始控制器")
@Controller
@RequestMapping("")
public class HelloController {

    @Operation(summary = "文档", description = "转发到swagger文档")
    @GetMapping("doc")
    public String toSwagger() {
        // return "forward:/swagger-ui/index.html";
        return "redirect:/swagger-ui/index.html";
    }

    // @GetMapping("a")
    // public String a() {
    // // return "forward:/swagger-ui/index.html";
    // return "redirect:/b.html";
    // }

    @Operation(summary = "get连接测试", description = "初始快速连接测试")
    @GetMapping("connect")
    @ResponseBody
    public String test0() {
        System.out.println("connect succeed 连接成功");
        return "connect succeed 连接成功";
    }

    // 传参测试
    @GetMapping("getparam")
    @ResponseBody
    public String getTC(HttpServletRequest request, String param) {
        Date now = new Date(); // 创建一个Date对象，获取当前时间

        String ip = IpUtil.getIpAddr(request);

        return "时间：" + now.toString() + "  ip: " + ip + "  参数：" + param;
    }

    // 传参测试
    @GetMapping("getparam1")
    @ResponseBody
    public String getparam1(String param, String param1) {
        Date now = new Date(); // 创建一个Date对象，获取当前时间

        return "时间：" + now.toString() + param + "::::" + param1;
    }

}
