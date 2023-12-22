package org.lab5;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector {
    private Properties p;

    public Injector() {
        p = new Properties();
    }

    public void loadFile(String path) throws IOException {
        p.load(new FileReader(path));
    }

    public Object doInjection(Object injectable) {
        Class<?> injectableClass = injectable.getClass();

        for (Field field : injectableClass.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                field.set(injectable, findClass(field));
            }
            catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return injectable;
    }

    private Object findClass(Field field) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String className = field.getType().toString().split(" ")[1];
        Class<?> implementation = Class.forName(p.getProperty(className));
        return implementation.getDeclaredConstructor().newInstance();
    }
}
