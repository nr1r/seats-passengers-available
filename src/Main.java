import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] seats = {{120, 15, 30},
                {65, 1, 2},
                {4, 52, 7},
                {46, 32, 16},
                {64, 23, 11},
                {61, 12, 91}};
        Scanner scanner = new Scanner(System.in);
        int dest = 0;
        int flight = 0;
        int passengers = 0;
        int totalPass = 0;
        boolean keepGoing = true;

        while (keepGoing) {
            scanner.reset();
            System.out.println("Enter destination: ");
            dest = scanner.nextInt();
            System.out.println("Enter flight: ");
            flight = scanner.nextInt();
            System.out.println("Enter number of passengers: ");
            passengers = scanner.nextInt();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (i == dest && j == flight) {
                        if (passengers > seats[i][j]) {
                            System.out.println("We're sorry, we couldn't complete your booking. There's not enough seats available :(");
                        } else if (passengers <= seats[i][j]) {
                            System.out.println("Your booking was registered with success!");
                            seats[i][j] -= passengers;
                            totalPass += passengers;
                        }
                    }
                }
            }
            scanner.nextLine();  // Consume newline character left in the input buffer!!
            System.out.println("Press ENTER to keep booking and FINISH to end the day: ");
            if (scanner.nextLine().equalsIgnoreCase("finish")) {
                keepGoing = false;
            }
        }
        System.out.println("*******************************************************************");
        System.out.println("Great job! Here's the total of seats sold for the day: " + totalPass);
        scanner.close();
    }
}
