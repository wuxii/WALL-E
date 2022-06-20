package com.harmony.bot.lark

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.harmony.bot.lark.api.Param
import com.harmony.bot.lark.api.PrimitiveType

class ApiModelGenerator {

    fun parseResponseData(o: JsonObject): List<Param> {
        return listOf()
    }

    private fun parseParams(params: JsonArray): List<Param> {
        return listOf()
    }

    private fun parseParam(o: JsonObject): Param {
        val type = PrimitiveType.typeOf(o["type"].asString)
        if (type is PrimitiveType) {
            return Param(
                name = o["name"].asString,
                example = o["example"].asString,
                description = o["description"].asString,
                type = type
            )
        }
        return null!!
    }

    private fun filterFirstNotBlankValue(o: JsonObject, vararg names: String): String? {
        return names.map { o[it] }.firstOrNull { it != null && it.asString.isNotBlank() }?.asString
    }

}
