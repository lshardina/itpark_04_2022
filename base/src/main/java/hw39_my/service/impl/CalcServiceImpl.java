package hw39_my.service.impl;

import hw39_my.service.CalcService;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public Integer summ(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }
}
