package com.harmony.bot.lark.api

import kotlin.reflect.KClass

interface Type {

    /**
     * 类型的 SimpleName
     */
    fun getTypeName(): String

    fun getPackage(): String

    fun getFullName() = "${getPackage()}.${getTypeName()}"

    fun getFields(): List<Type> = listOf()

}

data class Param(
    var name: String = "",
    var example: String = "",
    var description: String = "",
    var type: Type = SimpleType.OBJECT,
) : Type {

    fun isHasExample() = example.isNotBlank()

    fun isList() = (type == SimpleType.LIST)

    override fun getTypeName(): String {
        return type.getTypeName()
    }

    override fun getPackage(): String {
        TODO("Not yet implemented")
    }

}

data class ListType(val name: String, private val type: Type) : Type {

    override fun getTypeName(): String {
        return "List<Object>"
    }

    override fun getPackage(): String {
        return type.getPackage();
    }

}

enum class SimpleType(private val type: KClass<*>, val primitive: Boolean) : Type {

    STRING(String::class, true),
    OBJECT(Any::class, false),
    INT(Int::class, true),
    LIST(List::class, false),
    BOOLEAN(Boolean::class, true);

    override fun getTypeName(): String = type.simpleName!!

    override fun getPackage(): String = type.java.packageName

    companion object {
        fun typeOf(name: String): SimpleType? = values().firstOrNull { it.getTypeName().equals(name, true) }

    }

}

