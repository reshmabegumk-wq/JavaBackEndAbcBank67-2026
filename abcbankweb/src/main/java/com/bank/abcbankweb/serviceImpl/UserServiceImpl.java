package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.Role;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.RoleRepository;
import com.bank.abcbankweb.repository.UserRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.response.LoginResponse;
import com.bank.abcbankweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    @Override
    public ApiResponse saveUser(UserDTO dto) {

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() ->
                        new RuntimeException("Role Not Found"));

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setAlternateMobileNumber(dto.getAlternateMobileNumber());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setPinCode(dto.getPinCode());
        user.setCountry(dto.getCountry());
        user.setAadharNumber(dto.getAadharNumber());
        user.setPanNumber(dto.getPanNumber());
        user.setDateOfBirth(dto.getDateOfBirth());

        user.setUserName(dto.getEmail());
        user.setPassword("abcbank@123");
        user.setRole(role);

        User savedUser = userRepository.save(user);

        if (dto.getRoleId() == 2) {

            Account account = new Account();

            account.setCustomer(savedUser);

            User adminUser = userRepository.findAll()
                    .stream()
                    .filter(u -> u.getRole().getRoleId() == 1)
                    .findFirst()
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Admin User Not Found"));
            account.setApprovedBy(adminUser);

            account.setOpenedDate(LocalDate.now());
            account.setAccountType("SAVINGS");
            account.setAccountBalance(3000);
            account.setAverageAmount(3000);

            accountRepository.save(account);

            return new ApiResponse(
                    "Customer Saved & Account Created Successfully",
                    savedUser
            );
        }

        return new ApiResponse(
                "Admin User Saved Successfully",
                savedUser
        );
    }

    @Override
    public ApiResponse getAllUsers() {

        List<User> list = userRepository.findAll();

        return new ApiResponse(
                "User List Fetched Successfully",
                list
        );
    }

    @Override
    public ApiResponse getUserById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        return new ApiResponse(
                "User Found",
                user
        );
    }

    @Override
    public ApiResponse updateUser(Integer id,
                                  UserDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setAlternateMobileNumber(dto.getAlternateMobileNumber());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setPinCode(dto.getPinCode());
        user.setCountry(dto.getCountry());

        userRepository.save(user);

        return new ApiResponse(
                "User Successfully Updated",
                user
        );
    }

    @Override
    public LoginResponse login(String email,
                               String password) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid Email"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException(
                    "Invalid Password");
        }

        return new LoginResponse(
                "Login Successful",
                user.getRole().getRoleId()
        );
    }
}