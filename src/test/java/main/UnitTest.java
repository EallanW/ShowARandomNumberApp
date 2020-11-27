package main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShowARandomNumberApp.class)
@AutoConfigureMockMvc
public class UnitTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void test() throws Exception {
        assertEquals(mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn().getModelAndView().getViewName(), "forward:index.html");
    }
}
