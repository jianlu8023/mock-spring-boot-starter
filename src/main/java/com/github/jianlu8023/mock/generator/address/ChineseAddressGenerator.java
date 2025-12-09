package com.github.jianlu8023.mock.generator.address;

import com.github.jianlu8023.mock.generator.*;
import com.github.jianlu8023.mock.generator.utils.*;
import org.apache.commons.lang3.*;

public class ChineseAddressGenerator extends AbstractGenerator<String> {

    private static class SingleHolder {
        private static final ChineseAddressGenerator INSTANCE = new ChineseAddressGenerator();
    }

    private ChineseAddressGenerator() {

    }

    public static ChineseAddressGenerator newInstance() {
        return SingleHolder.INSTANCE;
    }

    @Override
    public String generate() {
        return genProvinceAndCity() + ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "路" +
                       RandomUtils.nextInt(1, 8000) + "号" +
                       ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "小区" +
                       RandomUtils.nextInt(1, 20) + "单元" +
                       RandomUtils.nextInt(101, 2500) + "室";
    }


    private static String genProvinceAndCity() {
        return ChineseAreaList.provinceCityList.get(
                RandomUtils.nextInt(0, ChineseAreaList.provinceCityList.size()));
    }

    public static void main(String[] args) {
        ChineseAddressGenerator gen = ChineseAddressGenerator.newInstance();
        for (int i = 0; i < 100; i++) {
            System.out.println(gen.generate());
        }
    }
}
