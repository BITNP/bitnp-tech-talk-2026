/**
 * 第 10 题：定义商品字段并创建对象
 * 对应课件：精简版“定义类：把相关的量写在一起”“用商品对象替代三个分散的数组”。
 *
 * 场景：不再用三个平行数组保存商品，而是让每个对象保存自己的名称、价格和库存。
 * 目标：补全 Task10Product 的字段声明，并在 main 中创建两个商品对象，
 * 分别设置不同数据，再修改第一个对象的价格，观察第二个对象不受影响。
 *
 * 需要修改：
 *   1. 同目录 Task10Product.java 中的三处字段声明；
 *   2. 本文件 main 内练习区域。
 * 已提供：两组商品数据，以及修改第一个商品价格用的 newFirstPrice。
 * 程序参数顺序：名称1、单价1、库存1、名称2、单价2、库存2、第一个商品的新单价。
 * 默认输出（共两行）：
 * First: Notebook, 15.0, 10
 * Second: Pen, 8.0, 20
 *
 * 名称用 String，单价用 double，库存用 int。两个对象的数据互相独立。
 * 本题允许修改对象字段，不修改测试参数本身。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task10ProductFieldsTest.java。
 */
public class Task10ProductFields {
    public static void main(String[] args) {
        String firstName = "Notebook";
        double firstPrice = 12.5;
        int firstStock = 10;
        String secondName = "Pen";
        double secondPrice = 8.0;
        int secondStock = 20;
        double newFirstPrice = 15.0;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            firstName = args[0];
            firstPrice = Double.parseDouble(args[1]);
            firstStock = Integer.parseInt(args[2]);
            secondName = args[3];
            secondPrice = Double.parseDouble(args[4]);
            secondStock = Integer.parseInt(args[5]);
            newFirstPrice = Double.parseDouble(args[6]);
        }

        /*
        // TODO 1：创建第一个 Task10Product 对象 first，并设置三个字段。
        ____
        ____
        ____
        ____
        // TODO 2：创建第二个 Task10Product 对象 second，并设置三个字段。
        ____
        ____
        ____
        ____
        // TODO 3：只修改 first 的价格为 newFirstPrice。
        ____
        System.out.println("First: " + first.name + ", " + first.price + ", " + first.stock);
        System.out.println("Second: " + second.name + ", " + second.price + ", " + second.stock);
        */
    }
}
