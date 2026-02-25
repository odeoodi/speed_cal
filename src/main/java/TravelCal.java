import java.util.Scanner;

public class TravelCal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Distance: ");
        double distance = input.nextDouble();
        System.out.println("Time: ");
        double time = input.nextDouble();
        System.out.println("Distance: " + distance);
        System.out.println("Time: " + time);
        System.out.println("Your speed: " + calSpeed(distance, time));
    }

    public static double calSpeed(double distance, double time) {
        return distance / time;
    }
}
