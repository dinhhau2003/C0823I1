package CaseStudy.model;

public class Villa extends Facility {
    private String roomStandard;
    private int numberOfFloors;
    private double poolArea;

    public Villa() {
    }

    public Villa(int maDV, String name, double usableArea, int numberOfPeople, String rentalType, String roomStandard, int numberOfFloors, double poolArea) {
        super(maDV, name, usableArea, numberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
        this.poolArea = poolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa= " +super.toString()+
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", poolArea=" + poolArea +
                '}';
    }
}
