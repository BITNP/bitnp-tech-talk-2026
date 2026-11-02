import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task09MethodCallTest {
    @DisplayName("第09题：square 返回平方")
    @ParameterizedTest(name = "{0}")
    @MethodSource("squareCases")
    void calculatesSquare(String label, double x, double expected) {
        double actual = Task09MethodCall.square(x);
        String message = "第09题 square / " + label + "：期望 " + expected + "，实际 " + actual;
        assertTrue(Double.isFinite(actual), message + "。返回值必须是有限数值。");
        assertEquals(expected, actual, 1e-9, message);
    }

    static Stream<Arguments> squareCases() {
        return Stream.of(
                arguments("1的平方", 1.0, 1.0),
                arguments("2的平方", 2.0, 4.0),
                arguments("3的平方", 3.0, 9.0),
                arguments("0的平方", 0.0, 0.0),
                arguments("负数的平方", -2.0, 4.0),
                arguments("小数的平方", 0.5, 0.25)
        );
    }

    @DisplayName("第09题：calculate 按公式返回结果")
    @ParameterizedTest(name = "{0}")
    @MethodSource("calculateCases")
    void calculatesFormula(String label, double x, double expected) {
        double actual = Task09MethodCall.calculate(x);
        String message = "第09题 calculate / " + label + "：期望 " + expected + "，实际 " + actual;
        assertTrue(Double.isFinite(actual), message + "。返回值必须是有限数值。");
        assertEquals(expected, actual, 1e-9, message);
    }

    static Stream<Arguments> calculateCases() {
        return Stream.of(
                arguments("x为1", 1.0, 15.0),
                arguments("x为2", 2.0, 22.0),
                arguments("x为3", 3.0, 31.0),
                arguments("x为0", 0.0, 10.0),
                arguments("x为负数", -2.0, 6.0),
                arguments("x为小数", 0.5, 12.25)
        );
    }
}
