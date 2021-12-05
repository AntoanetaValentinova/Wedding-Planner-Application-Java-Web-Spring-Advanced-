package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;
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
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WeddingGuestsControllerTest {

    public static final String TEST_USER_EMAIL = "user@user.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);

    private static final String TEST_USER_PARTNER_FIRST_NAME = "TestPartnerFirstName";
    private static final String TEST_USER_PARTNER_LAST_NAME = "TestPartnerLastName";
    private static final String TEST_USER_PARTNER_FIRST_NAME_INVALID = "T";
    private static final String TEST_USER_PARTNER_LAST_NAME_INVALID = "";

    private static final AttendEnum TEST_GUEST_ATTEND = AttendEnum.PENDING;
    private static final String TEST_GUEST_FIRST_NAME = "TestGuestFirstName";
    private static final String TEST_GUEST_LAST_NAME = "TestGuestLastName";
    private static final String TEST_GUEST_EMAIL = "guest@email";
    private static final String TEST_GUEST_PHONE_NUMBER = "234567890";
    private static final TypeGuestEnum TEST_GUEST_TYPE = TypeGuestEnum.FAMILY;
    private static final AgeEnum TEST_GUEST_AGE = AgeEnum.ADULT;
    private static final boolean TEST_GUEST_NEED_HOTEL = true;

    private static final AttendEnum TEST_GUEST_INVALID_ATTEND = null;
    private static final String TEST_GUEST_FIRST_INVALID_NAME = "T";
    private static final String TEST_GUEST_LAST_INVALID_NAME = "";
    private static final String TEST_GUEST_INVALID_EMAIL = "TestGuestEmail";

    private static final AttendEnum TEST_GUEST_ATTEND_UPDATED = AttendEnum.ATTENDING;
    private static final String TEST_GUEST_FIRST_NAME_UPDATED = "UpdatedGuestFirstName";
    private static final String TEST_GUEST_LAST_NAME_UPDATED = "UpdatedGuestLastName";
    private static final String TEST_GUEST_EMAIL_UPDATED = "updated@email";
    private static final String TEST_GUEST_PHONE_NUMBER_UPDATED = "updated234567890";


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
    private GuestRepository guestRepository;

    @BeforeEach
    public void setUp() {
        User testUser = getTestUser();
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
        this.guestRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testOpenWeddingGuestsPage() throws Exception {
        mockMvc
                .perform(get("/wedding-guests"))
                .andExpect(status().isOk())
                .andExpect(view().name("wedding-guests"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testAddPartner() throws Exception {
        mockMvc
                .perform(patch("/wedding-guests/add-partner")
                        .param("partnerFirstName", TEST_USER_PARTNER_FIRST_NAME)
                        .param("partnerLastName", TEST_USER_PARTNER_LAST_NAME)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"));

        User userByEmail = this.userRepository.findUserByEmail(TEST_USER_EMAIL).orElse(null);

        Assertions.assertEquals(TEST_USER_PARTNER_FIRST_NAME, userByEmail.getPartnerFirstName());
        Assertions.assertEquals(TEST_USER_PARTNER_LAST_NAME, userByEmail.getPartnerLastName());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testAddPartnerShouldRedirectToWeddingGuestsPageWithErrors() throws Exception {
        BindingResult bindingResult =(BindingResult) mockMvc
                .perform(patch("/wedding-guests/add-partner")
                        .param("partnerFirstName", TEST_USER_PARTNER_FIRST_NAME_INVALID)
                        .param("partnerLastName", TEST_USER_PARTNER_LAST_NAME_INVALID)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.partnerNamesAddBindingModel");

        Assertions.assertEquals(0, this.guestRepository.count());

        Assertions.assertTrue(bindingResult.hasFieldErrors("partnerFirstName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("partnerLastName"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testAddGuest() throws Exception {
        mockMvc
                .perform(post("/wedding-guests")
                        .param("attend", String.valueOf(TEST_GUEST_ATTEND))
                        .param("firstName", TEST_GUEST_FIRST_NAME)
                        .param("lastName", TEST_GUEST_LAST_NAME)
                        .param("email", TEST_GUEST_EMAIL)
                        .param("phoneNumber", TEST_GUEST_PHONE_NUMBER)
                        .param("type", String.valueOf(TEST_GUEST_TYPE))
                        .param("age", String.valueOf(TEST_GUEST_AGE))
                        .param("needHotel", String.valueOf(TEST_GUEST_NEED_HOTEL))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"));

        Assertions.assertEquals(1, this.guestRepository.count());

        Guest guest = this.guestRepository.findAll().get(0);

        Assertions.assertEquals(TEST_GUEST_ATTEND, guest.getAttend());
        Assertions.assertEquals(TEST_GUEST_FIRST_NAME, guest.getFirstName());
        Assertions.assertEquals(TEST_GUEST_LAST_NAME, guest.getLastName());
        Assertions.assertEquals(TEST_GUEST_EMAIL, guest.getEmail());
        Assertions.assertEquals(TEST_GUEST_PHONE_NUMBER, guest.getPhoneNumber());
        Assertions.assertEquals(TEST_GUEST_TYPE, guest.getType());
        Assertions.assertEquals(TEST_GUEST_AGE, guest.getAge());
        Assertions.assertEquals(TEST_GUEST_NEED_HOTEL, guest.isNeedHotel());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testAddGuestShouldRedirectToWeddingGuestsPageWithErrors() throws Exception {
        BindingResult bindingResult =(BindingResult) mockMvc
                .perform(post("/wedding-guests")
                        .param("attend", String.valueOf(TEST_GUEST_INVALID_ATTEND))
                        .param("firstName", TEST_GUEST_FIRST_INVALID_NAME)
                        .param("lastName", TEST_GUEST_LAST_INVALID_NAME)
                        .param("email", TEST_GUEST_INVALID_EMAIL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.guestAddBindingModel");

        Assertions.assertEquals(0, this.guestRepository.count());

        Assertions.assertTrue(bindingResult.hasFieldErrors("attend"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("firstName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("lastName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("email"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testGuestUpdatePageOpen() throws Exception {
        Guest testGuest = getTestGuest();
        mockMvc
                .perform(get("/wedding-guests/"+testGuest.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("guest-update"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testUpdateGuest() throws Exception {
        Guest guest=getTestGuest();
        mockMvc
                .perform(patch("/wedding-guests/"+guest.getId())
                        .param("attend", String.valueOf(TEST_GUEST_ATTEND_UPDATED))
                        .param("firstName", TEST_GUEST_FIRST_NAME_UPDATED)
                        .param("lastName", TEST_GUEST_LAST_NAME_UPDATED)
                        .param("email", TEST_GUEST_EMAIL_UPDATED)
                        .param("phoneNumber", TEST_GUEST_PHONE_NUMBER_UPDATED)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"));

        Assertions.assertEquals(1, this.guestRepository.count());

        Guest guestUpdated = this.guestRepository.findById(guest.getId()).orElse(null);

        Assertions.assertEquals(TEST_GUEST_ATTEND_UPDATED, guestUpdated.getAttend());
        Assertions.assertEquals(TEST_GUEST_FIRST_NAME_UPDATED, guestUpdated.getFirstName());
        Assertions.assertEquals(TEST_GUEST_LAST_NAME_UPDATED, guestUpdated.getLastName());
        Assertions.assertEquals(TEST_GUEST_EMAIL_UPDATED, guestUpdated.getEmail());
        Assertions.assertEquals(TEST_GUEST_PHONE_NUMBER_UPDATED, guestUpdated.getPhoneNumber());
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testUpdateGuestShouldRedirectToWeddingGuestsPageWithErrors() throws Exception {
        Guest testGuest = getTestGuest();
        BindingResult bindingResult =(BindingResult) mockMvc
                .perform(patch("/wedding-guests/"+testGuest.getId())
                        .param("attend", String.valueOf(TEST_GUEST_INVALID_ATTEND))
                        .param("firstName", TEST_GUEST_FIRST_INVALID_NAME)
                        .param("lastName", TEST_GUEST_LAST_INVALID_NAME)
                        .param("email", TEST_GUEST_INVALID_EMAIL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests/"+testGuest.getId()+"/errors"))
                .andReturn()
                .getFlashMap()
                .get("org.springframework.validation.BindingResult.guestUpdateBindingModel");

        Assertions.assertEquals(1, this.guestRepository.count());

        Assertions.assertTrue(bindingResult.hasFieldErrors("attend"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("firstName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("lastName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("email"));
    }

    @Test
    @WithMockUser(value = TEST_USER_EMAIL, roles = "USER")
    public void testDeleteGuest() throws Exception {
        Guest testGuest = getTestGuest();
        mockMvc
                .perform(delete("/wedding-guests/"+testGuest.getId())
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/wedding-guests"));

        Assertions.assertEquals(0, this.guestRepository.count());
    }

    private Guest getTestGuest() {
        Guest guest=new Guest()
                .setAge(TEST_GUEST_AGE)
                .setAttend(TEST_GUEST_ATTEND)
                .setEmail(TEST_GUEST_EMAIL)
                .setFirstName(TEST_GUEST_FIRST_NAME)
                .setLastName(TEST_GUEST_LAST_NAME)
                .setNeedHotel(TEST_GUEST_NEED_HOTEL)
                .setPhoneNumber(TEST_GUEST_PHONE_NUMBER)
                .setWeddingToAttend(this.weddingRepository.findWeddingByUserEmail(TEST_USER_EMAIL).get());
        return this.guestRepository.save(guest);
    }

    private User getTestUser() {
        Budget testBudget = (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET)
                .setCurrentBudget(TEST_USER_INITIAL_BUDGET);
        Budget savedBudget = this.budgetRepository.save(testBudget);

        Wedding testWedding = (Wedding) new Wedding()
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