package com.sadman.springboottest;

import static org.assertj.core.api.Assertions.assertThat;

import com.sadman.springboottest.controller.HomeController;
import com.sadman.springboottest.controller.NullController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController controller;

//    @Autowired
//    private NullController nullController;

    @Test
    public void contextLoads1() throws Exception {
        assertThat(controller).isNotNull();
    }

//    @Test
//    public void contextLoads2() throws Exception {
//        assertThat(nullController).isNotNull();
//    }
}
