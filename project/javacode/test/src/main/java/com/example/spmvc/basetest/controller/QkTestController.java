package com.example.spmvc.basetest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.spmvc.basetest.utils.javaweb.IpUtil;
import com.example.spmvc.basetest.utils.tencentCloud.TencentcloudapiUsual;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import springfox.documentation.annotations.ApiIgnore;

/**
 * FeatureController
 * 图层矢量数据的处理
 *
 * @author WangXu
 * @date 2020/10/23
 */
@Tag(name = "快速测试", description = "the user API")
@Controller
@RequestMapping("/qktest")
public class QkTestController {

    @Operation(summary = "doc测试模板", description = "快速测试模板")
    @GetMapping("")
    @ResponseBody
    public String test0() {
        System.out.println("test succeed 测试成功");
        return "测试成功";
    }

    @Operation(summary = "不定参数测试模板", description = "快速测试模板")
    // @ApiImplicitParams({
    //         @ApiImplicitParam(paramType = "query",name = "name", dataType = "string", summary = "only return models..."),
    //         @ApiImplicitParam(paramType = "query",name = "name0", dataType = "string", summary = "only return models...")
    //         // @ApiImplicitParam(paramType = "header", name = "X-Access-Token", summary = "token标记", dataType = "String"),
    // })
    @GetMapping("testParams")
    @ResponseBody
    public String testParams( @RequestParam Map<String, Object> params) {
        System.out.println(params);
        System.out.println("test succeed 测试成功");
        return "测试成功";
    }


}
