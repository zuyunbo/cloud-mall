package com.cloud.cloudgeccoserver.lmada;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author zuyunbo
 * @Date 2021/8/9  12:56 下午
 **/

@RestController
@RequestMapping(value = "/file")
public class ImageController {

    @GetMapping("/image")
    public ResponseEntity<String> queryImageBytes( String urlstr) throws InterruptedException {
        Thread.sleep(100000);
        return ResponseEntity.ok("ok");
    }

}
