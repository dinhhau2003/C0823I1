package com.example.email.repository;

import com.example.email.model.Email;

public interface IEmailBoxRepository {
    Email findAll();

    void save(Email email);
}
