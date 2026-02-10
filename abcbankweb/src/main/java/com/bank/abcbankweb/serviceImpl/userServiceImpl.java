package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.entity.*;
import com.bank.abcbankweb.repository.*;
import com.bank.abcbankweb.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    public userServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public String saveUser(UserDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User name already exists");
        }


        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = mapToEntity(dto);
        user.setRole(role);

        User savedUser = userRepository.save(user);

        // 🔹 Auto Create Account
        Account acc = new Account();
        acc.setAccountType("SAVINGS");
        acc.setBalance(0);
        acc.setOpenedDate(LocalDate.now());
        acc.setUser(savedUser);

        accountRepository.save(acc);

        return "User and Account created successfully";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }

//    @Override
//    public UserDTO login(String userName, String password) {
//
//        User user = userRepository
//                .findByUserNameAndPassword(userName, password)
//                .orElseThrow(() ->
//                        new RuntimeException("Invalid Username or Password"));
//
//        return mapToDTO(user);
//    }

    @Override
    public LoginDTO login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginDTO(
                user.getEmail(),     // email
                null,                // password not returned
                "Login successful",  // message
                user.getRole().getRoleId()
        );
    }





    private UserDTO mapToDTO(User u) {

        UserDTO d = new UserDTO();

        d.setUserId(u.getUserId());
        d.setFirstName(u.getFirstName());
        d.setLastName(u.getLastName());
        d.setMobileNumber(u.getMobileNumber());
        d.setAlternateMobileNumber(u.getAlternateMobileNumber());
        d.setEmail(u.getEmail());
        d.setAddress(u.getAddress());
        d.setCity(u.getCity());
        d.setState(u.getState());
        d.setPinCode(u.getPinCode());
        d.setCountry(u.getCountry());
        d.setAadharNumber(u.getAadharNumber());
        d.setPanNumber(u.getPanNumber());
        d.setDateOfBirth(u.getDateOfBirth());
        d.setUserName(u.getUserName());
        d.setRoleId(u.getRole().getRoleId());

        return d;
    }

    private User mapToEntity(UserDTO dto) {

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
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());

        return user;
    }
}

