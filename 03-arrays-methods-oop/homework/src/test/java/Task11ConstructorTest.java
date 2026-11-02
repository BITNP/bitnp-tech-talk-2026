import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task11ConstructorTest {
    @TempDir
    Path directory;

    @DisplayName("第11题：构造方法初始化全部字段")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task11Constructor.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认商品", "Name: Notebook\nPrice: 12.5\nStock: 10", new String[]{}),
                arguments("另一组数据", "Name: Ink\nPrice: 9.75\nStock: 4",
                        new String[]{"Ink", "9.75", "4"}),
                arguments("零库存也要初始化", "Name: Ruler\nPrice: 3.5\nStock: 0",
                        new String[]{"Ruler", "3.5", "0"})
        );
    }

    @Test
    @DisplayName("第11题：构造方法接收三个参数并初始化全部字段")
    void constructorInitializesAllFields() throws Exception {
        Constructor<Task11Product> constructor =
                Task11Product.class.getDeclaredConstructor(String.class, double.class, int.class);
        Task11Product product = constructor.newInstance("Ink", 9.75, 4);

        assertEquals("Ink", field("name").get(product),
                "第11题：构造方法没有把名称参数保存到 name 字段。");
        assertEquals(9.75, (double) field("price").get(product), 1e-9,
                "第11题：构造方法没有把单价参数保存到 price 字段。");
        assertEquals(4, field("stock").get(product),
                "第11题：构造方法没有把库存参数保存到 stock 字段。");
    }

    @Test
    @DisplayName("第11题：字段必须是正确的实例字段类型")
    void declaresInstanceFieldsWithCorrectTypes() throws Exception {
        assertField("name", String.class);
        assertField("price", double.class);
        assertField("stock", int.class);
    }

    @Test
    @DisplayName("第11题：两个对象由构造方法初始化后互不影响")
    void constructorCreatesIndependentObjects() throws Exception {
        Constructor<Task11Product> constructor =
                Task11Product.class.getDeclaredConstructor(String.class, double.class, int.class);
        Task11Product first = constructor.newInstance("First", 1.5, 3);
        Task11Product second = constructor.newInstance("Second", 2.5, 7);

        assertEquals("First", field("name").get(first),
                "第11题：创建第二个对象后，第一个对象的名称被改写。");
        assertEquals(1.5, (double) field("price").get(first), 1e-9,
                "第11题：创建第二个对象后，第一个对象的价格被改写。");
        assertEquals(3, field("stock").get(first),
                "第11题：创建第二个对象后，第一个对象的库存被改写。");
        assertEquals("Second", field("name").get(second),
                "第11题：第二个对象应保存自己的名称。");
        assertEquals(2.5, (double) field("price").get(second), 1e-9,
                "第11题：第二个对象应保存自己的价格。");
        assertEquals(7, field("stock").get(second),
                "第11题：第二个对象应保存自己的库存。");
    }

    private static void assertField(String name, Class<?> type) throws Exception {
        Field field = field(name);
        assertEquals(type, field.getType(), "第11题：字段 " + name + " 的类型不正确。");
        assertFalse(Modifier.isStatic(field.getModifiers()),
                "第11题：字段 " + name + " 必须属于每个对象，不能是 static。");
    }

    private static Field field(String name) throws Exception {
        Field field = Task11Product.class.getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }
}
