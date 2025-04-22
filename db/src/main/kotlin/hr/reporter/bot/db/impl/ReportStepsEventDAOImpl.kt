package hr.reporter.bot.db.impl

import hr.reporter.bot.db.entity.toEntity
import hr.reporter.bot.db.repository.ReportStepperRepository
import hr.reporter.bot.domain.dao.ReportStepsEventDAO
import hr.reporter.bot.domain.model.event.Event
import org.springframework.stereotype.Component

@Component
class ReportStepsEventDAOImpl(
    private val reportStepperRepository: ReportStepperRepository
) : ReportStepsEventDAO {
    override fun saveEvent(event: Event) {
        reportStepperRepository.save(event.toEntity())
    }
}
