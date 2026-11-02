import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task06RestockTest {
    @TempDir
    Path directory;

    @DisplayName("第06题：为每个库存增加相同的补货量")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task06Restock.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认补货5件", "15\n5\n12\n8", new String[]{}),
                arguments("补货量为0", "10\n0\n7\n3", new String[]{"4", "0", "10", "0", "7", "3"}),
                arguments("空数组没有输出", "", new String[]{"0", "5"}),
                arguments("只有一件商品", "6", new String[]{"1", "2", "4"}),
                arguments("三个不同库存", "3\n4\n10", new String[]{"3", "3", "0", "1", "7"})
        );
    }
}
