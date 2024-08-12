import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /* Inmutable */
        System.out.println("\n////////////////// Punto 1 --> Inmutable && Mutable  \n");
        List<String> categories = new LinkedList<>();
        categories.add("Aseo");
        InmutableProduct inmutableProduct = new InmutableProduct("Jabón Rey", "Limpiador", categories);

        System.out.println("inmutableProduct = " + inmutableProduct);
        badIntentionInmutable(inmutableProduct);
        System.out.println("inmutableProduct = " + inmutableProduct + "\n");


        /* Mutable */
        List<String> categoriesMutable = new LinkedList<>();
        categoriesMutable.add("Aseo");
        MutableProduct puntoUnoMutableProduct = new MutableProduct("Jabón Rey", "Limpiador", categoriesMutable);

        System.out.println("mutableProduct = " + puntoUnoMutableProduct);
        badIntentionMutable(puntoUnoMutableProduct);
        System.out.println("mutableProduct = " + puntoUnoMutableProduct + "\n");


        /* Function */
        System.out.println("////////////////// Punto 2 --> Function (Function<T, R>) \n");

        Scanner scanner = new Scanner(System.in);

        Function<Integer,Integer> power = new PowerFunction(2);

        System.out.println("Ingrese un número que sea la base para calcular la potencia ");

        int number = Integer.valueOf(scanner.nextLine());
        int resultPower = power.apply(number);
        System.out.println("\nPower of number "+ number + " is "+ resultPower + "\n");


        /* Predicate */
        System.out.println("////////////////// Punto 3 --> Predicate (Predicate<T>) \n");

        Predicate<PowerPredicate> isOdd = value -> value.getResult() % 2 == 0;
        PowerPredicate puntoTresPredicate = new PowerPredicate(resultPower);
        System.out.println("The number is Odd : " + isOdd.test(puntoTresPredicate) + "\n");


        /* Supplier and Consumer */
        System.out.println("////////////////// Punto 4 --> Supplier and Consume (Supplier<T> && Consumer<T>) \n");

        Supplier<List<Book>> booksSupplier =  listBooksSupplier();
        Consumer<List<Book>> listConsumer = recommendedBooks();

        List<Book> books = booksSupplier.get();
        listConsumer.accept(books);


        /* BinaryOperator */
        System.out.println("////////////////// Punto 5 --> BinaryOperator (BinaryOperator<T>) \n");

        BinaryOperator binaryOperator = new BinaryDivisión();
        System.out.println("Ingrese un número dividendo ");
        BigDecimal number1 = scanner.nextBigDecimal();
        System.out.println("Ingrese un número divisor ");
        BigDecimal number2 = scanner.nextBigDecimal();
        System.out.println("Result: "+ binaryOperator.apply(number1,number2) + "\n");


        /* SAM and Trifunction */
        System.out.println("////////////////// Punto 6 --> SAM and Trifunction @FunctionalInterface \n");

        TriFunctionSAM calculateAge  = new CalculateAgeSAM();

        System.out.println("Ingrese año de nacimiento (ej. 1995): ");
        int yearBorn = scanner.nextInt();
        System.out.println("Ingrese mes de nacimiento (1-12): ");
        int monthBorn = scanner.nextInt();
        System.out.println("Ingrese día de nacimiento (1-31): ");
        int dayBorn = scanner.nextInt();

        if (yearBorn > 0 && (monthBorn >= 1 && monthBorn <= 12) && (dayBorn >= 1 || dayBorn <= 31)){
            System.out.println(calculateAge.responseCalculateAge("Pepe", 29, LocalDate.of(yearBorn,monthBorn,dayBorn)));
        } else {
            System.out.println("Ingrese valores validos para el día, mes o año");
        }


        /* Operator */
        System.out.println("////////////////// Punto 7 --> Operator :: \n");
        List<LocalDate> localDates = Arrays.asList(
                LocalDate.parse("2024-05-09"),
                LocalDate.parse("1995-04-23"),
                LocalDate.parse("2000-12-12"));

        Function<LocalDate,String> printMessageDates = value -> String.format("La fecha es %s de %s del año %s \n",
                value.getDayOfMonth(),
                value.getMonth(),
                value.getYear());

        localDates.stream()
                .map(printMessageDates)
                .forEach(System.out::println);


        /*  Chaining  */
        System.out.println("////////////////// Punto 8 --> Chaining  \n");
        System.out.println("Ingrese un número para calcular la suma/resta/Multiplicación ");
        int numberOne = scanner.nextInt();
        System.out.println("Ingrese un número para calcular la suma/resta/Multiplicación");
        int numberTwo = scanner.nextInt();

        CalculatorChaining calculatorChaining = new CalculatorChaining();
        calculatorChaining.resultSum(numberOne,numberTwo).resultRest(numberOne,numberTwo).resultMultiplication(numberOne,numberTwo);
        System.out.println("El acumulado final es : " + calculatorChaining.getAccumulated());

        /*  Optional Streams, ForEach and Filter  */
        System.out.println("\n////////////////// Punto 9 --> Optional Streams, ForEach and Filter  \n");
        Optional<List<String>> result = printNames("Maya");
        result.ifPresent(names -> System.out.println("Names list: " + names));

    }

    private static Consumer<List<Book>> recommendedBooks() {

        Predicate<Book> isRecommendaded = book -> book.getScore() >= 7;
        return books -> {
            List<Book> recommendedBooks = books.stream()
                    .filter(isRecommendaded)
                    .collect(Collectors.toList());
            UnaryOperator<String> bookRecommended = b -> "Book: " + b.toString() + ", is Recommended 😊 \n";
            recommendedBooks.forEach(value -> {
                System.out.println(bookRecommended.apply(value.getName().toString()));
            });
        };
    }

    private static Supplier<List<Book>> listBooksSupplier(){
        return () -> Arrays.asList(
                new Book("100 Años de soledad","Gabriel Garcia",10),
                new Book("Nacho","Jorge Luis",6),
                new Book("Bridgerton","Julia Quinn",5),
                new Book("Game of thrones","George R.R",8)
        );
    }

    private static Optional<List<String>> getNames(){
        return Optional.of(Arrays.asList("Jacinto", "Guillermina", "Sol", "Pedro", "Bruno", "Lucas", "Maya"));
    }

    private static Stream<String> filterNames(String value){
        List<String> names = getNames().orElse(Collections.emptyList());
        return names.stream().filter(name -> name.equalsIgnoreCase(value));
    }

    private static Optional<List<String>> printNames(String value){
        List<String> optionalNames = filterNames(value).collect(Collectors.toList());
            optionalNames.forEach(System.out::println);
            return Optional.of(optionalNames);
    }

    private static void badIntentionMutable(MutableProduct puntoUnoMutableProduct) {
        List<String> product = new LinkedList<>();
        product.add("Licores");
        puntoUnoMutableProduct.setName("Vino");
        puntoUnoMutableProduct.setDescription("");
        puntoUnoMutableProduct.setCategories(product);
    }

    private static void badIntentionInmutable(InmutableProduct product) {
        List<String> products = product.getCategories();
        products.clear();
        products.add("Licores");
    }
}