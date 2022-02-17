package com.go.sports.entity;

import com.go.sports.enums.EventType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "events")
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @OneToMany(targetEntity = Category.class, mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> categories;
}
