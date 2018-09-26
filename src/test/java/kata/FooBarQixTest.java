package kata;

import junit.framework.TestCase;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FooBarQixTest extends TestCase {
    private FooBarQix fooBarQix;

    private Map<Integer, String> testCases =
            Collections.unmodifiableMap(Stream.of(
                    new SimpleEntry<>(51, "FooBar"),
                    new SimpleEntry<>(53, "BarFoo"),
                    new SimpleEntry<>(13, "Foo"),
                    new SimpleEntry<>(15, "FooBarBar"),
                    new SimpleEntry<>(33, "FooFooFoo"),
                    new SimpleEntry<>(27, "FooQix")
            )
                    .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    @Override
    protected void setUp() throws Exception {
        this.fooBarQix = new FooBarQix();
    }

    public void testCases() {
        testCases.keySet().stream()
                .forEach(value -> assertEquals(
                        "Test failed for : " + value,
                        testCases.get(value),
                        this.fooBarQix.processValue(value)));
    }
}
