package com.cloud.service;

import com.cloud.service.impl.AnalyseFileContentPartServiceImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:27 下午
 **/
public class TestMain {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream bis = null;
        bis = new BufferedInputStream(new FileInputStream(new File("/Users/zuyunbo/202101/xsd/GWM_PK1E_DS_20201216_1014.stpx")));
        AnalyseFileContentPartServiceImpl analyseFileContentPartService = new AnalyseFileContentPartServiceImpl();
        analyseFileContentPartService.analyseFileContent(bis);
    }

}
