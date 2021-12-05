package bg.softuni.weedinfplanner.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.view.UserProfileUpdateViewModel;
import bg.softuni.weedinfplanner.repository.BudgetRepository;
import bg.softuni.weedinfplanner.repository.RoleRepository;
import bg.softuni.weedinfplanner.repository.UserRepository;
import bg.softuni.weedinfplanner.repository.WeddingRepository;
import bg.softuni.weedinfplanner.service.RoleService;
import bg.softuni.weedinfplanner.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private static final String TEST_USER_EMAIL = "test@test.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);

    private static final String TEST_USER_INVALID_EMAIL = "testtest.com";
    private static final String TEST_USER_INVALID_PASSWORD = "1234";
    private static final String TEST_USER_INVALID_FIRST_NAME = "";
    private static final String TEST_USER_INVALID_LAST_NAME = "T";
    private static final LocalDate TEST_USER_INVALID_DATE = LocalDate.of(2021, 9, 30);
    private static final BigDecimal TEST_USER_INVALID_INITIAL_BUDGET = null;

    private static final String TEST_USER_UPDATE_FIRST_NAME = "UserFirstName";
    private static final String TEST_USER_UPDATE_LAST_NAME = "UserLastName";
    private static final String TEST_USER_UPDATE_PARTNER_FIRST_NAME = "PartnerFirstName";
    private static final String TEST_USER_UPDATE_PARTNER_LAST_NAME = "PartnerLastName";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WeddingRepository weddingRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        Role roleUser = this.roleRepository.save(new Role().setName(RoleEnum.USER));

