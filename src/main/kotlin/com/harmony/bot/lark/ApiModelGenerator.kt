package com.harmony.bot.lark

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.harmony.bot.lark.api.Param
import com.harmony.bot.lark.api.PrimitiveType
import com.harmony.bot.lark.api.SimpleType
import com.harmony.bot.lark.api.Type
import com.harmony.bot.support.get

class ApiModelGenerator {

    private val `package`: String = "com.harmony.lark.model"

    fun parseApiMetaData(o: JsonElement): Param {
        val data = o["data"]
        val body = parseRequestBody(data["request"]["body"].asJsonObject).apply {
            val typeName = concatAsParamName(data["resource"], data["name"]) + "ReqBody"
            this.type = SimpleType.objectType(typeName, `package` + "." + data["project"].asString)
            this.name = "body"
        }
        return body
    }

    private fun parseRequestBody(o: JsonObject): Param = parseParam(o)

    fun parseResponseData(o: JsonElement): Type {
        return null!!
    }

    private fun parseParam(o: JsonElement): Param {
        val type = PrimitiveType.of(o["type"].asString)
        if (type == PrimitiveType.LIST) {
            return Param(
                name = o["name"].asString,
                example = o["example"].asString,
                description = o["description"].asString,
                type = SimpleType.listType(o["name"].asString, `package`),
                fields = o["items"]["properties"].asJsonArray.map { parseParam(it) }
            )
        }
        if (type == PrimitiveType.OBJECT) {
            return Param(
                name = o["name"].asString,
                example = o["example"].asString,
                description = o["description"].asString,
                type = SimpleType.objectType(o["name"].asString, `package`),
                fields = o["properties"].asJsonArray.map { parseParam(it) }
            )
        }
        return Param(
            name = o["name"].asString,
            example = o["example"].asString,
            description = o["description"].asString,
            type = type
        )
    }

    private fun concatAsParamName(vararg names: JsonElement): String {
        return names.map {
            it.asString.split(".").joinToString("") { token ->
                token.replaceFirstChar { c -> c.uppercase() }
            }
        }.joinToString("") { it.replaceFirstChar { c -> c.uppercase() } }
    }

}
