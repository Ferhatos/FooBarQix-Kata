import kata.FooBarQix;

public class Main {
    public static void main(String[] args) {
        int size = 100;
        try {
            size = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Running without argument, default range size is 100");
        }
        FooBarQix fooBarQix = new FooBarQix();
        fooBarQix.processRange(size);
    }
}
