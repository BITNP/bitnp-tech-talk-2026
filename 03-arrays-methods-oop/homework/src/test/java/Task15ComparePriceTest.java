import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task15ComparePriceTest {
    @DisplayName("第15题：严格比较两件商品的价格")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void comparesPrices(String label, double thisPrice, double otherPrice, boolean expected) {
        Task15Product current = new Task15Product("Current", thisPrice, 5);
        Task15Product other = new Task15Product("Other", otherPrice, 7);
        boolean actual = current.isCheaperThan(other);
        assertEquals(expected, actual,
                "第15题 / " + label + "：当前价 " + thisPrice + "，另一件价 " + otherPrice
                        + "，期望 " + expected + "，实际 " + actual);
        assertEquals(thisPrice, current.price, 1e-9, "第15题 / " + label + "：不应修改当前商品。");
        assertEquals(otherPrice, other.price, 1e-9, "第15题 / " + label + "：不应修改另一件商品。");
        assertEquals(5, current.stock, "第15题 / " + label + "：不应修改当前商品的库存。");
        assertEquals(7, other.stock, "第15题 / " + label + "：不应修改另一件商品的库存。");
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("当前商品更便宜", 8.0, 12.5, true),
                arguments("当前商品更贵", 12.5, 8.0, false),
                arguments("两件价格相等", 8.0, 8.0, false),
                arguments("零元对正价", 0.0, 1.0, true),
                arguments("正价对零元", 1.0, 0.0, false)
        );
    }

    @Test
    @DisplayName("第15题：与自身比较返回 false")
    void isNotCheaperThanItself() {
        Task15Product product = new Task15Product("Pen", 8.0, 20);
        assertFalse(product.isCheaperThan(product), "同一件商品与自身比较时，价格不可能严格小于自己。");
    }
}
