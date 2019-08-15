package cn.knightapple.service;

import cn.knightapple.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface PersonService {
    void insert(Person person);
}
