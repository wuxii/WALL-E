package com.harmony.bot.config

import com.harmony.lark.spring.autoconfig.LarkApiConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LarkConfig {

    @Bean
    fun larkApiConfigurer(): LarkApiConfigurer {
        return object : LarkApiConfigurer {}
    }

}
