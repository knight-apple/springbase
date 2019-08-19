package cn.knightapple.service;

import cn.knightapple.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PersonService {
    void insert(Person person);

    @CachePut("person")
    List<Person> findAll();

    @CacheEvict("person")
    void update(Person person);
}
