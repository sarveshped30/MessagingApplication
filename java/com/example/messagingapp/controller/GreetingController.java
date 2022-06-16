package com.example.messagingapp.controller;

import com.example.messagingapp.model.Greeting;
import com.example.messagingapp.model.User;
import com.example.messagingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controller class with @RestController annotation which receives rest api calls
 * and provide response in form json or xml */
@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "fName",defaultValue = "World") String fName,
                             @RequestParam(value = "lName", defaultValue = "World") String lName) {
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.addGreeting(user);
    }

    /* Requesting all data for server */
    @GetMapping("/messages")
    public List<Greeting> greeting() {
        return greetingService.getGreetings();
    }

    /* Requesting particular data with specified id from server */
    @GetMapping("/messages/{id}")
    public Optional<Greeting> greeting(@PathVariable long id) {
        return greetingService.getGreetingById(id);
    }

    /* Sending data to server */
    @PostMapping("/messages")
    public Greeting greeting(User user) {
        return greetingService.postGreetings(user);
    }

    /* Deleting specific data from server as per specified id */
    @DeleteMapping("/messages/{id}")
    public void deleteGreeting(@PathVariable long id) {
         greetingService.deleteGreetingById(id);
    }

    /* Updating data to server */
    @PutMapping("/messages")
    public Greeting updateGreetingMessage(@RequestBody Greeting greeting) {
        return greetingService.updateGreetings(greeting);
    }
}
