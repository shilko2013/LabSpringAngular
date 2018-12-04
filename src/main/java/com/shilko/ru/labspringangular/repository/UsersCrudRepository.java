package com.shilko.ru.labspringangular.repository;

import com.shilko.ru.labspringangular.model.UserStatusEnum;
import com.shilko.ru.labspringangular.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Users crud repository.
 */
@Repository
public interface UsersCrudRepository extends CrudRepository<Users, Long> {

    @Override
    Users save(Users users);

    @Override
    Optional<Users> findById(Long id);

    @Override
    void deleteById(Long id);

    /**
     * Find by login optional.
     *
     * @param username the login
     * @return the optional
     */
    Optional<Users> findByUsername(String username);

    @Override
    List<Users> findAll();

    /**
     * Find all by user status list.
     *
     * @param userStatus the user status
     * @return the list
     */
    List<Users> findAllByUserStatus(UserStatusEnum userStatus);
}
