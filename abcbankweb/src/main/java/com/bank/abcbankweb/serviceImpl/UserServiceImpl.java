package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.entity.Role;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.repository.RoleRepository;
import com.bank.abcbankweb.repository.UserRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.response.LoginResponse;
import com.bank.abcbankweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final RoleRepository roleRepository;

    @Override
    public ApiResponse saveUser(UserDTO dto) {

        User u = new User();

        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setMobileNumber(dto.getMobileNumber());
        u.setAlternativeNumber(dto.getAlternativeNumber());
        u.setEmail(dto.getEmail());
        u.setDateOfBirth(dto.getDateOfBirth());
        u.setAddress(dto.getAddress());
        u.setCity(dto.getCity());
        u.setState(dto.getState());
        u.setCountry(dto.getCountry());
        u.setPincode(dto.getPincode());
        u.setPanCard(dto.getPanCard());
        u.setAadhar(dto.getAadhar());
        u.setUserName(dto.getUserName());
        u.setPassword(dto.getPassword());

        Role role =
                roleRepository.findById(dto.getRoleId())
                        .orElse(null);

        u.setRole(role);

        repo.save(u);

        return new ApiResponse(
                "User saved successfully",
                u
        );
    }

    @Override
    public ApiResponse getAllUsers() {

        List<User> list = repo.findAll();

        if (list.isEmpty()) {
            return new ApiResponse(
                    "No users found",
                    null
            );
        }

        return new ApiResponse(
                "Users fetched successfully",
                list
        );
    }

    @Override
    public ApiResponse getUserById(Integer id) {

        User u = repo.findById(id).orElse(null);

        if (u == null) {
            return new ApiResponse(
                    "User not found",
                    null
            );
        }

        return new ApiResponse(
                "User fetched successfully",
                u
        );
    }

    @Override
    public ApiResponse updateUser(Integer id, UserDTO dto) {

        User u = repo.findById(id).orElse(null);

        if (u == null) {
            return new ApiResponse(
                    "User not found",
                    null
            );
        }

        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setMobileNumber(dto.getMobileNumber());
        u.setAlternativeNumber(dto.getAlternativeNumber());
        u.setEmail(dto.getEmail());
        u.setDateOfBirth(dto.getDateOfBirth());
        u.setAddress(dto.getAddress());
        u.setCity(dto.getCity());
        u.setState(dto.getState());
        u.setCountry(dto.getCountry());
        u.setPincode(dto.getPincode());
        u.setPanCard(dto.getPanCard());
        u.setAadhar(dto.getAadhar());

        Role role =
                roleRepository.findById(dto.getRoleId())
                        .orElse(null);

        u.setRole(role);

        repo.save(u);

        return new ApiResponse(
                "User updated successfully",
                u
        );
    }

    @Override
    public LoginResponse login(LoginDTO dto) {

        User u =
                repo.findByUserNameAndPassword(
                                dto.getUserName(),
                                dto.getPassword())
                        .orElse(null);

        if (u == null) {
            return new LoginResponse(
                    "Invalid username or password",
                    null,
                    "FAILED"
            );
        }

        return new LoginResponse(
                "Login successful",
                u.getRole().getRoleId(),
                "ACTIVE"
        );
    }
}