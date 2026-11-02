import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task08SumPricesTest {
    @TempDir
    Path directory;

    @DisplayName("第08题：方法返回数组总和且不修改数组")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task08SumPrices.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认三件商品", "Total: 45.5\nCount: 3\nPrices: 12.0 8.5 25.0", new String[]{}),
                arguments("空数组", "Total: 0.0\nCount: 0\nPrices:", new String[]{"0"}),
                arguments("单件商品", "Total: 7.5\nCount: 1\nPrices: 7.5", new String[]{"1", "7.5"}),
                arguments("小数求和", "Total: 17.5\nCount: 4\nPrices: 1.5 2.25 3.75 10.0",
                        new String[]{"4", "1.5", "2.25", "3.75", "10.0"}),
                arguments("原数组元素必须保持不变", "Total: 60.0\nCount: 5\nPrices: 10.0 20.0 5.0 15.0 10.0",
                        new String[]{"5", "10.0", "20.0", "5.0", "15.0", "10.0"})
        );
    }
}
