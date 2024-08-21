package com.tdd_demo.tdd;







import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(LeapYearController.class)
public class LeapYearControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeapYearService leapYearService;

    @Test
    public void testLeapYear() throws Exception {
        when(leapYearService.isLeapYear(2024)).thenReturn(true);

        mockMvc.perform(get("/api/leapyear")
                        .param("year", "2024"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testNonLeapYear() throws Exception {
        when(leapYearService.isLeapYear(2023)).thenReturn(false);

        mockMvc.perform(get("/api/leapyear")
                        .param("year", "2023"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }


}
