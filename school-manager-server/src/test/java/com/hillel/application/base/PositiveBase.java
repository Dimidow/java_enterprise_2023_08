package com.hillel.application.base;

import com.hillel.multi.service.ClassroomService;
import org.springframework.boot.test.mock.mockito.MockBean;

public class PositiveBase extends ContractTestRunner{

    @MockBean
    private ClassroomService classroomService;
}
