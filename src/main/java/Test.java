import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public Test() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        String path = new String("D://Books/12");
        getStatistic(path);

    }

    public static void getStatistic(String path) throws IOException {
        Map<Date,Long> lineMap = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .flatMap(f -> readLines(f))
                .map(l -> getTimeSubstr(l))
                .map(l -> convertToDate(l))
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()));

        lineMap.entrySet().stream().forEach(System.out::println);
    }

    private static Date convertToDate(String l)  {
        try {
            return new SimpleDateFormat("[dd-MM-yyyy]").parse(l);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static String getTimeSubstr(String l) {
        return l.substring(l.indexOf("["), l.indexOf("]")+1);
    }

    public static void readWarn(String path) throws IOException {
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .flatMap(f -> readLines(f))
                .filter(l -> l.startsWith("WARN"))
                .forEach(System.out::println);
    }

    private static Stream<String> readLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}

