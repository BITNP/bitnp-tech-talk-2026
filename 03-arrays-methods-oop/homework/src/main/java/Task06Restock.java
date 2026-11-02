/**
 * 第 06 题：批量更新库存
 * 对应课件：精简版“通过索引读取和修改数组元素”，结合 for 循环。
 *
 * 场景：一次补货要给每种商品增加相同的数量。
 * 目标：按下标遍历数组，修改每一个库存元素。
 *
 * 已提供：库存数组 stocks、补货量 amount（默认 5）。
 * 需要修改：main 内练习区域的一处 for 循环。
 * 程序参数顺序：元素个数 count、补货量 amount、随后 count 个库存。
 * 不传参数时使用默认数据；库存和补货量都是非负的小整数。
 * 默认输出（共四行）：
 * 15
 * 5
 * 12
 * 8
 *
 * 本题会修改数组。空数组不输出任何内容。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task06RestockTest.java。
 */
public class Task06Restock {
    public static void main(String[] args) {
        int[] stocks = {10, 0, 7, 3};
        int amount = 5;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            int count = Integer.parseInt(args[0]);
            amount = Integer.parseInt(args[1]);
            stocks = new int[count];
            for (int i = 0; i < count; i++) {
                stocks[i] = Integer.parseInt(args[i + 2]);
            }
        }

        /*
        // TODO：用 i 遍历 stocks，把 amount 加到每一个元素上。
        for (____; ____; ____) {
            ____
        }
        */

        // 已提供：依次输出补货后的每个库存。
        for (int i = 0; i < stocks.length; i++) {
            System.out.println(stocks[i]);
        }
    }
}
