/**
 * 第 04 题：计算价格总和
 * 对应课件：精简版“用 for 循环计算总价”“用 length 获取数组长度”。
 *
 * 场景：收银时要把一批商品的价格累加起来。
 * 目标：用普通 for 循环遍历数组，计算所有价格的总和。
 *
 * 已提供：价格数组 prices，默认 {12.0, 8.5, 25.0}。
 * 需要修改：main 内练习区域中 for 循环的三处 ____ 和累加表达式中的 ____。
 * 程序参数顺序：先给元素个数 count，再依次给 count 个价格。
 * 不传参数时使用默认数组。价格非负且数值较小。
 * 默认输出（一行）：
 * Total: 45.5
 *
 * 空数组的总和约定为 0。本题不修改数组。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task04PriceSumTest.java。
 */
public class Task04PriceSum {
    public static void main(String[] args) {
        double[] prices = {12.0, 8.5, 25.0};
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            int count = Integer.parseInt(args[0]);
            prices = new double[count];
            for (int i = 0; i < count; i++) {
                prices[i] = Double.parseDouble(args[i + 1]);
            }
        }

        /*
        double total = 0;
        // TODO：用 i 作为下标遍历 prices，把每个元素累加到 total。
        for (____; ____; ____) {
            total += ____;
        }
        System.out.println("Total: " + total);
        */
    }
}
