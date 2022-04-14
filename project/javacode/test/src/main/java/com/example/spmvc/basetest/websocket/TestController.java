package com.example.spmvc.basetest.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController
 *
 * @author Wangxu
 * @date 2022/4/14
 */
@Controller
@RequestMapping("/api/test")
//@Api(description = "服务器向客户端推送消息接口", tags = "Test")
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;
    /**
     * 启动页面
     * @return
     */
    @GetMapping("/start")
    public String start(){
        return "index";
    }

    @PostMapping("/pushToWeb")
//    @ApiOperation(value = "服务器端向客户端推送消息", notes = "服务器端向客户端推送消息")
//    public ResponseBean<?> pushToWeb(@RequestBody @ApiParam(value = "回收人编码和医院编码", required = true) CodesInfo info){
    public ResponseBean pushToWeb(){

        testServiceImpl.printTime();
        return ResponseBean.ok("wxwxw");
    }

}

