/**
 * 第 14 题：商品自己计算库存价值
 * 对应课件：精简版“把商品的数据和相关操作放在一起”“完整定义：Product.java”。
 *
 * 场景：计算库存价值需要商品的单价和库存，这两项本来就在商品对象里。
 * 目标：在 Task14Product 中补全实例方法 double stockValue()，
 * 让商品对象使用自己的字段完成计算。
 *
 * 已提供：字段、构造方法和创建两件商品的 main。
 * 需要修改：Task14Product.java 中的 stockValue 练习区域。
 * 程序参数顺序：第一件商品的单价、库存，第二件商品的单价、库存；
 * 默认 8.0、20、12.5、10。
 * 方法约定：实例方法不写 static，不接收当前商品对象作为参数；
 * 返回 price * stock；不修改字段。
 * 默认输出（共两行）：
 * Pen: 160.0
 * Notebook: 125.0
 *
 * 调用 pen.stockValue() 时应使用 pen 自己的字段，notebook 同理。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task14InstanceMethodTest.java。
 */
public class Task14InstanceMethod {
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

        Task14Product pen = new Task14Product("Pen", firstPrice, firstStock);
        Task14Product notebook = new Task14Product("Notebook", secondPrice, secondStock);
        System.out.println("Pen: " + pen.stockValue());
        System.out.println("Notebook: " + notebook.stockValue());
    }
}
