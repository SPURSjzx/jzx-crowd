package com.jzx.crowd.util;

import com.jzx.crowd.constant.CrowdConstant;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @title: CrowdUtil
 * @Author Jzxxxx
 * @Date: 2020/9/17 21:08
 * @Version 1.0
 */
public class CrowdUtil {

    /**
     * 对明文字符串进行加密
     * @param source 明文密码
     * @return encoded 加密后的密码
     */
    public static String md5(String source){

        // 1 对source进行判断
        if(source == null || source.length()==0){
            //2 如果不是有效的字符串就进行异常处理
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        // 3 获取MessageDigest对象  JDK提供的一个MD5加密工具
        String algorithm="md5";

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 4 获取明文字符串对应的字节数组
            byte[] input = source.getBytes();

            // 5 执行加密
            byte[] output = messageDigest.digest(input);

            // 6 创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);

            // 7 按照16进制将bigInteger转为字符串
            int redix = 16;
            String encoded = bigInteger.toString(redix);

            return encoded;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 判断请求类型是普通请求还是ajax请求  true = ajax请求  false = 普通请求
     * 判断请求是ajax请求还是普通请求 来对他们进行不同的异常处理
     *   普通请求异常是返回粗错误页面，ajax异常时返回ResultEntity中自己定义好的public static  <E> ResultEntity<E> failed(String message){
     *          return new ResultEntity<E>(FAILED,message,null);
     *      }方法
     * @param request 因为想要获取请求方法类型 所以需要传入request才可以  还要记得导入servlet-api
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        //要从请求头来判断具体的请求类型 先获取请求头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        //判断
        if(
                (acceptHeader != null && acceptHeader.contains("application/json"))
                ||
                (xRequestHeader !=null && xRequestHeader.equals("XMLHttpRequest"))
        ){
            return true;
        }
        return  false;
    }
}
