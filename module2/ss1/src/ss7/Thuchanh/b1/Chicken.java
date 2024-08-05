package ss7.Thuchanh.b1;

public class Chicken extends Animal implements Edible{
    public String makeSound(){
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
