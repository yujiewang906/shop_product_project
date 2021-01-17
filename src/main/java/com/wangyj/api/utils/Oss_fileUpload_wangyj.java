package com.wangyj.api.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class Oss_fileUpload_wangyj {

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        private static String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        private static String accessKeyId = "LTAI4G98wyb3Fq1DBf8Uanff";
        private static String accessKeySecret = "fIu69jCoJpy8tcX64M9q88vYQW0EQY";
        private static String bucket = "store-photo";

        /*
           is  输入流

           fileName  保存的名字  //可以包含路径

         */
        public static String uploadFile(InputStream is, String fileName) {
            // 下载jar包
            //创建工具类
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            //调用上传方法
            PutObjectResult putObjectResult = ossClient.putObject(bucket, fileName, is);
            //判断是否上传成功
            //释放资源
            ossClient.shutdown();
            //返回文件的存储路径
            return "https://" + bucket + "." + endpoint + "/" + fileName;
        }


}
