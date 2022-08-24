import de.deicon.quarkus.samples.model.QuoteCategory
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class QuoteOfTheDay() {
    @Id
    @GeneratedValue
    var id: Long? = null
    var category: QuoteCategory = QuoteCategory.FUN
    var quote: String = "Nothing there for you"

    constructor(category: QuoteCategory, quote: String) : this() {
        this.id = id
        this.category = category
        this.quote = quote
    }
}