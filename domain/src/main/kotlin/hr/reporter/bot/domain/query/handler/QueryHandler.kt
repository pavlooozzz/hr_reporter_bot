package hr.reporter.bot.domain.query.handler

import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.ReporterIdentifier
import hr.reporter.bot.domain.model.SubmittedReport

interface QueryHandler {
    fun handle(hrIdentifier: HRIdentifier): List<SubmittedReport>

    fun handle(reporterIdentifier: ReporterIdentifier): List<SubmittedReport>
}
