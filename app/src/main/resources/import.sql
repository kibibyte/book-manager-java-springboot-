--Book
INSERT INTO book (title, description, type) VALUES ('Book 1', 'Book 1 description', 'FANTASY');
INSERT INTO book (title, description, type) VALUES ('Book 2', 'Book 2 description', 'FANTASY');
INSERT INTO book (title, description, type) VALUES ('Book 3', 'Book 3 description', 'HISTORICAL');
INSERT INTO book (title, description, type) VALUES ('Book 4', 'Book 4 description', 'HISTORICAL');
--Book categories
INSERT INTO book_category(name, description) VALUES ('Kids Category', 'Kids Category');
INSERT INTO book_category (name, description) VALUES ('Teens Category', 'Teens Category');
INSERT INTO book_category (name, description) VALUES ('Other Category', 'Other Category');
--Book categories join table
INSERT INTO category_has_book (category_id, book_id) VALUES (1, 1);
INSERT INTO category_has_book (category_id, book_id) VALUES (1, 2);
INSERT INTO category_has_book (category_id, book_id) VALUES (2, 3);
INSERT INTO category_has_book (category_id, book_id) VALUES (2, 4);
