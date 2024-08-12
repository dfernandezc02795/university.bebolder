import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiFunction;

public class CalculateAgeSAM implements TriFunctionSAM{
    @Override
    public String responseCalculateAge(String name, Integer age, LocalDate dateOfBirth) {
        int calculateAge = Period.between(dateOfBirth,LocalDate.now()).getYears();
        BiFunction<Integer,Integer,String> result = (calculatedAge, providedAge) ->{
            if(calculatedAge == providedAge){
                return "\nThe date of birth " + name + " corresponds to the age entered \n";
            }else{
                return "\nThe date of birth " + name + " no corresponds to the age entered \n";
            }
        };
        return result.apply(calculateAge,age);
    }
}
