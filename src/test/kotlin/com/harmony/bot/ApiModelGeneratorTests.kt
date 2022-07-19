package com.harmony.bot

import com.harmony.bot.lark.ApiModelGenerator
import com.harmony.bot.lark.api.Param
import com.harmony.bot.lark.api.PrimitiveType
import com.harmony.bot.utils.ApiModelUtils
import freemarker.template.Configuration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.io.StringWriter
import java.text.CompactNumberFormat

@SpringBootTest
class ApiModelGeneratorTests(@Autowired val configuration: Configuration) {

    val apiModelGenerator: ApiModelGenerator = ApiModelGenerator()

    @Test
    fun test() {
        val data = ApiModelUtils.readApiMethodData("bitable", "v1", "app.table.field", "create")
        val template = configuration.getTemplate("data.ftl")
        val writer = PrintWriter(OutputStreamWriter(System.out))

        val params = collectAllParams(apiModelGenerator.parseApiMetaData(data))
        for (param in params) {
            template.process(mapOf("p" to param), writer)
            writer.write("\n\n---->>>>\n\n")
            writer.flush()
        }

    }

    fun collectAllParams(param: Param): List<Param> {
        val result = mutableListOf(param)
        for (field in param.fields) {
            if (field.type is PrimitiveType) {
                continue
            }
            result.addAll(collectAllParams(field))
        }
        return result
    }

}
