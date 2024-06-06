package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car myCar = new Car("Black", "Manual", 2024);
        myCar.displayCharacteristics();
        myCar.accelerate();
        myCar.brake();
    }

}
