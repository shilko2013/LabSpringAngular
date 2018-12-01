package com.shilko.ru.labspringangular.serviceimpl;

import com.shilko.ru.labspringangular.model.Result;
import com.shilko.ru.labspringangular.repository.ResultCrudRepository;
import com.shilko.ru.labspringangular.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    HttpSession httpSession;

    @Autowired
    ResultCrudRepository resultCrudRepository;

    @Override
    public boolean addResult(double x, double y, double r) {
        try {
            boolean checking = false; //TODO add checking
            Result result = new Result(x, y, r, checking, httpSession.getId());
            resultCrudRepository.save(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Result> getAllResults() {
        return resultCrudRepository.findAllBySessionID(httpSession.getId());
    }

    @Override
    public void disableSession() {
        httpSession.invalidate();
    }
}
