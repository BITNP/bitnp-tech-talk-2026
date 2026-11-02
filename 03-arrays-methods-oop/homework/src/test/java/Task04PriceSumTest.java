import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task04PriceSumTest {
    @TempDir
    Path directory;

    @DisplayName("第04题：用循环计算价格总和")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task04PriceSum.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认三件商品", "Total: 45.5", new String[]{}),
                arguments("空数组总和为0", "Total: 0.0", new String[]{"0"}),
                arguments("只有一件商品", "Total: 7.5", new String[]{"1", "7.5"}),
                arguments("四种不同价格", "Total: 17.5", new String[]{"4", "1.5", "2.25", "3.75", "10.0"}),
                arguments("不能写死默认总和", "Total: 60.0", new String[]{"5", "10.0", "20.0", "5.0", "15.0", "10.0"})
        );
    }
}
