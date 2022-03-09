package com.go.sports.entity;

import com.go.sports.dto.request.CategoryDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_event_id")
    private Event event;

    public Category(CategoryDTO categoryDTO) {
        this.id = categoryDTO.getId();
        this.title = categoryDTO.getTitle();
        this.description = categoryDTO.getDescription();
    }

    public Category() {
    }
}
