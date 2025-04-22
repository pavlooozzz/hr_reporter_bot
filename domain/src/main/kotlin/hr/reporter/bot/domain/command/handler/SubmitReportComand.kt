package hr.reporter.bot.domain.command.handler

import hr.reporter.bot.domain.model.ReportStepper

interface SubmitReportComand {

    fun hande(reportStepper: ReportStepper)
}
