package cn.knightapple.dao;

import cn.knightapple.entity.Person;
import cn.knightapple.entity.PersonExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    int countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    @Delete({
            "delete from Person",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into Person (id, name, ",
            "sex, age, comments, ",
            "birthDay)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{sex,jdbcType=CHAR}, #{age,jdbcType=INTEGER}, #{comments,jdbcType=VARCHAR}, ",
            "#{birthday,jdbcType=TIMESTAMP})"
    })
    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    @Select({
            "select",
            "id, name, sex, age, comments, birthDay",
            "from Person",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Person selectByPrimaryKey(Integer id);


    @Select({
            "select",
            "id, name, sex, age, comments, birthDay",
            "from Person",
    })
    List<Person> findAll();


    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    @Update({
            "update Person",
            "set name = #{name,jdbcType=VARCHAR},",
            "sex = #{sex,jdbcType=CHAR},",
            "age = #{age,jdbcType=INTEGER},",
            "comments = #{comments,jdbcType=VARCHAR},",
            "birthDay = #{birthday,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Person record);


}