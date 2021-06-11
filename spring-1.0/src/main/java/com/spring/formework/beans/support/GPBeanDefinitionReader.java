package com.spring.formework.beans.support;

import com.spring.formework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GPBeanDefinitionReader {

    private Properties config = new Properties();

    private List<String> registyBeanClasses = new ArrayList<>();



    public GPBeanDefinitionReader(String... locations) {
        InputStream classpath = this.getClass().getClassLoader()
                .getResourceAsStream(locations[0].replace("classpath", ""));

        try {
            config.load(classpath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert classpath != null;
                classpath.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        doScanner(config.getProperty("scan_packge"));
    }

    private void doScanner(String property) {

        URL url = this.getClass().getClassLoader().getResource("./" + property.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if(file.isDirectory()){
                doScanner(property + "." + file.getName());
            }else{
                if(!file.getName().endsWith(".class")){ continue;}
                String className = (property + "." + file.getName().replace(".class",""));
                registyBeanClasses.add(className);
            }
        }

    }

    public Properties getConfig(){
        return this.config;
    }



    public List<GPBeanDefinition> loadBeanDefinitions(){



        return null;
    }

}
