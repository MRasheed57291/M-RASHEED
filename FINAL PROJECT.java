import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    static class Reservation {
        private String guestName;
        private String guestEmail;
        private String roomType;
        private Date checkInDate;
        private Date checkOutDate;
        private int numberOfGuests;

        public Reservation(String guestName, String guestEmail, String roomType, Date checkInDate, Date checkOutDate, int numberOfGuests) {
            this.guestName = guestName;
            this.guestEmail = guestEmail;
            this.roomType = roomType;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.numberOfGuests = numberOfGuests;
        }

        public String getGuestName() {
            return guestName;
        }

        public void setGuestName(String guestName) {
            this.guestName = guestName;
        }

        public String getGuestEmail() {
            return guestEmail;
        }

        public void setGuestEmail(String guestEmail) {
            this.guestEmail = guestEmail;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public Date getCheckInDate() {
            return checkInDate;
        }

        public void setCheckInDate(Date checkInDate) {
            this.checkInDate = checkInDate;
        }

        public Date getCheckOutDate() {
            return checkOutDate;
        }

        public void setCheckOutDate(Date checkOutDate) {
            this.checkOutDate = checkOutDate;
        }

        public int getNumberOfGuests() {
            return numberOfGuests;
        }

        public void setNumberOfGuests(int numberOfGuests) {
            this.numberOfGuests = numberOfGuests;
        }

        @Override
        public String toString() {
            return "Reservation{" +
                    "guestName='" + guestName + '\'' +
                    ", guestEmail='" + guestEmail + '\'' +
                    ", roomType='" + roomType + '\'' +
                    ", checkInDate=" + checkInDate +
                    ", checkOutDate=" + checkOutDate +
                    ", numberOfGuests=" + numberOfGuests +
                    '}';
        }
    }

    private List<Reservation> reservations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.run();
    }

    public void run() {
        System.out.println("Welcome to the Hotel Reservation System");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Make a new reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void makeReservation() {
        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter guest email: ");
            String guestEmail = scanner.nextLine();

            System.out.print("Enter room type (e.g., Single, Double, Suite): ");
            String roomType = scanner.nextLine();

            System.out.print("Enter check-in date (dd-MM-yyyy): ");
            Date checkInDate = dateFormat.parse(scanner.nextLine());

            System.out.print("Enter check-out date (dd-MM-yyyy): ");
            Date checkOutDate = dateFormat.parse(scanner.nextLine());

            System.out.print("Enter number of guests: ");
            int numberOfGuests = scanner.nextInt();
            scanner.nextLine(); 

            Reservation reservation = new Reservation(guestName, guestEmail, roomType, checkInDate, checkOutDate, numberOfGuests);
            reservations.add(reservation);

            System.out.println("Reservation made successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("\nAll Reservations:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
