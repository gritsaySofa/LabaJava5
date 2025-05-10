import org.example.SomeBean;
import org.example.SomeInterface;
import org.example.SomeOtherInterface;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SomeBeanTest {

    @Test
    void foo_shouldCallDependencies() {
        SomeBean bean = new SomeBean();

        SomeInterface mock1 = () -> System.out.print("X");
        SomeOtherInterface mock2 = () -> System.out.print("Y");

        try {
            Field field1 = SomeBean.class.getDeclaredField("field1");
            field1.setAccessible(true);
            field1.set(bean, mock1);

            Field field2 = SomeBean.class.getDeclaredField("field2");
            field2.setAccessible(true);
            field2.set(bean, mock2);
        } catch (Exception e) {
            fail("Failed to set test dependencies");
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bean.foo();

        assertEquals("XY", outContent.toString());
    }
}