package hr.reporter.bot.domain.model.event

interface EventHandler {
    fun handle(event: Event)
}