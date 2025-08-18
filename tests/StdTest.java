import kvx.jcandy.*;

public class StdTest {
    public static void run() {
        // Basic no-throw smoke tests
        Std.print("x");
        Std.printf("%s", "y");
        Std.println("line");
        Std.println("fmt %s", "ok");

        // new lines
        Std.newl();
        Std.newl(2);

        // delay
        System.out.println("Delaying for 1 second, the screen will clear after this.");
        Std.delay(1000);

        // clear (may or may not work depending on environment) - ensure no exception
        try {
            Std.clear();
        } catch (Exception e) {
            System.out.println("clear threw: " + e.getMessage());
        }

        System.out.println("[PASSED] StdTest");
    }
}
