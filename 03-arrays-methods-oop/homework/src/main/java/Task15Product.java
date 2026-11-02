/**
 * 第 15 题配套类：比较商品单价的实例方法。
 *
 * 需要修改：isCheaperThan 方法中的练习区域。
 * 要求：
 *   1. 方法签名保持 boolean isCheaperThan(Task15Product other)；
 *   2. 当前对象的单价严格低于 other 的单价时返回 true；
 *   3. 相等、当前商品更贵或与自身比较时返回 false；
 *   4. 不修改任何字段，也不直接打印结果。
 *
 * 完成练习后删除方法末尾的临时 return。
 */
class Task15Product {
    String name;
    double price;
    int stock;

    Task15Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    boolean isCheaperThan(Task15Product other) {
        /*
        // TODO：比较 this.price 和 other.price，返回比较结果。
        // 注意“便宜”是严格小于。
        return ____;
        */
        return false; // 临时返回语句：完成练习后删除这一行。
    }
}
