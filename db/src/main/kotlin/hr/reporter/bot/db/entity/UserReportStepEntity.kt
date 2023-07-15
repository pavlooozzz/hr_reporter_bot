package hr.reporter.bot.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("hr_report_user_steps")
data class UserReportStepEntity(
    @Id
    val eventId: Long?,

    val eventType: String,

    val userId: String,

    val eventData: String



)
