# 验证记录

本文件记录第三次作业项目的实际验证过程。以下结果来自本次执行，不是根据测试数量估算。

## 环境

- 日期：2026-11-02
- 操作系统：Linux（CachyOS）
- JDK：OpenJDK 17.0.20.1
- Gradle Wrapper：9.6.0
- JUnit Jupiter：6.0.0
- 项目目录：`03-arrays-methods-oop/homework`

## 阅读的参考材料

开始实现前实际阅读了：

- 根目录 `AGENTS.md`；
- 第二次作业的 `README.md`、`build.gradle.kts`、`settings.gradle.kts`、
  `gradle/wrapper/gradle-wrapper.properties`、代表性主线题与附加题；
- 第二次作业的 `OutputCheck.java`、`Task01VariablesTest.java`、
  `Task12ItemNumbersTest.java`、`Extra02RightTriangleTest.java`；
- 第二次作业的 `docs/answers.md`、`LICENSE`、`LICENSES/`、`.gitignore`、`.gitattributes`；
- 第三次课件 `simplified.tex` 和 `main.tex`。

第二次作业、课件和共享主题文件均未修改。

## A. 学生初始版本

### 编译

命令：

```sh
cd 03-arrays-methods-oop/homework
./gradlew testClasses --console=plain
```

结果：`BUILD SUCCESSFUL`。主代码和全部测试类都能编译，尚未填写的练习区域没有破坏项目。

缓存完整后再次执行：

```sh
./gradlew testClasses --offline --console=plain
```

结果：`BUILD SUCCESSFUL`。

为确认项目不依赖本机已有的 `build` 或 `.gradle` 目录，又把整个项目（排除这两个目录）复制到
`/tmp/opencode/final-student-check`，执行：

```sh
./gradlew testClasses --offline --console=plain
```

结果：`BUILD SUCCESSFUL`，主代码和测试代码重新编译成功。

### 测试

命令：

```sh
./gradlew test --console=plain
```

结果：退出码 1，`122 tests completed, 93 failed`，0 个错误、0 个跳过。

这是预期状态：所有题目都至少有一个行为用例失败，不存在“完全没做却整题通过”的主线题。按测试类统计：

| 测试类 | 用例数 | 失败数 |
| --- | ---: | ---: |
| `Task01PriceArrayTest` | 4 | 4 |
| `Task02PriceUpdateTest` | 6 | 5 |
| `Task03StockArrayTest` | 5 | 5 |
| `Task04PriceSumTest` | 5 | 5 |
| `Task05CountBelowTest` | 6 | 6 |
| `Task06RestockTest` | 5 | 3 |
| `Task07TotalPriceTest` | 5 | 3 |
| `Task08SumPricesTest` | 5 | 4 |
| `Task09MethodCallTest` | 12 | 11 |
| `Task10ProductFieldsTest` | 5 | 5 |
| `Task11ConstructorTest` | 6 | 6 |
| `Task12ProductArrayTest` | 4 | 4 |
| `Task13StaticObjectTest` | 7 | 4 |
| `Task14InstanceMethodTest` | 8 | 5 |
| `Task15ComparePriceTest` | 6 | 2 |
| `Task16PrivateStockTest` | 7 | 5 |
| `Task17SetterTest` | 7 | 4 |
| `Task18PurchaseTest` | 9 | 4 |
| `Extra01ProductIdTest` | 5 | 5 |
| `Extra02BatchValueTest` | 5 | 3 |

部分用例在占位实现下偶然通过是正常的。例如 setter 尚未实现时，“负库存保持原值”可能通过；但同一题的合法更新用例会失败，整道题不能算完成。

### 每题 main 能启动

对 20 个题目入口类逐一执行（无参数）：

```sh
java -Dfile.encoding=UTF-8 -cp build/classes/java/main <题目类名>
```

结果：20 个入口全部退出码 0，没有启动异常。未完成的题可能没有输出，但不会因缺少类、字段或方法而在类初始化阶段崩溃。

## B. 参考答案版本

在临时目录复制学生项目，并按 `docs/answers.md` 逐题应用答案：

```sh
rm -rf /tmp/opencode/03-homework-answer
mkdir -p /tmp/opencode/03-homework-answer
cp -a src docs gradle build.gradle.kts settings.gradle.kts gradlew gradlew.bat \
  .gitignore .gitattributes LICENSE LICENSES /tmp/opencode/03-homework-answer/
```

随后修改每个题目的练习区域，包括：

- 第 10、11、14～18 题和附加题 01 的辅助类；
- 第 16 题的 `private` 字段和 getter；
- 第 17 题 setter 和附加题 02 的数组循环；
- 所有临时 `return` 均删除。

