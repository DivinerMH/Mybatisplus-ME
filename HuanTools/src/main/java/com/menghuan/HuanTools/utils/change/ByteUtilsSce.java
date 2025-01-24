package com.menghuan.HuanTools.utils.change;

import java.math.BigInteger;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author asus
 * @create 2019/12/6 17:14
 */
public class ByteUtilsSce {

    private static String[] binaryArray = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
        "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    /**
     * @param hex 十六进制转为十进制
     * @return
     */
    public static String getHexToTen(String hex) {
        // return String.valueOf(Integer.parseInt(hex, 16));
        int sum = 0;
        for (int i = 0; i < hex.length(); i++) {
            int m = hex.charAt(i);// 将输入的十六进制字符串转化为单个字符
            int num = m >= 'A' ? m - 'A' + 10 : m - '0';// 将字符对应的ASCII值转为数值
            sum += Math.pow(16, hex.length() - 1 - i) * num;
        }
        return String.valueOf(sum);
    }

    /**
     * 将十六进制字符串转为字符串类型Ascll码
     */
    public static String getHexToAscllString(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < hex.length() - 1; i += 2) {
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return getFileAddSpace(sb.toString());
    }

    /**
     * 每两位之间插入空格
     */
    public static String getFileAddSpace(String replace) {
        String regex = "(.{2})";
        replace = replace.replaceAll(regex, "$1 ");
        return replace;
    }

    /**
     * 字符串转换为 Ascii
     *
     * @param value
     * @return
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int)chars[i]).append(",");
            } else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * 十六进制转字符串
     * 
     * @param hexString 十六进制字符串
     * @param encodeType 编码类型 4：Unicode，2：普通编码
     * @return 字符串     
     */
    public static String hexStringToString(String hexString, int encodeType) {
        String result = "";
        int max = hexString.length() / encodeType;
        for (int i = 0; i < max; i++) {
            char c = (char)hexStringToAlgorism(hexString.substring(i * encodeType, (i + 1) * encodeType));
            result += c;
        }
        return result;
    }

    /**
     * 十六进制字符串装十进制
     * 
     * @param hex 十六进制字符串
     * @return 十进制数值     
     */
    public static long hexStringToAlgorism(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        long result = 0;
        for (int i = max; i > 0; i--) {
            char c = hex.charAt(i - 1);
            long algorism = 0;
            if (c >= '0' && c <= '9') {
                algorism = c - '0';
            } else {
                algorism = c - 55;
            }
            result += Math.pow(16, max - i) * algorism;
        }
        return result;
    }

