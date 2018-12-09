package com.shilko.ru.labspringangular.service;

import com.shilko.ru.labspringangular.model.Result;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ResultService {

    Pair<Boolean, Boolean> addResult(String strX, String strY, String strR, String sessionID);

    List<Result> getAllResults(String sessionID);

    void disableSession(String sessionID);
}
