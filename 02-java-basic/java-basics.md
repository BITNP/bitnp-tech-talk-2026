# Java 基本程序设计结构

根据《Java 核心技术 卷 I》的文字版材料整理，当前包含 3.1–3.6，跳过 3.3.4、3.4.4、3.5.8、3.6.3、3.6.6、3.6.8。字符串部分仅以英文文本讲解常用 API。示例沿用书中的显式类声明与 `public static void main(String[] args)` 入口形式，不展开其他入口写法。

## 3.1 一个简单的 Java 应用程序

### 从一条输出指令开始

**要让程序在屏幕上显示一句话，代码应该放在哪里，又从哪里开始执行？**

先看一个完整程序，将它保存为 `FirstSample.java`：

```java
public class FirstSample {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

它分为三层：外层的**类**组织代码，类中的 **`main` 方法**作为启动入口，方法中的**语句**描述具体操作。这里的操作就是输出一行文本。

### 类与入口：组织代码，确定起点

**当一个程序包含多个功能时，需要把相关代码组织起来；启动时还需要一个明确的执行起点。**

本例通过 `class FirstSample` 声明一个名为 `FirstSample` 的类。现阶段可以先把类理解为组织程序逻辑的容器，暂不展开对象与面向对象设计。

启动这个类时，程序进入 `main`，执行其中的语句。入口声明的各部分含义如下：

| 写法 | 在本例中的作用 |
| --- | --- |
| `public` | 访问修饰符，表示该类或方法是公开的。 |
| `static` | 表示这是类的静态方法，调用它不需要先创建该类的对象。 |
| `void` | 表示方法不返回结果值。 |
| `main` | 本例启动入口的方法名。 |
| `String[] args` | 接收命令行参数的字符串数组；本例没有使用它，数组后面再讲。 |

因此，这个结构解决了两个问题：**类负责组织代码，入口方法确定从哪里开始执行。** 这里先理解各部分的职责，访问控制和静态方法的详细规则留到学习类时再展开。

### 文件与命名：让源码和类对应起来

**编译和启动都需要准确定位程序，因此名字既要符合语法，也要前后一致。**

本例使用公共类 `FirstSample`，源文件就命名为 `FirstSample.java`。Java 区分大小写，`FirstSample` 与 `firstsample` 是不同的名字，`main` 与 `Main` 也是不同的方法名。

区分两类要求：

- **语法规则**：名字不能以数字开头，不能使用 `class`、`public` 等关键字，也不能包含空格。
- **命名习惯**：类名通常使用名词，每个单词的首字母大写，例如 `FirstSample`、`StudentRecord`。

前者决定代码是否合法，后者帮助人读懂代码。

### 编译与运行：把源代码交给运行环境

**写好的 `.java` 是源代码；按本例的编译运行方式，需要先把它转换为字节码，再启动执行。**

安装好 JDK 后，在源文件所在目录执行：

```sh
javac FirstSample.java
java FirstSample
```

过程如下：

```text
FirstSample.java → javac 编译 → FirstSample.class
FirstSample.class → java 启动 JVM → 执行 main
```

`javac` 检查源码并生成字节码文件；`java FirstSample` 指定要启动的类，由 Java 虚拟机（JVM）执行程序。第二条命令使用类名，不加 `.class` 后缀。

输出结果：

```text
Hello, Java!
```

### 代码块与语句：确定范围和边界

**程序中有类、方法和具体操作，需要明确每部分从哪里开始、到哪里结束。**

大括号 `{ ... }` 划定范围：本例外层大括号是类体，内层大括号是方法体。方法中的这条调用语句以分号结束：

```java
System.out.println("Hello, Java!");
```

换行主要用于排版，不代替分号。比如下面仍然是一条调用语句，输出结果相同：

```java
System.out.println(
    "Hello, Java!"
);
```

缩进用来展示层次，便于人阅读；大括号和分号则明确代码的结构。类、方法的声明块不需要像上述调用语句那样在结尾添加分号。

### 方法调用：使用已有功能

**输出文字是一项现成的功能，我们只需指定调用哪个方法，并把要输出的内容交给它。**

在 `System.out.println("Hello, Java!")` 中：

- `System.out` 是标准输出对象，在本例中输出到控制台。
- `println` 是调用的方法名，负责输出内容并换行。
- 双引号中的 `"Hello, Java!"` 是字符串，作为参数传给方法。

本例体现的调用形式是 `对象.方法名(参数)`。圆括号表示参数列表；即使没有参数，也要保留括号。例如，把下面两句放入 `main`：

```java
System.out.println();
System.out.println("Ready.");
```

第一句输出一个空行，第二句输出 `Ready.` 并换行。参数决定交给方法处理什么内容，方法实现决定具体如何处理。

## 3.2 注释

### 为什么需要注释

**代码表达“执行什么”，但不一定能表达“为什么这样写”。这些解释需要留给阅读和维护代码的人。**

注释可以记录目的、约定或背景，不作为程序指令执行。比如下面的注释解释了输出的用意，而不是重复“打印文字”这个动作：

```java
// Show a startup message so the user knows the program is running.
System.out.println("Ready.");
```

这句注释说明：输出启动消息是为了让用户知道程序已经开始运行。删除注释不会改变这条语句的输出。

### 三种注释，分别解决什么问题

| 需求 | 写法 | 作用范围与用途 |
| --- | --- | --- |
| 给一小段代码补充说明 | `// 内容` | 从 `//` 到本行末尾，适合简短解释。 |
| 说明较长的背景或约定 | `/* 内容 */` | 从 `/*` 到 `*/`，可以跨多行。 |
| 为类或方法提供可生成的说明文档 | `/** 内容 */` | 文档注释，由 Javadoc 工具提取并生成 API 文档。 |

