package com.example.mongoandmybatis.service;

import com.example.mongoandmybatis.domain.Person;
import com.example.mongoandmybatis.domain.PersonExample;
import com.example.mongoandmybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonMapper personMapper;

    public void insert() {
        PersonExample personExample = new PersonExample();
        personExample.setOrderByClause("id asc");
        List<Person> people = personMapper.selectByExample(personExample);

        mongoTemplate.insertAll(people);
    }
}
