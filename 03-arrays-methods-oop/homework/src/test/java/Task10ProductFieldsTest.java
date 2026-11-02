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

class Task10ProductFieldsTest {
    @TempDir
    Path directory;

    @DisplayName("第10题：两个商品对象的数据互相独立")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task10ProductFields.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认两件商品",
                        "First: Notebook, 15.0, 10\nSecond: Pen, 8.0, 20",
                        new String[]{}),
                arguments("修改第一件不会改变第二件",
                        "First: Ink, 11.25, 4\nSecond: Ruler, 3.5, 12",
                        new String[]{"Ink", "9.75", "4", "Ruler", "3.5", "12", "11.25"}),
                arguments("零库存商品也保存自己的价格",
                        "First: Marker, 6.75, 0\nSecond: Box, 2.25, 7",
                        new String[]{"Marker", "5.5", "0", "Box", "2.25", "7", "6.75"})
        );
    }

    @Test
    @DisplayName("第10题：字段必须是正确的实例字段类型")
    void declaresInstanceFieldsWithCorrectTypes() throws Exception {
        assertField("name", String.class);
        assertField("price", double.class);
        assertField("stock", int.class);
    }

    @Test
    @DisplayName("第10题：两个对象的字段互不影响")
    void fieldsBelongToEachObject() throws Exception {
        Constructor<Task10Product> constructor = Task10Product.class.getDeclaredConstructor();
        Task10Product first = constructor.newInstance();
        Task10Product second = constructor.newInstance();

        set(first, "name", "First");
        set(first, "price", 1.5);
        set(first, "stock", 3);
        set(second, "name", "Second");
        set(second, "price", 2.5);
        set(second, "stock", 7);

        assertEquals("First", get(first, "name"), "第10题：第二个对象不应改写第一个对象的名称。");
        assertEquals(1.5, (double) get(first, "price"), 1e-9, "第10题：第二个对象不应改写第一个对象的价格。");
        assertEquals(3, get(first, "stock"), "第10题：第二个对象不应改写第一个对象的库存。");
        assertEquals("Second", get(second, "name"), "第10题：第二个对象应保存自己的名称。");
        assertEquals(2.5, (double) get(second, "price"), 1e-9, "第10题：第二个对象应保存自己的价格。");
        assertEquals(7, get(second, "stock"), "第10题：第二个对象应保存自己的库存。");
    }

    private static void assertField(String fieldName, Class<?> type) throws Exception {
        Field field = Task10Product.class.getDeclaredField(fieldName);
        assertEquals(type, field.getType(), "第10题：字段 " + fieldName + " 的类型不正确。");
        assertFalse(Modifier.isStatic(field.getModifiers()),
                "第10题：字段 " + fieldName + " 必须属于每个对象，不能是 static。");
    }

    private static void set(Object product, String fieldName, Object value) throws Exception {
        Field field = Task10Product.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(product, value);
    }

    private static Object get(Object product, String fieldName) throws Exception {
        Field field = Task10Product.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(product);
    }
}
