package com.example.mongoandmybatis.service;

import com.example.mongoandmybatis.domain.Person;
import com.example.mongoandmybatis.domain.PersonExample;
import com.example.mongoandmybatis.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void insert() {
        PersonExample personExample = new PersonExample();
        personExample.setOrderByClause("id asc");
        List<Person> people = personMapper.selectByExample(personExample);

        mongoTemplate.insertAll(people);
    }

    @Test
    public void search() {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").gte(2).lt(4).and("name").);
        List<Person> people = mongoTemplate.find(query, Person.class);
        System.out.println(people);
    }
}