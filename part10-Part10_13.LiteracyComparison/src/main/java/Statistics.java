public class Statistics{

    private String country;
    private String year;
    private String sex;
    private double literacyRate;

    public double getLiteracyRate() {
        return literacyRate;
    }

    public Statistics(String country, String year, String sex, double literacyRate) {
        this.country = country;
        this.year = year;
        this.sex = sex;
        this.literacyRate = literacyRate;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.sex + ", " + this.literacyRate;
    }
}
