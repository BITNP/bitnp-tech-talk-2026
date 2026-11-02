/**
 * 第 07 题：单价与数量计算总价
 * 对应课件：精简版“方法定义：返回类型、名字和参数列表”。
 *
 * 场景：收银时需要根据单价和购买数量算出应付金额。
 * 目标：补全 static double calculateTotal(double price, int quantity)，
 * 由 main 调用方法并打印返回值。
 *
 * 已提供：单价 price、数量 quantity，以及打印返回值的 main 代码。
 * 需要修改：calculateTotal 方法中的练习区域。
 * 程序参数顺序：单价 price、整数数量 quantity，默认 12.5 和 3。
 * 方法约定：返回 price * quantity；参数顺序不能交换。
 * 默认输出（一行）：
 * Total: 37.5
 *
 * 方法只计算结果，不在方法内部打印。价格和数量为非负的有限数值。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task07TotalPriceTest.java。
 */
public class Task07TotalPrice {
    public static void main(String[] args) {
        double price = 12.5;
        int quantity = 3;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            price = Double.parseDouble(args[0]);
        }
        if (args.length > 1) {
            quantity = Integer.parseInt(args[1]);
        }

        double total = calculateTotal(price, quantity);
        System.out.println("Total: " + total);
    }

    static double calculateTotal(double price, int quantity) {
        /*
        // TODO：返回单价乘数量。由上面的 main 负责打印。
        return ____;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }
}
