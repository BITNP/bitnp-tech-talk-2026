import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task01PriceArrayTest {
    @TempDir
    Path directory;

    @DisplayName("第01题：创建价格数组并读取指定索引")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task01PriceArray.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认读取索引1", "8\n3", new String[]{}),
                arguments("读取第一个价格", "12\n3", new String[]{"0"}),
                arguments("读取中间价格", "8\n3", new String[]{"1"}),
                arguments("读取最后一个价格", "25\n3", new String[]{"2"})
        );
    }
}
