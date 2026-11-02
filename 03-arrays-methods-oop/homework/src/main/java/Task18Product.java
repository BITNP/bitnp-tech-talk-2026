/**
 * 第 18 题配套类：带购买规则的库存。
 *
 * 需要修改：purchase 方法体。
 * 要求：
 *   1. 方法签名保持 public boolean purchase(int quantity)；
 *   2. quantity <= 0 或 quantity > stock 时返回 false，库存不变；
 *   3. 购买成功时执行 stock -= quantity，并返回 true；
 *   4. 不要使用 System.out 在方法内打印。
 *
 * 完成练习后删除方法末尾的临时 return。库存字段保持 private。
 */
class Task18Product {
    String name;
    double price;
    private int stock;

    Task18Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public boolean purchase(int quantity) {
        /*
        // TODO：先判断 quantity 是否合法且不超过库存；
        // 合法时扣减库存并返回 true，否则返回 false。
        ____
        */
        return false; // 临时返回语句：完成练习后删除这一行。
    }
}
