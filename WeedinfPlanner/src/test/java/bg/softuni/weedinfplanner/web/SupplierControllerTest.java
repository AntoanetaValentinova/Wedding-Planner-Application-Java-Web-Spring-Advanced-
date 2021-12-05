package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.view.UserProfileUpdateViewModel;
import bg.softuni.weedinfplanner.repository.*;
import bg.softuni.weedinfplanner.service.*;
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

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

@SpringBootTest
@AutoConfigureMockMvc
class SupplierControllerTest {

    private static final String TEST_SUPPLIER_EMAIL="supplier@supplier.com";
    private static final String TEST_SUPPLIER_PASSWORD="123456";
    private static final String TEST_SUPPLIER_CONFIRM_PASSWORD="123456";
    private static final String TEST_SUPPLIER_COMPANY_NAME="TestCompanyName";
    private static final String TEST_SUPPLIER_ADDRESS="TestAddress";
    private static final String TEST_SUPPLIER_CITY="TestAddress";

    private static final String TEST_SUPPLIER_INVALID_EMAIL="suppliersupplier.com";
    private static final String TEST_SUPPLIER_INVALID_PASSWORD="1234";
    private static final String TEST_SUPPLIER_CONFIRM_INVALID_PASSWORD="126";
    private static final String TEST_SUPPLIER_INVALID_COMPANY_NAME="T";
    private static final String TEST_SUPPLIER_INVALID_ADDRESS="T";
    private static final String TEST_SUPPLIER_INVALID_CITY=null;

    private static final String TEST_SUPPLIER_UPDATE_COMPANY_NAME="UpdatedCompanyName";
    private static final String TEST_SUPPLIER_UPDATE_ADDRESS="UpdatedAddress";
    private static final String TEST_SUPPLIER_UPDATE_CITY="UpdatedAddress";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SupplierRepository supplierRepository;
    @MockBean
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SupplierService supplierService;
    @MockBean
    private CityService cityService;

    @BeforeEach
    public void setUp() {
        Role roleSupplier = this.roleRepository.save(new Role().setName(RoleEnum.SUPPLIER));

        Mockito.when(this.roleService.findRoleByName(roleSupplier.getName()))
                .thenReturn(roleSupplier);
        Region region=this.regionRepository.save(new Region().setName("TestRegion"));

        City city=this.cityRepository.save(new City().setName(TEST_SUPPLIER_CITY).setRegion(region));
        City cityUpdate=this.cityRepository.save(new City().setName(TEST_SUPPLIER_UPDATE_CITY).setRegion(region));

        Mockito.when(this.cityService.findByName(TEST_SUPPLIER_CITY))
                .thenReturn(city);
        Mockito.when(this.cityService.findByName(TEST_SUPPLIER_UPDATE_CITY))
                .thenReturn(cityUpdate);

        Address address=this.addressRepository.save(new Address().setCity(city).setAddress(TEST_SUPPLIER_ADDRESS));

        Supplier testSupplier=(Supplier) new Supplier()
                .setAddress(address)
                .setCompanyName(TEST_SUPPLIER_COMPANY_NAME)
                .setEmail(TEST_SUPPLIER_EMAIL)
                .setPassword(TEST_SUPPLIER_PASSWORD)
                .setRoles(Set.of(roleSupplier));
        this.supplierRepository.save(testSupplier);
    }

    @AfterEach
    public void tearDown() {
        this.supplierRepository.deleteAll();
        this.roleRepository.deleteAll();
        this.addressRepository.deleteAll();
        this.cityRepository.deleteAll();
        this.regionRepository.deleteAll();

    }

