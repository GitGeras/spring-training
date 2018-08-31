package com.db.spring.day3.custom_scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSecondsScope implements Scope {
    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, LocalDateTime> timeOfCreation
            = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(!scopedObjects.containsKey(name) || isExpired(name)) {
            scopedObjects.put(name, objectFactory.getObject());
            timeOfCreation.put(name, LocalDateTime.now());
        }
        return scopedObjects.get(name);
    }

    private boolean isExpired(String name) {
        return ChronoUnit.SECONDS.between(timeOfCreation.get(name), LocalDateTime.now()) > 2;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object remove(String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public String getConversationId() {
        return "twoSeconds";
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

}