package RegInsurers.controller;

import RegInsurers.dto.InsurerDto;
import RegInsurers.service.InsurerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Controller
//@RestController
@RequiredArgsConstructor
public class InsurerPageController {

    private final InsurerService insurerService;

    @GetMapping("/insurers")
    public String index() {
        return "insurer/insurers";
    }

    @GetMapping("/insurer/add")
    public String newInsurer() {
        return "insurer/insurer";
    }

    @GetMapping("/insurer/edit")
    public String currentInsurer(@RequestParam("regNum") Long regNum, Model model) {
        InsurerDto currentInsurer = insurerService.getById(regNum)
                .orElseThrow(() -> new IllegalArgumentException("Non existed insurer"));
        model.addAttribute("insurer", currentInsurer);
        return "insurer/insurer";
    }

    @PostMapping("/insurer/save")
    public String saveInsurer(InsurerDto insurerDto) {
        insurerService.save(insurerDto);
        return "redirect:/insurers";
    }
}
