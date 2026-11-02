/**
 * 附加题 02 配套类：已提供完整的商品类。
 *
 * 本题重点是对象数组、循环和对每个对象调用 stockValue()，
 * 不需要修改这个类，也不要在 totalStockValue 中重新实现库存价值公式。
 */
class Extra02Product {
    String name;
    double price;
    int stock;

    Extra02Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    double stockValue() {
        return price * stock;
    }
}
