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
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldLoadEventById(){
        Event event = new Event();
        event.setTitle("Desafio em POA");
        event.setDescription("Vai ter desafio em poa localizado zona sul");
        event.setEventType(EventType.BIKE_MTB);

        Category category1 = new Category();
        category1.setTitle("30 KM leve");
        category1.setDescription("Esse categoria para quem não possui experiencia e facilitar subida sem suor");

        Category category2 = new Category();
        category2.setTitle("50 KM Pesado");
        category2.setDescription("Esse categoria para quem possui experiencia e terá subida pesado, baita desafio.");

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);

        event.setCategories(list);
        entityManager.persist(event);

        Event result = eventRepository.getById(event.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(event, result);
    }
}
