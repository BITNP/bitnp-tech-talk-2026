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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Extra01ProductIdTest {
    @TempDir
    Path directory;

    @DisplayName("附加题01：静态计数器从1开始且旧编号不变")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Extra01ProductId.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认三件商品",
                        "1 Notebook\n2 Pen\n3 Eraser\nFirst id after: 1",
                        new String[]{}),
                arguments("换一组商品名称",
                        "1 Alpha\n2 Beta\n3 Gamma\nFirst id after: 1",
                        new String[]{"Alpha", "Beta", "Gamma"}),
                arguments("名称顺序不改变编号顺序",
                        "1 Eraser\n2 Notebook\n3 Pen\nFirst id after: 1",
                        new String[]{"Eraser", "Notebook", "Pen"})
        );
    }

    @Test
    @DisplayName("附加题01：nextId 是静态字段，id 是实例字段")
    void usesStaticCounterAndInstanceId() throws Exception {
        Field nextId = Extra01Product.class.getDeclaredField("nextId");
        assertEquals(int.class, nextId.getType(), "附加题01：nextId 必须是 int。");
        assertTrue(Modifier.isStatic(nextId.getModifiers()), "附加题01：nextId 必须属于类，使用 static。");

        Field id = Extra01Product.class.getDeclaredField("id");
        assertEquals(int.class, id.getType(), "附加题01：id 必须是 int。");
        assertFalse(Modifier.isStatic(id.getModifiers()), "附加题01：id 必须属于每个商品，不能是 static。");
    }

    @Test
    @DisplayName("附加题01：nextId 的初始值为1")
    void nextIdStartsAtOne() throws Exception {
        Field nextId = Extra01Product.class.getDeclaredField("nextId");
        assertEquals(1, nextId.getInt(null),
                "附加题01：静态计数器 nextId 的初值必须是 1，第一件商品才会得到编号 1。");
    }
}
