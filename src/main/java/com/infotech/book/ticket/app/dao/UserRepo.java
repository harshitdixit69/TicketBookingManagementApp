package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import com.infotech.book.ticket.app.entities.Entities;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Entities, Integer> {
    Optional<Entities> findByUsername(String username);
}
