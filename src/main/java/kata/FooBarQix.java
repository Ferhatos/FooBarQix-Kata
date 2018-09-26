package kata;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FooBarQix {

    private List<Integer> divisors = Arrays.asList(3, 5);
    private Map<Integer, String> patterns =
            Collections.unmodifiableMap(Stream.of(
                    new SimpleEntry<>(3, "Foo"),
                    new SimpleEntry<>(5, "Bar"),
                    new SimpleEntry<>(7, "Qix"))
                    .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    public void processRange(int size) {
        IntStream.rangeClosed(1, size).boxed()
                .map(this::processValue)
                .forEach(System.out::println);
    }

    public String processValue(int value) {
        String result = this.divisors.stream()
                .map(divisor -> this.processDivisor(value, divisor))
                .reduce("", String::concat);
        result += this.processPattern(value);
        return result.isEmpty() ? value + "" : result;
    }

    private String processDivisor(int value, int divisor) {
        return 0 == value % divisor ? patterns.get(divisor) : "";
    }

    private String processPattern(int value) {
        return (value + "").codePoints()
                .mapToObj(c -> Integer.parseInt((char) c + ""))
                .map(this.patterns::get)
                .filter(Objects::nonNull)
                .reduce("", String::concat);
    }
}
