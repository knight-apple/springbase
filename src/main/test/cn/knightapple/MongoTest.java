package cn.knightapple;

import cn.knightapple.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/spring-base.xml", "classpath:spring/spring-mybatis.xml"})
@ComponentScan
public class MongoTest {
    @Autowired
    MongoOperations mongo;

    @Test
    public void testSaveAndFind(){
        Order order = new Order();
        mongo.save(order,"order");
        mongo.getCollection("order").count();
    }

}
