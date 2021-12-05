package bg.softuni.weedinfplanner.web;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.repository.*;
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
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class WeddingChecklistControllerTest {
    public static final String TEST_USER_EMAIL="user@user.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);
    private static final String TEST_TASK_DESCRIPTION = "TestDescriptionTask";
    private static final String TEST_TASK_INVALID_DESCRIPTION = "T";
    private static final String TEST_TASK_UPDATE_DESCRIPTION = "UpdatedDescriptionTask";


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
    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        User testUser = getTestUser();
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
        this.taskRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testOpenWeddingCkecklistPage() throws Exception {
        mockMvc
                .perform(get("/wedding-checklist"))
                .andExpect(status().isOk())
                .andExpect(view().name("wedding-checklist"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testAddTask() throws Exception {
        mockMvc
                .perform(post("/wedding-checklist/task/add")
                        .param("description",TEST_TASK_DESCRIPTION)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-checklist"));
        Assertions.assertEquals(1,taskRepository.count());
        Task task = this.taskRepository.findAll().get(0);
        Assertions.assertEquals(TEST_TASK_DESCRIPTION,task.getDescription());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateTaskShouldRedirectWithError() throws Exception {
        BindingResult bindingResult =(BindingResult) mockMvc
                .perform(post("/wedding-checklist/task/add")
                        .param("description", TEST_TASK_INVALID_DESCRIPTION)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-checklist"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.taskAddBindingModel");

        Assertions.assertEquals(0,taskRepository.count());
        Assertions.assertTrue(bindingResult.hasFieldErrors("description"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateTask() throws Exception {
        Task testTask=getTestTask();
        mockMvc
                .perform(patch("/wedding-checklist/task/"+testTask.getId())
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-checklist"));

        Assertions.assertEquals(1,taskRepository.count());
        Task task = this.taskRepository.findById(testTask.getId()).orElse(null);
        Assertions.assertTrue(task.isCompleted());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testDeleteTask() throws Exception {
        Task testTask=getTestTask();
        mockMvc
                .perform(delete("/wedding-checklist/"+testTask.getId())
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-checklist"));
        Assertions.assertEquals(0,taskRepository.count());
    }

    private Task getTestTask() {
        Task task=new Task()
                .setInitial(false)
                .setCompleted(false)
                .setDescription(TEST_TASK_DESCRIPTION)
                .setWedding(this.userRepository.findUserByEmail(TEST_USER_EMAIL).get().getWedding());
        return this.taskRepository.save(task);
    }


    private User getTestUser() {
        Budget testBudget= (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET)
                .setCurrentBudget(TEST_USER_INITIAL_BUDGET);
        Budget savedBudget = this.budgetRepository.save(testBudget);

        Wedding testWedding= (Wedding) new Wedding()
                .setBudget(savedBudget)
                .setDate(TEST_USER_DATE);
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