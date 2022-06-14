package com.menghuan.quickMark;

/**
 * @Author: menghuan
 * @Date: 2021/10/29 16:31
 */
public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "诗羽是居宝宝";
        // 嵌入二维码的图片路径
        // String imgPath = "G:/qrCode/dog.jpg";
        // String imgPath = "C:\\Users\\Administrator\\Desktop\\Alink.png";
        String imgPath = "G:\\Idea-Workspaces\\Mybatisplus-ME\\common-tools-private\\src\\test\\java\\com\\menghuan\\QuickMark\\pika.jpg";
        // 生成的二维码的路径及名称
        // String destPath = "G:/qrCode/qrcode/jam.jpg";
        String destPath = "C:\\Users\\Administrator\\Desktop\\QrCode2.png";
        // 生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println("解析二维码：" + str);
    }

}