    @Test
    void testOpenRegisterSupplier() throws Exception {
        mockMvc
                .perform(get("/register/supplier"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-supplier"));
    }

    @Test
    void testRegisterUser() throws Exception {
        this.supplierRepository.deleteAll();
        this.addressRepository.deleteAll();
        mockMvc
                .perform(
                        post("/register/supplier")
                                .param("email", TEST_SUPPLIER_EMAIL)
                                .param("password", TEST_SUPPLIER_PASSWORD)
                                .param("confirmPassword", TEST_SUPPLIER_CONFIRM_PASSWORD)
                                .param("companyName", TEST_SUPPLIER_COMPANY_NAME)
                                .param("address", TEST_SUPPLIER_ADDRESS)
                                .param("city",TEST_SUPPLIER_CITY)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, this.supplierRepository.count());

        Optional<Supplier> supplierByEmail = this.supplierRepository.findSupplierByEmail(TEST_SUPPLIER_EMAIL);

        Assertions.assertTrue(supplierByEmail.isPresent());

        Assertions.assertEquals(TEST_SUPPLIER_EMAIL, supplierByEmail.get().getEmail());
        Assertions.assertTrue(this.passwordEncoder.matches(TEST_SUPPLIER_PASSWORD, supplierByEmail.get().getPassword()));
        Assertions.assertEquals(TEST_SUPPLIER_COMPANY_NAME, supplierByEmail.get().getCompanyName());
        Assertions.assertEquals(TEST_SUPPLIER_ADDRESS, supplierByEmail.get().getAddress().getAddress());
        Assertions.assertEquals(TEST_SUPPLIER_CITY, supplierByEmail.get().getAddress().getCity().getName());
    }

    @Test
    public void testRegisterSupplierWithInvalidParamsShouldRedirectWithErrors() throws Exception {
        BindingResult bindingResult = (BindingResult) mockMvc
                .perform(
                        post("/register/supplier")
                                .param("email", TEST_SUPPLIER_INVALID_EMAIL)
                                .param("password", TEST_SUPPLIER_INVALID_PASSWORD)
                                .param("confirmPassword", TEST_SUPPLIER_CONFIRM_INVALID_PASSWORD)
                                .param("companyName", TEST_SUPPLIER_INVALID_COMPANY_NAME)
                                .param("address", TEST_SUPPLIER_INVALID_ADDRESS)
                                .param("city",TEST_SUPPLIER_INVALID_CITY)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register/supplier"))
                .andExpect(flash().attributeExists("org.springframework.validation.BindingResult.supplierRegisterBindingModel"))
                .andReturn().getFlashMap().get("org.springframework.validation.BindingResult.supplierRegisterBindingModel");

        Assertions.assertTrue(bindingResult.hasErrors());
        Assertions.assertTrue(bindingResult.hasFieldErrors("email"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("password"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("companyName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("address"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("city"));
    }

    @Test
    public void profilePageOpenFromUnauthenticatedUserShouldRedirectToLoginPage() throws Exception {
        mockMvc
                .perform(get("/supplier-profile"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "user@user.com", roles = "USER")
    public void profilePageOpenFromAuthenticatedWithNoUserRoleShouldReturnStatus403Forbidden() throws Exception {
        mockMvc
                .perform(get("/supplier-profile"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL, roles = "SUPPLIER")
    public void profilePageOpenFromAuthenticatedSupplier() throws Exception {
        mockMvc
                .perform(get("/supplier-profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("supplier-profile"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL, roles = "SUPPLIER")
    public void profilePageUpdate() throws Exception {
        mockMvc
                .perform(
                        patch("/supplier-profile")
                                .param("companyName",TEST_SUPPLIER_UPDATE_COMPANY_NAME)
                                .param("address",TEST_SUPPLIER_UPDATE_ADDRESS)
                                .param("cityName",TEST_SUPPLIER_UPDATE_CITY)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/supplier-profile"));

        Supplier supplier = this.supplierRepository.findSupplierByEmail(TEST_SUPPLIER_EMAIL).get();
        Assertions.assertEquals(TEST_SUPPLIER_UPDATE_COMPANY_NAME,supplier.getCompanyName());
        Assertions.assertEquals(TEST_SUPPLIER_UPDATE_ADDRESS,supplier.getAddress().getAddress());
        Assertions.assertEquals(TEST_SUPPLIER_UPDATE_CITY,supplier.getAddress().getCity().getName());
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL, roles = "SUPPLIER")
    public void testUpdateUserWithInvalidParamsShouldRedirectWithErrors() throws Exception {
        BindingResult bindingResult = (BindingResult) mockMvc
                .perform(
                        patch("/supplier-profile")
                                .param("companyName",TEST_SUPPLIER_INVALID_COMPANY_NAME)
                                .param("address",TEST_SUPPLIER_INVALID_ADDRESS)
                                .param("cityName",TEST_SUPPLIER_INVALID_CITY)
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/supplier-profile/errors"))
                .andExpect(flash().attributeExists("org.springframework.validation.BindingResult.supplierProfileUpdateBindingModel"))
                .andReturn().getFlashMap().get("org.springframework.validation.BindingResult.supplierProfileUpdateBindingModel");

        Assertions.assertTrue(bindingResult.hasErrors());
        Assertions.assertTrue(bindingResult.hasFieldErrors("companyName"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("address"));
        Assertions.assertTrue(bindingResult.hasFieldErrors("cityName"));
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL, roles = "SUPPLIER")
    public void openErrorPageFromUpdateSupplierProfile() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/errors"))
                .andExpect(status().isOk())
                .andExpect(view().name("supplier-profile"));
    }

    @Test
    public void openErrorPageWithNonAuthenticatedUserShouldRedirectToLogin() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/errors"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "user@user.com", roles = "USER")
    public void openErrorPageWithUserRoleShouldReturn403() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/errors"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(value = TEST_SUPPLIER_EMAIL, roles = "SUPPLIER")
    public void openMyOffersPageFromUpdateSupplierProfile() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/my-offers"))
                .andExpect(status().isOk())
                .andExpect(view().name("my-offers"));
    }

    @Test
    public void openMyOffersPageWithNonAuthenticatedUserShouldRedirectToLogin() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/my-offers"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "user@user.com", roles = "USER")
    public void openMyOffersPageWithUserRoleShouldReturn403() throws Exception {
        mockMvc
                .perform(get("/supplier-profile/my-offers"))
                .andExpect(status().isForbidden());
    }
}