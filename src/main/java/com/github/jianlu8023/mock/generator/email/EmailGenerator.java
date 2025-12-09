package com.github.jianlu8023.mock.generator.email;

import com.github.jianlu8023.mock.generator.*;

public class EmailGenerator extends AbstractGenerator<String> {


    private static class SingleHolder {
        private static final EmailGenerator INSTANCE = new EmailGenerator();
    }

    private EmailGenerator() {

    }

    public static EmailGenerator newInstance() {
        return SingleHolder.INSTANCE;
    }


    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    private Integer lMin = 10;

    private Integer lMax = 25;

    public void setlMin(Integer lMin) {
        this.lMin = lMin;
    }

    public void setlMax(Integer lMax) {
        this.lMax = lMax;
    }

    public Integer getlMax() {
        return lMax;
    }

    public Integer getlMin() {
        return lMin;
    }

    private int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    @Override
    public String generate() {
        int length = getNum(lMin, lMax);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(EmailGenerator.newInstance().generate());
        }
    }
}