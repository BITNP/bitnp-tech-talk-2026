/**
 * 附加题 01 配套类：商品编号。
 *
 * 已提供：名称字段和构造方法中保存名称的部分。
 * 需要自行添加：
 *   1. static int nextId，初值为 1，表示下一个可用编号；
 *   2. int id，保存当前商品自己的编号；
 *   3. 在构造方法中把 nextId 赋给 id，然后让 nextId 增加 1。
 *
 * 注意：nextId 必须加 static。若写成 int nextId，每个对象都会从 1 开始，
 * 三个商品会得到重复编号。实例字段 id 不能加 static。
 * 本题不是填空题，请直接编写缺少的字段和构造方法语句。
 */
class Extra01Product {
    String name;

    Extra01Product(String name) {
        this.name = name;
        // TODO：分配编号并更新静态计数器。
    }
}
