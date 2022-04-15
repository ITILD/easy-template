package com.example.spmvc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpmvcApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void usetText(){

        System.out.println("整合springboot 与junit结束");
    }

}
