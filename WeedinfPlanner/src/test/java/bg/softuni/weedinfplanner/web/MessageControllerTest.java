package bg.softuni.weedinfplanner.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    private static final String TEST_USER_EMAIL="user@user.com";
    private static final String TEST_SUPPLIER_EMAIL="supplier@supplier.com";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void openMessagesSupplier() throws Exception {
        mockMvc
                .perform(get("/supplier/messages"))
                .andExpect(status().isOk())
                .andExpect(view().name("supplier-messages"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    void openMessagesUser() throws Exception {
        mockMvc
                .perform(get("/user/messages"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-messages"));
    }
}