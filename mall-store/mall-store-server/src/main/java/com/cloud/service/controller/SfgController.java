package com.cloud.service.controller;

import com.cloud.service.syn.Parts;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zuyunbo
 * @Date 2021/8/26  2:26 下午
 **/

@RestController
@RequestMapping("/dynamic")
public class SfgController {


    @RequestMapping(value="/alert/query",method= RequestMethod.POST)
    public String sayHello(@RequestBody Parts parts){
        return "{\"msg\":\"成功¦\",\"code\":\"200\",\"data\":{\"alertUserVOPage\":{\"total\":\"0\",\"totalPages\":0,\"page\":1,\"rows\":20,\"content\":[],\"totalElements\":\"0\"},\"notHandleNum\":\"0\"},\"requestId\":\"\",\"custom\":\"\"}";
    }

    public void sss(){

        System.out.println("123");
    }

    @RequestMapping(value="/snapshot/query/count",method= RequestMethod.POST)
    public String sayHellos(@RequestBody Parts parts){
        return "{" +
                "\"code\":\"200\",\n" +
                "\"msg\":\"操作成功\",\n" +
                "\"requestId\":\"\",\n" +
                "\"data\":{\n" +
                "\"total\":1048036\n" +
                "},\n" +
                "\"custom\":\"\"\n" +
                "}";
    }



}
