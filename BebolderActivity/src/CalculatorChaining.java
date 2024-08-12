public class CalculatorChaining {

    private int accumulated;

    public CalculatorChaining() {
        this.accumulated = 0;
    }

    public int getAccumulated() {
        return accumulated;
    }

    CalculatorChaining resultSum(int numberOne, int numberTwo){
        accumulated += (numberOne + numberTwo);
        System.out.println("\nAcumulado posterior de sumar: " + numberOne + " y " + numberTwo + " es : " + accumulated);
        return this;
    }

    CalculatorChaining resultRest(int numberOne, int numberTwo){
        accumulated -= (numberOne - numberTwo);
        System.out.println("Acumulado posterior de restar: " + numberOne + " y " + numberTwo + " es : " + accumulated);
        return this;
    }

    CalculatorChaining resultMultiplication(int numberOne, int numberTwo) {
        accumulated *= (numberOne * numberTwo);
        System.out.println("Acumulado posterior de multiplicar: " + numberOne + " y " + numberTwo + " es : " + accumulated + "\n");
        return this;
    }
}
