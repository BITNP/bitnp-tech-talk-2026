import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 教师提供的输出检查工具，无需修改。
 * 每次检查都启动独立进程，因此学生代码中的死循环可以被超时终止。
 */
final class OutputCheck {
    private OutputCheck() {
    }

    static void assertOutput(Class<?> task, Path directory, String expected, String... args) throws Exception {
        String actual = run(task, directory, args);
        assertEquals(normalize(expected), actual,
                context(args) + "输出不符合题意。主线题请补全练习区域；附加题请完成自行编写的代码。\n"
                        + "请按顺序核对每一行；不要修改测试或直接打印固定答案。");
    }

    private static String run(Class<?> task, Path directory, String... args) throws Exception {
        String executable = System.getProperty("os.name").startsWith("Windows")
                ? "java.exe" : "java";
        Path java = Path.of(System.getProperty("java.home"), "bin", executable);
        Path classes = Path.of(task.getProtectionDomain().getCodeSource().getLocation().toURI());
        Path stdout = directory.resolve("stdout.txt");
        Path stderr = directory.resolve("stderr.txt");

        List<String> command = new ArrayList<>(List.of(
                java.toString(), "-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8",
                "-Dstderr.encoding=UTF-8", "-cp", classes.toString(), task.getName()));
        command.addAll(List.of(args));
        Process process = new ProcessBuilder(command)
                .directory(directory.toFile())
                .redirectOutput(stdout.toFile())
                .redirectError(stderr.toFile())
                .start();
        try {
            process.getOutputStream().close();
            long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
            while (!process.waitFor(100, TimeUnit.MILLISECONDS)) {
                checkOutputSize(stdout, stderr);
                assertTrue(System.nanoTime() < deadline,
                        context(args) + "程序运行超过 5 秒，请检查是否有死循环或等待输入的代码。");
            }
            checkOutputSize(stdout, stderr);
            String errors = Files.readString(stderr, StandardCharsets.UTF_8);
            assertEquals(0, process.exitValue(), context(args) + "程序未正常结束：\n" + errors);
            return normalize(Files.readString(stdout, StandardCharsets.UTF_8));
        } finally {
            if (process.isAlive()) {
                process.destroyForcibly();
                process.waitFor(5, TimeUnit.SECONDS);
            }
        }
    }

    private static void checkOutputSize(Path stdout, Path stderr) throws Exception {
        assertTrue(Files.size(stdout) + Files.size(stderr) <= 64 * 1024,
                "输出超过 64 KiB，请检查循环是否忘记更新变量或输出了多余内容。");
    }

    private static String context(String[] args) {
        return args.length == 0 ? "使用题目默认数据。\n" : "本次程序参数：" + String.join(" ", args) + "\n";
    }

    private static String normalize(String output) {
        // 忽略平台换行差异和最后一次换行，保留其他空格与空行。
        String text = output.replace("\r\n", "\n").replace('\r', '\n');
        return text.endsWith("\n") ? text.substring(0, text.length() - 1) : text;
    }
}
