import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class BinaryDivisión implements BinaryOperator<BigDecimal> {

    @Override
    public BigDecimal apply(BigDecimal number1, BigDecimal number2) {
        if (number2 == null || number1 == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }
        if(number2.compareTo(BigDecimal.ZERO) == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return number1.divide(number2);
    }
}
