package hr.reporter.bot.domain.query.handler

import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.HRInappropriateBehaviorReport
import hr.reporter.bot.domain.model.ReporterIdentifier

interface QueryHandler {
    fun handle(hrIdentifier: HRIdentifier): List<HRInappropriateBehaviorReport>

    fun handle(reporterIdentifier: ReporterIdentifier): List<HRInappropriateBehaviorReport>
}
