package com.harmony.bot.lark

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.harmony.bot.lark.api.Param
import com.harmony.bot.lark.api.SimpleType
import com.harmony.bot.lark.api.Type
import com.harmony.bot.support.get

class ApiModelGenerator {

    fun parseApiMetaData(o: JsonElement) {
        parseRequestBody(o["data"]["request"]["body"].asJsonObject)
    }

    private fun parseRequestBody(o: JsonObject): Type {
        if (!o.has("properties") || o["properties"].asJsonArray.isEmpty) {
            return SimpleType.OBJECT
        }
        val type = o["properties"].asJsonArray.map { parseParam(it) }
        return SimpleType.OBJECT
    }

    fun parseResponseData(o: JsonElement): Type {
        return null!!
    }

    private fun parseParam(o: JsonElement): Param {
        val type = SimpleType.typeOf(o["type"].asString)
        if (type != null && type.primitive) {
            return Param(
                name = o["name"].asString,
                example = o["example"].asString,
                description = o["description"].asString,
                type = type
            )
        }

        if (type == SimpleType.LIST) {
            // todo handle list type
            o["items"].asJsonObject
        }

        if (type == SimpleType.OBJECT) {
            // todo handle object type
        }
        return null!!
    }

}
