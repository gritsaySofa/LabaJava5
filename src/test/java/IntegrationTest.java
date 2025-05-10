
import org.example.Injector;
import org.example.SomeBean;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void fullIntegrationTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SomeBean bean = new Injector().inject(new SomeBean());
        bean.foo();

        String output = outContent.toString();

        assertTrue(output.contains("A") || output.contains("B"),
                "Должен быть вывод A или B от SomeInterface реализации");

        assertTrue(output.contains("C"),
                "Должен быть вывод C от SomeOtherInterface реализации");

        long lineCount = output.lines().count();
        assertEquals(2, lineCount,
                "Должно быть 2 строки вывода");
    }
}