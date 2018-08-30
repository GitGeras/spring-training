package com.db.spring.day2.screen_saver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
        while (true) {
            ColorFrame frame = context.getBean(ColorFrame.class);
            frame.moveToRandomLocation();
            Thread.sleep(70);
        }
    }
}
