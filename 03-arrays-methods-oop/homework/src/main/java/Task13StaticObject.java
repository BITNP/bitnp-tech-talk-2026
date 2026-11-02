/**
 * 第 13 题：把对象传给静态方法
 * 对应课件：精简版“对象也可以作为方法参数”。
 *
 * 场景：计算一件商品的库存总价值，需要一个方法读取商品对象的单价和库存。
 * 目标：补全 static double stockValue(Task13Product product)，
 * 从参数对象读取 price 和 stock，返回 price * stock。
 *
 * 已提供：完整的 Task13Product 类，以及创建两件商品的 main。
 * 需要修改：stockValue 方法中的练习区域。
 * 程序参数顺序：第一件商品的单价、库存，第二件商品的单价、库存；
 * 默认 8.0、20、12.5、10。
 * 方法约定：参数是一个 Task13Product 对象；返回库存总价值；
 * 不修改商品对象的任何字段。
 * 默认输出（共两行）：
 * Pen: 160.0
 * Notebook: 125.0
 *
 * 静态方法内部没有 this，必须通过参数 product 访问对象的数据。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task13StaticObjectTest.java。
 */
public class Task13StaticObject {
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

        Task13Product pen = new Task13Product("Pen", firstPrice, firstStock);
        Task13Product notebook = new Task13Product("Notebook", secondPrice, secondStock);
        System.out.println("Pen: " + stockValue(pen));
        System.out.println("Notebook: " + stockValue(notebook));
    }

    static double stockValue(Task13Product product) {
        /*
        // TODO：从参数 product 读取 price 和 stock，返回乘积。
        // 不要使用 static 字段保存某一件商品的数据。
        return ____;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }
}
