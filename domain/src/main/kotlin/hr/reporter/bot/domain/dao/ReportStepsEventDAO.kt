package hr.reporter.bot.domain.dao

import hr.reporter.bot.domain.model.event.Event

interface ReportStepsEventDAO {
    fun saveEvent(event: Event)
}
