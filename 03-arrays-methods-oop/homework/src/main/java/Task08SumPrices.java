/**
 * 第 08 题：将数组求和提取成方法
 * 对应课件：精简版“用 for 循环计算总价”“方法定义与调用”。
 *
 * 场景：多处收银都需要求一批商品价格的总和，把重复的循环收进方法。
 * 目标：补全 static double sumPrices(double[] prices)，由 main 调用。
 *
 * 已提供：价格数组 prices，默认 {12.0, 8.5, 25.0}；main 会打印方法返回值，
 * 并在调用后再次输出原数组，便于检查方法有没有修改传入的数组。
 * 需要修改：sumPrices 方法中的练习区域。
 * 程序参数顺序：元素个数 count，随后 count 个价格；不传参数时使用默认数组。
 * 方法约定：参数写成 double[] prices，表示一个 double 数组；调用时直接传数组变量，
 * 不写方括号。返回所有元素之和；空数组返回 0；不修改传入的数组。
 * 价格非负且数值较小。
 * 默认输出（共三行）：
 * Total: 45.5
 * Count: 3
 * Prices: 12.0 8.5 25.0
 *
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task08SumPricesTest.java。
 */
public class Task08SumPrices {
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

        double total = sumPrices(prices);
        System.out.println("Total: " + total);
        System.out.println("Count: " + prices.length);
        System.out.print("Prices:");
        for (int i = 0; i < prices.length; i++) {
            System.out.print(" " + prices[i]);
        }
        System.out.println();
    }

    static double sumPrices(double[] prices) {
        /*
        // TODO：用 for 循环遍历 prices，累加每个元素并返回总和。
        // 空数组时循环不执行，应返回 0；不要修改 prices 的元素。
        double total = 0;
        for (____; ____; ____) {
            total += ____;
        }
        return total;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }
}
