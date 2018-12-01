package com.shilko.ru.labspringangular.service;

import com.shilko.ru.labspringangular.model.Result;

import java.util.List;

public interface ResultService {

    boolean addResult(double x, double y, double r);

    List<Result> getAllResults();

    void disableSession();
}
