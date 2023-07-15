package hr.reporter.bot.db.entity

import hr.reporter.bot.domain.command.ReportHRInappropriateBehavior
import hr.reporter.bot.domain.model.ContactType
import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.HRInappropriateBehaviorReportStepper
import hr.reporter.bot.domain.model.InappropriateBehavior
import hr.reporter.bot.domain.model.ReporterIdentifier
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("hr_report")
data class ReportEntity(
    @Id
    val id: Long? = null,
    val hrContactType: ContactType,
    val hrIdentifier: String,
    val inappropriateBehavior: InappropriateBehavior,
    val reporterIdentifier: String,
    @CreatedDate
    val createdAt: Instant? = null
)

fun ReportHRInappropriateBehavior.toEntity() = ReportEntity(
    hrContactType = this.hrIdentifier.contactType,
    hrIdentifier = this.hrIdentifier.identifier,
    inappropriateBehavior = this.inappropriateBehavior,
    reporterIdentifier = this.reporterIdentifier.identifier
)

fun ReportEntity.toDomain() = HRInappropriateBehaviorReportStepper(
    hrIdentifier = HRIdentifier(this.hrContactType, this.hrIdentifier),
    reporterIdentifier = ReporterIdentifier(this.reporterContactType, this.reporterIdentifier),
    behavior = this.inappropriateBehavior,
    createdAt = this.createdAt!!
)
