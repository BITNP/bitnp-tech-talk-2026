/**
 * 第 05 题：统计低于指定价格的商品数量
 * 对应课件：精简版“用 for 循环计算总价”，结合条件判断。
 *
 * 场景：找出价格严格低于预算线的商品，并统计数量。
 * 目标：遍历数组，逐项与阈值 threshold 比较后计数。
 *
 * 已提供：价格数组 prices、阈值 threshold（默认 10.0）。
 * 需要修改：main 内练习区域中循环的三处 ____ 和条件中的一处 ____。
 * 程序参数顺序：元素个数 count、阈值 threshold、随后 count 个价格。
 * 不传参数时使用默认数据；价格和阈值非负。
 * 默认输出（一行）：
 * Count: 3
 *
 * “低于”表示严格小于，价格恰好等于阈值时不计入。
 * 空数组的数量为 0。本题不修改数组。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task05CountBelowTest.java。
 */
public class Task05CountBelow {
    public static void main(String[] args) {
        double[] prices = {12.0, 8.0, 25.0, 3.0, 8.0};
        double threshold = 10.0;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            int count = Integer.parseInt(args[0]);
            threshold = Double.parseDouble(args[1]);
            prices = new double[count];
            for (int i = 0; i < count; i++) {
                prices[i] = Double.parseDouble(args[i + 2]);
            }
        }

        /*
        int count = 0;
        // TODO：用 i 遍历 prices；当当前价格严格低于 threshold 时，把 count 加 1。
        for (____; ____; ____) {
            if (____) {
                count++;
            }
        }
        System.out.println("Count: " + count);
        */
    }
}
