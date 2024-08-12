import java.util.function.Function;

public class PowerFunction implements Function<Integer,Integer> {

    private final int exponent;

    public PowerFunction(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public Integer apply(Integer x){
        return (int) Math.pow(x, exponent);
    }
}
