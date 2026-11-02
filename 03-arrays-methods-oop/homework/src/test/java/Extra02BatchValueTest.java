import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Extra02BatchValueTest {
    @TempDir
    Path directory;

    @DisplayName("附加题02：统计整批商品的库存价值")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Extra02BatchValue.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认三件商品",
                        "Count: 3\nTotal: 285.0\n"
                                + "Notebook, 12.5, 10, 125.0\n"
                                + "Pen, 8.0, 20, 160.0\n"
                                + "Eraser, 3.0, 0, 0.0",
                        new String[]{}),
                arguments("空数组返回0", "Count: 0\nTotal: 0.0", new String[]{"empty"}),
                arguments("全部零库存", "Count: 2\nTotal: 0.0\n"
                                + "Item1, 5.0, 0, 0.0\n"
                                + "Item2, 9.0, 0, 0.0",
                        new String[]{"5.0", "0", "9.0", "0"}),
                arguments("单件商品", "Count: 1\nTotal: 30.0\nItem1, 7.5, 4, 30.0",
                        new String[]{"7.5", "4"}),
                arguments("三件商品混合库存", "Count: 3\nTotal: 22.0\n"
                                + "Item1, 1.5, 2, 3.0\n"
                                + "Item2, 2.25, 4, 9.0\n"
                                + "Item3, 10.0, 1, 10.0",
                        new String[]{"1.5", "2", "2.25", "4", "10.0", "1"})
        );
    }
}
