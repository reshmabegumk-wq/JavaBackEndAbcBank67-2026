package com.bank.abcbankweb.repository;//package com.bank.abcbankweb.repository;
//
//import com.bank.abcbankweb.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, Integer> {
//
//    Optional<User> findByUserNameAndPassword(String userName, String password);
//
//    boolean existsByEmail(String Email );
//}


import com.bank.abcbankweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    // OR if you have username column
    Optional<User> findByUserName(String userName);

    boolean existsByEmail(String email);
}
