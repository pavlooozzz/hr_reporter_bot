package hr.reporter.bot.domain.dao

import hr.reporter.bot.domain.model.event.Event

interface HRInappropriateBehaviorReportStepperDAO {
    fun saveEvent(event: Event)
}