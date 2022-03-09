package com.go.sports.entity;

import com.go.sports.enums.RegisterStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(generator =  "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus;
}
