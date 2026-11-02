import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task12ProductArrayTest {
    @TempDir
    Path directory;

    @DisplayName("第12题：交换对象引用后商品信息仍完整")
    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void checksOutput(String label, String expected, String[] args) throws Exception {
        OutputCheck.assertOutput(Task12ProductArray.class, directory, expected, args);
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                arguments("默认交换索引0和1",
                        "Pen, 8.0, 20\nNotebook, 12.5, 10\nEraser, 3.0, 30",
                        new String[]{}),
                arguments("交换索引1和2",
                        "Notebook, 12.5, 10\nEraser, 3.0, 30\nPen, 8.0, 20",
                        new String[]{"1", "2"}),
                arguments("交换索引2和0",
                        "Eraser, 3.0, 30\nPen, 8.0, 20\nNotebook, 12.5, 10",
                        new String[]{"2", "0"}),
                arguments("相同索引不改变顺序",
                        "Notebook, 12.5, 10\nPen, 8.0, 20\nEraser, 3.0, 30",
                        new String[]{"1", "1"})
        );
    }
}
