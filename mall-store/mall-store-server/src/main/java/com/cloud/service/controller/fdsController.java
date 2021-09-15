package com.cloud.service.controller;

import com.cloud.param.CApplicationParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @Author zuyunbo
 * @Date 2021/6/29  2:08 下午
 **/

@RestController
@RequestMapping("/face-api/v3/face/add")
public class fdsController {


    @RequestMapping(value="/add",method= RequestMethod.POST)
    public String sayHello(@PathVariable("action_type") String id,@PathVariable("appid") String name,
                           @PathVariable("group_id") String name1,
                           @PathVariable("image") String name2){
        return "id:"+id+" name:"+name+"name2"+name1+"name3"+name2;
    }






    @PostMapping("/archive/saas/documents/image")
    public String fdsfds(HttpServletResponse response,@RequestBody  Fd fd) {
        System.out.println(fd.getFace());
        System.out.println(fd.getSimilar());

        return "{\n" +
                "\t\"exception\": null,\n" +
                "\t\"data\": [{\n" +
                "\t\t\t\"id\": \"3eb13eccf49b49629da19faf06637bae\",\n" +
                "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
                "\t\t\t\"imageNum\": \"9.0909\",\n" +
                "\t\t\t\"placeNum\": \"4.1667\",\n" +
                "\t\t\t\"timeNum\": \"1.0417\",\n" +
                "\t\t\t\"level\": \"极高\",\n" +
                "\t\t\t\"score\": \"89.7064\",\n" +
                "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
                "\t\t\t\"conflict\": false,\n" +
                "\t\t\t\"updateTime\": \"20180824143020\",\n" +
                "\t\t\t\"content\": [{\n" +
                "\t\t\t\t\"sourceId\": 123456\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"sourceId\": 345678\n" +
                "\t\t\t},{\n" +
                "\t\t\t\t\"sourceId\": 56789\n" +
                "\t\t\t}]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": \"5d2ab9065630450894d3080e18c4dc60\",\n" +
                "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
                "\t\t\t\"imageNum\": \"9.0909\",\n" +
                "\t\t\t\"placeNum\": \"4.1667\",\n" +
                "\t\t\t\"timeNum\": \"1.0417\",\n" +
                "\t\t\t\"level\": \"极高\",\n" +
                "\t\t\t\"score\": \"4.7064\",\n" +
                "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
                "\t\t\t\"conflict\": false,\n" +
                "\t\t\t\"updateTime\": \"20180824133700\",\n" +
                "\t\t\t\"content\": {\n" +
                "\t\t\t\t\"sourceId\": 89077-00\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"5d2ab9065630450894d3080e18c4dc60\",\n" +
                "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
                "\t\t\t\"imageNum\": \"9.0909\",\n" +
                "\t\t\t\"placeNum\": \"4.1667\",\n" +
                "\t\t\t\"timeNum\": \"1.0417\",\n" +
                "\t\t\t\"level\": \"极高\",\n" +
                "\t\t\t\"score\": \"98.7064\",\n" +
                "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
                "\t\t\t\"conflict\": false,\n" +
                "\t\t\t\"updateTime\": \"20180824133700\",\n" +
                "\t\t\t\"content\": {\n" +
                "\t\t\t\t\"sourceId\": 321321\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"code\": 200,\n" +
                "\t\"msg\": \"结果正常\"\n" +
                "}";
    }


