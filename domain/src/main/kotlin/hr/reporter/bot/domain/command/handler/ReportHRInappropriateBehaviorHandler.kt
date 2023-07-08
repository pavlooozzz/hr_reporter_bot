package hr.reporter.bot.domain.command.handler

import java.lang.RuntimeException
import kotlin.jvm.Throws

interface ReportHRInappropriateBehaviorHandler {
    @Throws(CommandHandleError::class)
    fun hande(reportHRInappropriateBehaviorHandler: ReportHRInappropriateBehaviorHandler)
}

class CommandHandleError(override val message: String?) : RuntimeException()
