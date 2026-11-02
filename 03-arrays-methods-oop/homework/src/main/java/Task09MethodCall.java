/**
 * 第 09 题：方法调用另一个方法
 * 对应课件：精简版“方法也可以调用另一个方法”。
 *
 * 场景：反复计算 x² + 4x + 10，把“平方”单独写成一个方法。
 * 目标：补全 square 和 calculate；calculate 必须调用 square 求平方，
 * 不要在 calculate 中再写一次 x * x。
 *
 * 已提供：输入 x，默认 2.0；main 调用 calculate 并打印结果。
 * 需要修改：square 和 calculate 两个方法中的练习区域。
 * 程序参数顺序：x，默认 2.0。
 * 方法约定：
 *   square(x)    返回 x 的平方；
 *   calculate(x) 返回 x² + 4x + 10，并通过 square(x) 获得平方。
 * 默认输出（一行）：
 * Result: 22.0
 *
 * “calculate 确实调用了 square”属于人工检查要求，输出测试不能证明这一点。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Task09MethodCallTest.java。
 */
public class Task09MethodCall {
    public static void main(String[] args) {
        double x = 2.0;
        // 已提供：测试数据准备，无需修改。
        if (args.length > 0) {
            x = Double.parseDouble(args[0]);
        }

        System.out.println("Result: " + calculate(x));
    }

    static double square(double x) {
        /*
        // TODO：返回 x 的平方。
        return ____;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }

    static double calculate(double x) {
        /*
        // TODO：调用 square(x) 得到平方，再计算 squared + 4 * x + 10 并返回。
        // 不要在本题中重复写 x * x。
        double squared = ____;
        return ____;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }
}
