package dadeAndisheNiroo.authentication;

import dadeAndisheNiroo.authentication.model.UserModel;
import dadeAndisheNiroo.authentication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    void login() throws Exception {
        UserModel user= new UserModel();
        user.setUsername("Elahe_You");
        user.setPassword("mypass");
        user.setRole("ADMIN");
        userService.addUser(user);

        mockMvc.perform(post("/auth/login")
                .contentType("application/json")
                .content("""
                        {   "username":"Elahe_You",
                            "password":"mypass"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
            }
}