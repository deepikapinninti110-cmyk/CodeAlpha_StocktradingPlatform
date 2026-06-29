public class Transaction {

    public static void buyStock(Portfolio portfolio, Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;

        if (portfolio.getBalance() >= totalCost) {
            portfolio.deductBalance(totalCost);
            portfolio.addStock(stock.getName(), quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public static void sellStock(Portfolio portfolio, Stock stock, int quantity) {
        if (portfolio.hasStock(stock.getName(), quantity)) {
            double totalGain = stock.getPrice() * quantity;
            portfolio.addBalance(totalGain);
            portfolio.removeStock(stock.getName(), quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("You do not have enough shares!");
        }
    }
}