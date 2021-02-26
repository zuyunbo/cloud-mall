package com.cloud.service.controller;
import com.cloud.service.config.AutoInterface;
import com.cloud.service.config.impl.AutoInterfaceImpl;
import com.cloud.service.service.GenerateCode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zuyunbo
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(String tables, HttpServletResponse response) throws IOException {
        AutoInterface autoInterface = new AutoInterfaceImpl() {
            @Override
            public GenerateCode getGenerateCodes() {
                return super.getGenerateCodes();
            }
        };
        autoInterface.connectionJDBC(tables);
        GenerateCode generateCodes = autoInterface.getGenerateCodes();
        generateCodes.isToExecute();
    }

    public static void main(String[] args) {

    }
}
