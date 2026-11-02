import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task18PurchaseTest {
    @Test
    @DisplayName("第18题：purchase 必须是 public boolean 方法")
    void hasExpectedSignature() throws Exception {
        Method method = Task18Product.class.getDeclaredMethod("purchase", int.class);
        assertTrue(Modifier.isPublic(method.getModifiers()),
                "第18题：purchase 必须是 public，调用方才能使用。");
        assertEquals(boolean.class, method.getReturnType(),
                "第18题：purchase 的返回类型必须是 boolean（不是 Boolean）。");
    }

    @Test
    @DisplayName("第18题：部分购买成功并扣减库存")
    void partialPurchaseSucceeds() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        boolean success = product.purchase(3);
        assertTrue(success, "第18题：库存10时购买3件应返回 true。");
        assertEquals(7, product.getStock(), "第18题：购买3件后库存应为7。");
    }

    @Test
    @DisplayName("第18题：恰好买完返回 true 且库存为0")
    void buyingAllStockSucceeds() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        boolean success = product.purchase(10);
        assertTrue(success, "第18题：购买量等于库存时应成功。");
        assertEquals(0, product.getStock(), "第18题：恰好买完后库存应为0。");
    }

    @Test
    @DisplayName("第18题：库存不足时失败且库存不变")
    void insufficientStockFails() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        boolean success = product.purchase(11);
        assertFalse(success, "第18题：库存10时购买11件应返回 false。");
        assertEquals(10, product.getStock(), "第18题：购买失败后库存应保持10。");
    }

    @Test
    @DisplayName("第18题：购买0件失败且库存不变")
    void zeroQuantityFails() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        boolean success = product.purchase(0);
        assertFalse(success, "第18题：购买0件应返回 false。");
        assertEquals(10, product.getStock(), "第18题：购买0件后库存应保持10。");
    }

    @Test
    @DisplayName("第18题：负数购买量失败且库存不变")
    void negativeQuantityFails() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        boolean success = product.purchase(-2);
        assertFalse(success, "第18题：购买负数件应返回 false。");
        assertEquals(10, product.getStock(), "第18题：负数购买后库存应保持10。");
    }

    @Test
    @DisplayName("第18题：空库存不能购买")
    void emptyStockCannotBePurchased() {
        Task18Product product = new Task18Product("Notebook", 12.5, 0);
        boolean success = product.purchase(1);
        assertFalse(success, "第18题：库存为0时购买1件应返回 false。");
        assertEquals(0, product.getStock(), "第18题：失败后库存应保持0。");
    }

    @Test
    @DisplayName("第18题：连续购买依次扣减并在不足时停止")
    void consecutivePurchasesUpdateStock() {
        Task18Product product = new Task18Product("Notebook", 12.5, 10);
        assertTrue(product.purchase(4), "第18题：第一次购买4件应成功。");
        assertEquals(6, product.getStock(), "第18题：第一次购买后库存应为6。");
        assertTrue(product.purchase(4), "第18题：第二次购买4件应成功。");
        assertEquals(2, product.getStock(), "第18题：第二次购买后库存应为2。");
        assertFalse(product.purchase(3), "第18题：库存2时购买3件应失败。");
        assertEquals(2, product.getStock(), "第18题：第三次失败后库存应保持2。");
    }

    @Test
    @DisplayName("第18题：失败操作不破坏已有库存")
    void failureDoesNotChangeRemainingStock() {
        Task18Product product = new Task18Product("Notebook", 12.5, 8);
        assertTrue(product.purchase(5), "第18题：库存8时购买5件应成功。");
        assertEquals(3, product.getStock(), "第18题：购买5件后库存应为3。");
        assertFalse(product.purchase(4), "第18题：库存3时购买4件应失败。");
        assertEquals(3, product.getStock(), "第18题：失败后库存应保持3。");
        assertTrue(product.purchase(3), "第18题：随后恰好购买剩余的3件应成功。");
        assertEquals(0, product.getStock(), "第18题：最后库存应为0。");
    }
}
