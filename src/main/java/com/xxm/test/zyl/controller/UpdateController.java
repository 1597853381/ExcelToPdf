package com.xxm.test.zyl.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.spire.xls.FileFormat;
import com.spire.xls.TextRotationType;
import com.spire.xls.Workbook;
import com.xxm.test.zyl.service.TestForExcel2PDF;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("/upload")
public class UpdateController {

    @Autowired
    private FastFileStorageClient client;

    private String path = "upload/";

    @PostMapping("/test")
    private String uploadFile(MultipartFile fileToUpload, String fileurl, String filetype, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String originalFilename = fileToUpload.getOriginalFilename();
        String orgPath = path + "/" + originalFilename;
        File saveFile = new File(new File(path).getAbsolutePath()+ "/" + originalFilename);
        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        fileToUpload.transferTo(saveFile);
        String newPath = orgPath.replace(".xlsx", ".pdf");
        //已完成文件转换
        TestForExcel2PDF.excel2pdf(orgPath, newPath);

        //上传文件
        File newFile = new File(newPath);
        FileInputStream fileInputStream = new FileInputStream(newFile);
        StorePath storePath =
                client.uploadFile(
                        fileInputStream, newFile.length(), "pdf", null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getGroup());
        System.out.println(storePath.getPath());
        return "39.107.252.103/"+storePath.getFullPath();


    }


}