单行注释可以独占一行，也可以写在语句后面。多行说明可以连续写几行 `//`，也可以用 `/* ... */` 包围。

### 文档注释：让说明随代码维护

**如果类和方法的用途只写在另一份文档里，修改代码时容易漏改说明。文档注释让说明紧挨着它描述的代码，并能由工具生成文档。**

下面是三种注释在同一个程序中的用法，保存为 `CommentSample.java`：

```java
/**
 * Demonstrates a startup message.
 */
public class CommentSample {
    /*
     * Keep this example focused on startup and output.
     * Input handling is introduced separately.
     */
    public static void main(String[] args) {
        // Confirm that startup reached the main method.
        System.out.println("Ready.");
    }
}
```

类前的文档注释说明这个类的用途；多行注释说明示例为什么只包含启动和输出；单行注释说明输出语句的目的。运行结果只有：

```text
Ready.
```

选择哪种注释，取决于说明给谁看、描述什么：局部解释用普通注释，需要成为类或方法说明文档的内容用文档注释。写注释时优先补充代码本身看不出的原因。

## 3.3 数据类型

**人数、温度、字母和“是否完成”表达的是不同的信息。程序怎样区分这些数据，并判断哪些操作有意义？**

Java 中的每个变量都有类型。类型规定它能够保存哪类值，也参与决定可以对它进行哪些操作。例如，人数可以相加，而“是否完成”用真假来表达。编译器可以根据类型检查操作是否符合规则。

Java 有 8 种基本类型：

| 数据用途 | 基本类型 |
| --- | --- |
| 表示整数 | `byte`、`short`、`int`、`long` |
| 表示浮点数 | `float`、`double` |
| 表示字符，本节只使用英文字符 | `char` |
| 表示真假 | `boolean` |

下面没有完整类声明的代码片段，都可以放进 3.1 示例的 `main` 方法中执行。`类型 名字 = 值` 用于声明变量并给出初始值，3.4 会具体解释。

### 3.3.1 整型：在取值范围与存储大小之间选择

**班级人数和大型系统的累计计数都是整数，但可能需要的范围差别很大。因此，Java 提供了不同大小的整数类型。**

