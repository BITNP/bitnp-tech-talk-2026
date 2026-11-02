/**
 * 第 17 题：通过 setter 检查库存
 * 对应课件：精简版“getter 和 setter：读取与设置字段”。
 *
 * 场景：外部只能通过 setStock 修改库存，setter 要拒绝负数。
 * 目标：补全 Task17Product.setStock(int stock)：
 * 非负输入更新库存，负数输入保持原值。
 *
 * 已提供：private 库存字段、构造方法、getStock() 和调用 setter 的 main。
 * 需要修改：Task17Product.java 中的 setStock 方法体。
 * 程序参数顺序：初始库存，默认 10；main 随后依次调用 setStock(25)、
 * setStock(-5)、setStock(0)。
 * 方法约定：public void setStock(int stock)；不返回值；
 * 参数非负时执行 this.stock = stock，否则什么都不做。
 * 默认输出（共四行）：
 * 10
 * 25
 * 25
 * 0
 *
 * 失败（负数）时不能改变库存。本题不涉及异常处理。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task17SetterTest.java。
 */
public class Task17Setter {
    public static void main(String[] args) {
        int initialStock = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            initialStock = Integer.parseInt(args[0]);
        }

        Task17Product product = new Task17Product("Notebook", 12.5, initialStock);
        System.out.println(product.getStock());
        product.setStock(25);
        System.out.println(product.getStock());
        product.setStock(-5);
        System.out.println(product.getStock());
        product.setStock(0);
        System.out.println(product.getStock());
    }
}
