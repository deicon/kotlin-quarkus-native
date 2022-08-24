package de.deicon.quarkus.samples.repository

import QuoteOfTheDay
import de.deicon.quarkus.samples.model.QuoteCategory
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class QuoteOfTheDayRepository(private val seed: DataSeed): PanacheRepository<QuoteOfTheDay> {
    fun findAllByCategory(category: QuoteCategory) = find("category", category).list()
    fun findAnyByCategory(category: QuoteCategory) = find("category", category).list()?.shuffled().first() ?: QuoteOfTheDay()
}