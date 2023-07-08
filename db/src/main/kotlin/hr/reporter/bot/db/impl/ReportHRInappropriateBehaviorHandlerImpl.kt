package hr.reporter.bot.db.impl

import hr.reporter.bot.db.entity.toEntity
import hr.reporter.bot.db.repository.ReportRepository
import hr.reporter.bot.domain.command.ReportHRInappropriateBehavior
import hr.reporter.bot.domain.command.handler.ReportHRInappropriateBehaviorHandler
import org.springframework.stereotype.Component

@Component
class ReportHRInappropriateBehaviorHandlerImpl(private val reportRepository: ReportRepository) :
    ReportHRInappropriateBehaviorHandler {
    override fun hande(reportHRInappropriateBehavior: ReportHRInappropriateBehavior) {
        reportRepository.save(reportHRInappropriateBehavior.toEntity())
    }
}
