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
        String path = "D://Books/12";
        getStatistic(path);

    }

    private static void getStatistic(String path) throws IOException {
        Map<Date,Long> lineMap = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .flatMap(Test::readLines)
                .map(Test::getTimeSubstr)
                .map(Test::convertToDate)
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()));
        lineMap.entrySet().forEach(System.out::println);
    }

    private static Date convertToDate(String l)  {
        try {
            return new SimpleDateFormat("[dd-MM-yyyy]").parse(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getTimeSubstr(String l) {
        return l.substring(l.indexOf("["), l.indexOf("]")+1);
    }

    public static void readWarn(String path) throws IOException {
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .flatMap(Test::readLines)
                .filter(l -> l.startsWith("WARN"))
                .forEach(System.out::println);
    }

    private static Stream<String> readLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

