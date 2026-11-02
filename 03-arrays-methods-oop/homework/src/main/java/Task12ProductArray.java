/**
 * 第 12 题：商品对象数组与交换
 * 对应课件：精简版“调整商品顺序，只需交换对象”。
 *
 * 场景：三件商品放在一个 Task12Product[] 数组中，要交换其中两件的位置。
 * 目标：创建三个对象并放入对象数组，用临时变量交换指定两个下标，
 * 确认名称、价格和库存仍属于原来的商品。
 *
 * 已提供：三件商品的名称、单价和库存数组，以及两个下标的变量。
 * 需要修改：main 内练习区域；按提示创建对象、放入数组、交换并调用 printProducts。
 * 程序参数顺序：第一个下标 firstIndex、第二个下标 secondIndex，范围都是 0～2；
 * 默认 0 和 1。
 * 默认输出（共三行）：
 * Pen, 8.0, 20
 * Notebook, 12.5, 10
 * Eraser, 3.0, 30
 *
 * 交换的是数组中的对象引用，不是逐个复制名称、价格和库存。
 * 两个下标可以相同，此时数组顺序不变。不要修改对象自身的字段。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task12ProductArrayTest.java。
 */
public class Task12ProductArray {
    public static void main(String[] args) {
        String[] names = {"Notebook", "Pen", "Eraser"};
        double[] prices = {12.5, 8.0, 3.0};
        int[] stocks = {10, 20, 30};
        int firstIndex = 0;
        int secondIndex = 1;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 1) {
            firstIndex = Integer.parseInt(args[0]);
            secondIndex = Integer.parseInt(args[1]);
        }

        /*
        // TODO 1：用上面的数组创建三个 Task12Product 对象。
        // 可以分别命名，例如 notebook、pen、eraser。
        ____
        ____
        ____
        // TODO 2：把三个对象放入 Task12Product[] 数组 products。
        ____
        // TODO 3：用临时变量 temp 交换 products[firstIndex] 与 products[secondIndex]。
        ____
        ____
        ____
        // TODO 4：调用下面已提供的 printProducts，输出交换后的数组。
        ____
        */
    }

    // 已提供：按数组顺序输出每件商品的完整信息，无需修改。
    private static void printProducts(Task12Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Task12Product product = products[i];
            System.out.println(product.name + ", " + product.price + ", " + product.stock);
        }
    }
}
