package cn.knightapple.controller;

import cn.knightapple.dao.OrderRepository;
import cn.knightapple.entity.Item;
import cn.knightapple.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Controller
@RequestMapping("/mongo")
public class MongodbController {
    @Autowired
    MongoOperations mongo;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/test")
    public void MongoTest()
    {
        Order order = new Order();
        order.setCustomer("customer");
        order.setType("type");
        order.setId("1170290059");
        Collection<Item> items = new ArrayList<Item>();
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
        order.setItems(items);
//        orderRepository.exists(order);
        orderRepository.findOrderByTypeEqualss("type");
        orderRepository.save(order);
        mongo.save(order,"order");
//        mongo.insert(order,"order");
        mongo.find(new Query(),Order.class);
        mongo.getCollection("order").count();
    }
}
