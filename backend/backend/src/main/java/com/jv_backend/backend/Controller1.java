package com.jv_backend.backend;

import com.jv_backend.backend.Repo.UserRepo;
import com.jv_backend.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller1 {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/welcome")
    public String welcome(){
        return "hello and welcome!";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user)
    {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String DeleteUser(@PathVariable long id)
    {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted user with id: "+id;
    }
}
