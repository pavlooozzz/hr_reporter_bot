package hr.reporter.bot.db.repository

import hr.reporter.bot.db.entity.ReportEntity
import hr.reporter.bot.domain.model.ContactType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : CrudRepository<ReportEntity, Long> {
    fun findByHrContactTypeAndHrIdentifier(hrContactType: ContactType, hrIdentifier: String): List<ReportEntity>
    fun findByReporterContactTypeAndReporterIdentifier(
        reporterContactType: ContactType,
        reporterIdentifier: String
    ): List<ReportEntity>
}
