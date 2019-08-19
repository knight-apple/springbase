package cn.knightapple;


import cn.knightapple.dao.PersonMapper;
import cn.knightapple.entity.Person;
import cn.knightapple.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml", "classpath:spring/spring-mybatis.xml"})
public class testMyBatis {
    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonService personService;
    @Test
    public void insertTest() {
        Person person = new Person();
        person.setSex("男");
        person.setAge(19);
        person.setBirthday(new Date());
        person.setComments("");
        person.setName("凌锦涛");
        personMapper.insert(person);
    }

    @Test
    public void TestFind() {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        int times = 0;
        while (end - start < 10000) {
            personService.findOneNoCache(1);
            times++;
            end = System.currentTimeMillis();
        }
        System.out.println("No cached" + times);
        start = System.currentTimeMillis();
        times = 0;
        while (end - start < 10000) {
            personService.findOne(1);
            times++;
            end = System.currentTimeMillis();
        }
        System.out.println("cached" + times);


    }
}


