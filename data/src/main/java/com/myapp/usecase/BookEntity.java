package com.myapp.usecase;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.myapp.usecase.book.BookType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String title;

  String description;

  @Enumerated(EnumType.STRING)
  BookType type;

  @ManyToMany(mappedBy = "books")
  Set<CategoryEntity> categories = new HashSet<>();
}