| 类型 | 位数 | 取值范围 |
| --- | --- | --- |
| `byte` | 8 位（1 字节） | -128 ～ 127 |
| `short` | 16 位（2 字节） | -32,768 ～ 32,767 |
| `int` | 32 位（4 字节） | -2,147,483,648 ～ 2,147,483,647 |
| `long` | 64 位（8 字节） | -2⁶³ ～ 2⁶³ - 1，约正负 922 亿亿 |

这些范围不随运行机器改变，帮助程序在不同平台上保持一致的数值行为。普通整数通常用 `int`；超出它的范围时用 `long`。`byte`、`short` 主要用于需要较小存储单位的场景，不必仅因为当前数字小就选它们。

```java
int studentCount = 40;
long totalVisits = 4_000_000_000L;
System.out.println(studentCount); // 40
System.out.println(totalVisits);  // 4000000000
```

直接写在源码中的数值称为**字面量**。这里的 `L` 表示该字面量是 `long` 类型；大写 `L` 比小写 `l` 更容易与数字 `1` 区分。数字之间的下划线只帮助阅读，不改变数值。

**同一个整数也可能需要以不同进制书写**，例如对照十六进制的数据说明。前缀决定源码中的进制，默认输出仍为十进制：

| 写法 | 含义 | 十进制值 |
| --- | --- | --- |
| `10` | 无前缀，十进制 | 10 |
| `0b1010` | `0b` 前缀，二进制 | 10 |
| `0xA` | `0x` 前缀，十六进制 | 10 |
| `012` | `0` 前缀，八进制 | 10 |

进制只改变书写形式，不会产生新的整数类型。日常计数用十进制即可，不要为了对齐而给整数补前导 `0`。

### 3.3.2 浮点类型：表示带小数的数值

**温度、距离等数值可能带小数，整数类型无法直接表达这部分信息。浮点类型用有限的有效数字表示较大范围的数值。**

| 类型 | 位数 | 大致有效十进制位数 | 最大有限正值约为 |
| --- | --- | --- | --- |
| `float` | 32 位 | 6–7 位 | 3.4 × 10³⁸ |
| `double` | 64 位 | 15–16 位 | 1.8 × 10³⁰⁸ |

“有效位数”包括整数部分和小数部分，不是固定能保留多少位小数。`double` 能保留更多有效数字，通常优先使用；`float` 适合明确要求单精度或需要节省大量数值存储空间的场景。

```java
double temperature = 23.5;
float ratio = 0.75F;
double distance = 1.5e3;
System.out.println(temperature); // 23.5
System.out.println(ratio);       // 0.75
System.out.println(distance);    // 1500.0
```

带小数点的数值字面量默认是 `double`；`F` 或 `f` 后缀指定为 `float`。`1.5e3` 是科学计数法，表示 1.5 × 10³。

**浮点运算还需要表达超出有限范围或没有有效数值结果的情况**，因此有正无穷大、负无穷大和 NaN（Not a Number）这些特殊值：

```java
System.out.println(1.0 / 0.0);  // Infinity
System.out.println(-1.0 / 0.0); // -Infinity
System.out.println(0.0 / 0.0);  // NaN
```

这里特意使用浮点数。整数除以零会产生异常，不能把上述结果套用到整数运算中。

### 3.3.3 char 类型：表达字符与特殊符号

**如果只需要一个英文等级字母或标点，可以用 `char`；如果需要一段文本，则使用字符串。** 本节只讨论英文字符，不展开编码。

```java
char grade = 'A';
String label = "A";
System.out.println(grade); // A
System.out.println(label); // A
```

`'A'` 使用单引号，是字符字面量；`"A"` 使用双引号，是字符串字面量。虽然打印结果相同，它们的类型不同。`String` 是类，不属于上面的 8 种基本类型。

**换行不能像普通字母一样直接放进单行字符串，引号本身又承担着界定文本的作用，怎样表达这些内容？** 使用以反斜杠开头的转义序列：

