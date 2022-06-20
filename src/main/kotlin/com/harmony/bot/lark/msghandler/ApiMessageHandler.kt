package com.harmony.bot.lark.msghandler

import com.harmony.bot.service.LarkService
import com.harmony.lark.*
import com.harmony.lark.event.EventContext
import com.harmony.lark.event.msghandler.MessageHandler
import com.larksuite.oapi.service.im.v1.model.MessageReceiveEventData
import org.springframework.stereotype.Component

@Component
class ApiMessageHandler(private val larkService: LarkService) : MessageHandler {

    override fun canHandle(context: EventContext<MessageReceiveEventData>): Boolean {
        return context.data.isTextMessageContentStartsWith("api ")
    }

    override fun handle(context: EventContext<MessageReceiveEventData>) {
        val larkApi = context.getLarkApi()
        val service = larkApi.unwrap(MessageApi::class)
        val data = context.data
        service.replyMessage(data.getMessageId(), MessageContent.ofText("Hi"))
    }

}
