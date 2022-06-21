package com.harmony.bot.utils

import com.google.gson.JsonObject
import com.larksuite.oapi.core.api.tools.OKHttps
import com.larksuite.oapi.core.utils.Jsons
import com.larksuite.oapi.okhttp3_14.HttpUrl
import com.larksuite.oapi.okhttp3_14.Request
import java.util.concurrent.TimeUnit

object ApiModelUtils {

    fun readApiMethodData(project: String, version: String, resource: String, method: String): JsonObject {
        val url = HttpUrl.get("https://open.feishu.cn/api/tools/api_explore/api_method_meta")
            .newBuilder()
            .addQueryParameter("project", project)
            .addQueryParameter("version", version)
            .addQueryParameter("resource", resource)
            .addQueryParameter("method", method)
            .build()
        val client = OKHttps.create(30, 30, TimeUnit.SECONDS)
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        val response = client.newCall(request).execute()
        val responseText = response.body()!!.string()
        val respObj = Jsons.DEFAULT_GSON.fromJson(responseText, JsonObject::class.java)
        if (respObj["code"].asInt != 0) {
            throw RuntimeException(respObj["msg"].asString)
        }
        return respObj
    }
}