| 写法 | 表示的内容 |
| --- | --- |
| `\n` | 换行 |
| `\t` | 制表符 |
| `\r` | 回车 |
| `\b` | 退格 |
| `\"` | 双引号 |
| `\'` | 单引号 |
| `\\` | 反斜杠 |

```java
System.out.println("Hello\nJava");
System.out.println("Say \"Hi\".");
System.out.println("C:\\work");
```

输出：

```text
Hello
Java
Say "Hi".
C:\work
```

转义序列让源码能够表达特殊字符。例如 `\n` 在源码里由反斜杠和字母 `n` 组成，运行时表达的是换行。

### 3.3.5 boolean 类型：保存判断结果

**“是否完成”“是否达到要求”需要表达真假，而不是数量。** `boolean` 专门保存这类信息，只有 `true` 和 `false` 两个值。

```java
boolean finished = false;
boolean passed = 85 >= 60;
System.out.println(finished); // false
System.out.println(passed);   // true
```

`85 >= 60` 是一个比较，结果为 `true`，可以存入布尔变量。比较运算将在 3.5 展开。

Java 不把 `0`、`1` 当作布尔值，也不支持布尔值与数值类型之间的直接转换。这样，表示数量和表示判断结果的代码能够保持明确的类型区别。

## 3.4 变量与常量

**有了数据类型，还需要给数据起名字，才能重复使用它，并表达它在程序中的含义。** 会变化的数据用变量保存；需要固定下来的数值可以声明为常量。

### 3.4.1 声明变量：给数据确定类型和名字

**比起在程序中到处写一个数字，用名字表达它是什么，可以让计算过程更容易理解和修改。**

声明的基本形式是 `类型 变量名;`：

```java
int studentCount;
double temperature;
boolean finished;
```

这三行分别声明了用于保存整数、浮点数和真假值的变量。它们只确定名字和类型，还没有给这些局部变量赋值。

变量命名遵循 3.1 中的基本规则：区分大小写，不以数字开头，不使用关键字或空格。本总结采用英文名称，变量名通常首字母小写，后续单词首字母大写，例如 `studentCount`。名字应体现含义，不必把类型写进名字里。

虽然 `int width, height;` 可以一次声明两个变量，但逐个声明更便于分别初始化和阅读。声明尽量靠近第一次使用的位置，读者就不必来回寻找它。

### 3.4.2 变量初始化：从“有名字”到“有可用的值”

**声明只确定可以保存什么数据；使用数据前，还必须明确它当前是什么值。** 在方法中声明的局部变量，必须先赋值才能读取，编译器会检查这一点。

```java
int studentCount;
studentCount = 40;
System.out.println(studentCount); // 40

studentCount = 41;
System.out.println(studentCount); // 41
```

第一行声明变量，第二行首次赋值使它获得可用的值，后面的赋值将它更新为 `41`。`=` 表示赋值：先求右侧的值，再存入左侧变量，不表示数学上的相等判断。

声明和初始化也可以写在同一行：

```java
int studentCount = 40;
System.out.println(studentCount); // 40
```

如果删除初始化，直接读取变量，下面的片段就无法通过编译：

```java
int studentCount;
System.out.println(studentCount); // Does not compile: no value assigned.
```

这里限定为**局部变量**，不将规则泛化到以后会学到的类字段。先赋值再读取，可以避免程序依赖一个尚未确定的值。

### 3.4.3 常量：给固定数值命名并限制重新赋值

**英寸与厘米的换算系数会被反复使用，但不应该在计算过程中被改掉。怎样同时表达它的含义与固定性？** 使用 `final`：

```java
final double CM_PER_INCH = 2.54;
double lengthInInches = 10.0;
System.out.println(lengthInInches * CM_PER_INCH); // 25.4
```

`CM_PER_INCH` 说明这个数字是“每英寸对应的厘米数”；`final` 限制该变量只能赋值一次。因此读者能看懂换算含义，编译器也会阻止后续重新赋值。

常量名习惯使用全大写，单词之间用下划线分隔。这是命名习惯；真正限制重新赋值的是 `final`。

