import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task02PriceUpdateTest {
    @TempDir
    Path directory;

    @DisplayName("第02题：只修改指定索引的价格")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task02PriceUpdate.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认修改索引1", "12\n10\n25\n6", new String[]{}),
                arguments("修改第一件商品", "9\n8\n25\n6", new String[]{"0", "9"}),
                arguments("修改第三件商品", "12\n8\n30\n6", new String[]{"2", "30"}),
                arguments("修改最后一件商品", "12\n8\n25\n0", new String[]{"3", "0"}),
                arguments("新价格与原价相同", "12\n8\n25\n6", new String[]{"1", "8"}),
                arguments("不能写死索引1", "12\n8\n25\n99", new String[]{"3", "99"})
        );
    }
}
