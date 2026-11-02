/**
 * 第 18 题：购买商品
 * 对应课件：精简版“public：通过公开方法修改库存”。
 *
 * 场景：顾客购买商品时，库存必须足够且购买数量必须为正数。
 * 目标：补全 Task18Product.purchase(int quantity)：
 * 购买量大于 0 且不超过库存时，扣减库存并返回 true；
 * 否则返回 false，库存不变。
 *
 * 已提供：private 库存、构造方法、getStock() 和调用 purchase 的 main。
 * 需要修改：Task18Product.java 中的 purchase 方法体。
 * 程序参数顺序：初始库存，默认 10。
 * 方法约定：public boolean purchase(int quantity)；
 * 成功返回 true 并执行 stock -= quantity；失败返回 false，库存保持原值。
 * 默认输出（共四行）：
 * true 7
 * false 7
 * true 0
 * false 0
 *
 * 失败包括：quantity <= 0、quantity > stock、库存已经是 0。
 * 本题不涉及异常处理；调用方要同时检查返回值和调用后的库存。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task18PurchaseTest.java。
 */
public class Task18Purchase {
    public static void main(String[] args) {
        int initialStock = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            initialStock = Integer.parseInt(args[0]);
        }

        Task18Product product = new Task18Product("Notebook", 12.5, initialStock);
        System.out.println(product.purchase(3) + " " + product.getStock());
        System.out.println(product.purchase(100) + " " + product.getStock());
        System.out.println(product.purchase(7) + " " + product.getStock());
        System.out.println(product.purchase(1) + " " + product.getStock());
    }
}