    @PostMapping("/abf/api/v1/aggregation/cobject/delete")
    public String fdsfds1() {
      return "{\n" +
              "\t\"exception\": null,\n" +
              "\t\"data\": [{\n" +
              "\t\t\t\"id\": \"3eb13eccf49b49629da19faf06637bae\",\n" +
              "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
              "\t\t\t\"imageNum\": \"9.0909\",\n" +
              "\t\t\t\"placeNum\": \"4.1667\",\n" +
              "\t\t\t\"timeNum\": \"1.0417\",\n" +
              "\t\t\t\"level\": \"极高\",\n" +
              "\t\t\t\"score\": \"89.7064\",\n" +
              "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
              "\t\t\t\"conflict\": false,\n" +
              "\t\t\t\"updateTime\": \"20180824143020\",\n" +
              "\t\t\t\"content\": [{\n" +
              "\t\t\t\t\"sourceId\": 123456\n" +
              "\t\t\t}, {\n" +
              "\t\t\t\t\"sourceId\": 345678\n" +
              "\t\t\t},{\n" +
              "\t\t\t\t\"sourceId\": 56789\n" +
              "\t\t\t}]\n" +
              "\t\t},\n" +
              "\t\t{\n" +
              "\t\t\t\"id\": \"5d2ab9065630450894d3080e18c4dc60\",\n" +
              "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
              "\t\t\t\"imageNum\": \"9.0909\",\n" +
              "\t\t\t\"placeNum\": \"4.1667\",\n" +
              "\t\t\t\"timeNum\": \"1.0417\",\n" +
              "\t\t\t\"level\": \"极高\",\n" +
              "\t\t\t\"score\": \"4.7064\",\n" +
              "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
              "\t\t\t\"conflict\": false,\n" +
              "\t\t\t\"updateTime\": \"20180824133700\",\n" +
              "\t\t\t\"content\": {\n" +
              "\t\t\t\t\"sourceId\": 89077-00\n" +
              "\t\t\t}\n" +
              "\t\t}, {\n" +
              "\t\t\t\"id\": \"5d2ab9065630450894d3080e18c4dc60\",\n" +
              "\t\t\t\"humanNo\": \"110109199010101122\",\n" +
              "\t\t\t\"imageNum\": \"9.0909\",\n" +
              "\t\t\t\"placeNum\": \"4.1667\",\n" +
              "\t\t\t\"timeNum\": \"1.0417\",\n" +
              "\t\t\t\"level\": \"极高\",\n" +
              "\t\t\t\"score\": \"98.7064\",\n" +
              "\t\t\t\"imageUrl\": \"http://10.153.106.13:8388/viip/file/image/5b7f7ea5242efb025fb59455\",\n" +
              "\t\t\t\"conflict\": false,\n" +
              "\t\t\t\"updateTime\": \"20180824133700\",\n" +
              "\t\t\t\"content\": {\n" +
              "\t\t\t\t\"sourceId\": 321321\n" +
              "\t\t\t}\n" +
              "\t\t}\n" +
              "\t],\n" +
              "\t\"code\": 200,\n" +
              "\t\"msg\": \"结果正常\"\n" +
              "}";
    }




    @PostMapping("/loginProcess")
    public String addUser2(HttpServletResponse response, Fd fd) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }

    @PostMapping("/hello")
    public String addUser21(@RequestBody te face) {
        System.out.println("123"+ face.getFace());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123";
    }

    static class te{
        String face;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }
    }




    @PostMapping("/dynamic/search/match")
    public String addUser21(@RequestBody Fd fd, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach(System.out::println);

        System.out.println(fd.imageBase64One);
        System.out.println(fd.imageBase64Two);
        Map<String,String > stringStringMap = new HashMap<>();
        stringStringMap.put("score","100");
        String age = "{\"code\": 200,\n" +
                "           \"msg\": \"server.build_result_dict.SUCCESS_STR\",\n" +
                "           \"data\":{\"score\" : \"100\"},         \n" +
                " \"requestId\": \"\",\n" +
                "           \"custom\": \"\"\n" +
                "           }";
        return age;
    }


    static class Fd{
        String username;
        String imageBase64One;
        String imageBase64Two;
        String password;

        String face;

        String similar;


        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getSimilar() {
            return similar;
        }

        public void setSimilar(String similar) {
            this.similar = similar;
        }

        public String getImageBase64One() {
            return imageBase64One;
        }

        public void setImageBase64One(String imageBase64One) {
            this.imageBase64One = imageBase64One;
        }

        public String getImageBase64Two() {
            return imageBase64Two;
        }

        public void setImageBase64Two(String imageBase64Two) {
            this.imageBase64Two = imageBase64Two;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
