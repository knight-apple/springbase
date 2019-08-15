package cn.knightapple;


import cn.knightapple.dao.PersonMapper;
import cn.knightapple.entity.Person;
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
    @Test
    public void insertTest()
    {
        Person person = new Person();
        person.setSex("男");
        person.setAge(19);
        person.setBirthday(new Date());
        person.setComments("");
        person.setName("凌锦涛");
        personMapper.insert(person);
    }
}


