package rating.task;

public enum RatingType {
    LONG("LONG"), SHORT("SHORT"), INVALID("INVALID TYPE");

    private String description;

    RatingType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

