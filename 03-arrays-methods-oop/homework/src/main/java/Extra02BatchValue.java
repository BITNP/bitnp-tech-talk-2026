/**
 * 附加题 02：统计整批商品的库存价值
 * 对应课件：综合运用对象数组、循环、方法调用和实例方法。
 *
 * 场景：仓库里有一批商品，需要汇总所有商品的库存价值（单价 × 库存）。
 * 目标：自行实现
 *   static double totalStockValue(Extra02Product[] products)
 * 让它接收商品数组，逐个调用每件商品的 stockValue() 并累加。
 *
 * 需要修改：totalStockValue 方法体。
 * 已提供：完整的 Extra02Product 类、商品数组的构造代码和结果输出代码。
 * 程序参数顺序：
 *   不传参数：使用默认三件商品；
 *   传入一个 empty：使用空数组；
 *   传入若干组“单价 库存”：每两个参数创建一件商品。
 * 方法约定：空数组返回 0；零库存商品贡献 0；不修改商品对象。
 * 默认输出（共五行）：
 * Count: 3
 * Total: 285.0
 * Notebook, 12.5, 10, 125.0
 * Pen, 8.0, 20, 160.0
 * Eraser, 3.0, 0, 0.0
 *
 * 本题不是填空题。请使用循环和 products[i].stockValue()，不要重新写一遍
 * 单价乘库存的公式，也不要排序或输出购物车菜单。
 * 运行本题：运行本文件的 main。
 * 检查本题：运行 src/test/java/Extra02BatchValueTest.java。
 */
public class Extra02BatchValue {
    public static void main(String[] args) {
        Extra02Product[] products;
        // 已提供：测试数据准备，无需修改。
        if (args.length == 1 && args[0].equals("empty")) {
            products = new Extra02Product[0];
        } else if (args.length == 0) {
            products = new Extra02Product[]{
                    new Extra02Product("Notebook", 12.5, 10),
                    new Extra02Product("Pen", 8.0, 20),
                    new Extra02Product("Eraser", 3.0, 0)
            };
        } else {
            int count = args.length / 2;
            products = new Extra02Product[count];
            for (int i = 0; i < count; i++) {
                double price = Double.parseDouble(args[2 * i]);
                int stock = Integer.parseInt(args[2 * i + 1]);
                products[i] = new Extra02Product("Item" + (i + 1), price, stock);
            }
        }

        double total = totalStockValue(products);
        System.out.println("Count: " + products.length);
        System.out.println("Total: " + total);
        // 已提供：调用后再输出每件商品的状态，便于检查有没有被修改。
        for (int i = 0; i < products.length; i++) {
            Extra02Product product = products[i];
            System.out.println(product.name + ", " + product.price + ", "
                    + product.stock + ", " + product.stockValue());
        }
    }

    static double totalStockValue(Extra02Product[] products) {
        // TODO：用循环遍历 products，对每个元素调用 stockValue() 并累加。
        // 空数组返回 0，不要修改商品对象。
        return 0.0; // 临时返回语句：完成实现后删除这一行。
    }
}
