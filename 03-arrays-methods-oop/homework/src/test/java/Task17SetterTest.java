import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task17SetterTest {
    @Test
    @DisplayName("第17题：setStock 必须是 public void 方法")
    void hasExpectedSignature() throws Exception {
        Method method = Task17Product.class.getDeclaredMethod("setStock", int.class);
        assertTrue(Modifier.isPublic(method.getModifiers()),
                "第17题：setStock 必须是 public，外部才能调用。");
        assertEquals(void.class, method.getReturnType(),
                "第17题：setStock 不返回值，返回类型必须是 void。");
    }

    @Test
    @DisplayName("第17题：非负库存可以更新")
    void acceptsNonNegativeStock() {
        Task17Product product = new Task17Product("Notebook", 12.5, 10);
        product.setStock(25);
        assertEquals(25, product.getStock(), "第17题：setStock(25) 后库存应为 25。");
    }

    @Test
    @DisplayName("第17题：setStock(0) 应把库存设为0")
    void acceptsZeroStock() {
        Task17Product product = new Task17Product("Notebook", 12.5, 10);
        product.setStock(0);
        assertEquals(0, product.getStock(), "第17题：0 是合法库存，setStock(0) 后应为 0。");
    }

    @Test
    @DisplayName("第17题：负库存被拒绝且原值不变")
    void rejectsNegativeStock() {
        Task17Product product = new Task17Product("Notebook", 12.5, 10);
        product.setStock(-5);
        assertEquals(10, product.getStock(), "第17题：setStock(-5) 后库存应保持 10。");
    }

    @Test
    @DisplayName("第17题：连续调用按顺序更新库存")
    void appliesConsecutiveCalls() {
        Task17Product product = new Task17Product("Notebook", 12.5, 10);
        product.setStock(30);
        product.setStock(4);
        product.setStock(-1);
        assertEquals(4, product.getStock(),
                "第17题：连续 setStock(30)、setStock(4)、setStock(-1) 后库存应为 4。");
    }

    @Test
    @DisplayName("第17题：从0开始设置负数仍保持0")
    void negativeDoesNotChangeZeroStock() {
        Task17Product product = new Task17Product("Notebook", 12.5, 0);
        product.setStock(-10);
        assertEquals(0, product.getStock(), "第17题：零库存收到负数后应保持 0。");
    }

    @Test
    @DisplayName("第17题：拒绝负数后仍可设置合法库存")
    void canSetValidValueAfterFailure() {
        Task17Product product = new Task17Product("Notebook", 12.5, 10);
        product.setStock(-3);
        assertEquals(10, product.getStock(), "第17题：负数被拒绝后库存应保持 10。");
        product.setStock(6);
        assertEquals(6, product.getStock(), "第17题：之后 setStock(6) 应正常生效。");
    }
}
