package com.infotech.book.ticket.app.dao;

import com.infotech.book.ticket.app.entities.Entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubmitRepo extends CrudRepository<Entities, Integer> {

}