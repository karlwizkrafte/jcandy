package tests.kvx.jcandy;

import kvx.jcandy.*;

public class FlavorfulTest {
    public static void run() {
        // hex 6
        String hex6 = Flavorful.Color.hex("#112233");
        if (!hex6.equals("\u001B[38;2;17;34;51m")) throw new RuntimeException("hex6 fail: " + hex6);

        // hex 8 (treated as ARGB-like in implementation)
        String hex8 = Flavorful.Color.hex("FF112233");
        if (!hex8.equals("\u001B[38;2;255;17;34m")) throw new RuntimeException("hex8 fail: " + hex8);

        // rgba valid
        String rgba = Flavorful.Color.rgba(10, 20, 30, 255);
        if (!rgba.equals("\u001B[38;2;10;20;30m")) throw new RuntimeException("rgba fail: " + rgba);

        // rgba invalid should throw
        boolean thrown = false;
        try {
            Flavorful.Color.rgba(-1, 0, 0, 0);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        if (!thrown) throw new RuntimeException("rgba invalid did not throw");

        // flavor composition
        String flavored = Flavorful.flavor(Flavorful.Color.red, "hi");
        String expected = Flavorful.Color.red.toString() + "hi" + Flavorful.Style.reset.toString();
        if (!flavored.equals(expected)) throw new RuntimeException("flavor fail: " + flavored);

        // bold helper
        String bold = Flavorful.bold("b");
        String expectedBold = Flavorful.Style.bold.toString() + "b" + Flavorful.Style.reset.toString();
        if (!bold.equals(expectedBold)) throw new RuntimeException("bold fail: " + bold);

        System.out.println("[PASSED] FlavorfulTest");
    }
}
