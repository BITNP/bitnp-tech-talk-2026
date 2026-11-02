/**
 * 第 15 题：比较两件商品的价格
 * 对应课件：精简版“this 表示当前调用方法的对象”。
 *
 * 场景：判断“这件商品是否比另一件便宜”。
 * 目标：在 Task15Product 中补全 boolean isCheaperThan(Task15Product other)，
 * 用 this 表示当前商品，用 other 表示传入的另一件商品。
 *
 * 已提供：商品类字段、构造方法，以及比较两件商品的 main。
 * 需要修改：Task15Product.java 中的 isCheaperThan 练习区域。
 * 程序参数顺序：第一件商品的单价、库存，第二件商品的单价、库存；
 * 默认 8.0、20、12.5、10。
 * 方法约定：当前商品单价严格低于 other 的单价时返回 true；
 * 相等时返回 false；不修改任何商品。
 * 默认输出（共三行）：
 * Pen cheaper than Notebook: true
 * Notebook cheaper than Pen: false
 * Pen cheaper than Pen: false
 *
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task15ComparePriceTest.java。
 */
public class Task15ComparePrice {
    public static void main(String[] args) {
        double firstPrice = 8.0;
        int firstStock = 20;
        double secondPrice = 12.5;
        int secondStock = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            firstPrice = Double.parseDouble(args[0]);
            firstStock = Integer.parseInt(args[1]);
            secondPrice = Double.parseDouble(args[2]);
            secondStock = Integer.parseInt(args[3]);
        }

        Task15Product pen = new Task15Product("Pen", firstPrice, firstStock);
        Task15Product notebook = new Task15Product("Notebook", secondPrice, secondStock);
        System.out.println("Pen cheaper than Notebook: " + pen.isCheaperThan(notebook));
        System.out.println("Notebook cheaper than Pen: " + notebook.isCheaperThan(pen));
        System.out.println("Pen cheaper than Pen: " + pen.isCheaperThan(pen));
    }
}
