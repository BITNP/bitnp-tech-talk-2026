import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task05CountBelowTest {
    @TempDir
    Path directory;

    @DisplayName("第05题：统计严格低于阈值的商品")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task05CountBelow.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认数据", "Count: 3", new String[]{}),
                arguments("没有商品低于阈值", "Count: 0", new String[]{"3", "5.0", "12.0", "8.0", "25.0"}),
                arguments("全部商品都低于阈值", "Count: 5", new String[]{"5", "100.0", "12.0", "8.0", "25.0", "3.0", "8.0"}),
                arguments("等于阈值不计数", "Count: 1", new String[]{"2", "10.0", "10.0", "5.0"}),
                arguments("空数组", "Count: 0", new String[]{"0", "10.0"}),
                arguments("阈值为0时没有更小的非负价格", "Count: 0", new String[]{"2", "0.0", "0.0", "1.0"})
        );
    }
}
