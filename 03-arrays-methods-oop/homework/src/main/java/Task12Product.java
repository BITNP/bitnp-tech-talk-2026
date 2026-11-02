/**
 * 第 12 题配套类：已提供完整的商品类。
 *
 * 本题的重点是对象数组和交换引用，不需要再修改这个类。
 * 每个 Task12Product 对象各自保存自己的名称、单价和库存。
 */
class Task12Product {
    String name;
    double price;
    int stock;

    Task12Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
