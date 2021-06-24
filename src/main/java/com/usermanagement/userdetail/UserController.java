package com.usermanagement.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable int id) {

        return userService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/email/{name}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PostMapping("register")
    public String registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return "Congratulation " + user.getName() + " ,You have been Successfully registered";

    }


    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        Optional<User> deletedUserData = userService.getById(id);

        userService.deleteUser(id);
        return "The User with name " + deletedUserData.get().getName() + " deleted successfully";

    }

    @PutMapping("{id}")
    public String updateUser(@PathVariable("id") Integer id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String password,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String number) {
        userService.updateUser(id,name,password,email,number);
        return "User update successfully";
    }
}
