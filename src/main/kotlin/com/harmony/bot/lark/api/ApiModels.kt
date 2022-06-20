package com.harmony.bot.lark.api

import kotlin.reflect.KClass

data class Param(
    var name: String = "",
    var example: String = "",
    var description: String = "",
    var type: Type = PrimitiveType.OBJECT,
) {

    fun isHasExample() = example.isNotBlank()

}


interface Type {

    fun getText(): String

    fun getPackage(): String

    fun getFullName() = "${getPackage()}.${getText()}"

}

enum class PrimitiveType(private val type: KClass<*>, val primitive: Boolean) : Type {

    STRING(String::class, true),
    OBJECT(Any::class, false),
    INT(Int::class, true),
    LIST(List::class, false),
    BOOLEAN(Boolean::class, true);

    override fun getText(): String = type.simpleName!!

    override fun getPackage(): String = type.java.packageName

    companion object {
        fun typeOf(name: String): PrimitiveType? = values().firstOrNull { it.getText().equals(name, true) }
    }

}

