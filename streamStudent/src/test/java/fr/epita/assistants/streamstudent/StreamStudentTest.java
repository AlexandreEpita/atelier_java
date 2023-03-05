package fr.epita.assistants.streamstudent;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamStudentTest {
    static void assertStreamEquals(Stream<Pair<Integer, String>> expectedStream,
                                   Stream<Pair<Integer, String>> actualStream) {
        // Get iterators from stream
        Iterator<Pair<Integer, String>> iterator1 = expectedStream.iterator();
        Iterator<Pair<Integer, String>> iterator2 = actualStream.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            // Get next objects
            Pair<Integer, String> login1 = iterator1.next();
            Pair<Integer, String> login2 = iterator2.next();

            // Check if pairs are equal
            assertEquals(login1, login2);
        }

        assertTrue(!iterator1.hasNext() && !iterator2.hasNext(),
                "Streams do not have the same length");

    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(50, "xavier_login_");
        Pair<Integer, String> loginValid = new Pair<>(90, "xavier_login");
        Pair<Integer, String> loginMultipleUnderscord = new Pair<>(10, "_login__x");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginMultipleUnderscord);

        var expected = List.of(loginValid).stream();
        var actual = streamer.validator(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore2() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(2, "zzz_z");
        Pair<Integer, String> loginValid = new Pair<>(2, "aaaa_z");
        Pair<Integer, String> loginMultipleUnderscord = new Pair<>(1, "aaa_z");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginMultipleUnderscord);

        var expected = List.of(loginMultipleUnderscord, loginValid, loginTwoUnderscore).stream();
        var actual = streamer.orderGrade(loginList.stream());

        assertStreamEquals(expected, actual);
    }
    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore3() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(10, "abc_a");
        Pair<Integer, String> loginValid = new Pair<>(11, "aBc_z");

        Pair<Integer, String> loginTwoUnderscore1 = new Pair<>(10, "abc_a");
        Pair<Integer, String> loginValid1 = new Pair<>(5, "aBc_z");

        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid);

        var expected = List.of(loginTwoUnderscore1, loginValid1).stream();
        var actual = streamer.lowercase(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore4() {
        Pair<Integer, String> l1 = new Pair<>(5, "abc_a");
        Pair<Integer, String> l2 = new Pair<>(15, "abc_b");
        Pair<Integer, String> l3 = new Pair<>(15, "abc_z");

        Streamer streamer = new Streamer();

        var loginList = List.of(l1, l2, l3);

        var expected = List.of(l2).stream();
        var actual = streamer.headOfTheClass(loginList.stream());

        assertStreamEquals(expected, actual.stream());
    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore5() {
        Pair<Integer, String> l1 = new Pair<>(60, "abc_a");
        Pair<Integer, String> l2 = new Pair<>(20, "mA_x");
        Pair<Integer, String> l3 = new Pair<>(40, "mA_x");
        Streamer streamer = new Streamer();

        var loginList = List.of(l1, l2);

        var expected = List.of(l1, l3).stream();
        var actual = streamer.quickFix(loginList.stream());

        assertStreamEquals(expected, actual);
    }
    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore6() {
        Pair<Integer, String> l1 = new Pair<>(10, "tigrou_c");
        Pair<Integer, String> l2 = new Pair<>(10, "login_x");
        Pair<Integer, String> l3 = new Pair<>(10, "ou_ctigr");
        Pair<Integer, String> l4 = new Pair<>(10, "in_xlog");
        Streamer streamer = new Streamer();

        var loginList = List.of(l1, l2);

        var expected = List.of(l3, l4).stream();
        var actual = streamer.encryption(loginList.stream());

        assertStreamEquals(expected, actual);
    }
    // Add your own tests here
}
