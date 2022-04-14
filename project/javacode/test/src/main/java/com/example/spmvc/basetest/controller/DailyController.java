package com.example.spmvc.basetest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

//import javafx.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import com.example.spmvc.basetest.utils.javaweb.IpUtil;
import com.example.spmvc.basetest.utils.tencentCloud.TencentcloudapiUsual;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * FeatureController
 * 图层矢量数据的处理
 *
 * @author WangXu
 * @date 2022/01/20
 */
@Api(tags = "日常应用")
@Controller
@RequestMapping("/daily")
public class DailyController {
    @ApiOperation(value = "修改准许ip", notes = "安全地修改准许ip", httpMethod = "PUT")
    @GetMapping("ip")
    @ResponseBody
    public String getTC(HttpServletRequest request, String psd) {
        Date now = new Date(); // 创建一个Date对象，获取当前时间
        // 指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("HHddMM");
        System.out.println(f.format(now)); // 将当前时间袼式化为指定的格式

        System.out.println(psd);
        System.out.println("test3 start------------");

        String ip = IpUtil.getIpAddr(request);
        System.out.println(ip);

        return TencentcloudapiUsual.changeTCSecurityOne(ip) + "参数： " + psd + "  时间：" + now;
    }

}
