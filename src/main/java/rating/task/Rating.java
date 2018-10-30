package rating.task;

import java.math.BigInteger;

public class Rating {

    private BigInteger companyId;
    private RatingAgency ratingAgency;
    private RatingType ratingType;
    private RatingValue ratingValue;

    public Rating(BigInteger companyId, RatingAgency ratingAgency, RatingType ratingType, RatingValue ratingValue) {
        this.companyId = companyId;
        this.ratingAgency = ratingAgency;
        this.ratingType = ratingType;
        this.ratingValue = ratingValue;
    }

    public BigInteger getCompanyId() {
        return companyId;
    }

    public RatingAgency getRatingAgency() {
        return ratingAgency;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public RatingValue getRatingValue() {
        return ratingValue;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "companyId=" + companyId +
                ", ratingAgency=" + ratingAgency +
                ", ratingType=" + ratingType +
                ", ratingValue=" + ratingValue +
                '}';
    }
}
