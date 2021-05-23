package ru.training.at.hw5.context;


import java.util.HashMap;
import java.util.Map;

public final class TestContext {
    private static TestContext instance;
    public static final String WEB_DRIVER = "webDriver";


    private Map<String, Object> context = new HashMap<>();
    public void setObject(String key, Object object) {
        context.put(key, object);
//        System.out.println(key + " object has been added to context");
    }
    public <T> T getObject(String key) {
        return (T) context.get(key);
    }
    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

}

