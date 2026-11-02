/**
 * 第 02 题：修改指定商品价格
 * 对应课件：精简版“通过索引读取和修改数组元素”。
 *
 * 场景：四种商品的价格依次为 12、8、25、6 元，要把其中一个价格改成新值。
 * 目标：只修改索引 index 处的元素，其他元素保持不变。
 *
 * 已提供：价格数组、索引 index（默认 1）、新价格 newPrice（默认 10）。
 * 需要修改：main 内练习区域的一处 ____。
 * 程序参数顺序：索引 index、新价格 newPrice；索引范围 0～3，默认 1 和 10。
 * 默认输出（共四行）：
 * 12
 * 10
 * 25
 * 6
 *
 * 本题会修改数组。索引一定合法，不需要处理越界。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task02PriceUpdateTest.java。
 */
public class Task02PriceUpdate {
    public static void main(String[] args) {
        int[] prices = {12, 8, 25, 6};
        int index = 1;
        int newPrice = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            index = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            newPrice = Integer.parseInt(args[1]);
        }

        /*
        // TODO：把 prices 中索引 index 处的元素改为 newPrice。
        ____
        */

        // 已提供：依次输出修改后的每个价格。
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
    }
}
