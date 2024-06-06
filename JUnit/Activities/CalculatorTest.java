import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// The Test class should start or end with "Test"
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
        System.out.println("multiply =" + calculator.multiply(4, 5));
    }
    @Test
    @DisplayName("Simple add should work")
    public void testAdd() {
        assertEquals(9, calculator.add(4, 5));
        System.out.println("add =" + calculator.add(4, 5) );
    }
    @Test
    @DisplayName("Simple sub should work")
    public void testSub() {
        assertEquals(5, calculator.sub(10, 5));
        System.out.println("sub =" + calculator.sub(10, 5) );
    }
    @Test
    @DisplayName("Simple div should work")
    public void testDiv() {
        assertEquals(4, calculator.div(20, 5));
        System.out.println("div =" + calculator.div(20, 5));
    }
}