//        Mockito.when(this.roleService.findRoleByName(roleUser.getName()))
//                .thenReturn(roleUser);

        User testUser = getTestUser(roleUser);
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    private User getTestUser(Role roleUser) {
        Budget testBudget= (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET);
        Budget savedBudget = this.budgetRepository.save(testBudget);

        Wedding testWedding= (Wedding) new Wedding()
                .setBudget(savedBudget)
                .setDate(TEST_USER_DATE)
                .setId(1L);
        Wedding savedWedding = this.weddingRepository.save(testWedding);

        User testUser = (User) new User()
                .setFirstName(TEST_USER_FIRST_NAME)
                .setLastName(TEST_USER_LAST_NAME)
                .setWedding(savedWedding)
                .setRoles(Set.of(roleUser))
                .setEmail(TEST_USER_EMAIL)
                .setCreated(LocalDateTime.now())
                .setPassword(passwordEncoder.encode(TEST_USER_PASSWORD))
                .setId(1L);
        this.userRepository.save(testUser);
        return testUser;
    }

    @Test
    void testOpenRegisterUser() throws Exception {
        mockMvc
                .perform(get("/register/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-user"));
    }

    @Test
    void testRegisterUser() throws Exception {
        this.userRepository.deleteAll();
        mockMvc
                .perform(
                        post("/register/user")
                                .param("email", TEST_USER_EMAIL)
                                .param("password", TEST_USER_PASSWORD)
                                .param("confirmPassword", TEST_USER_PASSWORD)
                                .param("firstName", TEST_USER_FIRST_NAME)
                                .param("lastName", TEST_USER_LAST_NAME)
                                .param("date", String.valueOf(TEST_USER_DATE))
                                .param("initialBudget", String.valueOf(TEST_USER_INITIAL_BUDGET))
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, this.userRepository.count());

        Optional<User> userByEmail = this.userRepository.findUserByEmail(TEST_USER_EMAIL);

        Assertions.assertTrue(userByEmail.isPresent());

        Assertions.assertEquals(TEST_USER_EMAIL, userByEmail.get().getEmail());
        Assertions.assertTrue(this.passwordEncoder.matches(TEST_USER_PASSWORD, userByEmail.get().getPassword()));
        Assertions.assertEquals(TEST_USER_FIRST_NAME, userByEmail.get().getFirstName());
        Assertions.assertEquals(TEST_USER_LAST_NAME, userByEmail.get().getLastName());
        Assertions.assertEquals(TEST_USER_DATE, userByEmail.get().getWedding().getDate());
        Assertions.assertEquals(TEST_USER_INITIAL_BUDGET, userByEmail.get().getWedding().getBudget().getInitialBudget());

    }

    @Test
    public void testRegisterUserWithInvalidParamsShouldRedirectWithErrors() throws Exception {
        BindingResult bindingResult = (BindingResult) mockMvc
                .perform(
                        post("/register/user")
                                .param("email", TEST_USER_INVALID_EMAIL)
                                .param("password", TEST_USER_INVALID_PASSWORD)
                                .param("confirmPassword", TEST_USER_INVALID_PASSWORD)
                                .param("firstName", TEST_USER_INVALID_FIRST_NAME)
                                .param("lastName", TEST_USER_INVALID_LAST_NAME)
                                .param("date", String.valueOf(TEST_USER_INVALID_DATE))
                                .param("initialBudget", String.valueOf(TEST_USER_INVALID_INITIAL_BUDGET))
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register/user"))
                .andExpect(flash().attributeExists("org.springframework.validation.BindingResult.userRegisterBindingModel"))
                .andReturn().getFlashMap().get("org.springframework.validation.BindingResult.userRegisterBindingModel");

        Assertions.assertTrue(bindingResult.hasErrors());
        Assertions.assertTrue(bindingResult.hasFieldErrors("email"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("password"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("firstName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("lastName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("date"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("initialBudget"));
    }

    @Test
    public void profilePageOpenFromUnauthenticatedUserShouldRedirectToLoginPage() throws Exception {
        mockMvc
                .perform(get("/user-profile"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "supplier@supplier.com", roles = "SUPPLIER")
    public void profilePageOpenFromAuthenticatedWithNoUserRoleShouldReturnStatus403Forbidden() throws Exception {
        mockMvc
                .perform(get("/user-profile"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void profilePageOpenFromAuthenticatedUser() throws Exception {
        mockMvc
                .perform(get("/user-profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-profile"));
    }


    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void profilePageUpdate() throws Exception {
        mockMvc
                .perform(
                        patch("/user-profile")
                                .param("firstName",TEST_USER_UPDATE_FIRST_NAME)
                                .param("lastName",TEST_USER_UPDATE_LAST_NAME)
                                .param("partnerFirstName",TEST_USER_UPDATE_PARTNER_FIRST_NAME)
                                .param("partnerLastName",TEST_USER_UPDATE_PARTNER_LAST_NAME)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user-profile"));

        User userByEmail = this.userRepository.findUserByEmail(TEST_USER_EMAIL).get();
        Assertions.assertEquals(TEST_USER_UPDATE_FIRST_NAME,userByEmail.getFirstName());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testUpdateUserWithInvalidParamsShouldRedirectWithErrors() throws Exception {
        BindingResult bindingResult = (BindingResult) mockMvc
                .perform(
                        patch("/user-profile")
                                .param("firstName", TEST_USER_INVALID_FIRST_NAME)
                                .param("lastName", TEST_USER_INVALID_LAST_NAME)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user-profile/errors"))
                .andExpect(flash().attributeExists("org.springframework.validation.BindingResult.userProfileUpdateBindingModel"))
                .andReturn().getFlashMap().get("org.springframework.validation.BindingResult.userProfileUpdateBindingModel");

        Assertions.assertTrue(bindingResult.hasErrors());
        Assertions.assertTrue(bindingResult.hasFieldErrors("firstName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("lastName"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void openErrorPageFromUpdateUserProfile() throws Exception {
        mockMvc
                .perform(get("/user-profile/errors"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-profile"));
    }

    @Test
    public void openErrorPageWithNonAuthenticatedUserShouldRedirectToLogin() throws Exception {
        mockMvc
                .perform(get("/user-profile/errors"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "supplier@user.com", roles = "SUPPLIER")
    public void openErrorPageWithSupplierRoleShouldReturn403() throws Exception {
        mockMvc
                .perform(get("/user-profile/errors"))
                .andExpect(status().isForbidden());
    }

}