package br.com.ParametersAndExceptionHandler.services;

import org.springframework.stereotype.Service;

@Service
public class MathServices {

    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException(
                "Please set a numeric value!"
        );
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.0

        return Double.parseDouble(number);
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.0

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
