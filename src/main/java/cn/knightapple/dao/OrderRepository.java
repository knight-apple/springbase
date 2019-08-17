package cn.knightapple.dao;

import cn.knightapple.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    @Query("{'type':?0}")
    public List<Order> findOrderByTypeEqualss(String type);
}

