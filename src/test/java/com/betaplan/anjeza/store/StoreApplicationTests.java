package com.betaplan.anjeza.store;

import com.betaplan.anjeza.store.configurations.UserPropertyResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class StoreApplicationTests {


    @Autowired
    private UserPropertyResolver userPropertyResolver;

    @Value("${example.user.name}")
    private String userName;

    @Test
    public void test_read_property_OK() {
        assertEquals("test name", userPropertyResolver.getUserName());
        assertEquals("test surname", userPropertyResolver.getUserSurname());
    }


}