**如果多个方法都需要同一个常量，把它放在一个方法内部就不方便共享。** 可以将声明移到类体中、方法之外，并使用 `static final`：

```java
public class ConstantsSample {
    public static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        System.out.println(10.0 * CM_PER_INCH); // 25.4
    }
}
```

将完整示例保存为 `ConstantsSample.java`，按 3.1 的方式编译运行即可。

这里各部分分工不同：

- **放在类体中**：同一类的多个方法都可以使用它。
- **`static`**：它属于类，使用时不需要创建该类的对象。
- **`final`**：它只能被赋值一次。
- **`public`**：允许其他类访问，例如 `ConstantsSample.CM_PER_INCH`。

只在一个方法内使用的固定数值，可以声明为局部 `final` 变量；需要作为类的共同定义时，再放到类体中。

## 3.5 运算符

**保存数据之后，还需要计算新结果、比较大小和组合条件。运算符把值连接成表达式，表达式求值后得到一个结果。** 例如 `3 + 2` 得到整数 `5`，`3 > 2` 得到布尔值 `true`。

### 3.5.1 算术运算符：表达基本计算

**计算总量、平均值或分组后剩余的数量，需要不同的算术操作。** Java 使用 `+`、`-`、`*`、`/`、`%` 表示加、减、乘、除、求余。

```java
System.out.println(15 + 2);   // 17
System.out.println(15 - 2);   // 13
System.out.println(15 * 2);   // 30
System.out.println(15 / 2);   // 7
System.out.println(15 % 2);   // 1
System.out.println(15.0 / 2); // 7.5
```

`15 / 2` 的两个操作数都是整数，所以执行整数除法，结果向零截断；`15 % 2` 得到余数。想保留小数，需要在除法发生前让至少一个操作数成为浮点类型。

```java
// The division happens before assignment.
double first = 15 / 2;
double second = 15.0 / 2;
System.out.println(first);  // 7.0
System.out.println(second); // 7.5
```

左侧变量是 `double`，不会让右侧已经完成的整数除法重新计算。整数除以零会产生异常；浮点除以零的特殊结果见 3.3.2。

### 3.5.2 数学函数与常量：复用现成的计算

**平方根、乘方和对数等计算不能只靠一个基本运算符直接表达。标准库的 `Math` 类提供了这些功能，无需自行实现算法。**

| 需求 | 写法 |
| --- | --- |
| 平方根、乘方 | `Math.sqrt(x)`、`Math.pow(x, exponent)` |
| 三角函数，角度参数使用弧度 | `Math.sin(x)`、`Math.cos(x)`、`Math.tan(x)` |
| 反正切 | `Math.atan(x)`、`Math.atan2(y, x)` |
| 指数、自然对数、以 10 为底的对数 | `Math.exp(x)`、`Math.log(x)`、`Math.log10(x)` |
| π 与自然常数 e 的近似值 | `Math.PI`、`Math.E` |

```java
System.out.println(Math.sqrt(9.0));     // 3.0
System.out.println(Math.pow(2.0, 3.0)); // 8.0
```

这里直接通过类名 `Math` 调用方法，不需要创建对象。Java 的乘方使用 `Math.pow`，不能用 `^` 表示。

**如果数值需要绕回一个固定区间，例如时针往前或往后移动，负数求余就不一定符合要求。** 对于正除数，`Math.floorMod` 可以将结果归一化到从零开始的区间：

```java
int position = 2;
int adjustment = -5;
System.out.println((position + adjustment) % 12);      // -3
System.out.println(Math.floorMod(position + adjustment, 12)); // 9
```

时针从 2 点往回移动 5 小时，应落在 9 点。除数为正数 `12` 时，`floorMod` 的结果在 `0` 到 `11` 之间。

### 3.5.3 数值类型之间的转换：统一计算所用的类型

**整数与浮点数可能一起参与计算。要计算结果，Java 需要先确定共同使用的数值类型。** 一些转换可以自动完成，例如将 `int` 赋给 `double`：

