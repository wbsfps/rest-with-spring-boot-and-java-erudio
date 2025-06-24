package br.com.ParametersAndExceptionHandler.controllers;

import br.com.ParametersAndExceptionHandler.math.SimpleMath;
import br.com.ParametersAndExceptionHandler.services.MathServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private SimpleMath simpleMath;

    // http://localhost:8080/math/sum/3/5
    @GetMapping("/{operation}/{numberOne}/{numberTwo}")
    public Double operation(
            @PathVariable("operation") String operation,
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        return simpleMath.calculate(operation, numberOne, numberTwo);
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        return simpleMath.squareRoot(number);
    }
}

