package com.github.jianlu8023.mock.config;

import com.github.jianlu8023.mock.generator.address.*;
import com.github.jianlu8023.mock.generator.email.*;
import com.github.jianlu8023.mock.generator.identity.*;
import com.github.jianlu8023.mock.generator.mobile.*;
import com.github.jianlu8023.mock.generator.pojo.*;
import lombok.extern.slf4j.*;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

@Configuration
@ConditionalOnClass({
        IdentityIDGenerator.class,
        ChineseMobileNumberGenerator.class,
        ChineseAddressGenerator.class,
        PojoGenerator.class,
        EmailGenerator.class
})
@ConditionalOnProperty(prefix = "mock", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MockProperties.class)
@Slf4j
public class GeneratorAutoConfiguration {

    @Bean
    IdentityIDGenerator identityIDGenerator() {
        log.debug("inject identityIDGenerator...");
        return IdentityIDGenerator.newInstance();
    }

    @Bean
    ChineseMobileNumberGenerator chineseMobileNumberGenerator() {
        log.debug("inject chineseMobileNumberGenerator...");
        return ChineseMobileNumberGenerator.newInstance();
    }

    @Bean
    ChineseAddressGenerator chineseAddressGenerator() {
        log.debug("inject chineseAddressGenerator...");
        return ChineseAddressGenerator.newInstance();
    }

    @Bean
    @ConditionalOnProperty(prefix = "mock.pojo", name = "enabled", havingValue = "true", matchIfMissing = true)
    PojoGenerator<?> pojoGenerator() {
        log.debug("inject pojoGenerator...");
        return PojoGenerator.newInstance();
    }

    @Bean
    EmailGenerator emailGenerator(MockProperties mockProperties) {
        log.debug("inject emailGenerator...");
        EmailGenerator generator = EmailGenerator.newInstance();
        generator.setlMin(mockProperties.getEmail().getMinUsernameLength());
        generator.setlMax(mockProperties.getEmail().getMaxUsernameLength());
        return generator;
    }

}