package com.myapp.usecase;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_category")
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String name;

  String description;

  @ManyToMany
  @JoinTable(
      name = "category_has_book",
      joinColumns = {@JoinColumn(name = "category_id")},
      inverseJoinColumns = {@JoinColumn(name = "book_id")}
  )
  Set<BookEntity> books = new HashSet<>();
}
