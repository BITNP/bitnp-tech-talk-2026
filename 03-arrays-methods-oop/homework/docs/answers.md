# 参考答案与解析

覆盖全部 18 道主线题和附加题 01、02。这里给出一种符合题意的完整实现；满足题目约定的等价写法同样正确。

## 使用方法

- 每题先标明要替换的文件和区域。**不要把参考答案与原来的练习区域同时保留。**
- 主线题：如果答案给出的是练习区域片段，删除包住它的 `/*` 和 `*/` 后写入；如果答案给出完整方法或完整类声明，就用它替换原方法或原类声明，保留文件头注释，不要只摘取花括号内的内容。若方法末尾还有“临时返回语句”，一并删除。
- 多文件题：按顺序修改每个文件；只改一个文件通常不能通过测试。
- 附加题：没有填空形式，把给出的完整实现放到对应类中；保留已提供的输入准备和输出代码。
- 题目要求“不要修改”的数组、商品对象或输出代码，答案中也没有修改它们。
- 行为测试通过后，仍要按每题末尾的“人工核对”检查语法要求。除少量字段/构造方法结构检查外，测试不分析源代码，不能证明循环形式、`this` 的用法或“方法调用了另一个方法”。

## 目录

| 题目 | 答案 |
| --- | --- |
| 01 创建与读取价格数组 | [查看](#task01) |
| 02 修改指定商品价格 | [查看](#task02) |
| 03 创建指定长度的库存数组 | [查看](#task03) |
| 04 计算价格总和 | [查看](#task04) |
| 05 统计低于指定价格的商品数量 | [查看](#task05) |
| 06 批量更新库存 | [查看](#task06) |
| 07 单价与数量计算总价 | [查看](#task07) |
| 08 将数组求和提取成方法 | [查看](#task08) |
| 09 方法调用另一个方法 | [查看](#task09) |
| 10 定义商品字段并创建对象 | [查看](#task10) |
| 11 构造方法与 this | [查看](#task11) |
| 12 商品对象数组与交换 | [查看](#task12) |
| 13 把对象传给静态方法 | [查看](#task13) |
| 14 商品自己计算库存价值 | [查看](#task14) |
| 15 比较两件商品的价格 | [查看](#task15) |
| 16 私有库存与 getter | [查看](#task16) |
| 17 通过 setter 检查库存 | [查看](#task17) |
| 18 购买商品 | [查看](#task18) |
| 附加 01 为商品分配编号 | [查看](#extra01) |
| 附加 02 统计整批商品的库存价值 | [查看](#extra02) |

<a id="task01"></a>

## 01 创建与读取价格数组

**文件与区域：** `Task01PriceArray.java`，替换 `main` 中包住三处 `____` 的整个练习区域。

```java
int[] prices = {12, 8, 25};
System.out.println(prices[index]);
System.out.println(prices.length);
```

**解析：** `{12, 8, 25}` 由三个初始元素确定数组长度为 3，索引分别是 0、1、2。`prices[index]` 使用变量作为下标，所以换一个参数就能读取另一件商品。`length` 是数组自带的属性，不是方法，不能写成 `prices.length()`。

**常见错误：** 把索引 1 当成第一件商品；在 `length` 后面加括号；把数组长度写成固定的 `3` 虽然本题能通过，但没有体现“由数组本身报告长度”的意图，换数组后容易出错。

**边界与等价写法：** 本题参数只取 0～2，不测试越界。也可以先创建 `new int[]{12, 8, 25}` 再赋值给 `prices`，效果相同。

**人工核对：** `prices` 必须是 `int[]`，不能把三个价格拆成三个变量后直接打印。

<a id="task02"></a>

## 02 修改指定商品价格

**文件与区域：** `Task02PriceUpdate.java`，替换 `main` 中的练习区域。

```java
prices[index] = newPrice;
```

**解析：** 赋值语句左侧的 `prices[index]` 表示“索引 index 对应的那个格子”。右侧的 `newPrice` 是新的价格。其他元素没有出现在赋值左侧，因此不会被修改。

**常见错误：** 写死 `prices[1] = 10;`，只能通过默认用例；写成 `prices = new int[]{...}` 会丢掉原来的数组；把 `index` 当成商品数量。

**边界与等价写法：** 新价格可以等于原价格；索引 0、2、3 都必须可用。本题不测试越界索引。

**人工核对：** 修改目标必须使用变量 `index`，不能出现写死的下标。

<a id="task03"></a>

## 03 创建指定长度的库存数组

**文件与区域：** `Task03StockArray.java`，替换 `main` 中的练习区域，保留已提供的输出和循环。

```java
int[] stocks = new int[length];
System.out.println("Length: " + stocks.length);
for (int i = 0; i < stocks.length; i++) {
    System.out.println(stocks[i]);
}
```

**解析：** `new int[length]` 按变量给出的长度创建数组，所有 `int` 元素自动初始化为 0。循环条件使用 `stocks.length`，长度 0 时循环体一次也不执行，所以不会读取 `stocks[0]`，也不会越界。

**常见错误：** 写成 `new int[3]`，无法处理其他长度；在循环外直接 `System.out.println(stocks[0])`，长度为 0 时会抛出 `ArrayIndexOutOfBoundsException`；把 `length` 当成最后一个下标。

**边界：** 长度为 0 时只输出 `Length: 0`；长度为 1 时输出一个 0。

**人工核对：** 必须使用 `new int[length]`，不能写死长度。

**等价写法：** 可以分成 `int[] stocks;` 和 `stocks = new int[length];` 两条语句，效果相同；数组创建后元素仍全是 0。

<a id="task04"></a>

## 04 计算价格总和

**文件与区域：** `Task04PriceSum.java`，替换 `main` 中的练习区域。

```java
double total = 0;
for (int i = 0; i < prices.length; i++) {
    total += prices[i];
}
System.out.println("Total: " + total);
```

**解析：** `total` 从 0 开始，循环变量 `i` 依次取 0 到 `length - 1`。每轮把当前价格加到累计值中。空数组时循环不执行，直接输出 0.0。

**常见错误：** 条件写成 `i <= prices.length`，最后一次会越界；把 `total` 在循环内重新设为 0，只剩最后一个价格；循环变量从 1 开始，漏掉第一个元素。

**边界与等价写法：** 本题要求普通 `for`。累计变量也可以用 `total = total + prices[i]`。

**人工核对：** 必须使用数组的 `length` 作为循环条件，并逐项累加。

<a id="task05"></a>

## 05 统计低于指定价格的商品数量

**文件与区域：** `Task05CountBelow.java`，替换 `main` 中的练习区域。

```java
int count = 0;
for (int i = 0; i < prices.length; i++) {
    if (prices[i] < threshold) {
        count++;
    }
}
System.out.println("Count: " + count);
```

**解析：** 循环检查每个价格，只有当前价格严格小于阈值时计数器才加 1。“低于”不包含等于，所以条件必须是 `<`，不能写 `<=`。

**常见错误：** 用 `<=` 把等于阈值的商品也算进去；把 `count` 放在循环内重新赋 0；在循环外只比较第一个元素；把阈值写死成 10。

**边界：** 空数组返回 0；全部低于阈值时等于元素个数；恰好等于阈值时不计数。

**人工核对：** 阈值必须使用变量 `threshold`，比较必须是严格小于。

**等价写法：** 条件可以写成 `threshold > prices[i]`，仍然表示价格严格低于阈值；计数器也可以写 `count = count + 1;`。不能改成“小于等于”或只比较一个元素。

<a id="task06"></a>

## 06 批量更新库存

**文件与区域：** `Task06Restock.java`，替换 `main` 中的练习区域。

```java
for (int i = 0; i < stocks.length; i++) {
    stocks[i] += amount;
}
```

**解析：** `stocks[i]` 既在赋值左侧又在累加表达式中，表示取出当前库存、加上补货量、再写回同一个格子。循环遍历所有下标，所以每个元素都会更新。

**常见错误：** 只给 `stocks[0]` 加；用另一个总和变量代替数组元素修改；在循环外执行 `stocks[i] += amount`，此时 `i` 已超出作用域；把 `amount` 写成固定值。

**边界：** 空数组不输出；补货量为 0 时数组不变；数据范围保证不会整数溢出。

**人工核对：** 必须按下标逐个修改数组元素，不能只计算总库存。

**等价写法：** 循环体可以写成 `stocks[i] = stocks[i] + amount;`。只要每次写回的是同一个下标，结果就相同。

<a id="task07"></a>

## 07 单价与数量计算总价

**文件与区域：** `Task07TotalPrice.java`，用下面的完整方法替换原来的 `calculateTotal` 方法（连同签名），并删除临时 `return 0.0;`。

```java
static double calculateTotal(double price, int quantity) {
    return price * quantity;
}
```

**解析：** 方法的两个参数按顺序接收单价和数量，返回类型是 `double`。方法只负责计算并返回，打印由 `main` 完成，这是“方法与调用方分工”的体现。

**常见错误：** 在方法里打印后返回 0；把参数顺序写反；返回类型改成 `void`；写成 `return (int) (price * quantity);` 丢失小数部分。

**边界：** 数量为 0 时总价为 0；单价为 0 时总价为 0。参数顺序由方法签名固定，调用时必须先传单价，再传数量。

**人工核对：** 方法内不能有 `System.out.println`，`main` 打印的是方法返回值。

**等价写法：** 可以先写 `double total = price * quantity;`，再 `return total;`。返回类型仍必须是 `double`，不能为了省事改成 `int`。

<a id="task08"></a>

## 08 将数组求和提取成方法

**文件与区域：** `Task08SumPrices.java`，用下面的完整方法替换原来的 `sumPrices` 方法（连同签名），并删除临时 `return 0.0;`。

```java
static double sumPrices(double[] prices) {
    double total = 0;
    for (int i = 0; i < prices.length; i++) {
        total += prices[i];
    }
    return total;
}
```

**解析：** 参数类型 `double[]` 表示方法接收一个 `double` 数组，调用时只传数组名，不写方括号。方法内部与第 04 题一样求和，但没有给 `prices[i]` 赋值，所以不会修改调用方的数组。空数组返回 0。

**常见错误：** 参数写成 `double prices`；返回类型写成 `void` 后仍然 `return total;`；循环中写 `prices[i] = 0;` 把原数组清零；忘记 `return`。

**边界：** 空数组返回 0.0；单元素返回该元素；小数求和按 `double` 计算。

**人工核对：** 必须使用数组参数和 `for` 循环；方法内不能修改 `prices` 的元素。

**等价写法：** 累加语句可以写成 `total = total + prices[i];`。循环仍然必须覆盖 0 到 `prices.length - 1`，不能写死数组长度。

<a id="task09"></a>

## 09 方法调用另一个方法

**文件与区域：** `Task09MethodCall.java`，分别用下面的完整方法替换原来的 `square` 和 `calculate`（连同签名），并删除两处临时 `return 0.0;`。

```java
static double square(double x) {
    return x * x;
}

static double calculate(double x) {
    double squared = square(x);
    return squared + 4 * x + 10;
}
```

**解析：** `square` 只负责平方。`calculate` 先把 `x` 传给 `square`，得到平方值存入 `squared`，再完成其余运算。执行 `return` 后回到 `calculate` 的调用位置继续计算，这就是方法调用的返回链。

**常见错误：** 在 `calculate` 中写 `x * x`，没有调用 `square`；把 `square(x)` 写成 `square`（方法值）；在 `square` 中返回 `x + x`；忘记删除临时返回导致不可达语句。

**边界：** `x` 为负数时平方仍为正；`x = 0` 时结果为 10；小数输入也按 `double` 计算。

**人工核对：** `calculate` 中必须出现 `square(x)`，不能重复实现平方。输出测试只能验证数值，不能证明调用了哪个方法。

**等价写法：** `square` 可以先写 `double result = x * x;` 再返回；`calculate` 也可以直接写 `return square(x) + 4 * x + 10;`。只要 `calculate` 确实调用了 `square`，这些写法都可以。

<a id="task10"></a>

## 10 定义商品字段并创建对象

**文件与区域：**

1. `Task10Product.java`：用下面的完整类声明替换原来整个 `Task10Product` 类（保留文件头注释）；
2. `Task10ProductFields.java`：替换 `main` 中的练习区域。

`Task10Product.java` 的最终类体：

```java
class Task10Product {
    String name;
    double price;
    int stock;
}
```

`Task10ProductFields.java` 的 `main` 练习区域：

```java
Task10Product first = new Task10Product();
first.name = firstName;
first.price = firstPrice;
first.stock = firstStock;

Task10Product second = new Task10Product();
second.name = secondName;
second.price = secondPrice;
second.stock = secondStock;

first.price = newFirstPrice;
System.out.println("First: " + first.name + ", " + first.price + ", " + first.stock);
System.out.println("Second: " + second.name + ", " + second.price + ", " + second.stock);
```

**解析：** 类中的字段描述“每件商品都有什么”，`new` 创建具体的对象。`first.name` 与 `second.name` 是两个不同的存储位置。修改 `first.price` 只改变第一个对象，第二个对象仍保存自己的价格。

**常见错误：** 把字段声明在 `main` 里变成局部变量；两个变量指向同一个对象（例如 `Task10Product second = first;`），修改一个会影响另一个；把价格声明成 `int`，默认价格 12.5 无法保存；忘记输出全部三个字段。

**边界：** 库存可以为 0；两个对象的名称、价格、库存可以完全不同；测试会替换全部输入，不能打印写死的数据。

**人工核对：** 字段必须分别是 `String name`、`double price`、`int stock`，并且两个对象都要用 `new` 创建。自动测试还会用反射检查三个字段的类型和“实例字段”属性，并检查两个对象的字段互不影响。

**等价写法：** 可以先创建两个对象，再统一给字段赋值；也可以调整对象变量的名字。只要两个对象由两次 `new` 得到，字段类型正确，且修改一个不会影响另一个，就符合题意。

<a id="task11"></a>

## 11 构造方法与 this

**文件与区域：**

1. `Task11Product.java`：用下面的完整类声明替换原来整个 `Task11Product` 类（保留文件头注释）；
2. `Task11Constructor.java`：替换 `main` 中的练习区域。

`Task11Product.java` 的最终类体：

```java
class Task11Product {
    String name;
    double price;
    int stock;

    Task11Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
```

`Task11Constructor.java` 的 `main` 练习区域：

```java
Task11Product product = new Task11Product(name, price, stock);
System.out.println("Name: " + product.name);
System.out.println("Price: " + product.price);
System.out.println("Stock: " + product.stock);
```

**解析：** 构造方法与类同名，`new Task11Product(...)` 时自动调用。参数与字段同名，`this.name` 明确表示当前对象的字段，右侧 `name` 是构造参数。三行赋值分别初始化三个字段。

**常见错误：** 给构造方法写 `void` 或返回类型；写成 `name = name;`，两边都是参数，字段仍为默认值；只初始化部分字段；创建对象时不传三个参数。

**边界：** 库存为 0 也要正确初始化；价格可以是小数；参数顺序必须是名称、单价、库存。

**人工核对：** 构造方法必须与类同名、无返回类型；参数必须与字段同名；三个字段都必须用 `this` 赋值。自动测试还会用反射调用三参数构造方法，检查字段类型、实例属性和两个对象的独立性，确保所有字段都完成初始化。

**等价写法：** 构造方法中的三条赋值可以分行、可以调整顺序，只要每个字段都保存对应的参数值。不能改成带返回类型的方法，也不能只初始化部分字段。

<a id="task12"></a>

## 12 商品对象数组与交换

**文件与区域：** `Task12ProductArray.java`，替换 `main` 中的练习区域。`Task12Product.java` 已提供完整实现，不需要修改。

```java
Task12Product notebook = new Task12Product(names[0], prices[0], stocks[0]);
Task12Product pen = new Task12Product(names[1], prices[1], stocks[1]);
Task12Product eraser = new Task12Product(names[2], prices[2], stocks[2]);

Task12Product[] products = {notebook, pen, eraser};
Task12Product temp = products[firstIndex];
products[firstIndex] = products[secondIndex];
products[secondIndex] = temp;
printProducts(products);
```

**解析：** 三个对象各自保存一组完整数据。对象数组的元素是引用，交换引用后，`Pen` 仍然带着自己的 8.0 和 20，不会出现名称换了、价格没换的错位。临时变量 `temp` 保存第一个引用，防止第一次赋值把它覆盖。

**常见错误：** 交换时直接写 `products[0] = products[1]; products[1] = products[0];`，两个位置最后都指向同一个对象；只交换名称或价格；把 `temp` 声明成 `int`；忘记调用 `printProducts`。

**边界：** 两个下标相同时，三次交换后顺序恢复原样；交换 0 和 2 也必须正确。索引一定合法。

**人工核对：** 必须用临时变量交换数组元素，交换的是对象引用，不能逐项复制字段。

**等价写法：** 临时变量可以改名为 `saved`、`backup` 等；创建对象和数组的三条语句可以分行或紧凑书写。交换三步的顺序不能变。

<a id="task13"></a>

## 13 把对象传给静态方法

**文件与区域：** `Task13StaticObject.java`，用下面的完整方法替换原来的 `stockValue` 方法（连同签名），并删除临时 `return 0.0;`。

```java
static double stockValue(Task13Product product) {
    return product.price * product.stock;
}
```

**解析：** 参数 `product` 接收一个完整的商品对象。静态方法内部没有 `this`，所以通过参数名访问 `product.price` 和 `product.stock`。每次调用传入不同对象，方法就读取不同数据。

**常见错误：** 把参数写成 `double price, int stock`，没有体现对象参数；在方法中访问不存在的 `this.price`；用静态字段缓存某一件商品，导致换对象后仍读旧数据。

**边界：** 零库存或零单价返回 0；方法不能修改商品字段。

**人工核对：** 参数类型必须是 `Task13Product`，并通过参数对象读取数据；方法应是 `static`。自动测试还会检查返回类型必须是 `double`，并用 2.5 × 3 = 7.5 的小数结果防止改成 `int`。

**等价写法：** 可以先写 `double result = product.price * product.stock;`，再 `return result;`。两种写法都不修改商品对象。

<a id="task14"></a>

## 14 商品自己计算库存价值

**文件与区域：** `Task14Product.java`，用下面的完整方法替换原来的 `stockValue` 方法（连同签名），并删除临时 `return 0.0;`。

```java
double stockValue() {
    return price * stock;
}
```

**解析：** 实例方法不带 `static`，也不接收当前商品参数。调用 `pen.stockValue()` 时，`price` 和 `stock` 自动指向 `pen` 的字段；调用 `notebook.stockValue()` 时则指向笔记本的字段。

**常见错误：** 加 `static` 后无法直接访问实例字段；方法写成 `stockValue(Task14Product product)`，与题目约定不符；返回 0 或写死 160；在方法中修改库存。

**边界：** 两件商品必须各自使用自己的字段；零库存返回 0。等价写法 `this.price * this.stock` 也正确。

**人工核对：** 不加 `static`，不增加商品参数，方法只读取当前对象字段。自动测试还会检查无参数实例方法和 `double` 返回类型，并用小数结果防止改成 `int`。

<a id="task15"></a>

## 15 比较两件商品的价格

**文件与区域：** `Task15Product.java`，用下面的完整方法替换原来的 `isCheaperThan` 方法（连同签名），并删除临时 `return false;`。

```java
boolean isCheaperThan(Task15Product other) {
    return this.price < other.price;
}
```

**解析：** 点号前的对象是当前对象，方法中用 `this` 表示；括号中的对象是 `other`。`pen.isCheaperThan(notebook)` 比较 8.0 和 12.5。反过来调用时 `this` 和 `other` 的角色互换。相等时 `<` 为 `false`，与自身比较也为 `false`。

**常见错误：** 写成 `other.price < this.price`，方向反了；用 `<=`，相等时错误返回 `true`；比较库存而不是单价；修改价格后再比较。

**边界：** 更便宜返回 `true`；更贵、相等、与自身比较都返回 `false`。

**人工核对：** 必须使用 `this.price` 与 `other.price`，比较符号是严格小于。

**等价写法：** 可以写成 `if (this.price < other.price) { return true; } return false;`，或先把比较结果存入 `boolean result` 再返回。不能把相等情况归入 `true`。

<a id="task16"></a>

## 16 私有库存与 getter

**文件与区域：** `Task16Product.java`，用下面的完整类声明替换整个 `Task16Product` 类（保留文件头注释）。`Task16PrivateStock.java` 不需要修改。

`Task16Product` 的最终类体：

```java
class Task16Product {
    String name;
    double price;
    private int stock;

    Task16Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}
```

**解析：** `private` 让 `stock` 只能在 `Task16Product` 类内部访问。构造方法和 getter 都在类内，可以直接读写字段；`main` 在类外，只能调用公开的 `getStock()`。getter 的返回类型是 `int`，直接返回字段值，不做修改。

**常见错误：** 保留 `int stock;`，外部仍可直接访问；把 getter 写成 `public void getStock()`，没有返回值；getter 中返回 0 或写死 10；把字段改成 `public`。

**边界：** 库存为 0 时 getter 返回 0；两个对象通过 getter 返回各自库存。测试使用反射检查字段是否为 `private`，这属于结构检查，不限制 getter 的内部写法。

**人工核对：** `stock` 必须是 `private`；`main` 不能写 `product.stock`；getter 必须是 `public int getStock()`。

**等价写法：** getter 可以写 `return this.stock;`。也可以先声明 `int result = stock;` 再返回，但不应在 getter 中修改库存。

<a id="task17"></a>

## 17 通过 setter 检查库存

**文件与区域：** `Task17Product.java`，用下面的完整方法替换原来的 `setStock` 方法（连同签名）。`Task17Setter.java` 不需要修改。

```java
public void setStock(int stock) {
    if (stock >= 0) {
        this.stock = stock;
    }
}
```

**解析：** 参数与字段同名，`this.stock` 是当前对象的字段，右侧 `stock` 是传入值。只有非负参数才执行赋值；负数时整个 `if` 不执行，字段保持原值。`void` 表示方法不返回结果，调用方通过 `getStock()` 再读取。

**常见错误：** 条件写成 `stock > 0`，拒绝合法的 0；写成 `stock = stock;`，只给参数自己赋值；没有 `this`，字段没有被更新；负数时把库存改成 0；在 setter 中打印。

**边界：** 0 合法；连续调用按顺序生效；负数失败后仍可继续设置合法值。

**人工核对：** 返回类型必须是 `void`；负数分支不能改变字段；赋值语句要更新 `this.stock`。自动测试还用反射检查方法必须是 `public void setStock(int)`。

**等价写法：** 可以写成 `if (stock < 0) { return; } this.stock = stock;`，或继续使用非负条件。两种写法都必须让负数输入保持原值，不能把负数改成 0。

<a id="task18"></a>

## 18 购买商品

**文件与区域：** `Task18Product.java`，用下面的完整方法替换原来的 `purchase` 方法（连同签名），并删除临时 `return false;`。`Task18Purchase.java` 不需要修改。

```java
public boolean purchase(int quantity) {
    if (quantity <= 0 || quantity > stock) {
        return false;
    }
    stock -= quantity;
    return true;
}
```

**解析：** 先用 `||` 合并两种失败情况：数量不是正数，或者超过当前库存。失败时立即返回 `false`，后面的扣减不会执行，所以库存不变。通过检查后扣减库存并返回 `true`。返回类型是 `boolean`，调用方可以据此判断是否成功。

**常见错误：** 先扣库存再检查，失败时库存已被破坏；条件写成 `quantity < 0`，允许购买 0 件；用 `quantity >= stock`，库存恰好足够时错误拒绝；失败分支也执行 `stock -= quantity`；只返回布尔值却忘记扣库存。

**边界：** 部分购买成功；恰好买完库存变为 0；库存不足、0、负数、空库存均失败且库存不变；连续购买从当前库存继续扣减。

**人工核对：** 失败分支不能修改库存；成功分支必须扣减；方法内不能打印。自动测试还用反射检查方法必须是 `public boolean purchase(int)`。

**等价写法：** 可以在成功分支先写 `boolean success = true;`，再统一返回；也可以先算出 `stock -= quantity` 后返回常量。必须保证失败分支提前返回，不能先扣库存。

<a id="extra01"></a>

## 附加 01 为商品分配编号

**文件与区域：**

1. `Extra01Product.java`：用下面的完整类声明替换整个 `Extra01Product` 类（保留文件头注释）；
2. `Extra01ProductId.java`：替换 `main` 中的练习区域。

`Extra01Product` 的最终类体：

```java
class Extra01Product {
    static int nextId = 1;
    int id;
    String name;

    Extra01Product(String name) {
        this.name = name;
        id = nextId;
        nextId++;
    }
}
```

`Extra01ProductId.java` 的 `main` 练习区域：

```java
Extra01Product first = new Extra01Product(firstName);
Extra01Product second = new Extra01Product(secondName);
Extra01Product third = new Extra01Product(thirdName);
System.out.println(first.id + " " + first.name);
System.out.println(second.id + " " + second.name);
System.out.println(third.id + " " + third.name);
System.out.println("First id after: " + first.id);
```

**解析：** `nextId` 属于类，被所有对象共享，初值为 1。每次构造对象时，先把当前 `nextId` 复制到该对象自己的 `id`，再让计数器增加。创建第二个对象时，计数器已经是 2；创建第三个时是 3。第一件商品的 `id` 早已保存为 1，后续计数器变化不会改写它。

**常见错误：** 把 `nextId` 写成实例字段，每个对象都从 1 开始；先自增再赋值，编号从 2 开始；把 `id` 写成 `static`，三件商品共享同一个编号；忘记在构造方法中保存名称。

**边界：** 每次程序运行都从 1 开始；测试在独立进程中运行，不共享静态状态。第一件商品的编号在创建三件后仍为 1。

**人工核对：** `nextId` 必须是 `static`，`id` 必须是实例字段；编号从 1 开始；输出必须使用对象的 `id` 和 `name`。自动测试还会用反射检查这两个字段的类型和静态属性，并检查 `nextId` 的初值是否为 1。

**等价写法：** 构造方法中可以用 `id = nextId++;` 代替两条语句，仍会先取旧值再自增。`nextId` 的初值必须是 1，不能先自增再赋值。

<a id="extra02"></a>

## 附加 02 统计整批商品的库存价值

**文件与区域：** `Extra02BatchValue.java`，用下面的完整方法替换原来的 `totalStockValue` 方法（连同签名），并删除临时 `return 0.0;`。`Extra02Product.java` 已提供，不需要修改。

```java
static double totalStockValue(Extra02Product[] products) {
    double total = 0;
    for (int i = 0; i < products.length; i++) {
        total += products[i].stockValue();
    }
    return total;
}
```

**解析：** 参数是对象数组，循环变量 `i` 遍历每个对象。`products[i].stockValue()` 调用当前商品的实例方法，方法内部使用该商品自己的单价和库存。把每次返回值累加到 `total`，循环结束后返回。空数组不执行循环，返回 0。

**常见错误：** 在循环中重新写 `products[i].price * products[i].stock`，没有调用 `stockValue()`；把 `products.length` 写成固定 3；用 `products[i]` 直接相加而不是调用方法；在累加时修改商品字段。

**边界：** 空数组返回 0.0；零库存商品贡献 0；多件商品按数组顺序累加；输出代码会再次打印每件商品的状态，用于确认没有被修改。

**人工核对：** 必须接收 `Extra02Product[]`，循环调用每个元素的 `stockValue()`，不能重新实现公式，也不能修改商品对象。

**等价写法：** 累加语句可以写成 `total = total + products[i].stockValue();`。如果课程已经讲过增强 `for`，也可以用，但本题按课堂进度使用普通 `for` 和下标。
