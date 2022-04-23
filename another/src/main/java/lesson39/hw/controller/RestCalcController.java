package lesson39.hw.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class RestCalcController {

    @GetMapping("/loggerCalc")
    public void aspectCalc (@RequestParam @NotEmpty String method, @RequestParam String params) {
       log.info("Сообщение от Aspect: Был вызван метод {} с параметрами {}", method, params);
    }
}
