package com.hillel.application.base;

import com.hillel.multi.presentation.controller.ClassroomController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(ClassroomController.class)
public class ContractTestRunner {

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {RestAssuredMockMvc.webAppContextSetup(context);}
}