```java
int count = 3;
double value = count;
System.out.println(value);       // 3.0
System.out.println(count + 0.5); // 3.5
```

常见的自动转换方向可以沿下面的箭头传递理解：

```text
byte → short → int → long → float → double
               ↑
              char
```

自动转换表示语言允许这样做，不等于一定保留所有有效数字。`int` 转 `float`、`long` 转 `float` 或 `double` 都可能损失精度。例如：

```java
int number = 123456789;
float approximate = number;
System.out.println(approximate); // 1.23456792E8
```

对于 `+`、`-`、`*`、`/` 等二元数值运算，按以下顺序决定共同类型：

1. 有 `double`，就按 `double` 计算。
2. 否则有 `float`，就按 `float` 计算。
3. 否则有 `long`，就按 `long` 计算。
4. 否则按 `int` 计算，包括 `byte`、`short`、`char` 参与的情况。

### 3.5.4 强制类型转换：明确要求转换目标

**有时计算结果是浮点数，但接下来只需要整数部分。这类转换需要显式表达，不能让编译器替我们决定如何舍弃信息。** 写法是 `(目标类型) 表达式`：

```java
double value = 9.997;
int whole = (int) value;
System.out.println(whole);       // 9
System.out.println((int) -9.997); // -9
```

本例在整数可表示的范围内，转换直接截去小数部分，方向是朝零，不是四舍五入。

**如果需要最接近的整数，就应该使用舍入方法，而不是强制转换来截断。**

```java
double value = 9.997;
long rounded = Math.round(value);
System.out.println(rounded); // 10
```

`Math.round(double)` 返回 `long`；距离相同的两个整数中取较大的那个。若最终需要 `int`，确认结果在其范围内后，再用 `(int)` 转换。

### 3.5.5 结合赋值和运算符：更新已有的值

**“取出原值、计算、再存回同一个变量”很常见，复合赋值把这个操作写得更紧凑。**

```java
int score = 10;
score += 5;
score *= 2;
System.out.println(score); // 30
```

在这个同类型的简单例子中，`score += 5` 相当于 `score = score + 5`，`score *= 2` 相当于 `score = score * 2`。同样还有 `-=`、`/=`、`%=`，运算符写在等号前面。

### 3.5.6 自增与自减：表达计数变化

**计数器经常只需要增加或减少一。** `n++`、`n--` 分别更新变量，让它加一或减一；因为要更新变量，不能对字面量写 `4++`。

当它们参与较大的表达式时，还要区分“变量更新后的值”和“表达式本身提供的值”：

```java
int first = 7;
int second = 7;
int a = ++first;
int b = second++;
System.out.println(first);  // 8
System.out.println(second); // 8
System.out.println(a);      // 8
System.out.println(b);      // 7
```

前缀 `++first` 提供更新后的值；后缀 `second++` 提供更新前的值。两者都会更新变量，自减同理。日常代码可以把自增、自减单独写成一条语句，减少读者推算执行过程的负担。

### 3.5.7 关系和布尔运算符：从数据得到条件

**程序不仅需要计算数量，也需要回答“是否达标”“是否同时满足条件”。** 关系运算符返回布尔值：

| 运算符 | 含义 |
| --- | --- |
| `==`、`!=` | 相等、不相等 |
| `<`、`>` | 小于、大于 |
| `<=`、`>=` | 小于等于、大于等于 |

`=` 是赋值，`==` 才是相等判断。这里先讨论数值比较；字符串的内容比较见 3.6.4。

**一个判断往往由多个条件组成。** 用 `&&` 表示“并且”，用 `||` 表示“或者”，用 `!` 取反：

```java
int score = 85;
boolean submitted = true;
boolean passed = score >= 60 && submitted;
System.out.println(passed);     // true
System.out.println(!submitted); // false
```

`&&` 两边都为真才为真；`||` 至少一边为真就为真。

