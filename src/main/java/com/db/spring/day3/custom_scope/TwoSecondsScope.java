package com.db.spring.day3.custom_scope;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TwoSecondsScope implements Scope {
    /*private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, LocalDateTime> timeOfCreation
            = Collections.synchronizedMap(new HashMap<>());*/

    Cache<Object, Object> cache;

    {
        cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();
    }

    @Override
    @SneakyThrows
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return cache.get(name, objectFactory::getObject);

        /*if(!scopedObjects.containsKey(name) || isExpired(name)) {
            scopedObjects.put(name, objectFactory.getObject());
            timeOfCreation.put(name, LocalDateTime.now());
        }
        return scopedObjects.get(name);*/
    }

    /*private boolean isExpired(String name) {
        return ChronoUnit.SECONDS.between(timeOfCreation.get(name), LocalDateTime.now()) > 2;
    }*/

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

}