package hr.reporter.bot.domain.model

import hr.reporter.bot.domain.model.event.BehaviorDescriptionReceivedEventData
import hr.reporter.bot.domain.model.event.Event
import hr.reporter.bot.domain.model.event.EventType
import hr.reporter.bot.domain.model.event.HRContactTypeSelectedEventData
import hr.reporter.bot.domain.model.event.HRIdentifierReceivedEventData
import hr.reporter.bot.domain.model.event.InappropriateBehaviorSelectedEventData
import java.time.Instant

data class ReportStepper(
    val hrContactType: ContactType? = null,
    val hrIdentifier: String? = null,
    val reporterIdentifier: ReporterIdentifier? = null,
    val behavior: InappropriateBehavior? = null,
    val description: String? = null,
    val createdAt: Instant = Instant.now(),
    val isSubmitted: Boolean = false,
    val events: List<Event> = emptyList()
) {

    fun apply(event: Event): ReportStepper {
        return when (event.eventType) {
            EventType.REPORT_STARTED -> {
                this.copy(
                    reporterIdentifier = event.userIdentifier,
                    createdAt = event.eventTime,
                    events = this.events + event
                )
            }

            EventType.HR_CONTACT_TYPE_SELECTED -> {
                this.copy(
                    hrContactType = (event.eventData as HRContactTypeSelectedEventData).contactType
                )
            }

            EventType.HR_IDENTIFIER_RECEIVED -> {
                this.copy(
                    hrIdentifier = (event.eventData as HRIdentifierReceivedEventData).hrIdentifier
                )
            }

            EventType.INAPPROPRIATE_BEHAVIOR_SELECTED -> {
                this.copy(
                    behavior = (event.eventData as InappropriateBehaviorSelectedEventData).inappropriateBehavior
                )
            }

            EventType.BEHAVIOR_DESCRIPTION_RECEIVED -> {
                this.copy(
                    description = (event.eventData as BehaviorDescriptionReceivedEventData).description
                )
            }

            EventType.REPORT_SUBMITTED -> {
                this.copy(
                    isSubmitted = true
                )
            }
        }
    }
}
