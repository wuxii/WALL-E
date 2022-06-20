package com.harmony.bot.support

import com.google.gson.JsonElement
import com.google.gson.JsonObject

fun JsonObject.filterFirst(vararg names: String, p: (JsonElement) -> Boolean): JsonElement? {
    return names.filter { this.has(it) && p.invoke(this[it]) }.map { this[it] }.firstOrNull()
}

fun JsonObject.filterFirst(p: (JsonElement) -> Boolean): JsonElement? {
    return this.keySet().filter { p.invoke(this[it]) }.map { this[it] }.firstOrNull()
}
