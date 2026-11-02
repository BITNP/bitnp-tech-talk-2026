/**
 * 第 11 题：构造方法与 this
 * 对应课件：精简版“构造方法：创建对象时就把数据填好”；
 * 完整版“this 区分字段与同名参数”。
 *
 * 场景：每次创建商品都要逐条给字段赋值，容易漏写；把初始化放进构造方法。
 * 目标：为 Task11Product 声明三个字段和构造方法。构造方法的参数与字段同名，
 * 用 this 区分当前对象的字段与参数；然后在 main 中创建对象并输出全部字段。
 *
 * 需要修改：
 *   1. 同目录 Task11Product.java 中的练习区域；
 *   2. 本文件 main 内练习区域。
 * 已提供：名称、单价、库存三个输入变量。
 * 程序参数顺序：名称、单价、库存，默认 Notebook、12.5、10。
 * 默认输出（共三行）：
 * Name: Notebook
 * Price: 12.5
 * Stock: 10
 *
 * 构造方法与类同名，不写返回类型，也不写 void。
 * 输出必须读取对象的字段，不能直接打印输入变量。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task11ConstructorTest.java。
 */
public class Task11Constructor {
    public static void main(String[] args) {
        String name = "Notebook";
        double price = 12.5;
        int stock = 10;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            name = args[0];
            price = Double.parseDouble(args[1]);
            stock = Integer.parseInt(args[2]);
        }

        /*
        // TODO 1：用三个输入变量调用构造方法，创建 Task11Product 对象 product。
        ____
        // TODO 2：输出 product 的三个字段，格式见文件开头。
        ____
        ____
        ____
        */
    }
}
