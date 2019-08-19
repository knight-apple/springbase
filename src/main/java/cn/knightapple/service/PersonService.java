package cn.knightapple.service;

import cn.knightapple.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PersonService {
    void insert(Person person);

    @Cacheable(value = "person")
//    @Cacheable(value = "person")
    List<Person> findAll();

    List<Person> findAllNoCache();

    @CacheEvict(value = "person")
//    @CacheEvict(value = "person")
    void update(Person person);

    @Cacheable(value = "person", key = "#root.args[0]")
//    @Cacheable(value = "person")
    Person findOne(int id);

    Person findOneNoCache(int id);
}
