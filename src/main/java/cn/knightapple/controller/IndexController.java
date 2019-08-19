package cn.knightapple.controller;

import cn.knightapple.entity.Person;
import cn.knightapple.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/home")
public class IndexController {

    @Autowired
    PersonService personService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/insert")
    public String insert() {
        Person person = new Person();
        person.setSex("男");
        person.setAge(19);
        person.setBirthday(new Date());
        person.setComments("");
        person.setName("凌锦涛");
        personService.insert(person);
        return "true";
    }

    @RequestMapping("/test")
    public String test() {
        List<Person> peoples = personService.findAll();
        int i = 0;
        for (Person p : peoples) {
            p.setName(p.getName() + i);
            personService.findAll();
            personService.update(p);
        }
        return "success";
    }
}

