package com.myapp.usecase.book.browse

import com.myapp.usecase.Book
import com.myapp.usecase.BookRepository
import com.myapp.usecase.BookResponse
import com.myapp.usecase.MockMvcTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.HttpStatus

import static com.myapp.usecase.book.BookType.HISTORICAL

class BrowseBookControllerTest extends MockMvcTest {

    private BookRepository repository = Mock()
    private JacksonTester<BookResponse> bookResponseMapper
    private JacksonTester<List<BookResponse>> booksResponseMapper

    def setup() {
        def controller = new BrowseBookController(repository, modelMapper)
        setupMvc(controller)
    }

    def "should find book"() {
        given:
        def expectedBook = createBook()
        repository.find(expectedBook.id) >> Optional.of(expectedBook)

        when:
        def response = get("/books/" + expectedBook.id)
        def actualBook = bookResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.OK.value()
        assertBook(actualBook, expectedBook)
    }

    def "should find all books"() {
        given:
        def expectedBook = createBook()
        repository.findAll() >> List.of(expectedBook)

        when:
        def response = get("/books")
        def actualBooks = booksResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.OK.value()
        assert actualBooks.size() == 1
        def actualBook = actualBooks.first()
        assertBook(actualBook, expectedBook)
    }

    private static void assertBook(BookResponse actualBook, Book expectedBook) {
        assert actualBook.id == expectedBook.id
        assert actualBook.title == expectedBook.title
        assert actualBook.description == expectedBook.description.get()
        assert actualBook.type == expectedBook.type
    }

    private static Book createBook() {
        return Book.builder()
                .id(1L)
                .title("Book title")
                .description("Book description")
                .type(HISTORICAL)
                .build();
    }
}
