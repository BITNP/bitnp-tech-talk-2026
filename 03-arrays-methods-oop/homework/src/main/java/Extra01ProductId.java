/**
 * 附加题 01：为商品分配编号
 * 对应课件：完整版“静态字段：为每件商品分配编号”；精简版“static 成员属于类”。
 *
 * 场景：每创建一件商品，就自动分配一个从 1 开始、依次递增的编号。
 * 目标：使用静态字段保存“下一个编号”，用实例字段保存每件商品自己的编号。
 *
 * 需要修改：
 *   1. Extra01Product.java：添加 static int nextId（从 1 开始）和 int id，
 *      在构造方法中先分配当前编号，再让 nextId 增加 1；
 *   2. 本文件 main 内练习区域：依次创建三件商品，按格式输出编号和名称，
 *      最后再输出第一件商品的编号，确认它没有被后来的创建改变。
 *
 * 已提供：三个商品名称，默认 Notebook、Pen、Eraser。
 * 程序参数顺序：名称1、名称2、名称3；默认三个名称。
 * 默认输出（共四行）：
 * 1 Notebook
 * 2 Pen
 * 3 Eraser
 * First id after: 1
 *
 * 本题不是填空题，请根据上面的思路自行实现。
 * 每次运行程序都从编号 1 开始；静态字段由同一类的所有对象共享，
 * 实例字段 id 属于各个商品，创建新商品不会改写旧商品的 id。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Extra01ProductIdTest.java。
 */
public class Extra01ProductId {
    public static void main(String[] args) {
        String firstName = "Notebook";
        String secondName = "Pen";
        String thirdName = "Eraser";
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            firstName = args[0];
            secondName = args[1];
            thirdName = args[2];
        }

        /*
        // TODO：在这里创建 first、second、third 三个 Extra01Product 对象，
        // 然后严格按文件开头的格式输出四行结果。
        */
    }
}
