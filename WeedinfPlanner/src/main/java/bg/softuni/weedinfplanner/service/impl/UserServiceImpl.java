package bg.softuni.weedinfplanner.service.impl;
import bg.softuni.weedinfplanner.model.entity.*;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.service.*;
import bg.softuni.weedinfplanner.model.view.UserProfileUpdateViewModel;
import bg.softuni.weedinfplanner.repository.UserRepository;
import bg.softuni.weedinfplanner.service.*;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final WeddingService weddingService;
    private final WPUserServiceImpl wpUserService;
    private final BudgetService budgetService;
    private final ExpenseService expenseService;
    private final TaskService taskService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService, ModelMapper modelMapper, WeddingService weddingService, WPUserServiceImpl wpUserService, BudgetService budgetService, ExpenseService expenseService, TaskService taskService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.weddingService = weddingService;
        this.wpUserService = wpUserService;
        this.budgetService = budgetService;
        this.expenseService = expenseService;
        this.taskService = taskService;
    }


    @Override
    public void save(UserRegisterServiceModel userRegisterServiceModel) {
        //create new User and set properties
        User userToRegister = this.modelMapper.map(userRegisterServiceModel, User.class);
        userToRegister.setPassword(this.passwordEncoder.encode(userRegisterServiceModel.getPassword()));
        userToRegister.setRoles(Set.of(this.roleService.findRoleByName(RoleEnum.USER)));

        //create Wedding entity
        Wedding newWedding = new Wedding();
        newWedding.setDate(userRegisterServiceModel.getDate());
        //create Budget entity and save it
        Budget budget=new Budget();
        budget.setInitialBudget(userRegisterServiceModel.getInitialBudget());
        budget.setCurrentBudget(userRegisterServiceModel.getInitialBudget());
        Budget savedBudget = this.budgetService.save(budget);
        //set Budget entity to Wedding entity and save Wedding entity
        newWedding.setBudget(savedBudget);
        Wedding savedWedding = this.weddingService.save(newWedding);

        initializeExpenses(savedBudget);
        initializeTasks(savedWedding);

        //set Wedding entity to User and save it
        userToRegister.setWedding(newWedding);
        User registeredUser = this.userRepository.save(userToRegister);

        //login user - Spring Security
        login(registeredUser);
    }


    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
    }

    @Override
    public BrideAndGroomNamesServiceModel findBrideAndGroomNamesViewModel(Principal principal) {
        User currentUser=getCurrentUser(principal);
        return this.modelMapper.map(currentUser,BrideAndGroomNamesServiceModel.class);
    }

    @Override
    public void savePartnerNames(PartnerNamesAddServiceModel partnerNamesAddServiceModel,Principal principal) {
        User currentUser = getCurrentUser(principal);
        currentUser.setPartnerFirstName(partnerNamesAddServiceModel.getPartnerFirstName());
        currentUser.setPartnerLastName(partnerNamesAddServiceModel.getPartnerLastName());
        this.userRepository.save(currentUser);
    }

    @Override
    public User getCurrentUser(Principal principal) {
        return this.userRepository.findUserByEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
    }

    @Override
    public UserProfileUpdateViewModel getUserProfileViewModelByEmail(String email) {
        User user = this.userRepository.findUserByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
        return this.modelMapper.map(user,UserProfileUpdateViewModel.class);
    }

    @Override
    public void updateUserProfile(UserProfileUpdateServiceModel userProfileUpdateServiceModel, Principal principal) {
        User user = this.userRepository.findUserByEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        user.setFirstName(userProfileUpdateServiceModel.getFirstName());
        user.setLastName(userProfileUpdateServiceModel.getLastName());
        user.setPartnerFirstName(userProfileUpdateServiceModel.getPartnerFirstName());
        user.setPartnerLastName(userProfileUpdateServiceModel.getPartnerLastName());
        this.userRepository.save(user);
    }

    @Override
    public List<UsersAllServiceModel> findAllUsers() {
        return  this.userRepository.findAll()
                .stream()
                .map(user -> {
                    UsersAllServiceModel usersAllServiceModel = this.modelMapper.map(user, UsersAllServiceModel.class);
                    user.getRoles()
                            .forEach(role -> usersAllServiceModel.getRoleEnums().add(role.getName()));
                    return usersAllServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public void makeUserAdmin(String email) {
        User user = this.userRepository.findUserByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
        user.getRoles().add(this.roleService.findRoleByName(RoleEnum.ADMIN));
        this.userRepository.save(user);
    }

    @Override
    public void removeAdminRole(String email) {
        User user = this.userRepository.findUserByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
        if(user.getId()!=1) {
           user.getRoles().remove(this.roleService.findRoleByName(RoleEnum.ADMIN));
           this.userRepository.save(user);
        }
    }



    private void initializeTasks(Wedding savedWedding) {
        List<Task> allInitialExpenses = this.taskService.findAllInitialTasks();
        allInitialExpenses.forEach(task -> {
            Task taskForCurrentUser=new Task();
            taskForCurrentUser.setInitial(false);
            taskForCurrentUser.setCompleted(false);
            taskForCurrentUser.setDescription(task.getDescription());
            taskForCurrentUser.setWedding(savedWedding);
            this.taskService.save(taskForCurrentUser);
        });
    }

    private void initializeExpenses(Budget savedBudget) {
        List<Expense> allInitialExpenses = this.expenseService.findAllInitialExpenses();
        allInitialExpenses.forEach(expense -> {
            Expense expenseForCurrentUser=new Expense();
            expenseForCurrentUser.setInitial(false);
            expenseForCurrentUser.setBudget(savedBudget);
            expenseForCurrentUser.setName(expense.getName());
            expenseForCurrentUser.setPaid(BigDecimal.valueOf(0L));
            expenseForCurrentUser.setPrice(BigDecimal.valueOf(0L));
            this.expenseService.save(expenseForCurrentUser);
        });
    }

    private void login(User registeredUser) {
        UserDetails principal = this.wpUserService.loadUserByUsername(registeredUser.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                registeredUser.getPassword(),
                principal.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
