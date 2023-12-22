package org.lab5.injector;

import org.lab5.Injector;
import org.lab5.Wrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class InjectorTest {
    Injector injector;

    @Before
    public void before() {
        injector = new Injector();
    }

    @Test
    public void inject1() throws IOException {
        injector.loadFile("test1.properties");
        Wrapper wrapper = (Wrapper) injector.doInjection(new Wrapper());

        Assert.assertEquals(wrapper.get1(), "1");
        Assert.assertEquals(wrapper.get2(), "4");
    }

    @Test
    public void inject2() throws IOException {
        injector.loadFile("test2.properties");
        Wrapper wrapper = (Wrapper) injector.doInjection(new Wrapper());

        Assert.assertEquals(wrapper.get1(), "2");
        Assert.assertEquals(wrapper.get2(), "5");
    }

    @Test
    public void inject3() throws IOException {
        injector.loadFile("test3.properties");
        Wrapper wrapper = (Wrapper) injector.doInjection(new Wrapper());

        Assert.assertEquals(wrapper.get1(), "3");
        Assert.assertEquals(wrapper.get2(), "6");
    }
}