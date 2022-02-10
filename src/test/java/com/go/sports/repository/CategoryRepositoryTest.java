package com.go.sports.repository;

import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.enums.EventType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldLoadTheCategoriesByEventId() {
        Event event = new Event();
        event.setTitle("Desafio em POA");
        event.setDescription("Vai ter desafio em poa localizado zona sul");
        event.setEventType(EventType.BIKE_MTB);
        entityManager.persist(event);

        Category category1 = new Category();
        category1.setTitle("30 KM leve");
        category1.setDescription("Esse categoria para quem não possui experiencia e facilitar subida sem suor");
        category1.setEvent(event);

        Category category2 = new Category();
        category2.setTitle("50 KM Pesado");
        category2.setDescription("Esse categoria para quem possui experiencia e terá subida pesado, baita desafio.");
        category2.setEvent(event);

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);

        entityManager.persist(category1);
        entityManager.persist(category2);

        List<Category> categories = categoryRepository.findByEvent(event);

        Assert.assertNotNull(categories);
        Assert.assertEquals(list.get(0), categories.get(0));
        Assert.assertEquals(list.get(1), categories.get(1));
    }
}
