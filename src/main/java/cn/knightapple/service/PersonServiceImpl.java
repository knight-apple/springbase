package cn.knightapple.service;

import cn.knightapple.dao.PersonMapper;
import cn.knightapple.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;
    @Override
    public void insert(Person person) {
        personMapper.insert(person);
    }
}
