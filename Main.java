import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock tcs = new Stock("TCS", 3500);
        Stock infy = new Stock("INFY", 1500);
        Stock reliance = new Stock("RELIANCE", 2800);

        Portfolio portfolio = new Portfolio(10000);

        while (true) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nMarket Stocks:");
                    System.out.println("1. TCS - ₹3500");
                    System.out.println("2. INFY - ₹1500");
                    System.out.println("3. RELIANCE - ₹2800");
                    break;

                case 2:
                    System.out.print("Select stock (1-3): ");
                    int buyChoice = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();

                    if (buyChoice == 1)
                        Transaction.buyStock(portfolio, tcs, buyQty);
                    else if (buyChoice == 2)
                        Transaction.buyStock(portfolio, infy, buyQty);
                    else if (buyChoice == 3)
                        Transaction.buyStock(portfolio, reliance, buyQty);
                    else
                        System.out.println("Invalid stock!");
                    break;

                case 3:
                    System.out.print("Select stock (1-3): ");
                    int sellChoice = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellChoice == 1)
                        Transaction.sellStock(portfolio, tcs, sellQty);
                    else if (sellChoice == 2)
                        Transaction.sellStock(portfolio, infy, sellQty);
                    else if (sellChoice == 3)
                        Transaction.sellStock(portfolio, reliance, sellQty);
                    else
                        System.out.println("Invalid stock!");
                    break;

                case 4:
                    portfolio.displayPortfolio();
                    break;

                case 5:
                    System.out.println("Thank you for trading!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}