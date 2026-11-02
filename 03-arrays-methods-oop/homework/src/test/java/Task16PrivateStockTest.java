import java.lang.reflect.Field;
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

class Task16PrivateStockTest {
    @Test
    @DisplayName("第16题：库存字段必须声明为 private")
    void stockFieldIsPrivate() throws Exception {
        Field stock = Task16Product.class.getDeclaredField("stock");
        assertTrue(Modifier.isPrivate(stock.getModifiers()),
                "第16题：stock 字段必须是 private，外部不能直接访问。");
    }

    @Test
    @DisplayName("第16题：getStock 必须是公开方法")
    void getterIsPublic() throws Exception {
        Method getter = Task16Product.class.getDeclaredMethod("getStock");
        assertTrue(Modifier.isPublic(getter.getModifiers()),
                "第16题：getStock() 必须是 public，main 才能通过它读取库存。");
        assertEquals(int.class, getter.getReturnType(), "第16题：getStock() 应返回 int。");
    }

    @DisplayName("第16题：getter 返回构造时的库存")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void getterReturnsStock(String label, int stock) {
        Task16Product product = new Task16Product("Notebook", 12.5, stock);
        assertEquals(stock, product.getStock(),
                "第16题 / " + label + "：getter 应返回构造时保存的库存 " + stock + "。");
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认库存", 10),
                arguments("零库存", 0),
                arguments("较小库存", 7),
                arguments("较大库存", 25)
        );
    }

    @Test
    @DisplayName("第16题：两个对象通过 getter 返回各自库存")
    void twoObjectsKeepIndependentStock() {
        Task16Product first = new Task16Product("Pen", 8.0, 20);
        Task16Product second = new Task16Product("Eraser", 3.0, 4);
        assertEquals(20, first.getStock(), "第16题：第一件商品的库存应为 20。");
        assertEquals(4, second.getStock(), "第16题：第二件商品的库存应为 4。");
    }
}
