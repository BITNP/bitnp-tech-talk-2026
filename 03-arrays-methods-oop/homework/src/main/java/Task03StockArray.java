/**
 * 第 03 题：创建指定长度的库存数组
 * 对应课件：精简版“数组的声明与初始化：指定数组长度”。
 *
 * 场景：为新到的一批商品准备库存数组，数组长度由变量 length 决定。
 * 目标：使用 new int[length] 创建数组，观察整数数组元素的默认值。
 *
 * 已提供：数组长度 length，默认 3。
 * 需要修改：main 内练习区域的一处 ____。
 * 程序参数顺序：数组长度 length，范围 0～6，默认 3。
 * 默认输出（共四行）：
 * Length: 3
 * 0
 * 0
 * 0
 *
 * length 为 0 时只输出 Length: 0。练习区域已给出安全的遍历方式，
 * 不要额外读取 stocks[0]。本题不修改已有数据。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task03StockArrayTest.java。
 */
public class Task03StockArray {
    public static void main(String[] args) {
        int length = 3;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            length = Integer.parseInt(args[0]);
        }

        /*
        // TODO：创建长度为 length 的 int 数组 stocks，元素先使用默认值。
        ____
        System.out.println("Length: " + stocks.length);
        for (int i = 0; i < stocks.length; i++) {
            System.out.println(stocks[i]);
        }
        */
    }
}
