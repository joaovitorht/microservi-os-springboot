package com.devsuperior.hr_user.resources;

import com.devsuperior.hr_user.entities.User;
import com.devsuperior.hr_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@RestController
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value="/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}

