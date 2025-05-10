import org.example.SODoer;
import org.example.SomeOtherInterface;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SODoerTest {

    @Test
    void doSomeOther_shouldPrintC() {
        SomeOtherInterface impl = new SODoer();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        impl.doSomeOther();

        assertEquals("C" + System.lineSeparator(), outContent.toString());
    }
}