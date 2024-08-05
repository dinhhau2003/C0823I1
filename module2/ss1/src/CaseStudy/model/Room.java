package CaseStudy.model;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(Number maDV, String name, double usableArea, int numberOfPeople, String rentalType, String freeService) {
        super((Integer) maDV, name, usableArea, numberOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room= " +super.toString()+
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
