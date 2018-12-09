package com.shilko.ru.labspringangular.serviceimpl;

import com.shilko.ru.labspringangular.model.Result;
import com.shilko.ru.labspringangular.repository.ResultCrudRepository;
import com.shilko.ru.labspringangular.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultCrudRepository resultCrudRepository;

    private static double equalsXArray[] = new double[]{-2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2};
    private static double equalsRArray[] = new double[]{0.5, 1, 1.5, 2};

    @Override
    public Pair<Boolean, Boolean> addResult(String strX, String strY, String strR, String sessionID) {
        double x, y, r;
        try {
            x = Double.parseDouble(strX);
            y = Double.parseDouble(strY);
            r = Double.parseDouble(strR);
        } catch (Exception e) {
            return Pair.of(false, false);
        }
        if (Arrays.binarySearch(equalsXArray, x) < 0
                || Arrays.binarySearch(equalsRArray, r) < 0
                || y < -5 || y > 3)
            return Pair.of(false, false);
        boolean checking = (x < r && x > 0 && y < 0 && y > -r / 2) ||
                (x <= 0 && y <= 0 && y >= -x - r / 2) ||
                (x < 0 && y > 0 && y * y + x * x < r * r);
        Result result = new Result(x, y, r, checking, sessionID);
        resultCrudRepository.save(result);
        return Pair.of(true, checking);
    }

    @Override
    public List<Result> getAllResults(String sessionID) {
        List<Result> results = resultCrudRepository.findAllBySessionID(sessionID);
        results.forEach(e -> e.setId(null));
        results.forEach(e -> e.setSessionID(null));
        return results;
    }

    @Override
    public void disableSession(String sessionID) {
        resultCrudRepository.deleteAllBySessionID(sessionID);
    }
}
