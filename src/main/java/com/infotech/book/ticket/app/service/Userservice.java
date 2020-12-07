package com.infotech.book.ticket.app.service;

import java.util.Optional;

import com.infotech.book.ticket.app.dao.UserRepo;
import com.infotech.book.ticket.app.dao.UserSubmitRepo;
import com.infotech.book.ticket.app.entities.Entities;
import com.infotech.book.ticket.app.entities.MyuserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice implements UserDetailsService {

    @Autowired
    private UserSubmitRepo userSubmitRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Entities create(Entities entities) {
        entities.setPassword(encoder.encode(entities.getPassword()));
        return userSubmitRepo.save(entities);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Entities> findByUserName = userRepo.findByUsername(username);
        findByUserName.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
        return findByUserName.map(MyuserDetail::new).get();
    }
}
