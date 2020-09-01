package com.lotus.web.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/***
 * redis Spring初始化配置
 *
 * @author haikuo.zhk
 */
@Configuration
public class RedisConfig extends RedisAutoConfiguration {

    /***
     * 若redis配置不是在application.yaml中，显式加载配置，并初始化redisFactory
     *
    @Value("${spring.redis.hostName}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;
    @Value("${spring.redis.password}")
    private String redisPassword;
    @Value("${spring.redis.database}")
    private int redisDataBase;
    @Value("${spring.redis.pool.max-active}")
    private int redisPoolMaxActive;
    @Value("${spring.redis.pool.max-idle}")
    private int redisPoolMaxIdle;
    @Value("${spring.redis.pool.max-wait}")
    private int redisPoolMaxWait;
    @Value("${spring.redis.pool.min-idle}")
    private int redisPoolMinIdle;
    @Value("${spring.redis.timeout}")
    private int redisTimeout;

    // redis配置工厂
    @Bean(name = "redisFactory")
    public RedisConnectionFactory connectionFactory() {
        final JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisHost);
        factory.setPort(redisPort);
        factory.setPassword(redisPassword);
        factory.setDatabase(redisDataBase);
        factory.setTimeout(redisTimeout);

        final JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisPoolMaxActive);
        jedisPoolConfig.setMaxIdle(redisPoolMaxIdle);
        jedisPoolConfig.setMinIdle(redisPoolMinIdle);
        jedisPoolConfig.setMaxWaitMillis(redisPoolMaxWait);
        factory.setPoolConfig(jedisPoolConfig);

        return factory;
    }
     */

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(/*** @Qualifier("redisFactory") */ RedisConnectionFactory factory) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        final Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        serializer.setObjectMapper(mapper);

        final RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }

}
