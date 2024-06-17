package com.example.email.repository;

import com.example.email.model.Email;
import org.springframework.stereotype.Repository;

@Repository

public class EmailBoxRepository implements IEmailBoxRepository{
    private Email email=new Email("English", 25, false, "King, Asgard");
    @Override
    public Email findAll() {
        return email;
    }

    @Override
    public void save(Email email) {
         this.email=email;
    }
}
