package com.example.OCR.utils;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.ocr_api20210707.models.RecognizeAllTextResponse;
import com.aliyun.ocr_api20210707.models.RecognizeIdcardRequest;
import com.aliyun.ocr_api20210707.models.RecognizeIdcardResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcrUtils {

    // 静态变量
    private static String accessKey;

    public static String getAccessKey() {
        return accessKey;
    }

    private static String accessKeySecret;

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    @Value("${ocr.AccessKey}")
    public void setAccessKey(String key) {
        accessKey = key;
    }

    @Value("${ocr.AccessKeySecret}")
    public void setAccessKeySecret(String secret) {
        accessKeySecret = secret;
    }


    private static com.aliyun.ocr_api20210707.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(accessKey)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

    public String analysis() throws Exception {
        com.aliyun.ocr_api20210707.Client client = OcrUtils.createClient();
        com.aliyun.ocr_api20210707.models.RecognizeAllTextRequest recognizeAllTextRequest = new com.aliyun.ocr_api20210707.models.RecognizeAllTextRequest()
                .setUrl("https://img.alicdn.com/tfs/TB1q5IeXAvoK1RjSZFNXXcxMVXa-483-307.jpg")
                .setType("IdCard");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            RecognizeAllTextResponse resp = client.recognizeAllTextWithOptions(recognizeAllTextRequest, runtime);
            return com.aliyun.teautil.Common.toJSONString(resp.body.data);
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            com.aliyun.teautil.Common.assertAsString(error.message);
            return error.getData().get("Recommend").toString();
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            com.aliyun.teautil.Common.assertAsString(error.message);
            return error.getData().get("Recommend").toString();
        }
    }

    public String analysisFile(MultipartFile file, String type) throws Exception {
        com.aliyun.ocr_api20210707.Client client = OcrUtils.createClient();

        InputStream inputStream = file.getInputStream();

        //这是上传本地图片的
        RecognizeIdcardRequest request = new RecognizeIdcardRequest();
        request.body = inputStream;

        //识别本地图片才要上传，但只是new一个实例进行传参，也没做什么
        RuntimeOptions runtimeOptions = new RuntimeOptions();

        RecognizeIdcardResponse response = null;


        try {
            response = client.recognizeIdcardWithOptions(request, runtimeOptions);
            return com.aliyun.teautil.Common.toJSONString(response.body.data);

        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            com.aliyun.teautil.Common.assertAsString(error.message);
            return error.getData().get("Recommend").toString();
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            com.aliyun.teautil.Common.assertAsString(error.message);
            return error.getData().get("Recommend").toString();
        }
    }
}