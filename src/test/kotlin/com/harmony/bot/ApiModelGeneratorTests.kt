package com.harmony.bot

import com.harmony.bot.lark.ApiModelGenerator
import com.harmony.bot.utils.ApiModelUtils
import org.junit.jupiter.api.Test

class ApiModelGeneratorTests {

    val apiModelGenerator: ApiModelGenerator = ApiModelGenerator()

    @Test
    fun test() {
        val data = ApiModelUtils.readApiMethodData("im", "v1", "message", "reply")
        apiModelGenerator.parseApiMetaData(data)
    }

}
