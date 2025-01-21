package com.betaplan.anjeza.store.integration.mockmvc;

import com.betaplan.anjeza.store.model.Category;
import com.betaplan.anjeza.store.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration testing ensures that different layers of the application (like controllers, services, and repositories) work "together" as expected
 * MockMvC => simulates HTTP requests to controllers and checks responses
 */
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:scripts/setup.sql")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        // what to do before each method
    }

    @Test
    public void test_showAllProducts() throws Exception {

        // sending HTTP like requests (GET, POST, PUT, DELETE) and verifying view names, model attributes, and status codes
        mockMvc.perform(get("/all-products"))
                .andDo(print())
                .andExpect(status().isOk())
                // JSP page name
                .andExpect(view().name("index"))
                // model attribute exists
                .andExpect(model().attributeExists("products"));
    }


    @Test
    public void test_saveProduct_user_not_logged() throws Exception {
        var product = new Product();
        product.setId(1);
        product.setName("Laptop");
        product.setDescription("This is a laptop");
        product.setQuantity(10);
        product.setCategory(new Category());


        mockMvc.perform(post("/product/create"))
//                .flashAttr("product", product)) // product
//                .andExpect(status().isOk())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    // TODO test update and delete api
}
