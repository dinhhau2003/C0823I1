package CaseStudy.model;

public abstract class Facility {
    private int maDV;
    private String  name;
    private double usableArea;
    private int numberOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(int maDV, String name, double usableArea, int numberOfPeople, String rentalType) {
        this.maDV = maDV;
        this.name = name;
        this.usableArea = usableArea;
        this.numberOfPeople = numberOfPeople;
        this.rentalType = rentalType;
    }


    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "maDV=" + maDV +
                ", name='" + name + '\'' +
                ", usableArea=" + usableArea +
                ", numberOfPeople=" + numberOfPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
