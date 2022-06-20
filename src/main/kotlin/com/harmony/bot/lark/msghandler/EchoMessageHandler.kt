package com.harmony.bot.lark.msghandler

import com.harmony.lark.event.EventContext
import com.harmony.lark.event.msghandler.MessageHandler
import com.harmony.lark.getTextMessageContent
import com.harmony.lark.isTextMessage
import com.larksuite.oapi.service.im.v1.model.MessageReceiveEventData
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class EchoMessageHandler : MessageHandler {

    private val log = KotlinLogging.logger { }

    override fun canHandle(context: EventContext<MessageReceiveEventData>): Boolean {
        val data = context.data
        return data.isTextMessage() && data.getTextMessageContent().startsWith("echo ")
    }

    override fun handle(context: EventContext<MessageReceiveEventData>) {
        log.info { "Echo message ${context.data.message.content}" }
    }

}
