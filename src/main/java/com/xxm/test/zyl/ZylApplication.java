package com.xxm.test.zyl;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)
public class ZylApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZylApplication.class, args);
    }

}
