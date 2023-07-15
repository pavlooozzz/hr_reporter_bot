package hr.reporter.bot.db.repository

import hr.reporter.bot.db.entity.UserReportStepsEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportStepperRepository : CrudRepository<UserReportStepsEntity, String>
