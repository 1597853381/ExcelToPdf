package com.xxm.test.zyl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spire.cloud.excel.sdk.ApiException;
import spire.cloud.excel.sdk.api.GeneralApi;
import spire.cloud.excel.sdk.model.ExportFormat;

import java.io.File;

@SpringBootTest
class ZylApplicationTests {

/*    private static String appId = "bb85fe9783428f6f8d93db66c02645e0";

    private static String appKey = "vBXYd6KS03gjFZaHyLZ33NFZbQMX9ThE";*/

    @Test
    void contextLoads() throws ApiException {
/*        //创建GeneralApi实例并配置账号信息
        GeneralApi generalApi = new GeneralApi(appId, appKey);
        //配置相关参数
        String format = ExportFormat.PDF.toString();
        String inputFilePath = "C:\\Users\\Administrator\\Desktop\\周工作计划总结表-肖新民-20200614.xls";
        File data = new File(inputFilePath );
        String outputFilePath = "C:\\Users\\Administrator\\Desktop\\test.pdf";
        String password = "1597853381";

        //调用putWorkbookConvert接口将文档保存为PDF
        //generalApi.putWorkbookConvert(format,outputFilePath,data, password);
        generalApi.convertInRequestToPath(format,outputFilePath,data,password);
        generalApi.convertInRequest(format,data,password);*/
    }

}
