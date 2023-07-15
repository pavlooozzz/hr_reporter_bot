package hr.reporter.bot.db.entity

import hr.reporter.bot.domain.model.ContactType
import hr.reporter.bot.domain.model.HRIdentifier
import hr.reporter.bot.domain.model.InappropriateBehavior
import hr.reporter.bot.domain.model.ReportStepper
import hr.reporter.bot.domain.model.ReporterIdentifier
import hr.reporter.bot.domain.model.SubmittedReport
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
    val description: String,
    @CreatedDate
    val createdAt: Instant? = null
)

fun ReportEntity.toDomain() = SubmittedReport(
    hrIdentifier = HRIdentifier(this.hrContactType, this.hrIdentifier),
    reporterIdentifier = ReporterIdentifier(this.reporterIdentifier),
    behavior = this.inappropriateBehavior,
    description = this.description,
    createdAt = this.createdAt!!
)

fun ReportStepper.toEntity() = ReportEntity(
    hrContactType = this.hrContactType!!,
    hrIdentifier = this.hrIdentifier!!,
    inappropriateBehavior = this.behavior!!,
    reporterIdentifier = this.reporterIdentifier!!.identifier,
    description = this.description!!,
)
