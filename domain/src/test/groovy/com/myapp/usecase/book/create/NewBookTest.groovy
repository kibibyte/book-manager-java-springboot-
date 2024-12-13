package com.myapp.usecase.book.create

import com.myapp.exceptions.InvalidArgumentException
import spock.lang.Specification

import static com.myapp.usecase.book.BookType.FANTASY
import static com.myapp.usecase.book.BookType.HISTORICAL

class NewBookTest extends Specification {

    private static final String INVALID_ARGUMENT_MESSAGE = "Invalid argument"

    def "should consider book as valid"() {
        when:
        new NewBook(title, description, type)

        then:
        noExceptionThrown()

        where:
        title   | description   | type
        "title" | "description" | HISTORICAL
        "title" | "description" | FANTASY
        "title" | null          | FANTASY
    }

    def "should not consider book as valid"() {
        when:
        new NewBook(title, description, type)

        then:
        def ex = thrown InvalidArgumentException
        ex.getMessage() == expectedErrorMessage

        where:
        title  | description   | type       || expectedErrorMessage
        null   | "description" | HISTORICAL || INVALID_ARGUMENT_MESSAGE
        "name" | "description" | null       || INVALID_ARGUMENT_MESSAGE
    }
}
