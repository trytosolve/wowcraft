package rating.task;

public class RatingValue {
    private final Integer value;

    public RatingValue(Integer value) {
        if(value <1 || value >100) throw new IllegalArgumentException("Rating value should be in range 1..100");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RatingValue{" +
                "value=" + value +
                '}';
    }
}
