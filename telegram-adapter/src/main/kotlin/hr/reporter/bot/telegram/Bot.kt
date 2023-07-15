package hr.reporter.bot.telegram

import hr.reporter.bot.domain.command.handler.ReportHRInappropriateBehaviorHandler
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.ActionType
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton.InlineKeyboardButtonBuilder


private val logger = LoggerFactory.getLogger(Bot::class.java)

class Bot(
    botToken: String,
    private val handler: ReportHRInappropriateBehaviorHandler
) :
    TelegramLongPollingBot(botToken) {

    override fun getBotUsername() = "hr_reporter_bot"

    override fun onUpdateReceived(update: Update?) {
        logger.info("Message received ${update?.message}")

        if (update!!.hasCallbackQuery()) {
            logger.info("Callback message received - ${update.callbackQuery.message}")
            when (update.callbackQuery.data) {
                "/report_hr_telegram" -> {
                    execute(SendMessage().also {
                        it.setChatId(update.callbackQuery.message.chat.id)
                        it.text = "Please sent hr identifier:"
                    })
                }

                else -> execute(SendMessage().also {
                    it.setChatId(update.callbackQuery.message.chat.id)
                    it.text = "Incorrect command. Please type a valid command!"
                })
            }
        }


        if (update.message?.text == "/start") {
            val sendMessage = SendMessage()
            sendMessage.setChatId(update.message?.chatId!!)
            sendMessage.text = "What you want to do ?"
            sendMessage.replyMarkup = InlineKeyboardMarkup().also { inlineKeyboardMarkup ->
                inlineKeyboardMarkup.keyboard = listOf(
                    listOf(InlineKeyboardButton().also {
                        it.text = "Report HR behavior by telegram!"
                        it.callbackData = "/report_hr_telegram"
                    },
                        InlineKeyboardButton().also {
                            it.text = "Report HR behavior by phone!"
                            it.callbackData = "/report_hr_phone"
                        }),
                    listOf(
                        InlineKeyboardButton().also {
                            it.text = "Find all reports by HR identifier"
                            it.callbackData = "/find_hr_reports"
                        }
                    )
                )
            }
            execute(sendMessage)
        }
    }
}
