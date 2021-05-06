package com.cloud.service.test.mapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/4/23  3:42 下午
 **/
public class Testamin {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            hashMap.put("key-"+i, "value-"+i);
        }

        System.out.println(hashMap);

        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        Map.Entry<String, String> entry;
        while (iterator.hasNext()){
            entry = iterator.next();
            // 放入新的Entry
            hashMap.put("prefix-"+ entry.getKey(), entry.getValue());
            // 删除老的Entry
            iterator.remove();
        }

        System.out.println("结果：");
        System.out.println(hashMap);
/*
        Map<String, String> characterStringMap = new HashMap();
        characterStringMap.put("Node GUID", "1");
        characterStringMap.put("BOM level", "01");
        characterStringMap.put("Common Type", "assembly");
        Iterator<Map.Entry<String, String>> iterator = characterStringMap.entrySet().iterator();
        Map.Entry<String, String> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            // 往newMap中放入新的Entry
            if("Node GUID".equals(entry.getKey())){
                characterStringMap.put("Common Weight",entry.getValue());
                iterator.remove();
            }
            if("BOM level".equals(entry.getKey())){
                characterStringMap.put("Common Weight type",entry.getValue());
                iterator.remove();
            }
        }*/

    }

}
