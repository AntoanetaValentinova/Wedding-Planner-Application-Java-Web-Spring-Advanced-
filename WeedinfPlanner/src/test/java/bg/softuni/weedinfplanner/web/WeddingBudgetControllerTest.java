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
class WeddingBudgetControllerTest {
    public static final String TEST_USER_EMAIL="user@user.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);
    private static final BigDecimal TEST_USER_UPDATE_INITIAL_BUDGET = BigDecimal.valueOf(20000.00).setScale(2);
    private static final BigDecimal TEST_USER_INVALID_INITIAL_BUDGET = null;
    private static final String TEST_EXPENSE_NAME="ExpenseTestName";
    private static final BigDecimal TEST_EXPENSE_PRICE = BigDecimal.valueOf(1000.00).setScale(2);
    private static final BigDecimal TEST_EXPENSE_PAID = BigDecimal.valueOf(500.00).setScale(2);
    private static final String TEST_EXPENSE_UPDATED_NAME="ExpenseUpdatedName";
    private static final BigDecimal TEST_EXPENSE_UPDATED_PRICE = BigDecimal.valueOf(2000.00).setScale(2);
    private static final BigDecimal TEST_EXPENSE_UPDATED_PAID = BigDecimal.valueOf(1000.00).setScale(2);
    private static final String TEST_EXPENSE_INVALID_UPDATED_NAME="E";
    private static final BigDecimal TEST_EXPENSE_INVALID_UPDATED_PRICE = BigDecimal.valueOf(-2000.00).setScale(2);
    private static final BigDecimal TEST_EXPENSE_UPDATED_INVALID_PAID = null;

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
    private ExpenseRepository expenseRepository;

    @BeforeEach
    public void setUp() {
        User testUser = getTestUser();
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.expenseRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testOpenWeddingBudgetPage() throws Exception {
        mockMvc
                .perform(get("/wedding-budget"))
                .andExpect(status().isOk())
                .andExpect(view().name("wedding-budget"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateWeddingBudget() throws Exception {
        mockMvc
                .perform(patch("/wedding-budget")
                        .param("initialBudget",String.valueOf(TEST_USER_UPDATE_INITIAL_BUDGET))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget"));
        Budget budget = this.userRepository.findUserByEmail(TEST_USER_EMAIL).get().getWedding().getBudget();
        Assertions.assertEquals(TEST_USER_UPDATE_INITIAL_BUDGET,budget.getInitialBudget());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateWeddingBudgetErrors() throws Exception {
        BindingResult bindingResult = (BindingResult) mockMvc
                .perform(patch("/wedding-budget")
                        .param("initialBudget", String.valueOf(TEST_USER_INVALID_INITIAL_BUDGET))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.budgetUpdateBindingModel");

        Assertions.assertTrue(bindingResult.hasFieldErrors("initialBudget"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testAddExpense() throws Exception {
        mockMvc
                .perform(post("/wedding-budget/expense/add")
                        .param("name",String.valueOf(TEST_EXPENSE_NAME))
                        .param("price",String.valueOf(TEST_EXPENSE_PRICE))
                        .param("paid",String.valueOf(TEST_EXPENSE_PAID))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget"));

        Assertions.assertEquals(1,this.expenseRepository.count());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testDeleteExpense() throws Exception {
        Expense testExpense=getTestExpense();
        Assertions.assertEquals(1,this.expenseRepository.count());
        mockMvc
                .perform(delete("/wedding-budget/expense/"+testExpense.getId())
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget"));

        Assertions.assertEquals(0,this.expenseRepository.count());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateExpense() throws Exception {
        Expense expense=getTestExpense();
        Assertions.assertEquals(1,this.expenseRepository.count());
        mockMvc
                .perform(patch("/wedding-budget/expense/"+expense.getId())
                        .param("name",TEST_EXPENSE_UPDATED_NAME)
                        .param("price",String.valueOf(TEST_EXPENSE_UPDATED_PRICE))
                        .param("paid",String.valueOf(TEST_EXPENSE_UPDATED_PAID))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget"));

        Expense updatedExpense = this.expenseRepository.findById(expense.getId()).orElse(null);
        Assertions.assertEquals(1,this.expenseRepository.count());
        Assertions.assertEquals(TEST_EXPENSE_UPDATED_PAID,updatedExpense.getPaid().setScale(2));
        Assertions.assertEquals(TEST_EXPENSE_UPDATED_PRICE,updatedExpense.getPrice().setScale(2));
        Assertions.assertEquals(TEST_EXPENSE_UPDATED_NAME,updatedExpense.getName());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    public void testUpdateExpenseShouldRedirectToWeddingBudgetWithErrors() throws Exception {
        Expense expense=getTestExpense();
        Assertions.assertEquals(1,this.expenseRepository.count());
        BindingResult bindingResult =(BindingResult) mockMvc
                .perform(patch("/wedding-budget/expense/" + expense.getId())
                        .param("name", TEST_EXPENSE_INVALID_UPDATED_NAME)
                        .param("price", String.valueOf(TEST_EXPENSE_INVALID_UPDATED_PRICE))
                        .param("paid", String.valueOf(TEST_EXPENSE_UPDATED_INVALID_PAID))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-budget/expense/"+expense.getId()+"/errors"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.expenseUpdateBindingModel");

        Assertions.assertTrue(bindingResult.hasFieldErrors("name"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("paid"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("price"));
    }


    private Expense getTestExpense() {
        Expense expense=new Expense()
                .setName(TEST_EXPENSE_NAME)
                .setPaid(TEST_EXPENSE_PAID)
                .setPrice(TEST_EXPENSE_PRICE)
                .setBudget(this.userRepository.findUserByEmail(TEST_USER_EMAIL).get().getWedding().getBudget());
        return this.expenseRepository.save(expense);
    }

    private User getTestUser() {
        Budget testBudget= (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET)
                .setCurrentBudget(TEST_USER_INITIAL_BUDGET);
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