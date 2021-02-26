package com.cloud.service.service;


import com.cloud.service.entity.ColumnEntity;
import com.cloud.service.service.impl.EntityCode;
import com.cloud.service.util.DateUtils;
import com.cloud.service.util.Utils;
import lombok.extern.slf4j.Slf4j;
import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @2u
 */
@Slf4j
public class GenerateCodePathConfig {


    public static String getEntityPath(){
        File directory = new File("");
        return directory.getAbsolutePath() + File.separator +"mall-store"+File.separator+"mall-store"+"-entity" + AutoGenConfig.projectPath + File.separator +
                AutoGenConfig.srcBasePath + File.separator
                + AutoGenConfig.entityPackageOutPath.replace(".", File.separator) + File.separator;
    }

    public static String getDaoPath(){
        File directory = new File("");
        return directory.getAbsolutePath() + File.separator +"mall-store"+File.separator+"mall-store"+ "-biz" + AutoGenConfig.projectPath + File.separator +
                AutoGenConfig.srcBasePath + File.separator
                + AutoGenConfig.daoPackageOutPath.replace(".", File.separator) + File.separator;
    }

    public static String getControllerPath(){
        File directory = new File("");
        return directory.getAbsolutePath() + File.separator +"mall-store"+File.separator+"mall-store" +"-controller"+ AutoGenConfig.projectPath + File.separator +
                AutoGenConfig.srcBasePath + File.separator
                + AutoGenConfig.controllerPackageOutPath.replace(".", File.separator) + File.separator;
    }

    public static String getXmlPath(){
        File directory = new File("");
        return directory.getAbsolutePath() + File.separator +"mall-store"+File.separator+"mall-store" +"-biz"+ AutoGenConfig.projectPath + File.separator +
                AutoGenConfig.resBasePath + File.separator;
    }


    public static Map<String, Object> getCodeMap(TableEntity autoGenEntity,String packages,String moduleName){
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", autoGenEntity.getTableName());
        map.put("comments", autoGenEntity.getComments());
        map.put("className", autoGenEntity.getClassName());
        map.put("classNames", StringUtils.uncapitalize(autoGenEntity.getClassName()));
        map.put("columns", autoGenEntity.getColumns());
        map.put("version", AutoGenConfig.version);
        map.put("package", packages);
        map.put("moduleName", moduleName);
        map.put("author", AutoGenConfig.author);
        map.put("email", "c1111");
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        map.put("date", DateUtils.format(new Date(), DateUtils.DATE_PATTERN));
        for(ColumnEntity columnEntity: autoGenEntity.getColumns()){
            //列名转换成Java属性名
            String attrName = EntityCode.columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAddrNames(StringUtils.uncapitalize(attrName));
            //列的数据类型，转换成Java类型
            String attrType = EntityCode.sqlType2JavaType(columnEntity.getDataType());
            columnEntity.setAttrType(attrType);
        }
        return map;
    }


    public static void writeCode(Map<String, Object> codeMap, String codePath, String basePath, String implPath, String name) {
        VelocityContext context = new VelocityContext(codeMap);
        StringWriter sw = new StringWriter();
        Template template = Velocity.getTemplate(codePath, "UTF-8");
        template.merge(context, sw);
        try {
            String entityPath = basePath + implPath + File.separator
                    + Utils.initcap(name) + ".java";
            if(name.contains("xml")){
                entityPath =basePath + implPath + File.separator
                        + Utils.initcap(name) ;
            }

            Utils.writeFile(entityPath, sw.toString());
        } catch (Exception e) {
            log.error("============>     {}" ,e.getMessage());
        }
    }

}
