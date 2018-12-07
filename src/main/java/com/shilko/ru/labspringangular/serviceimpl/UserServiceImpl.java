package com.shilko.ru.labspringangular.serviceimpl;

import com.shilko.ru.labspringangular.model.Users;
import com.shilko.ru.labspringangular.repository.UsersCrudRepository;
import com.shilko.ru.labspringangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersCrudRepository usersCrudRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersCrudRepository.save(user);
    }

    @Override
    public boolean exist(String username, String password) {
        Optional<Users> user = usersCrudRepository.findByUsername(username);
        return user.map(users -> users.getPassword().equals(bCryptPasswordEncoder.encode(password))).orElse(false);
    }

    @Override
    public Users findByUsername(String username) {
        return usersCrudRepository.findByUsername(username).orElse(null);
    }

}
