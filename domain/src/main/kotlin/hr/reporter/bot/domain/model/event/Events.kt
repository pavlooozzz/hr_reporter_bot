package hr.reporter.bot.domain.model.event

import hr.reporter.bot.domain.model.ContactType
import hr.reporter.bot.domain.model.InappropriateBehavior
import hr.reporter.bot.domain.model.ReporterIdentifier
import java.time.Instant
import java.util.*

class Event(
    val eventId: UUID = UUID.randomUUID(),
    val userIdentifier: ReporterIdentifier,
    val eventTime: Instant,
    val eventType: EventType,
    val reportData: Any? = null
)

enum class EventType {
    REPORT_STARTED,
    HR_CONTACT_TYPE_SELECTED,
    HR_IDENTIFIER_RECEIVED,
    INAPPROPRIATE_BEHAVIOR_SELECTED,
    BEHAVIOR_DESCRIPTION_RECEIVED,
    REPORT_SUBMITTED
}


data class HRContactTypeSelectedEventData(
    val contactType: ContactType
)

data class HRIdentifierReceivedEventData(
    val hrIdentifier: String
)

data class InappropriateBehaviorSelectedEventData(
    val inappropriateBehavior: InappropriateBehavior
)

data class BehaviorDescriptionReceivedEventData(
    val description: String
)
