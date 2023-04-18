package finki.emt.emt_lv1_201115.model.domain;

import finki.emt.emt_lv1_201115.model.dto.BookDto;
import finki.emt.emt_lv1_201115.model.enumeration.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;
}
