package cn.knightapple.service;

import cn.knightapple.dao.PersonMapper;
import cn.knightapple.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;
    @Override
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Cacheable("person")
    @Override
    public List<Person> findAll()
    {
        return personMapper.findAll();
    }

    @CacheEvict("person")
    @Override
    public void update(Person person)
    {
        personMapper.updateByPrimaryKey(person);
    }
}
