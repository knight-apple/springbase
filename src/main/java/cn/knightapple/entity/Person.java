package cn.knightapple.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String comments;

    private Date birthday;

    public Person(Integer id, String name, String sex, Integer age, String comments, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.comments = comments;
        this.birthday = birthday;
    }

    public Person() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}