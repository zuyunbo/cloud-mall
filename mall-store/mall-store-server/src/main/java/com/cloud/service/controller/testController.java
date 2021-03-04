package com.cloud.service.controller;

import com.cloud.cloudbaseutil.base.controller.GeneratorController;
import com.cloud.entity.CUser;
import com.cloud.service.CUserService;
import com.cloud.service.test.SaveController;
import com.cloud.service.test.SuperController;
import com.cloud.service.test.SuperSimpleController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/3/2  11:34 上午
 **/
@RestController
@RequestMapping("/test")
public class testController extends SuperController<CUserService,CUser ,CUser> {

    @GetMapping("/code1")
    public String generator1(){
          return "111";
    }


    public static void main(String[] args) {
        try {
            Method testType = testController.class.getMethod("testType", List.class, List.class, List.class, List.class, List.class, Map.class);
            Type[] genericParameterTypes = testType.getGenericParameterTypes();
            for(Type type : genericParameterTypes){
                ParameterizedType type1 = (ParameterizedType) type;
                Type[] actualTypeArguments = type1.getActualTypeArguments();
                for(int i=0 ; i<actualTypeArguments.length;i++){
                    Type type2 = actualTypeArguments[i];
                    System.out.println(i + "  类型【" + type2 + "】\t类型接口【" + type2.getClass().getInterfaces()[0].getSimpleName() + "】");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> void testType(List<String> a1 , List<ArrayList<String>> a2, List<T> a3, List<? extends Number> a4, List<ArrayList<String[]>> a5, Map<String,Integer> a6){

    }

}
