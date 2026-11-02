/**
 * 第 16 题：私有库存与 getter
 * 对应课件：精简版“private：限制类外直接访问字段”“getter 和 setter”。
 *
 * 场景：库存不能让外部代码随意读取或修改，只能通过商品类提供的方法访问。
 * 目标：把 Task16Product 的 stock 字段改为 private，并补全公开的 getStock()，
 * 让 main 通过 getStock() 读取库存。
 *
 * 需要修改：Task16Product.java 中字段前的访问修饰符和 getStock 方法体。
 * 已提供：Task16Product 的构造方法，以及使用 getStock() 的 main。
 * 程序参数顺序：名称、单价、库存，默认 Notebook、12.5、10。
 * 默认输出（一行）：
 * Stock: 10
 *
 * main 不应直接访问 product.stock；完成 private 后这种写法会编译失败。
 * getter 只读取字段，不修改库存。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task16PrivateStockTest.java。
 */
public class Task16PrivateStock {
    public static void main(String[] args) {
        String name = "Notebook";
        double price = 12.5;
        int stock = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            name = args[0];
            price = Double.parseDouble(args[1]);
            stock = Integer.parseInt(args[2]);
        }

        Task16Product product = new Task16Product(name, price, stock);
        // 只能通过公开方法读取私有库存。
        System.out.println("Stock: " + product.getStock());
    }
}
