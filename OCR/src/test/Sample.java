import com.aliyun.ocr_api20210707.models.RecognizeAllTextResponse;
import com.aliyun.tea.*;

public class Sample {

    private static final String ALIBABA_CLOUD_ACCESS_KEY_ID = "LTAI5tQ412T4NN8g86RnWCyA";
    private static final String ALIBABA_CLOUD_ACCESS_KEY_SECRET = "GrAvpCKlHETdJZHNBxcztGm1hghmMQ";

    private static final String ALIBABA_CLOUD_ACCESS_KEY_ID_ME = "LTAI5tCHYhuhc4kvK9ZPtPkc";
    private static final String ALIBABA_CLOUD_ACCESS_KEY_SECRET_ME = "D7hwIjMnwTAo7dLVRkKUfOSvbN8O1u";

    private static final String ALIBABA_CLOUD_ACCESS_KEY_ID_ME_2 = "LTAI5tHh1VwZy51f1XU1VgGm";
    private static final String ALIBABA_CLOUD_ACCESS_KEY_SECRET_ME_2 = "Au3kinPYyxZSbLcKL7b9e5UTjmKcJc";

    public static com.aliyun.ocr_api20210707.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                // .setAccessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                .setAccessKeyId(ALIBABA_CLOUD_ACCESS_KEY_ID)
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                // .setAccessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
                .setAccessKeySecret(ALIBABA_CLOUD_ACCESS_KEY_SECRET);
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.ocr_api20210707.Client client = Sample.createClient();
        com.aliyun.ocr_api20210707.models.RecognizeAllTextRequest recognizeAllTextRequest = new com.aliyun.ocr_api20210707.models.RecognizeAllTextRequest()
                .setUrl("https://img.alicdn.com/tfs/TB1q5IeXAvoK1RjSZFNXXcxMVXa-483-307.jpg")
                .setType("IdCard");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            RecognizeAllTextResponse resp = client.recognizeAllTextWithOptions(recognizeAllTextRequest, runtime);
            System.out.println(com.aliyun.teautil.Common.toJSONString(resp.body.data));
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }
}