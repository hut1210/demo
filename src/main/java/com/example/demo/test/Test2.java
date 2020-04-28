package com.example.demo.test;

/**
 * @Author: Hut
 * @Date: 2020/04/13 11:07
 **/
public class Test2 {
    public static void main(String[] args) {

        String str ="Error type: channel_error\n" +
                "\t Error message: 对支付渠道的请求未能成功。来自 allinpay 渠道的错误信息：3999-身份证号或手机号或姓名中有1项或多项不符[669X1020305]\n" +
                "\t Error code: channel_request_error";

        String s="Error type: invalid_request_error\n\t Error message: 请求来源存在风险，请联系Ping++。\n";

        System.out.println(s.split("\n\t")[1].split(":")[1]);
    }
}
