package com.shilko.ru.labspringangular.repository;

import com.shilko.ru.labspringangular.model.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultCrudRepository extends CrudRepository<Result, Long> {

    List<Result> findAllBySessionID(String sessionID);
}
