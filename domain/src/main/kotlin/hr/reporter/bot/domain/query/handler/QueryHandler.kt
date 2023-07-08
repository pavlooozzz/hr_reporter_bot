package hr.reporter.bot.domain.query.handler

import hr.reporter.bot.domain.model.HRInappropriateBehaviorReport
import hr.reporter.bot.domain.query.FindAllMyReports
import hr.reporter.bot.domain.query.FindInfoAboutHR
import java.lang.RuntimeException

interface QueryHandler {
    fun handle(findInfoAboutHR: FindInfoAboutHR): List<HRInappropriateBehaviorReport>

    fun handle(findAllMyReports: FindAllMyReports): List<HRInappropriateBehaviorReport>
}

class QueryHandleException(override val message: String) : RuntimeException(message)
