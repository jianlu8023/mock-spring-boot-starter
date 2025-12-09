package com.github.jianlu8023.mock.generator.mobile;


import com.github.jianlu8023.mock.generator.*;
import org.apache.commons.lang3.*;

public class ChineseMobileNumberGenerator extends AbstractGenerator<String> {

    private static class SingleHolder {
        private static final ChineseMobileNumberGenerator INSTANCE = new ChineseMobileNumberGenerator();
    }


    private ChineseMobileNumberGenerator() {
    }

    public static ChineseMobileNumberGenerator newInstance() {
        return SingleHolder.INSTANCE;
    }

    private static final int[] MOBILE_PREFIX = new int[]{133, 153, 177, 180,
            181, 189, 134, 135, 136, 137, 138, 139, 150, 151, 152, 157, 158, 159,
            178, 182, 183, 184, 187, 188, 130, 131, 132, 155, 156, 176, 185, 186,
            145, 147, 170};


    @Override
    public String generate() {
        return genMobilePre() + StringUtils
                .leftPad(String.valueOf(RandomUtils.nextInt(0, 99999999 + 1)), 8, "0");
    }

    /**
     * 生成假的手机号，以19开头
     */
    public String generateFake() {
        return "19" + StringUtils
                .leftPad(String.valueOf(RandomUtils.nextInt(0, 999999999 + 1)), 9, "0");
    }

    private static String genMobilePre() {
        return String.valueOf(MOBILE_PREFIX[RandomUtils.nextInt(0, MOBILE_PREFIX.length)]);
    }

    public static void main(String[] args) {
        ChineseMobileNumberGenerator generator = ChineseMobileNumberGenerator.newInstance();
        for (int i = 0; i < 100; i++) {
            System.out.println(generator.generate());
        }
    }
}
