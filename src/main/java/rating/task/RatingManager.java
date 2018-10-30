package rating.task;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RatingManager {

    private final String path = "D://somePath.txt";

    public static Map<BigInteger, Optional<Rating>> getRatingList(String path) throws IOException {


        return Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .flatMap(RatingManager::readLines)
                .map(RatingManager::getRatingFromString)
                .filter(rating -> rating.getRatingAgency() != RatingAgency.INTERNAL)
                .filter(rating -> rating.getRatingAgency() != RatingAgency.INVALID)
                .collect(Collectors.groupingBy(Rating::getCompanyId,
                        Collectors.reducing(getLessRatingOperator())));
    }

    private static BinaryOperator<Rating> getLessRatingOperator() {
        Comparator<Rating> ratingComparator = Comparator.comparing(rating -> rating.getRatingType());
        ratingComparator = ratingComparator.thenComparing(Comparator.comparingInt(rating ->
                rating.getRatingValue().getValue()));
        return BinaryOperator.minBy(ratingComparator);
    }


    public static Rating getRatingFromString(String line) {
        String[] args = line.split("\t");
        BigInteger id = new BigInteger(args[0]);
        RatingAgency ratingAgency = RatingAgency.INVALID;
        for (RatingAgency agency: RatingAgency.values()) {
            if (agency.getDescription().equals(args[1])) {
                ratingAgency = agency;
            }
        }
        RatingType ratingType = RatingType.INVALID;;
        for (RatingType type : RatingType.values()) {
            if (type.getDescription().equals(args[2])) {
                ratingType = type;
            }
        }
        RatingValue ratingValue = new RatingValue(new Integer(args[3]));
        return new Rating(id, ratingAgency, ratingType, ratingValue);
    }

    private static Stream<String> readLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        for (Map.Entry entry : getRatingList("D://somePath.txt").entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue().toString());
        }
    }

}