    /**
     * 字符串转化成为16进制字符串
     */
    public static String strTo16(String s) {
        if (StringUtils.isNumeric(s)) {
            return Long.toHexString(Long.parseLong(s));
        } else {
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                int ch = (int)s.charAt(i);
                String s4 = Integer.toHexString(ch);
                str = str + s4;
            }
            return str;
        }

    }

    //
    public static void main(String[] args) throws Exception {

        // System.out.println(get_to_2("0a01"));
        // String s = "256a";
        // System.out.println(Hex.encodeHexString(s.getBytes()));
        // String ss = Hex.encodeHexString(s.getBytes());
        // String sss = new String(Hex.decodeHex(ss));

        // Float f = new Float("-0.005");
        // String s = Integer.toHexString(Float.floatToIntBits(f));
        // Float.intBitsToFloat(new BigInteger(s, 16).intValue());
        //
        //// Double d = new Double("0.00000000006");
        //// String s2 = Long.toHexString(Double.doubleToLongBits(d));
        //// Double.longBitsToDouble(Long.parseLong(s, 16));
        //
        // System.out.println("1");
        //
        //
        // System.out.println(1);
    }

    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /**
     * 16进制转换成为string类型字符串
     *
     * @param s 十六进制数
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 向串口发送数据转为字节数组
     *
     * @param hex 十六进制数转byte数组
     */
    public static byte[] hex2byte(String hex) {
        String digital = "0123456789ABCDEF";
        String hex1 = hex.replace(" ", "");
        char[] hex2char = hex1.toCharArray();
        byte[] bytes = new byte[hex1.length() / 2];
        byte temp;
        for (int p = 0; p < bytes.length; p++) {
            temp = (byte)(digital.indexOf(hex2char[2 * p]) * 16);
            temp += digital.indexOf(hex2char[2 * p + 1]);
            bytes[p] = (byte)(temp & 0xff);
        }
        return bytes;
    }

    /**
     * 字节数组转16进制
     *
     * @param bytes 需要转换的byte数组
     * @return 转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 接收到的字节数组转换16进制字符串
     *
     * @param b 收到的byte数组
     * @param size byte自己数组长度
     * @return 十六进制字符串
     */
    public static String bytes2HexString(byte[] b, int size) {
        String ret = "";
        for (int i = 0; i < size; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    /**
     * byte数组转成16进制字符串
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 接收到的字节数组转换16进制字符串
     */
    public static String byteToStr(byte[] b, int size) {
        String ret = "";
        for (int i = 0; i < size; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static int hexStrToTenInteger(String hex) {
        int bigInteger = Integer.valueOf(new BigInteger(hex, 16).toString());
        return bigInteger;
    }

    /**
     * 字符串转byte数组
     */
    public static byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        }
        byte[] byteArray = str.getBytes();
        return byteArray;
    }

    /**
     * 计算CRC16校验码 逐个求和
     *
     * @param bytes 字节数组
     * @return {@link String} 校验码
     * @since 1.0
     */
    public static String getCRC_16(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;
        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int)bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        if (Integer.toHexString(CRC).toUpperCase().length() == 2) {
            return "00" + Integer.toHexString(CRC).toUpperCase();
        } else if (Integer.toHexString(CRC).toUpperCase().length() == 3) {
            return "0" + Integer.toHexString(CRC).toUpperCase();
        }
        return Integer.toHexString(CRC).toUpperCase();
    }

    /**
     * 指令校验和,并取出后两位字节
     */
    public static String getSum16(byte[] msg, int length) {
        long mSum = 0;
        byte[] mByte = new byte[length];
        for (byte byteMsg : msg) {
            long mNum = ((long)byteMsg >= 0) ? (long)byteMsg : ((long)byteMsg + 256);
            mSum += mNum;
        }
        for (int liv_Count = 0; liv_Count < length; liv_Count++) {
            mByte[length - liv_Count - 1] = (byte)(mSum >> (liv_Count * 8) & 0xff);
        }
        return byteToStr(msg, length) + byteToStr(mByte, mByte.length)
            .substring(byteToStr(mByte, mByte.length).length() - 4, byteToStr(mByte, mByte.length).length());
    }

    /**
     * 高低位转换
     */
    public static String getShort(String data) {
        switch (data.length()) {
            case 1:
                data = "000" + data;
                break;
            case 2:
                data = "00" + data;
                break;
            case 3:
                data = "0" + data;
                break;
        }
        String s1 = data.substring(0, 2);
        String s2 = data.substring(2, 4);
        return s2 + s1;
    }

    // 判断浮点数（double和float）
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 计算校验值
     */
    public static String getCRC_16CheckSum(String hexdata) {
        if (hexdata == null || hexdata.equals("")) {
            return "00";
        }
        hexdata = hexdata.replaceAll(" ", "");
        int total = 0;
        int len = hexdata.length();
        if (len % 2 != 0) {
            return "00";
        }
        int num = 0;
        while (num < len) {
            String s = hexdata.substring(num, num + 2);
            total += Integer.parseInt(s, 16);
            num = num + 2;
        }
        String data = hexInt(total);
        return data.substring(data.length() - 2, data.length());
    }

    public static String hexInt(int total) {
        int a = total / 256;
        int b = total % 256;
        if (a > 255) {
            return hexInt(a) + format(b);
        }
        return format(a) + format(b);
    }

    public static String format(int hex) {
        String hexa = Integer.toHexString(hex);
        int len = hexa.length();
        if (len < 2) {
            hexa = "0" + hexa;
        }
        return hexa;
    }

    /**
     * 十六转二
     *
     * @param
     * @return
     */
    public static String get_to_2(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0) {
            return null;
        }
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * @return 转换为二进制字符串
     */
    public static String bytes2BinaryStr(byte[] bArray) {

        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            // 高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            // 低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;

    }
}
