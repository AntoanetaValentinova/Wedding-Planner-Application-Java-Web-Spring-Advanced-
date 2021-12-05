package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.repository.*;
import bg.softuni.weedinfplanner.service.RoleService;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OffersControllerTest {
    public static final String TEST_USER_EMAIL="user@user.com";
    private static final String TEST_USER_PASSWORD = "123456";
    private static final String TEST_USER_FIRST_NAME = "Test";
    private static final String TEST_USER_LAST_NAME = "Test";
    private static final LocalDate TEST_USER_DATE = LocalDate.of(2021, 12, 31);
    private static final BigDecimal TEST_USER_INITIAL_BUDGET = BigDecimal.valueOf(15000.00).setScale(2);

    private static final String TEST_SUPPLIER_EMAIL="supplier@supplier.com";
    private static final String TEST_SUPPLIER_PASSWORD="123456";
    private static final String TEST_SUPPLIER_COMPANY_NAME="TestCompanyName";
    private static final String TEST_SUPPLIER_ADDRESS="TestAddress";
    private static final String TEST_SUPPLIER_CITY="TestAddress";

    public static final String TEST_OFFER_ABOUT="TestAboutTestAboutTestAboutTestAbout";
    public static final String TEST_OFFER_DESCRIPTION="TestDescriptionTestDescriptionTestDescriptionTestDescription";
    public static final String TEST_OFFER_TITLE="TestTitle";
    public static final String TEST_OFFER_PHONE_NUMBER="+34567890987865";
    public static final StatusEnum TEST_OFFER_STATUS=StatusEnum.PENDING;
    public static final CategorySupplierEnum TEST_OFFER_CATEGORY_ENUM=CategorySupplierEnum.PHOTOGRAPHERS;
    public static final BigDecimal TEST_OFFER_MAX_PRICE=BigDecimal.valueOf(1000.00).setScale(2);
    public static final BigDecimal TEST_OFFER_MIN_PRICE=BigDecimal.valueOf(500.00).setScale(2);
    public static final LocalDate TEST_OFFER_CREATED=LocalDate.of(2021,10,10);

    public static final String TEST_OFFER_UPDATE_ABOUT="UpdateAboutUpdateAboutUpdateAbout";
    public static final String TEST_OFFER_UPDATE_DESCRIPTION="UpdateDescriptionUpdateDescriptionUpdateDescription";
    public static final String TEST_OFFER_UPDATE_TITLE="UpdateTitle";
    public static final String TEST_OFFER_PHONE_UPDATE_NUMBER="Update+34567890987865";
    public static final BigDecimal TEST_OFFER_MAX_UPDATE_PRICE=BigDecimal.valueOf(2000.00).setScale(2);
    public static final BigDecimal TEST_OFFER_MIN_UPDATE_PRICE=BigDecimal.valueOf(1000.00).setScale(2);

    public static final String TEST_OFFER_UPDATE_INVALID_ABOUT="UpdateAbout";
    public static final String TEST_OFFER_UPDATE_INVALID_DESCRIPTION="UpdateDescription";
    public static final String TEST_OFFER_UPDATE_INVALID_TITLE="U";
    public static final String TEST_OFFER_PHONE_UPDATE_INVALID_NUMBER="";
    public static final BigDecimal TEST_OFFER_MAX_UPDATE_INVALID_PRICE=BigDecimal.valueOf(-2000.00).setScale(2);
    public static final BigDecimal TEST_OFFER_MIN_UPDATE_INVALID_PRICE=null;


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private WeddingRepository weddingRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private CategorySupplierRepository categorySupplierRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @BeforeEach
    public void setUp() {
        User testUser = getTestUser();
        Supplier testSupplier = getTestSupplier();
    }


    @AfterEach
    public void tearDown() {
        this.offerRepository.deleteAll();
        this.categorySupplierRepository.deleteAll();
        this.supplierRepository.deleteAll();
        this.userRepository.deleteAll();
        this.addressRepository.deleteAll();
        this.cityRepository.deleteAll();
        this.regionRepository.deleteAll();
        this.weddingRepository.deleteAll();
        this.budgetRepository.deleteAll();
        this.roleRepository.deleteAll();
    }

    @Test
    void testAllOffersOpen() throws Exception {
        this.mockMvc
                .perform(get("/offers"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-offers"));
    }


    @Test
    void testOffersByCategoryOpen() throws Exception {
        this.mockMvc
                .perform(get("/offers/category-venues"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-offers"));
    }


    @Test
    @WithMockUser(value = TEST_USER_EMAIL,roles = "USER")
    void testOfferDetailsOpen() throws Exception {
        Offer testOffer=getTestOffer();
        Long id=testOffer.getId();
        this.mockMvc
                .perform(get("/offers/"+id))
                .andExpect(status().isOk())
                .andExpect(view().name("offer-details"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void testAddOfferOpen() throws Exception {
        this.mockMvc
                .perform(get("/offers/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("offer-add"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void testUpdateOfferOpen() throws Exception {
        Offer testOffer=getTestOffer();
        Long id=testOffer.getId();
        this.mockMvc
                .perform(get("/offers/"+id+"/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("offer-update"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void testUpdateOffer() throws Exception {
        Offer testOffer=getTestOffer();
        Long id=testOffer.getId();
        this.mockMvc
                .perform(patch("/offers/"+id+"/update")
                        .param("title",TEST_OFFER_UPDATE_TITLE)
                        .param("about",TEST_OFFER_UPDATE_ABOUT)
                        .param("description",TEST_OFFER_UPDATE_DESCRIPTION)
                        .param("minPrice",String.valueOf(TEST_OFFER_MIN_UPDATE_PRICE))
                        .param("maxPrice",String.valueOf(TEST_OFFER_MAX_UPDATE_PRICE))
                        .param("phoneNumber",TEST_OFFER_PHONE_UPDATE_NUMBER)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/offers/"+id));

        Offer offer = this.offerRepository.findById(id).orElse(null);

        Assertions.assertEquals(TEST_OFFER_UPDATE_TITLE,offer.getTitle());
        Assertions.assertEquals(TEST_OFFER_UPDATE_ABOUT,offer.getAbout());
        Assertions.assertEquals(TEST_OFFER_UPDATE_DESCRIPTION,offer.getDescription());
        Assertions.assertEquals(TEST_OFFER_MIN_UPDATE_PRICE,offer.getMinPrice());
        Assertions.assertEquals(TEST_OFFER_MAX_UPDATE_PRICE,offer.getMaxPrice());
        Assertions.assertEquals(TEST_OFFER_PHONE_UPDATE_NUMBER,offer.getPhoneNumber());
    }


    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void testUpdateOfferShouldRedirectToErrorsIfBindingResultHasErrors() throws Exception {
        Offer testOffer=getTestOffer();
        Long id=testOffer.getId();
        BindingResult bindingResult =(BindingResult) this.mockMvc
                .perform(patch("/offers/"+id+"/update")
                        .param("title", TEST_OFFER_UPDATE_INVALID_TITLE)
                        .param("about", TEST_OFFER_UPDATE_INVALID_ABOUT)
                        .param("description", TEST_OFFER_UPDATE_INVALID_DESCRIPTION)
                        .param("minPrice", String.valueOf(TEST_OFFER_MIN_UPDATE_INVALID_PRICE))
                        .param("maxPrice", String.valueOf(TEST_OFFER_MAX_UPDATE_INVALID_PRICE))
                        .param("phoneNumber", TEST_OFFER_PHONE_UPDATE_INVALID_NUMBER)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/offers/"+id+"/update/errors"))
                .andReturn().getFlashMap().get("org.springframework.validation.BindingResult.offerUpdateBindingModel");

        Assertions.assertTrue(bindingResult.hasFieldErrors("title"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("about"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("description"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("minPrice"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("maxPrice"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("phoneNumber"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL,roles = "SUPPLIER")
    void testUpdateOfferErrorsOpen() throws Exception {
        Offer testOffer=getTestOffer();
        Long id=testOffer.getId();
        this.mockMvc
                .perform(get("/offers/"+id+"/update/errors"))
                .andExpect(status().isOk())
                .andExpect(view().name("offer-update"));
    }

    private Supplier getTestSupplier() {
        Role roleSupplier = this.roleRepository.save(new Role().setName(RoleEnum.SUPPLIER));
        Region region=this.regionRepository.save(new Region().setName("TestRegion"));
        City city=this.cityRepository.save(new City().setName(TEST_SUPPLIER_CITY).setRegion(region));
        Address address=this.addressRepository.save(new Address().setCity(city).setAddress(TEST_SUPPLIER_ADDRESS));
        Supplier testSupplier=(Supplier) new Supplier()
                .setAddress(address)
                .setCompanyName(TEST_SUPPLIER_COMPANY_NAME)
                .setEmail(TEST_SUPPLIER_EMAIL)
                .setPassword(TEST_SUPPLIER_PASSWORD)
                .setRoles(Set.of(roleSupplier));
        return this.supplierRepository.save(testSupplier);
    }

    private Offer getTestOffer() {
        CategorySupplier category=new CategorySupplier()
                .setName(TEST_OFFER_CATEGORY_ENUM);
        CategorySupplier savedCategory = this.categorySupplierRepository.save(category);
        Offer offer=new Offer()
                .setAbout(TEST_OFFER_ABOUT)
                .setCreated(TEST_OFFER_CREATED)
                .setCategory(savedCategory)
                .setDescription(TEST_OFFER_DESCRIPTION)
                .setMaxPrice(TEST_OFFER_MAX_PRICE)
                .setMinPrice(TEST_OFFER_MIN_PRICE)
                .setPhoneNumber(TEST_OFFER_PHONE_NUMBER)
                .setStatus(TEST_OFFER_STATUS)
                .setTitle(TEST_OFFER_TITLE)
                .setSupplier(this.supplierRepository.findSupplierByEmail(TEST_SUPPLIER_EMAIL).orElse(null));
        return this.offerRepository.save(offer);
    }

    private User getTestUser() {
        Budget testBudget= (Budget) new Budget()
                .setInitialBudget(TEST_USER_INITIAL_BUDGET);
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