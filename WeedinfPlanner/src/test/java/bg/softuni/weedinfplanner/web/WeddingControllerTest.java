package bg.softuni.weedinfplanner.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.repository.BudgetRepository;
import bg.softuni.weedinfplanner.repository.RoleRepository;
import bg.softuni.weedinfplanner.repository.UserRepository;
import bg.softuni.weedinfplanner.repository.WeddingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class WeddingControllerTest {
    public static final String TEST_USER_EMAIL="user@user.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private WeddingRepository weddingRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        User testUser = getTestUser();
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testWeddingPageOpen() throws Exception {
        mockMvc
                .perform(get("/wedding"))
                .andExpect(status().isOk())
                .andExpect(view().name("wedding"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testWeddingPage() throws Exception {
        mockMvc
                .perform(post("/wedding/add-date")
                        .param("date",String.valueOf(TEST_USER_DATE))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding"));
        Wedding wedding = this.userRepository.findUserByEmail(TEST_USER_EMAIL).get().getWedding();
        Assertions.assertEquals(TEST_USER_DATE,wedding.getDate());
    }

    private User getTestUser() {
        Budget testBudget= (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET);
        Budget savedBudget = this.budgetRepository.save(testBudget);

        Wedding testWedding= (Wedding) new Wedding()
                .setBudget(savedBudget)
                .setDate(null);
        Wedding savedWedding = this.weddingRepository.save(testWedding);

        Role roleUser = this.roleRepository.save(new Role().setName(RoleEnum.USER));

        User testUser = (User) new User()
                .setFirstName(TEST_USER_FIRST_NAME)
                .setLastName(TEST_USER_LAST_NAME)
                .setWedding(savedWedding)
                .setRoles(Set.of(roleUser))
                .setEmail(TEST_USER_EMAIL)
                .setCreated(LocalDateTime.now())
                .setPassword(passwordEncoder.encode(TEST_USER_PASSWORD));
        User savedUser = this.userRepository.save(testUser);
        return savedUser;
    }

}