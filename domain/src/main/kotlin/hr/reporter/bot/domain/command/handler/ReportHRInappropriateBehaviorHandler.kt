package hr.reporter.bot.domain.command.handler

import hr.reporter.bot.domain.command.ReportHRInappropriateBehavior

interface ReportHRInappropriateBehaviorHandler {

    fun hande(reportHRInappropriateBehavior: ReportHRInappropriateBehavior)
}
