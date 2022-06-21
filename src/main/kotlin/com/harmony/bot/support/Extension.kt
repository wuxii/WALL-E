package com.harmony.bot.support

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

fun JsonObject.filterFirst(vararg names: String, p: (JsonElement) -> Boolean): JsonElement? {
    return names.filter { this.has(it) && p.invoke(this[it]) }.map { this[it] }.firstOrNull()
}

fun JsonObject.filterFirst(p: (JsonElement) -> Boolean): JsonElement? {
    return this.keySet().filter { p.invoke(this[it]) }.map { this[it] }.firstOrNull()
}

operator fun JsonElement.get(name: String): JsonElement {
    var o: JsonElement? = null
    if (this.isJsonArray) {
        o = this.asJsonArray[name.toInt()]
    } else if (this.isJsonObject) {
        o = this.asJsonObject[name]
    }
    if (o == null) {
        throw IllegalArgumentException("element not contains $name")
    }
    return o
}

operator fun JsonArray.get(name: String): JsonElement {
    return this.get(name.toInt())
}
