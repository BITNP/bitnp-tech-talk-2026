import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task03StockArrayTest {
    @TempDir
    Path directory;

    @DisplayName("第03题：按指定长度创建库存数组")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task03StockArray.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认长度3", "Length: 3\n0\n0\n0", new String[]{}),
                arguments("零长度不能读取第一个元素", "Length: 0", new String[]{"0"}),
                arguments("长度为1", "Length: 1\n0", new String[]{"1"}),
                arguments("长度为4", "Length: 4\n0\n0\n0\n0", new String[]{"4"}),
                arguments("长度为6", "Length: 6\n0\n0\n0\n0\n0\n0", new String[]{"6"})
        );
    }
}