**如果左边已经确定整体结果，右边就没有必要再计算。** 这称为短路求值：`&&` 左侧为假就停止，`||` 左侧为真就停止。

```java
int divisor = 0;
boolean largeEnough = divisor != 0 && 10 / divisor > 2;
System.out.println(largeEnough); // false
```

左侧已经是 `false`，所以不会执行除法。把必要条件放在前面，还能避免对不满足前提的数据执行后续操作。

**只想根据条件在两个值中选一个时，可以使用条件表达式** `条件 ? 值1 : 值2`：

```java
int score = 85;
String result = score >= 60 ? "Pass" : "Fail";
System.out.println(result); // Pass
```

条件为真就求值并使用第一项，否则求值并使用第二项。

### 3.5.9 括号与运算符级别：明确表达式如何组合

**多个运算符出现在同一个表达式中，需要有规则决定哪些部分先结合。** 常见的优先级从高到低，可以先记住：

```text
乘除求余 → 加减 → 大小比较 → 相等比较 → && → || → ?: → 赋值
```

圆括号可以直接指定分组，逻辑非 `!` 则作用于紧随其后的操作数：

```java
System.out.println(2 + 3 * 4);       // 14
System.out.println((2 + 3) * 4);     // 20
System.out.println(true || false && false); // true
System.out.println((true || false) && false); // false
```

同级运算还要看结合性。例如 `10 - 3 - 2` 按 `(10 - 3) - 2` 组合，而连续赋值 `a = b = 3` 按 `a = (b = 3)` 组合。结合性描述的是表达式如何分组，不要把它当作所有操作数求值顺序的通用说明。表达复杂条件时，主动加括号通常比要求读者记住整张优先级表更清楚。

## 3.6 字符串

**名字、文件名和消息都需要作为整段文本处理。** Java 用 `String` 表示字符串，双引号中的文本就是字符串，例如 `String name = "Alice";`。

本节只处理英文、数字和常见标点组成的文本，按任务介绍 API，不讨论编码与内部实现。示例中的 `repeat`、`isBlank`、`strip` 需要 Java 11 或以上版本。

### 读取长度和字符（对应 3.6.7）

**要知道文本有多长，或者读取某个位置的字符，可以使用 `length()` 和 `charAt()`。**

```java
String text = "Hello";
System.out.println(text.length());  // 5
System.out.println(text.charAt(0)); // H
System.out.println(text.charAt(4)); // o
```

索引从 `0` 开始，所以最后一个字符的索引是 `length() - 1`。本例长度为 5，有效索引是 0 到 4。

### 3.6.1 子串：提取一段文本

**只需要文件名前缀或文本的一部分时，不必逐个字符拼接，直接截取即可。**

```java
String text = "Hello Java";
System.out.println(text.substring(0, 5)); // Hello
System.out.println(text.substring(6));    // Java
```

`substring(start, end)` 包含起点、不包含终点，截取长度为 `end - start`；只给起点就截取到末尾。这样，相邻的两个区间可以直接共享边界，不会重复取到同一个位置。

### 3.6.2 拼接：组合或重复文本

**生成消息时，常常要把固定文本与数据组合起来；列表式文本还需要统一的分隔符。**

```java
int age = 20;
System.out.println("Age: " + age);               // Age: 20
System.out.println(String.join(" / ", "S", "M", "L")); // S / M / L
System.out.println("Ha".repeat(3));               // HaHaHa
```

少量内容用 `+` 拼接，数值会转换为文本；多个片段需要同一分隔符时用 `String.join`；重复相同内容用 `repeat`。拼接不会自动添加空格，空格要写在文本或分隔符中。

### 3.6.4 比较：判断内容是否相同

**判断用户输入是否匹配某个词时，关心的是文本内容，而不是它们是否引用同一个对象。** 使用 `equals`，忽略大小写时使用 `equalsIgnoreCase`：

```java
String name = "Alice";
System.out.println(name.equals("Alice"));         // true
System.out.println(name.equals("alice"));         // false
System.out.println(name.equalsIgnoreCase("alice")); // true
```

