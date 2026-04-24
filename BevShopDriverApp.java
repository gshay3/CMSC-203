import java.util.Scanner;

public class BevShopDriverApp {

    int age, orderNumber;

    Customer customer;
    int minTime = 8 , maxTime = 24;


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        BevShop shop = new BevShop();

        // Customer Info.
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        input.nextLine(); // consume newline

        // Day Selection.
        System.out.println("Enter day of week (MONDAY - SUNDAY): ");
        Day day = Day.valueOf(input.nextLine().toUpperCase());

        // Create first order
        shop.startNewOrder(12, day, name, age);

        System.out.println("\nWelcome " + name + "!");

        boolean ordering = true;

        while (ordering)
        {
            // Displays the menu options.
            System.out.println("\n--- MENU ---");
            System.out.println("1. Coffee");
            System.out.println("2. Alcohol");
            System.out.println("3. Smoothie");
            System.out.println("4. Finish Order");
            System.out.print("Select drink type: ");

            int choice = input.nextInt();
            
            // Input validation.
            while(choice < 1 || choice > 4)
            {
            	System.out.println("Please enter a valid menu option.");
            	choice = input.nextInt();
            }
            
            // Exits menu if 4 is entered.
            if (choice == 4)
            {
                ordering = false;
                break;
            }

            input.nextLine(); // clear buffer

            //Prompts user for beverage name and size
            System.out.print("Enter beverage name: ");
            String bevName = input.nextLine();

            System.out.println("Choose size (SMALL, MEDIUM, LARGE): ");
            Size size = Size.valueOf(input.nextLine().toUpperCase());

            // Prompts user whether to add an extra shot and/or syrup.
            // Adds a coffee beverage to the order.
            if (choice == 1)
            {
                System.out.print("Add extra shot? (true/false): ");
                boolean shot = input.nextBoolean();

                System.out.print("Add extra syrup? (true/false): ");
                boolean syrup = input.nextBoolean();

                shop.processCoffeeOrder(bevName, size, shot, syrup);
            }

            // Checks whether customer is of age and if they are adds a alcohol beverage to the order.
            else if (choice == 2)
            {
                if (!shop.isValidAge(age))
                {
                    System.out.println("Sorry, you are not old enough to order alcohol.");
                    continue;
                }

                if (shop.isEligibleForMore())
                {
                    System.out.println("You have reached the maximum alcohol limit for this order.");
                    continue;
                }

                shop.processAlcoholOrder(bevName, size);
            }

            // Prompts user for how many fruits in smoothie and whether to add protein.
            // Adds a smoothie beverage to the order.
            else if (choice == 3)
            {
                System.out.print("Enter number of fruits: ");
                int fruits = input.nextInt();

                if (shop.isMaxFruit(fruits))
                {
                    System.out.println("Maximum fruit limit exceeded!");
                    continue;
                }

                System.out.print("Add protein? (true/false): ");
                boolean protein = input.nextBoolean();

                shop.processSmoothieOrder(bevName, size, fruits, protein);
            }

            System.out.println("Current order total: $" + shop.getCurrentOrder().calcOrderTotal());
        }

        // ----------- Final Summary -----------
        System.out.println("\nORDER COMPLETE");
        System.out.print(shop.getCurrentOrder().toString());
        System.out.print("Total price: $" + shop.getCurrentOrder().calcOrderTotal());
    }
}