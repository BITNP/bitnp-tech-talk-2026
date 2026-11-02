/**
 * 第 16 题配套类：私有库存。
 *
 * 需要修改：
 *   1. 给 stock 字段加上 private 访问修饰符；
 *   2. 补全 public int getStock()，返回当前库存。
 *
 * 构造方法在类内部，可以访问 private 字段，不需要修改。
 * 完成后删除 getter 末尾的临时 return。
 * 不要为库存添加 public 字段，也不要绕开 getter 暴露库存。
 */
class Task16Product {
    String name;
    double price;
    int stock; // TODO 1：改为 private int stock;

    Task16Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        /*
        // TODO 2：返回当前商品的库存。
        return ____;
        */
        return 0; // 临时返回语句：完成练习后删除这一行。
    }
}
