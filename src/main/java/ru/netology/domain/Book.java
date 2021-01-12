package ru.netology.domain;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString

public class Book extends Product {
  private String author;

  public Book(int id, String name, int price, String author) {
    super(id, name, price);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Book book = (Book) o;
    return Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), author);
  }

  @Override
  public String toString() {
    return "Book{" +
            "author='" + author + '\'' +
            '}';
  }
}
