package rating.task;

public enum RatingAgency {
    SP("SP"),MOODYS("MOODYS"),INTERNAL("INTERNAL"), INVALID("INVALID AGENCY");

    private String description;

    private RatingAgency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}