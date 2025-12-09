package com.github.jianlu8023.mock.config;

import lombok.*;
import org.springframework.boot.context.properties.*;

@Data
@ConfigurationProperties(prefix = "mock")
public class MockProperties {

    /**
     * 是否启用mock功能
     */
    private boolean enabled = true;

    /**
     * Email生成器配置
     */
    private Email email = new Email();

    /**
     * POJO生成器配置
     */
    private Pojo pojo = new Pojo();

    @Data
    public static class Email {
        /**
         * 邮箱用户名最小长度
         */
        private Integer minUsernameLength = 10;

        /**
         * 邮箱用户名最大长度
         */
        private Integer maxUsernameLength = 25;
    }

    @Data
    public static class Pojo {
        /**
         * 是否启用POJO生成器
         */
        private boolean enabled = true;
    }
}