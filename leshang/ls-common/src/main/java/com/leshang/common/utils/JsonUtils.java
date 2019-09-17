package com.leshang.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
@Slf4j
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    //@Nullable
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    //@Nullable
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    //@Nullable
    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    //@Nullable
    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    //@Nullable
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        String name;
        Integer age;
    }
    public static void main(String[] args) {
        User user = new User("Jack",21);
        //toString
        String json = serialize(user);
        System.out.println("json= "+json);
        //反序列化
        User user1 = parse(json, User.class);
        System.out.println("user1="+user1);

        //toList
        json="[20,21,23,2]";
        List<Integer> list = parseList(json, Integer.class);
        System.out.println("list="+list);

        //toMap
        String map = "{\"name\": \"jack\",\"age\": \"21\"}";
        Map<String, String> map1 = parseMap(map, String.class, String.class);
        System.out.println("map="+map1);

        //复杂嵌套
        String json1="[{\"name\": \"jack\",\"age\": \"21\"},{\"name\": \"jack1\",\"age\": \"211\"}]";
        List<Map<String, String>> maps = nativeRead(json1, new TypeReference<List<Map<String, String>>>() {
            
        });
        for (Map<String, String> map2 : maps) {
            System.out.println("复杂map="+map2);
        }
    }
}
