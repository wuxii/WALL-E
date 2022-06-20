package com.harmony.bot.controller

import com.harmony.lark.LarkApi
import com.harmony.lark.dispatchEvent
import com.larksuite.oapi.core.utils.Servlets
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/lark")
class LarkEventController(val larkApi: LarkApi) {

    /**
     * 飞书事件回调
     */
    @RequestMapping("/event")
    fun onEvent(httpRequest: HttpServletRequest, httpResponse: HttpServletResponse) {
        larkApi.dispatchEvent(httpRequest, httpResponse)
    }

}
