package com.cloud.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @Author zuyunbo
 * @Date 2021/8/9  12:56 下午
 **/

@Api(tags = "ds")
@RestController
@RequestMapping(value = "/file")
public class ImageController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);


    @ApiOperation(value = "档案背景图，返回二进制图片")
    @GetMapping("/image")
    public ResponseEntity<String> queryImageBytes(@NotNull String urlstr, HttpServletResponse response) {
        netImageToBase64(urlstr, response);
        return ResponseEntity.ok("ok");
    }


    /**
     * 获取 图片流 转换为 字节数组
     *
     * @param url , response
     * @return
     * @throws IOException
     */
    public static void netImageToBase64(String url, HttpServletResponse response) {
        String filename = UUID.randomUUID() + ".png";
        OutputStream out = null;
        InputStream inStream = null;
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setRequestMethod("GET");
            con.setReadTimeout(4 * 1000);
            // 通过输入流获取图片数据
            inStream = con.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            byte[] data = outStream.toByteArray();
            response.setContentType("png/jpg");
            response.setHeader("Content-Disposition", "attachment" + ";filename=\"" +
                    URLEncoder.encode(filename, "UTF-8") + "\"");
            out = response.getOutputStream();
            out.write(data);
        } catch (Exception e) {
            LOGGER.error("发起请求出现异常: {}", e.getMessage());
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
