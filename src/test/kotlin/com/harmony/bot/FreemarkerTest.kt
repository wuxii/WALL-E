package com.harmony.bot

import com.larksuite.oapi.core.utils.Jsons
import freemarker.ext.beans.BeansWrapper
import freemarker.ext.beans.BeansWrapperBuilder
import freemarker.template.Configuration
import freemarker.template.ObjectWrapper
import freemarker.template.TemplateModel
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.OutputStreamWriter

@SpringBootTest
class FreemarkerTest(@Autowired val configuration: Configuration) {

    val text = """
        {
                  "defaultValue": "",
                  "description": "",
                  "enumName": "",
                  "example": "",
                  "format": "",
                  "mandatory": false,
                  "max": "",
                  "maxLen": "",
                  "min": "",
                  "minLen": "",
                  "name": "",
                  "properties": [
                    {
                      "defaultValue": "",
                      "description": "消息id open_message_id",
                      "enumName": "",
                      "example": "om_dc13264520392913993dd051dba21dcf",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "message_id",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "根消息id open_message_id",
                      "enumName": "",
                      "example": "om_40eb06e7b84dc71c03e009ad3c754195",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "root_id",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "父消息的id open_message_id",
                      "enumName": "",
                      "example": "om_d4be107c616aed9c1da8ed8068570a9f",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "parent_id",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息类型 text post card image等等",
                      "enumName": "",
                      "example": "card",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "msg_type",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息生成的时间戳(毫秒)",
                      "enumName": "",
                      "example": "1609296809",
                      "format": "int64",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "create_time",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息更新的时间戳",
                      "enumName": "",
                      "example": "1609336806",
                      "format": "int64",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "update_time",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息是否被撤回",
                      "enumName": "",
                      "example": "false",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "deleted",
                      "ref": "",
                      "regexp": "",
                      "type": "boolean"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息是否被更新",
                      "enumName": "",
                      "example": "false",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "updated",
                      "ref": "",
                      "regexp": "",
                      "type": "boolean"
                    },
                    {
                      "defaultValue": "",
                      "description": "所属的群",
                      "enumName": "",
                      "example": "oc_5ad11d72b830411d72b836c20",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "chat_id",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    },
                    {
                      "defaultValue": "",
                      "description": "发送者，可以是用户或应用",
                      "enumName": "",
                      "example": "object",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "sender",
                      "properties": [
                        {
                          "defaultValue": "",
                          "description": "该字段标识发送者的id",
                          "enumName": "",
                          "example": "",
                          "format": "",
                          "mandatory": true,
                          "max": "",
                          "maxLen": "",
                          "min": "",
                          "minLen": "",
                          "name": "id",
                          "ref": "",
                          "regexp": "",
                          "type": "string"
                        },
                        {
                          "defaultValue": "",
                          "description": "该字段标识发送者的id类型",
                          "enumName": "",
                          "example": "",
                          "format": "",
                          "mandatory": true,
                          "max": "",
                          "maxLen": "",
                          "min": "",
                          "minLen": "",
                          "name": "id_type",
                          "ref": "",
                          "regexp": "",
                          "type": "string"
                        },
                        {
                          "defaultValue": "",
                          "description": "该字段标识发送者的类型",
                          "enumName": "",
                          "example": "",
                          "format": "",
                          "mandatory": true,
                          "max": "",
                          "maxLen": "",
                          "min": "",
                          "minLen": "",
                          "name": "sender_type",
                          "ref": "",
                          "regexp": "",
                          "type": "string"
                        },
                        {
                          "defaultValue": "",
                          "description": "tenant key",
                          "enumName": "",
                          "example": "736588c9260f175e",
                          "format": "",
                          "mandatory": false,
                          "max": "",
                          "maxLen": "",
                          "min": "",
                          "minLen": "",
                          "name": "tenant_key",
                          "ref": "",
                          "regexp": "",
                          "type": "string"
                        }
                      ],
                      "ref": "sender",
                      "regexp": "",
                      "type": "object"
                    },
                    {
                      "defaultValue": "",
                      "description": "消息内容,json结构",
                      "enumName": "",
                      "example": "json结构",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "body",
                      "properties": [
                        {
                          "defaultValue": "",
                          "description": "消息jsonContent",
                          "enumName": "",
                          "example": "text:测试消息",
                          "format": "",
                          "mandatory": true,
                          "max": "",
                          "maxLen": "",
                          "min": "",
                          "minLen": "",
                          "name": "content",
                          "ref": "",
                          "regexp": "",
                          "type": "string"
                        }
                      ],
                      "ref": "message_body",
                      "regexp": "",
                      "type": "object"
                    },
                    {
                      "defaultValue": "",
                      "description": "被艾特的人或应用的id",
                      "enumName": "",
                      "example": "",
                      "format": "",
                      "items": {
                        "defaultValue": "",
                        "description": "",
                        "enumName": "",
                        "example": "",
                        "format": "",
                        "mandatory": false,
                        "max": "",
                        "maxLen": "",
                        "min": "",
                        "minLen": "",
                        "name": "",
                        "properties": [
                          {
                            "defaultValue": "",
                            "description": "mention key",
                            "enumName": "",
                            "example": "1@_user_1",
                            "format": "",
                            "mandatory": true,
                            "max": "",
                            "maxLen": "",
                            "min": "",
                            "minLen": "",
                            "name": "key",
                            "ref": "",
                            "regexp": "",
                            "type": "string"
                          },
                          {
                            "defaultValue": "",
                            "description": "用户open id",
                            "enumName": "",
                            "example": "ou_155184d1e73cbfb8973e5a9e698e74f2",
                            "format": "",
                            "mandatory": true,
                            "max": "",
                            "maxLen": "",
                            "min": "",
                            "minLen": "",
                            "name": "id",
                            "ref": "",
                            "regexp": "",
                            "type": "string"
                          },
                          {
                            "defaultValue": "",
                            "description": "id 可以是open_id，user_id或者union_id",
                            "enumName": "",
                            "example": "open_id",
                            "format": "",
                            "mandatory": true,
                            "max": "",
                            "maxLen": "",
                            "min": "",
                            "minLen": "",
                            "name": "id_type",
                            "ref": "",
                            "regexp": "",
                            "type": "string"
                          },
                          {
                            "defaultValue": "",
                            "description": "被at用户的姓名",
                            "enumName": "",
                            "example": "Tom",
                            "format": "",
                            "mandatory": true,
                            "max": "",
                            "maxLen": "",
                            "min": "",
                            "minLen": "",
                            "name": "name",
                            "ref": "",
                            "regexp": "",
                            "type": "string"
                          },
                          {
                            "defaultValue": "",
                            "description": "tenant key",
                            "enumName": "",
                            "example": "736588c9260f175e",
                            "format": "",
                            "mandatory": false,
                            "max": "",
                            "maxLen": "",
                            "min": "",
                            "minLen": "",
                            "name": "tenant_key",
                            "ref": "",
                            "regexp": "",
                            "type": "string"
                          }
                        ],
                        "ref": "mention",
                        "regexp": "",
                        "type": "object"
                      },
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "mentions",
                      "ref": "",
                      "regexp": "",
                      "type": "list"
                    },
                    {
                      "defaultValue": "",
                      "description": "合并消息的上一层级消息id open_message_id",
                      "enumName": "",
                      "example": "om_40eb06e7b84dc71c03e00ida3c754892",
                      "format": "",
                      "mandatory": false,
                      "max": "",
                      "maxLen": "",
                      "min": "",
                      "minLen": "",
                      "name": "upper_message_id",
                      "ref": "",
                      "regexp": "",
                      "type": "string"
                    }
                  ],
                  "ref": "message",
                  "regexp": "",
                  "type": "object"
                }
    """.trimIndent()

    @Test
    fun test() {
        val template = configuration.getTemplate("data.ftl")

        val beansWrapper = BeansWrapperBuilder(configuration.incompatibleImprovements).build()
        val statics = beansWrapper.staticModels
        val data = Jsons.DEFAULT_GSON.toJsonTree(text)
        template.process(mapOf("data" to data, "statics" to statics), OutputStreamWriter(System.out))
    }

}
