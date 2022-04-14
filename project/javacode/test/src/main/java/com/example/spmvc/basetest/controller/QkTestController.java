package com.example.spmvc.basetest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import com.example.spmvc.basetest.utils.javaweb.IpUtil;
import com.example.spmvc.basetest.utils.tencentCloud.TencentcloudapiUsual;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * FeatureController
 * 图层矢量数据的处理
 *
 * @author WangXu
 * @date 2020/10/23
 */
@Api(tags = "快速测试")
@Controller
@RequestMapping("/qktest")
public class QkTestController {

    @ApiOperation(value = "测试模板", notes = "快速测试模板", httpMethod = "GET")
    @GetMapping("")
    @ResponseBody
    public String test0() {
        System.out.println("test succeed 测试成功");
        return "测试成功";
    }

    @ApiOperation(value = "不定参数测试模板", notes = "快速测试模板", httpMethod = "GET")
    // @ApiImplicitParams({
    //         @ApiImplicitParam(paramType = "query",name = "name", dataType = "string", value = "only return models..."),
    //         @ApiImplicitParam(paramType = "query",name = "name0", dataType = "string", value = "only return models...")
    //         // @ApiImplicitParam(paramType = "header", name = "X-Access-Token", value = "token标记", dataType = "String"),
    // })
    @GetMapping("testParams")
    @ResponseBody
    public String testParams(@ApiIgnore @RequestParam Map<String, Object> params) {
        System.out.println(params);
        System.out.println("test succeed 测试成功");
        return "测试成功";
    }


}
