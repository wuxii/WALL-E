package com.harmony.bot.lark.api

interface Type {

    /**
     * 类型的 SimpleName
     */
    fun getTypeName(): String

    fun getPackage(): String

    fun getFullName(): String = "${getPackage()}.${getTypeName()}"

}

data class Param(
    var name: String = "",
    var example: String = "",
    var description: String = "",
    var type: Type = PrimitiveType.OBJECT,
    var fields: List<Param> = listOf(),
) : Type {

    companion object {
        fun empty() = Param()
    }

    fun isList() = (type == PrimitiveType.LIST)

    override fun getTypeName(): String {
        return type.getTypeName()
    }

    override fun getPackage(): String {
        return type.getPackage()
    }

    fun getImportNames(): Set<String> {
        return fields.map { it.getFullName() }.filter { !it.startsWith("java.lang") }.sorted().toSet()
    }


    override fun toString(): String {
        return "${getTypeName()} $name;"
    }

}

data class SimpleType(
    private val type: PrimitiveType,
    private val name: String,
    private val pkg: String,
) : Type {

    companion object {

        fun listType(name: String, pkg: String) = SimpleType(PrimitiveType.LIST, name, pkg)

        fun objectType(name: String, pkg: String) = SimpleType(PrimitiveType.OBJECT, name, pkg)

    }

    override fun getTypeName(): String {
        return if (type == PrimitiveType.LIST) "List<$name>" else name;
    }

    override fun getPackage(): String {
        return pkg
    }

    override fun getFullName(): String {
        return type.getFullName()
    }

    override fun toString(): String {
        return "$pkg.$name"
    }

}

enum class PrimitiveType(private val type: Class<*>, val primitive: Boolean) : Type {

    STRING(String::class.java, true),
    OBJECT(Any::class.java, false),
    INT(Integer::class.java, true),
    LIST(List::class.java, false),
    BOOLEAN(java.lang.Boolean::class.java, true);

    override fun getTypeName(): String = type.simpleName

    override fun getPackage(): String = type.packageName

    companion object {
        fun of(name: String) = values().firstOrNull { it.name.equals(name, true) } ?: OBJECT

    }

}

