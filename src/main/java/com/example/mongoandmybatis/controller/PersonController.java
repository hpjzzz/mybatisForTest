package com.example.mongoandmybatis.controller;

import com.example.mongoandmybatis.mapper.PersonMapper;
import com.example.mongoandmybatis.domain.Person;
import com.example.mongoandmybatis.domain.PersonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/insert")
    public void insert(Person person) {
        System.out.println(person);
        personMapper.insert(person);
    }

    @GetMapping("/findOne")
    public Person findOne(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/find")
    public void find(String name, int lower, int upper) {
        PersonExample personExample = new PersonExample();
        personExample.setOrderByClause("id desc");
        personExample.setDistinct(false);

        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        criteria.andAgeBetween(lower, upper);

        List<Person> people = personMapper.selectByExample(personExample);
        System.out.println(people);
        for (Person person : people) {
            System.out.println(person);
        }

    }
}
