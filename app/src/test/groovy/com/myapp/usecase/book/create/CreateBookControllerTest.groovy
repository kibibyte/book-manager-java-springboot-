package com.myapp.usecase.book.create

import com.myapp.usecase.Book
import com.myapp.usecase.BookResponse
import com.myapp.usecase.MockMvcTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.HttpStatus

import static com.myapp.usecase.book.BookType.HISTORICAL

class CreateBookControllerTest extends MockMvcTest {

    private CreateBookRepository repository = Mock()
    private JacksonTester<BookResponse> bookResponseMapper
    private JacksonTester<CreateBookRequest> createBookRequestMapper

    def setup() {
        def controller = new CreateBookController(repository, modelMapper)
        setupMvc(controller)
    }

    def "should create book"() {
        given:
        def expectedBook = createBook()
        def bookRequest = createBookRequest()
        def jsonBookRequest = createBookRequestMapper.write(bookRequest).getJson()
        repository.create(_ as NewBook) >> expectedBook

        when:
        def response = post("/books", jsonBookRequest)
        def createdBook = bookResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.CREATED.value()
        assertBook(createdBook, expectedBook)
    }

    private static void assertBook(BookResponse actualBook, Book expectedBook) {
        assert actualBook.id == expectedBook.id
        assert actualBook.title == expectedBook.title
        assert actualBook.description == expectedBook.description.get()
        assert actualBook.type == expectedBook.type
    }

    private static CreateBookRequest createBookRequest() {
        return new CreateBookRequest(
                "Book title",
                "Book description",
                HISTORICAL
        )
    }

    private static Book createBook() {
        return Book.builder()
                .id(1L)
                .title("Book title")
                .description("Book description")
                .type(HISTORICAL)
                .build()
    }
}
