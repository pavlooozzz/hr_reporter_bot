package hr.reporter.bot.domain.query.handler

import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.HRInappropriateBehaviorReportStepper
import hr.reporter.bot.domain.model.ReporterIdentifier

interface QueryHandler {
    fun handle(hrIdentifier: HRIdentifier): List<HRInappropriateBehaviorReportStepper>

    fun handle(reporterIdentifier: ReporterIdentifier): List<HRInappropriateBehaviorReportStepper>
}
