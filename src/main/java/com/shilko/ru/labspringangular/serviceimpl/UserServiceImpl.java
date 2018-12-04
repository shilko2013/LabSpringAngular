package com.shilko.ru.labspringangular.serviceimpl;

import com.shilko.ru.labspringangular.model.UserStatusEnum;
import com.shilko.ru.labspringangular.model.Users;
import com.shilko.ru.labspringangular.repository.UsersCrudRepository;
import com.shilko.ru.labspringangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        user.setUserStatus(UserStatusEnum.USER_STATUS_READER);
        usersCrudRepository.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return usersCrudRepository.findByUsername(username).orElse(null);
    }

}
