package com.example.messagingapp.repository;

import com.example.messagingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    Greeting getOne(long id);
}