### 全量测试

命令：

```sh
cd /tmp/opencode/03-homework-answer
./gradlew test --console=plain
```

结果：`BUILD SUCCESSFUL`，122 个用例全部通过，0 失败、0 错误、0 跳过。

从 XML 结果独立统计得到：

```text
answer total tests=122 failures=0 errors=0 skipped=0
```

### 离线重跑

为了确认缓存完整时不需要网络，执行：

```sh
./gradlew test --offline --rerun-tasks --console=plain
```

结果：`BUILD SUCCESSFUL`，测试被强制重新执行，没有使用 `UP-TO-DATE` 跳过。

### 默认输出一致性

在答案副本中逐一运行 20 个入口类，保存 `build/main-defaults.txt`，共 20 组默认输出。逐项与各源文件开头声明的默认输出、README 摘要和测试预期核对，结果一致，包括：

- 第 06 题四行库存 `15 / 5 / 12 / 8`；
- 第 10 题 `First: Notebook, 15.0, 10` 与 `Second: Pen, 8.0, 20`；
- 第 12 题交换后的三件商品仍保持名称、价格、库存对应；
- 第 18 题 `true 7 / false 7 / true 0 / false 0`；
- 附加题 01 的 `1 / 2 / 3` 和第一件商品编号仍为 1；
- 附加题 02 的总价值 `285.0` 和零库存商品 `0.0`。

## C. 针对性错误实现

以下错误只在临时验证副本中修改，未写入交付目录。

| 错误实现 | 修改 | 执行测试 | 结果 |
| --- | --- | --- | --- |
| 阈值比较错误 | 第 05 题 `prices[i] < threshold` 改为 `<=` | `Task05CountBelowTest` | 6 个用例中 2 个失败：“等于阈值不计数”“阈值为 0 时没有更小的非负价格” |
| 购买失败仍扣库存 | 第 18 题失败分支增加 `stock -= 1;` | `Task18PurchaseTest` | 9 个用例中 6 个失败，包括库存不足、0 件、负数、空库存和连续购买 |
| 方法返回固定答案 | 第 07 题 `return price * quantity;` 改为 `return 37.5;` | `Task07TotalPriceTest` | 5 个用例中 4 个失败，只有默认金额偶然通过 |
| 实例字段错误共享 | 第 10 题三个字段全部改为 `static` | `Task10ProductFieldsTest` | 5 个用例全部失败，两件商品不再互相独立 |

这些检查表明测试不是只验证“能输出默认答案”，多组数据、状态变化和对象独立性都实际生效。

## D. 其他一致性检查

- `rg -n '____' src/main/java` 检查后，所有 `____` 都位于练习块注释或文件头说明中；没有可执行的未定义占位符。
- 初始项目 `testClasses` 成功，说明测试没有依赖尚未声明的类、字段或方法。
- 多文件题目均已按答案文档修改辅助类；第 12、13、16～18 题和附加题 02 的已提供类未被误改。
- 测试使用独立子进程检查含学生循环的 `main`，超时 5 秒、输出上限 64 KiB；直接方法测试只用于无循环的方法。
- 附加题 01 的静态编号测试每次在独立 JVM 中运行，不依赖 JUnit 执行顺序。
- 第 16 题仅使用反射检查 `private` 字段和 `public` getter，没有用正则扫描代码。
- 第 10、11 题使用反射检查实例字段、构造方法和对象独立性；第 13、14、17、18 题使用反射检查方法签名（`static`/实例、`double`/`void`/`boolean` 返回类型和参数类型）；附加题 01 使用反射检查 `nextId` 与 `id` 的静态/实例属性及初值。这些是结构检查，不限制等价的局部变量名或代码排版。
- 交付的 `src/main/java` 仍是学生未完成版本，答案只在 `docs/answers.md`。

## 未执行或仍有限制的检查

- 没有在 Windows 上实际运行 PowerShell 命令；README 中的 Windows 写法沿用第二次作业的格式，未做本机验证。
- 只在 JDK 17 上验证，没有测试其他 JDK 版本。
- 没有在全新机器、无 Gradle 缓存的网络环境中从零下载依赖；本次首次构建使用了已有缓存，之后用 `--offline` 验证了缓存完整时的重跑。
- 输出测试无法证明“使用普通 for”“calculate 调用了 square”“构造方法使用了 this”等源代码语法要求；这些已列为人工核对项，没有声称自动测试覆盖。
- 没有制作 PPT 或 PDF；本目录是代码作业项目，不涉及 LaTeX 编译和视觉检查。
- 没有初始化 Git 仓库、提交或推送。
