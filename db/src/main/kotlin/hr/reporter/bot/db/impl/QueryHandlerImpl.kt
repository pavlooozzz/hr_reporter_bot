package hr.reporter.bot.db.impl

import hr.reporter.bot.db.entity.toDomain
import hr.reporter.bot.db.repository.ReportRepository
import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.HRInappropriateBehaviorReport
import hr.reporter.bot.domain.model.ReporterIdentifier
import hr.reporter.bot.domain.query.handler.QueryHandler
import org.springframework.stereotype.Component

@Component
class QueryHandlerImpl(
    private val reportRepository: ReportRepository
) : QueryHandler {
    override fun handle(hrIdentifier: HRIdentifier): List<HRInappropriateBehaviorReport> =
        reportRepository.findByHrContactTypeAndHrIdentifier(
            hrIdentifier.contactType,
            hrIdentifier.identifier
        ).map { it.toDomain() }

    override fun handle(reporterIdentifier: ReporterIdentifier): List<HRInappropriateBehaviorReport> =
        reportRepository.findByHrContactTypeAndHrIdentifier(
            reporterIdentifier.contactType,
            reporterIdentifier.identifier
        ).map { it.toDomain() }
}
