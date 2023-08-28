import Model.Airlines;
import Model.Airports;
import Model.Manages;

import java.util.Scanner;
import java.util.Calendar;


public class Main {
    public static void main(String[] args) {

        int currentAirlineCount = 0;
        int currentAirportCount = 0;
        int currentManagementCount = 0;

        Scanner scanner = new Scanner(System.in);

        Airlines[] airline_array;
        airline_array = new Airlines[100];

        Airports[] airport_array;
        airport_array = new Airports[20];

        Manages[] manages_array;
        manages_array = new Manages[200];

        int choice;

        do {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Add a new Airline");
            System.out.println("2. Display a Airline");
            System.out.println("3. Add a new Airport");
            System.out.println("4. Display a Airport");
            System.out.println("5. Add an Management");
            System.out.println("6. Display all Managements");
            System.out.println("7. Check whether flight can land or find required runway length");
            System.out.println("8. Generate promo code for Airline");
            System.out.println("9. Check if promo code is valid");
            System.out.println("10.  Exit");
            System.out.println("------------------------------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("------------------------------------------------------------------");
            switch (choice) {
                case 1:
                    if (currentAirlineCount < airline_array.length) {
                        System.out.print("Enter Airline Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Email Id: ");
                        String email = scanner.next();

                        System.out.print("Enter Country of origin: ");
                        String country_of_origin = scanner.next();

                        System.out.print("Enter Total destinations served: ");
                        int destinations = scanner.nextInt();

                        System.out.print(
                                "Do you wish to give your airline a unique code (Type N for No or Type Y for yes): ");
                        String seq_ran = scanner.next();

                        int airline_id = currentAirlineCount + 1;

                        if (seq_ran.equals("N")) {
                            System.out.println("No chosen");
                            airline_array[currentAirlineCount] = new Airlines(airline_id, name, email,
                                    country_of_origin, destinations);
                        } else if (seq_ran.equals("Y")) {
                            System.out.println("Yes Chosen");
                            System.out.println("Enter the code you want to give to your airline");
                            String code = scanner.next();
                            airline_array[currentAirlineCount] = new Airlines(airline_id, name, email,
                                    country_of_origin, destinations, code);
                        }
                        currentAirlineCount++;
                        System.out.println("------------------------------------------------------------------");

                        System.out.println("Airline created Sucessfully");
                    } else {
                        System.out.println("Array is full. Cannot create more Students.");
                    }
                    break;
                case 2:

                    System.out.print("Enter Id of the Airline to Display: ");
                    int airline_id_to_display = scanner.nextInt();
                    System.out.println("------------------------------------------------------------------");

                    System.out.println("Airline Id : " + airline_array[airline_id_to_display - 1].getAirlineId());
                    System.out.println("Name : " + airline_array[airline_id_to_display - 1].getName());
                    System.out.println("Email : " + airline_array[airline_id_to_display - 1].getEmail());
                    System.out.println(
                            "Country of origin : " + airline_array[airline_id_to_display - 1].getCountry_of_origin());
                    System.out.println(
                            "Total Destinatios : " + airline_array[airline_id_to_display - 1].getDestinations());
                    System.out.println("Code: " + airline_array[airline_id_to_display - 1].getAirlinecode());

                    break;
                case 3:
                    if (currentAirportCount < airport_array.length) {
                        System.out.print("Enter Airport city: ");
                        String city_name = scanner.nextLine();

                        System.out.print("Enter IATA code of airport: ");
                        String airport_code = scanner.nextLine();

                        System.out.print("Enter Country: ");
                        String airport_country = scanner.nextLine();

                        System.out.print("Enter total passengers(in millions): ");
                        int total_passengers = scanner.nextInt();

                        System.out.print("Enter runway length (in KM) ");
                        Double runway_length = scanner.nextDouble();

                        System.out.print("Enter total number of runways: ");
                        int total_runways = scanner.nextInt();

                        System.out.print("Enter total area of the airport: ");
                        double airport_area = scanner.nextInt();

                        // Create the object dynamically
                        airport_array[currentAirportCount] = new Airports();
                        currentAirportCount++;

                        airport_array[currentAirportCount - 1].setAirportId(currentAirportCount);
                        airport_array[currentAirportCount - 1].setCityName(city_name);
                        airport_array[currentAirportCount - 1].setCode(airport_code);
                        airport_array[currentAirportCount - 1].setCountry(airport_country);
                        airport_array[currentAirportCount - 1].setPassengers(total_passengers);
                        airport_array[currentAirportCount - 1].setRunwayLength(runway_length);
                        airport_array[currentAirportCount - 1].setRunwayCount(total_runways);
                        airport_array[currentAirportCount - 1].setAirport_area(airport_area);

                        System.out.println("------------------------------------------------------------------");
                        System.out.println("Airport created sucessfully.");

                    } else {
                        System.out.println("Array is full. Cannot create more Airports.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Id of the Airport to Display: ");
                    int airport_id_to_display = scanner.nextInt();
                    System.out.println("------------------------------------------------------------------");

                    System.out.println("Airport Id : " + airport_array[airport_id_to_display - 1].getAirportId());
                    System.out.println("City of airport : " + airport_array[airport_id_to_display - 1].getCityName());
                    System.out.println("IATA code : " + airport_array[airport_id_to_display - 1].getCode());
                    System.out.println("Country of airport : " + airport_array[airport_id_to_display - 1].getCountry());
                    System.out.println("Total passengers (in millions) : "
                            + airport_array[airport_id_to_display - 1].getPassengers());
                    System.out.println(
                            "Total Runway length : " + airport_array[airport_id_to_display - 1].getRunwayLength());
                    System.out.println(
                            "Total number of runways : " + airport_array[airport_id_to_display - 1].getRunwayCount());
                    System.out.println(
                            "Total area of airport : " + airport_array[airport_id_to_display - 1].getAirportArea());
                    System.out.println("Passenger density of airport :"+
                            airport_array[airport_id_to_display - 1].calculatePassengerDensity(airport_array[airport_id_to_display - 1].getPassengers(),airport_array[airport_id_to_display - 1].getAirportArea())
                    +" passengers per sq.KM");
                    break;
                case 5:
                    if (currentManagementCount < manages_array.length) {

                        System.out.print("Enter Id of the Airline to be Managed: ");
                        int selected_airline_id = scanner.nextInt();

                        System.out.print("Enter Id of the Airport to be Managed on: ");
                        int selected_airport_id = scanner.nextInt();

                        System.out.println("Enter arrival time of flight(in format hh:mm )");
                        String time = scanner.next();
                        System.out.println("------------------------------------------------------------------");

                        manages_array[currentManagementCount] = new Manages();
                        currentManagementCount++;

                        manages_array[currentManagementCount - 1].airport_managed_airline(
                                airline_array[selected_airline_id - 1], airport_array[selected_airport_id - 1], time);

                        System.out.println("Management created and added to the array.");

                    } else {
                        System.out.println("Array is full. Cannot create more Managements.");
                    }
                    break;
                case 6:

                    for (int i = 0; i <= currentManagementCount - 1; i++) {
                        manages_array[i].display_flight();
                        System.out.println("------------------------------------------------------------------");
                    }
                    break;
                case 7:

                    System.out.println("Do you know weight of airplane(Y or N)");
                    String temp = scanner.next();
                    if (temp.equals("Y")) {
                        System.out.println("enter the weight of airplane(in tonnes)");
                        double tempWeight = scanner.nextDouble();
                        System.out.print("Enter Id of the Airport to check for: ");
                        int tempAirportId = scanner.nextInt();
                        airport_array[tempAirportId - 1].canLand(airport_array[tempAirportId - 1].getRunwayLength(),
                                tempWeight);

                    } else if (temp.equals("N")) {
                        System.out.print("Enter Id of the Airport to check for: ");
                        int tempAirportId = scanner.nextInt();
                        airport_array[tempAirportId - 1].canLand(airport_array[tempAirportId - 1].getRunwayLength());

                    } else {
                        System.out.println("Invalid choice");
                    }

                    break;

                case 8:
                    int i=0;
                    String promoCode = airline_array[i].generatePromoCode();
                    System.out.println("Promotional Code: " + promoCode);
                    i++;
                    break;

                case 9:
                    int j=0;
                    System.out.print("Enter the promo code to validate: ");
                    String PromoCode = scanner.nextLine();

                    boolean isValid = airline_array[j].isPromoCodeValid(PromoCode);

                    if (isValid) {
                        System.out.println("Promo code is valid! Congrats");
                    } else {
                        System.out.println("Promo code is not valid. Sorry");
                    }
                    j++;
                    break;


                case 10:
                    System.out.println("Thank You!!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 8);

        scanner.close();
    }
}
