package br.com.ParametersAndExceptionHandler.math;

import br.com.ParametersAndExceptionHandler.services.MathServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMath {

    @Autowired
    private MathServices mathServices;

    public Double calculate(String operation, String numberOne, String numberTwo) {
        if(!mathServices.isNumeric(numberOne) || !mathServices.isNumeric(numberTwo)) throw new UnsupportedOperationException(
                "Please set a numeric value!"
        );

        return switch (operation) {
            case "sum" -> mathServices.convertToDouble(numberOne) + mathServices.convertToDouble(numberTwo);
            case "subtraction" -> mathServices.convertToDouble(numberOne) - mathServices.convertToDouble(numberTwo);
            case "multiplication" -> mathServices.convertToDouble(numberOne) * mathServices.convertToDouble(numberTwo);
            case "division" -> {
                double divisor = mathServices.convertToDouble(numberTwo);
                if (divisor == 0) throw new UnsupportedOperationException("Division by zero");
                yield mathServices.convertToDouble(numberOne) / divisor;
            }
            case "mean" -> (mathServices.convertToDouble(numberOne) + mathServices.convertToDouble(numberTwo)) / 2;
            default -> throw new UnsupportedOperationException("Invalid operation");
        };
    }

    public Double squareRoot(String number) {
        if (!mathServices.isNumeric(number)) throw new UnsupportedOperationException("Please set a numeric value!");
        return Math.sqrt(mathServices.convertToDouble(number));
    }
}
