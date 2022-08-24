package de.deicon.quarkus.samples.repository

import QuoteOfTheDay
import de.deicon.quarkus.samples.model.QuoteCategory
import io.quarkus.runtime.StartupEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.transaction.Transactional


@ApplicationScoped
class DataSeed
    (private val repository: QuoteOfTheDayRepository) {

    @Transactional
    fun onStart(@Observes ev: StartupEvent?) {
        repository.run {
            persist(QuoteOfTheDay(category = QuoteCategory.FUN, quote = "Some Funny Quote" ))
            persist(QuoteOfTheDay(category = QuoteCategory.PROFANE, quote = "Some PROFANE Quote" ))
            persist(QuoteOfTheDay(category = QuoteCategory.WORK, quote = "Some WORK Quote" ))
            persist(QuoteOfTheDay(category = QuoteCategory.FUN, quote = "MORE Funny Quote" ))
        }
    }
}
