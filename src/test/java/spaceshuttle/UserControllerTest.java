package spaceshuttle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:h2-db.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void testGetUserById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"success\":true,\"errorCode\":null,\"errorMessage\":null,\"responseObject\":null}")));

    }

    @Test
    public void testAddUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/users").accept(MediaType.APPLICATION_JSON_VALUE).content("{\n" +
                "\t\"username\":\"hell again again updated\",\n" +
                "\t\"password\":\"guesswhat updated?\"\n" +
                "}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"success\":true,\"errorCode\":null,\"errorMessage\":null,\"responseObject\":null}")));

    }
}