package hw39_my;

import hw39_my.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class AspectCalcRunner {

    private static final Integer A = 8;
    private static final Integer B = 24;
    private static final Integer C = 51;

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(AspectCalcRunner.class, args);
        final CalcService calcService = applicationContext.getBean(CalcService.class);

        log.info("Сумма {} и {} равна {}", A, B, calcService.summ(A, B));
        log.info("Сумма {} и {} равна {}", B, C, calcService.summ(B, C));

    }
}
