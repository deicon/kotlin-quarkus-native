package de.deicon.quarkus.samples

import de.deicon.quarkus.samples.model.QuoteCategory
import de.deicon.quarkus.samples.repository.QuoteOfTheDayRepository
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.util.Locale.Category
import java.util.StringJoiner
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class QuotingResource {

    @Inject
    lateinit var quoteRepository: QuoteOfTheDayRepository

    @GET
    @Path("/{category}")
    fun quoteByCategory(@PathParam("category") category: String) = quoteRepository.findAnyByCategory(QuoteCategory.valueOf(category))


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from RESTEasy Reactive"
}