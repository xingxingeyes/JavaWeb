package com.kai;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/16
 **/
public class Base64Test {

    public static void main(String[] args) throws IOException {
        String content = "这是Base64编码的内容";
        // 创建Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 执行Base64编码操作
        String encodeStr = base64Encoder.encode(content.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeStr);

        // 创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        // 解码操作
        byte[] bytes = base64Decoder.decodeBuffer(encodeStr);

        String s = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(s);


    }
}
