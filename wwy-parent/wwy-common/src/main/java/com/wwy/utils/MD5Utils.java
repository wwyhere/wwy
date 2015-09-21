package com.wwy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * Md5加密工具类
 * 
 * @author wwy
 * @date 2015年5月31日上午9:05:27
 */
public class MD5Utils {
    
    /**
     * 获得MD5加密密码的方法
     * 
     * @param origString
     *            待加密的字符串
     */
    public static String getMD5ofStr(String origString) {
        String origMD5 = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(origString.getBytes());
            origMD5 = byteArray2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return origMD5;
    }
    
    /**
     * 提供一个MD5多次加密方法
     * 
     * @param origString
     *            待加密的字符串
     * @param times
     *            要加密的次数
     */
    public static String getMD5ofStr(String origString, int times) {
        String md5 = getMD5ofStr(origString);
        for (int i = 0; i < times - 1; i++) {
            md5 = getMD5ofStr(md5);
        }
        return getMD5ofStr(md5);
    }
    
    /**
     * 获取文件的Md5值
     * 
     * @param file
     *            文件
     * @return md5
     * @throws FileNotFoundException
     */
    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
    
    /**
     * 处理字节数组得到MD5密码的方法
     */
    private static String byteArray2HexStr(byte[] bs) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bs) {
            sb.append(byte2HexStr(b));
        }
        return sb.toString();
    }
    
    /**
     * 字节标准移位转十六进制方法
     */
    private static String byte2HexStr(byte b) {
        String hexStr = null;
        int n = b;
        if (n < 0) {
            // 若需要自定义加密,请修改这个移位算法即可
            n = b & 0x7F + 128;
        }
        hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
        return hexStr.toUpperCase();
    }
}
