package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int seats = 0;
        String openSeat = "S";

        // getting input for rows & number of seats per row
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        String[][] cinema = createCinema(rows, seats, openSeat);
        theatreMenu(cinema, openSeat, rows, seats);
    }

    private static void theatreMenu(String[][] cinema, String openSeat, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);

        int menuSelect = 0;

        do {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            menuSelect = scanner.nextInt();

            switch (menuSelect) {
                case 1:
                    printSeat(cinema, rows, seats, openSeat);
                    break;
                case 2:
                    /*initializing the updated array to the buy seat method so the array can be updated
                    everytime a seat is bought
                     */
                    String [][] cinemaUpdated = buySeat(cinema, rows, seats, openSeat);
                    break;
                case 3:
                    statistics(cinema, rows,seats);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        } while (menuSelect != 0);
    }

    private static void printSeat(String [][] cinemaUpdated, int rows, int seats, String openSeat) {
        int a = 0;
        int seats1 = seats;
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");

        while(a < seats1){
            // prints out the number of seats
            System.out.print(" " + (a + 1));
            a++;
        }

        System.out.println();

        // array printing our cinema layout with users seat choice
        for (int i = 0; i < cinemaUpdated.length; i++) {
            // prints the rows
            System.out.print(i + 1);
            // prints the seats updated seats
            for (int j = 0; j < cinemaUpdated[i].length; j++) {
                System.out.print(" " + cinemaUpdated[i][j]);
            }

            System.out.println();
        }
        System.out.println();
    }

    private static String[][] buySeat(String [][] cinemaUpdated, int rows, int seats, String openSeat) {
        int rowNum = 0;
        int seatNum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a row number:");
        rowNum = input.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNum = input.nextInt();

        /* prompting the user to re-enter row & seat info if selection is out of the parameters
        or if the seat has already been purchased */
        while (rowNum <= 0 || rowNum > rows || seats <= 0 || seatNum > seats || 
                cinemaUpdated[rowNum - 1][seatNum - 1].contains("B")) {
            if (rowNum <= 0 || rowNum > rows || seats <= 0 || seatNum > seats) {
                System.out.println("Wrong input!");
            } else if (cinemaUpdated[rowNum - 1][seatNum - 1].contains("B")) {
                System.out.println("That ticket has already been purchased!");
            }
            System.out.println();
            System.out.println("Enter a row number:");
            rowNum = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNum = input.nextInt();
        }

        int totalSeats = rows * seats;

        // determining the ticket price for the user after getting the number of seats & rows
        if (totalSeats <= 60) {
            System.out.print("Ticket price: $10");
            System.out.println();
        } else if (totalSeats > 60) {
            if (rows % 2 == 0) {
                if(rowNum <= (rows / 2)){
                    // even number of rows
                    System.out.println("Ticket price: $10");
                }else{
                    System.out.println("Ticket price: $8");
                }
            } else if (rows % 2 != 0) {
                // odd number of rows
                if(rowNum <= (rows / 2)){
                    System.out.println("Ticket price: $10");
                }else{
                    System.out.println("Ticket price: $8");
                }
            }
        }
        System.out.println();
        int a = 0;
        int seats1 = seats;
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");

        while(a < seats1){
            // prints out the number of seats
            System.out.print(" " + (a + 1));
            a++;
        }
        
        System.out.println();

        // array printing our cinema layout with users seat choice
        for (int i = 0; i < cinemaUpdated.length; i++) {
            // prints the rows
            System.out.print(i + 1);
            // prints the seats
            for (int j = 0; j < cinemaUpdated[i].length; j++) {
                if (i == rowNum - 1 && j == seatNum - 1) {
                    cinemaUpdated[i][j] = "B";
                    System.out.print(" " + cinemaUpdated[i][j]);
                } else if (cinemaUpdated[i][j].contains("B")) {
                    cinemaUpdated[i][j] = "B";
                    System.out.print(" " + cinemaUpdated[i][j]);
                } else {
                    cinemaUpdated[i][j] = openSeat;
                    System.out.print(" " + cinemaUpdated[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        return cinemaUpdated;
    }

    // printing the cinema
    private static String[][] createCinema(int rows, int seats, String openSeat){
        // creating the cinema array
        String[][] cinema = new String[rows][seats];
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = openSeat;
            }
        }
        return cinema;
    }

    //method for finding the total price for the tickets
    private static void statistics(String[][] cinema, int rows, int seats){
        int totalSeats = rows * seats;
        int totalPrice = 0;
        int currentIncome = 0;
        int purchased = 0;
        double percentage = 0;

        // calculating the number of tickets sold & the current income of the tickets sold
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j].contains("B")){
                    purchased++;
                    if (totalSeats <= 60) {
                        currentIncome = currentIncome + 10;
                    } else if (totalSeats >= 60) {
                        if (rows % 2 == 0) {
                            if(i <= (rows / 2)){
                                // even number of rows
                                currentIncome = currentIncome + 10;
                            }else {
                                currentIncome = currentIncome + 8;
                            }
                        } else if (rows % 2 != 0) {
                            // odd number of rows
                            if(i <= (rows / 2) - 1){
                                currentIncome = currentIncome + 10;
                            }else {
                                currentIncome = currentIncome + 8;
                            }
                        }
                    }
                }
            }
        }

        // calculates the percentage of seats sold
        percentage = ((double) purchased / totalSeats) * 100;

        // calculates the total price from the total number of seats
        if(totalSeats <= 60){
            totalPrice = totalSeats * 10;
        }else if(totalSeats > 60){
            if(rows % 2 == 0){
                // even number of rows
                totalPrice = (((rows / 2) * seats * 10) + ((rows / 2) * seats * 8));
            } else if(rows % 2 != 0){
                // odd number of rows
                totalPrice = (((rows / 2) * seats * 10) + (((rows / 2) + 1) * seats * 8));
            }
        }

        System.out.println("\nNumber of purchased tickets: " + purchased);
        System.out.printf("Percentage: %.2f%c", percentage, '%');
        System.out.println("\nCurrent income: $" + currentIncome);
        System.out.println("Total income: $" + totalPrice);
    }
}