对字符串使用 `==` 判断的是引用是否相同。要比较内容，就使用上面的方法。

### 3.6.5 空文本：区分没有对象、空串和空白

**“没有提供文本”“提供了空文本”“只输入空格”是三种不同情况。**

| 情况 | 表示 | 判断方法 |
| --- | --- | --- |
| 没有关联字符串对象 | `null` | `text == null` |
| 有字符串，但长度为零 | `""` | `text.isEmpty()` |
| 空串或只包含空白字符 | `""`、`"   "` 等 | `text.isBlank()` |

```java
System.out.println("".isEmpty());    // true
System.out.println("   ".isEmpty()); // false
System.out.println("   ".isBlank()); // true
String text = null;
System.out.println(text != null && !text.isBlank()); // false
```

不能在 `null` 上调用方法。最后一行先判断是否有对象，再判断内容，借助短路避免执行无效的方法调用。

### 3.6.7 常用 API：按文本处理任务选择

**查找一段内容或识别文件后缀时，需要定位或判断，而不是改动文本。**

```java
String file = "report-final.txt";
System.out.println(file.indexOf("-"));          // 6
System.out.println(file.lastIndexOf("."));      // 12
System.out.println(file.indexOf("draft"));      // -1
System.out.println(file.startsWith("report")); // true
System.out.println(file.endsWith(".txt"));     // true
```

`indexOf` 返回第一次出现的位置，`lastIndexOf` 返回最后一次出现的位置；找不到都返回 `-1`。`startsWith` 和 `endsWith` 直接返回是否匹配开头或结尾。

**需要按文本顺序比较时，使用 `compareTo`。** 对这里的同为小写的英文单词，可以按字母顺序理解；它区分大小写，不负责自然语言的排序规则。

```java
System.out.println("apple".compareTo("banana") < 0); // true
System.out.println("apple".compareTo("apple") == 0); // true
System.out.println("banana".compareTo("apple") > 0); // true
```

只需看返回值的符号：负数表示排在前面，零表示相等，正数表示排在后面，不要假设它只返回 `-1`、`0`、`1`。

**清理和统一文本格式时，需要替换、大小写转换或去除首尾空白。**

```java
String text = "  Hello Java  ";
System.out.println(text.strip());                 // Hello Java
System.out.println(text.trim());                  // Hello Java
System.out.println("Hello".toLowerCase());         // hello
System.out.println("Hello".toUpperCase());         // HELLO
System.out.println("red red".replace("red", "blue")); // blue blue
```

`replace` 替换所有匹配的文本；`toLowerCase`、`toUpperCase` 转换大小写。对于本例的普通英文空格，`trim` 与 `strip` 都会去掉首尾空格，保留中间空格；它们识别空白的规则不同，这里不展开。

这些方法返回处理结果。需要保存结果时，要接住返回值，例如 `text = text.strip();`，只写 `text.strip();` 不会让变量 `text` 改为保存清理后的文本。

### 3.6.9 StringBuilder：分多次构建文本

**如果文本需要逐段追加、插入或删除，可以用一个构建器集中完成编辑，最后再得到字符串。**

```java
StringBuilder builder = new StringBuilder();
builder.append("Hello");
builder.append(" Java");
builder.insert(5, ",");
System.out.println(builder.toString()); // Hello, Java
builder.delete(5, 6);
String result = builder.toString();
System.out.println(result); // Hello Java
```

`append` 追加到末尾，`insert` 在指定位置前插入，`delete(start, end)` 删除左闭右开区间内的内容，`toString` 得到最终字符串。少量片段直接用 `+` 就很清楚；需要多步编辑时再使用构建器。

---

材料来源：[《Java 核心技术 卷 I》3.1–3.7 文字版](/home/potato/Documents/book/Java核心技术卷I-3.1-3.7.md)。本文当前整理 3.1–3.6 正文，按约定跳过指定小节，不纳入原书的旁注和警告；字符串按英文文本的常用操作精简，示例为教学示例。
