package cn.knightapple.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public JedisConnectionFactory redisCF() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("119.23.44.109");
        return cf;
    }

//    将Product替换为想要的值类
//    @Bean
//    public RedisTemplate<String, Product> redisTemplate(JedisConnectionFactory cf) {
//        RedisTemplate<String,Product> redis = new RedisTemplate<String, Product>();
//        redis.setConnectionFactory(cf);
//        redis.setKeySerializer(new StringRedisSerializer());//设置key序列化器（可选）
//        redis.setKeySerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));//设置value序列化器（可选）
//        return redis;
//    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf){
        return new StringRedisTemplate(cf);
    }
}
