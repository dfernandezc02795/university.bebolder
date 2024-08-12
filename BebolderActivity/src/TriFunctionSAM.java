import java.time.LocalDate;

@FunctionalInterface
public interface TriFunctionSAM {
    String responseCalculateAge(String name, Integer age , LocalDate dateOfBirth);

}