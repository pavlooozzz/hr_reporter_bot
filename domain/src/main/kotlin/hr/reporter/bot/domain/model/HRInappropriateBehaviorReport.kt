package hr.reporter.bot.domain.model

import java.time.Instant

data class HRInappropriateBehaviorReport(
    val hrIdentifier: HRIdentifier,
    val reportIdentifier: ReportIdentifier,
    val behavior: InappropriateBehavior,
    val createdAt: Instant
)
