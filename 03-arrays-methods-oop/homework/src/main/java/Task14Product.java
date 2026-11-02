/**
 * 第 14 题配套类：商品与实例方法。
 *
 * 需要修改：stockValue 方法中的练习区域。
 * 要求：
 *   1. 方法签名保持 double stockValue()，不加 static，不增加商品参数；
 *   2. 返回当前对象的 price * stock；
 *   3. 不修改价格和库存。
 *
 * 完成练习后删除方法末尾的临时 return。
 */
class Task14Product {
    String name;
    double price;
    int stock;

    Task14Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    double stockValue() {
        /*
        // TODO：使用当前对象的 price 和 stock 计算库存价值并返回。
        return ____;
        */
        return 0.0; // 临时返回语句：完成练习后删除这一行。
    }
}
