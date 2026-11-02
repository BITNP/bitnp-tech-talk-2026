/**
 * 第 01 题：创建与读取价格数组
 * 对应课件：精简版“数组的声明与初始化”“通过索引读取和修改数组元素”。
 *
 * 场景：文具店有三种商品，价格依次为 12 元、8 元、25 元。
 * 目标：把三个价格放进一个 int 数组，读取指定索引处的价格，并输出数组长度。
 *
 * 已提供：要读取的索引 index，默认值为 1。
 * 需要修改：main 内练习区域的三处 ____。
 * 程序参数顺序：索引 index，范围 0～2，默认 1。
 * 默认输出（共两行）：
 * 8
 * 3
 *
 * 数组不被修改。length 是数组的属性，后面不写括号。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task01PriceArrayTest.java。
 */
public class Task01PriceArray {
    public static void main(String[] args) {
        int index = 1;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            index = Integer.parseInt(args[0]);
        }

        /*
        // TODO 1：创建 int 数组 prices，初始元素依次为 12、8、25。
        ____
        // TODO 2：输出 prices 在索引 index 处的元素。
        System.out.println(____);
        // TODO 3：输出数组长度，注意 length 后面没有括号。
        System.out.println(____);
        */
    }
}
