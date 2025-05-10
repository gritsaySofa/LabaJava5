import org.example.OtherImpl;
import org.example.SomeImpl;
import org.example.SomeInterface;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SomeInterfaceImplementationsTest {

    @Test
    void someImpl_shouldPrintA() {
        SomeInterface impl = new SomeImpl();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        impl.doSomething();

        assertEquals("A" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void otherImpl_shouldPrintB() {
        SomeInterface impl = new OtherImpl();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        impl.doSomething();

        assertEquals("B" + System.lineSeparator(), outContent.toString());
    }
}