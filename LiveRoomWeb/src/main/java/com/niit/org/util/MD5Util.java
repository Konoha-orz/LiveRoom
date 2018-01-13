package com.niit.org.util;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;



/**

 * Created by yangjian on 2018/1/9.

 */

public class MD5Util {

    public static String Encode(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] md5Bytes = md5.digest(password.getBytes());

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {

            int val = ((int) md5Bytes[i]) & 0xff;

            if (val < 16)

                hexValue.append("0");

            hexValue.append(Integer.toHexString(val));

        }

        return hexValue.toString();

    }

}