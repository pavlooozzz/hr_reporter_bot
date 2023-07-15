package hr.reporter.bot.configuration

import hr.reporter.bot.domain.command.handler.ReportHRInappropriateBehaviorHandler
import hr.reporter.bot.telegram.Bot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Component
class BotRegister(
    private val handler: ReportHRInappropriateBehaviorHandler
) :
    CommandLineRunner {

    @Value("\${bot.token}")
    lateinit var botToken: String

    override fun run(vararg args: String?) {
        val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
        botsApi.registerBot(Bot(botToken, handler))
    }
}
