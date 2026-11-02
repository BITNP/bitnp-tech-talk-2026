import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task07TotalPriceTest {
    @DisplayName("第07题：单价乘数量并返回结果")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void calculatesTotal(String label, double price, int quantity, double expected) {
        double actual = Task07TotalPrice.calculateTotal(price, quantity);
        String message = "第07题 / " + label + "：期望 " + expected + "，实际 " + actual;
        assertTrue(Double.isFinite(actual), message + "。返回值必须是有限数值。");
        assertEquals(expected, actual, 1e-9, message);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认数据", 12.5, 3, 37.5),
                arguments("数量为0", 8.25, 0, 0.0),
                arguments("单价为0", 0.0, 5, 0.0),
                arguments("整数金额", 3.0, 4, 12.0),
                arguments("不同单价和数量", 19.5, 7, 136.5)
        );
    }
}
