/**
 * 第 17 题配套类：带库存检查的 setter。
 *
 * 需要修改：setStock 方法体。
 * 要求：
 *   1. 方法签名保持 public void setStock(int stock)；
 *   2. 参数大于或等于 0 时，用 this.stock = stock 更新字段；
 *   3. 参数为负数时不修改库存；
 *   4. 不打印、不返回值，也不把负数改成 0。
 *
 * 字段已经是 private，外部只能通过 getStock 和 setStock 访问。
 */
class Task17Product {
    String name;
    double price;
    private int stock;

    Task17Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        // TODO：参数非负时更新当前对象的库存，负数时保持原值。
    }
}
