import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task13StaticObjectTest {
    @DisplayName("第13题：静态方法通过对象参数读取数据")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void calculatesStockValue(String label, String name, double price, int stock, double expected) {
        Task13Product product = new Task13Product(name, price, stock);
        double actual = Task13StaticObject.stockValue(product);
        String message = "第13题 / " + label + "：期望 " + expected + "，实际 " + actual;
        assertTrue(Double.isFinite(actual), message + "。返回值必须是有限数值。");
        assertEquals(expected, actual, 1e-9, message);
        assertEquals(name, product.name, "第13题 / " + label + "：方法不应修改商品名称。");
        assertEquals(price, product.price, 1e-9, "第13题 / " + label + "：方法不应修改单价。");
        assertEquals(stock, product.stock, "第13题 / " + label + "：方法不应修改库存。");
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
    @DisplayName("第13题：stockValue 必须是接收商品对象的 static double 方法")
    void hasExpectedSignature() throws Exception {
        Method method = Task13StaticObject.class.getDeclaredMethod("stockValue", Task13Product.class);
        assertEquals(double.class, method.getReturnType(),
                "第13题：stockValue 的返回类型必须是 double，不能是 int。");
        assertTrue(Modifier.isStatic(method.getModifiers()),
                "第13题：stockValue 必须是 static 方法。");
    }
}
