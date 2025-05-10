
import org.example.AutoInjectable;
import org.example.Injector;
import org.example.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    private Injector injector;

    @BeforeEach
    void setUp() {
        injector = new Injector();
    }

    @Test
    void inject_shouldThrowExceptionWhenNoImplementation() {
        class TestBean {
            @AutoInjectable
            private Repository repository;
        }

        assertThrows(RuntimeException.class, () -> {
            injector.inject(new TestBean());
        });
    }
}