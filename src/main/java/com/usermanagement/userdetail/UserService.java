package com.usermanagement.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();

    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void addNewUser(User user) {
        if (getByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Integer id, String name, String password, String email, String number) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " doesnot exist"));
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
            System.out.println(name);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
            System.out.println(password);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> user1 = userRepository.findByEmail(email);
            if(user1.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
            System.out.println(email);
        }
        if (number != null && number.length() > 0 && !Objects.equals(user.getNumber(), number)) {
            user.setNumber(number);
            System.out.println(number);
        }
    }
}
