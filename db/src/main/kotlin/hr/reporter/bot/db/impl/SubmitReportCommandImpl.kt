package hr.reporter.bot.db.impl

import hr.reporter.bot.db.entity.toEntity
import hr.reporter.bot.db.repository.ReportRepository
import hr.reporter.bot.domain.command.handler.SubmitReportComand
import hr.reporter.bot.domain.model.ReportStepper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

private val logger = LoggerFactory.getLogger(SubmitReportCommandImpl::class.java)

@Component
class SubmitReportCommandImpl(private val reportRepository: ReportRepository) :
    SubmitReportComand {
    override fun hande(reportStepper: ReportStepper) {
        reportRepository.save(reportStepper.toEntity())
        logger.info("$reportStepper successfully saved to db!")
    }
}
