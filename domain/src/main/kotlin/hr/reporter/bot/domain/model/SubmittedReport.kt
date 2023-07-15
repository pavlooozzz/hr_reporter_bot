package hr.reporter.bot.domain.model

import java.time.Instant

data class SubmittedReport(
    val hrIdentifier: HRIdentifier,
    val reporterIdentifier: ReporterIdentifier,
    val behavior: InappropriateBehavior,
    val description: String,
    val createdAt: Instant
)
