package rating.task;

public enum RatingType {
    LONG("LONG", 1), SHORT("SHORT",2), INVALID("INVALID TYPE",null);

    private String description;
    private Integer priority;

    RatingType(String description, Integer priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriority() {
        return priority;
    }
}

