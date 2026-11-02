import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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

class Task14InstanceMethodTest {
    @DisplayName("第14题：实例方法使用当前对象自己的字段")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void calculatesOwnStockValue(String label, String name, double price, int stock, double expected) {
        Task14Product product = new Task14Product(name, price, stock);
        double actual = product.stockValue();
        String message = "第14题 / " + label + "：期望 " + expected + "，实际 " + actual;
        assertTrue(Double.isFinite(actual), message + "。返回值必须是有限数值。");
        assertEquals(expected, actual, 1e-9, message);
        assertEquals(price, product.price, 1e-9, "第14题 / " + label + "：方法不应修改单价。");
        assertEquals(stock, product.stock, "第14题 / " + label + "：方法不应修改库存。");
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("笔的库存价值", "Pen", 8.0, 20, 160.0),
                arguments("笔记本的库存价值", "Notebook", 12.5, 10, 125.0),
                arguments("零库存", "Eraser", 3.0, 0, 0.0),
                arguments("零单价", "Gift", 0.0, 7, 0.0),
                arguments("带小数的单价", "Ruler", 19.25, 4, 77.0),
                arguments("结果带小数", "Tape", 2.5, 3, 7.5)
        );
    }

    @Test
    @DisplayName("第14题：两件商品分别使用自己的数据")
    void twoObjectsKeepIndependentValues() {
        Task14Product pen = new Task14Product("Pen", 8.0, 20);
        Task14Product notebook = new Task14Product("Notebook", 12.5, 10);

        assertEquals(160.0, pen.stockValue(), 1e-9, "笔应使用自己的 8.0 × 20。");
        assertEquals(125.0, notebook.stockValue(), 1e-9, "笔记本应使用自己的 12.5 × 10。");
        assertEquals(160.0, pen.stockValue(), 1e-9, "再次调用笔的库存价值应保持不变。");
        assertEquals(8.0, pen.price, 1e-9, "调用实例方法不应改变笔的单价。");
        assertEquals(20, pen.stock, "调用实例方法不应改变笔的库存。");
    }

    @Test
    @DisplayName("第14题：stockValue 必须是无参数的实例 double 方法")
    void hasExpectedSignature() throws Exception {
        Method method = Task14Product.class.getDeclaredMethod("stockValue");
        assertEquals(double.class, method.getReturnType(),
                "第14题：stockValue 的返回类型必须是 double，不能是 int。");
        assertFalse(Modifier.isStatic(method.getModifiers()),
                "第14题：stockValue 必须是实例方法，不能是 static。");
    }
}
