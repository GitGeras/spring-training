package com.db.spring.day3.custom_scope;

import com.db.spring.DefaultConfig;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DefaultConfig.class)
public class TwoSecondsBeanTest {

    @Autowired
    private TwoSecondsBean foo;
    @Autowired
    private TwoSecondsBean bar;

    @Autowired
    Map<String, TwoSecondsBean> foos;

    @Test
    @SneakyThrows
    public final void testTwoSecondsScope() {
        foo.sayHello();
        bar.sayHello();

        assertThat(foo, not(equalTo(bar)));
        assertThat(foos.size(), equalTo(2));
        assertTrue(foos.containsValue(foo));
        assertTrue(foos.containsValue(bar));

        String oldFoo = foo.toString();
        String oldBar = bar.toString();

        Thread.sleep(2100);

        assertNotEquals(oldFoo, foo.toString());
        assertEquals(oldBar, bar.toString());
    }
}