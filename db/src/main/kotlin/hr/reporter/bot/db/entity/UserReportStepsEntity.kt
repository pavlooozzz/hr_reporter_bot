package hr.reporter.bot.db.entity

import hr.reporter.bot.domain.model.event.Event
import hr.reporter.bot.domain.model.event.EventType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("hr_report_user_steps")
data class UserReportStepsEntity(
    @Id
    private val id: String,
    val userId: String,
    val eventType: EventType,
    val eventData: String,
    @CreatedDate
    val createdAt: Instant? = null
) : Persistable<String> {
    override fun getId() = id

    override fun isNew() = createdAt == null
}

fun Event.toEntity() = UserReportStepsEntity(
    id = this.eventId.toString(),
    userId = userIdentifier.identifier,
    eventType = this.eventType,
    eventData = this.eventData.toString()
)
