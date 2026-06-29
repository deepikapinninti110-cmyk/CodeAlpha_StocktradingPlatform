
import java.util.HashMap;

public class Portfolio {
    private double balance;
    private HashMap<String, Integer> stocks;

    public Portfolio(double balance) {
        this.balance = balance;
        stocks = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addStock(String stockName, int quantity) {
        stocks.put(stockName, stocks.getOrDefault(stockName, 0) + quantity);
    }

    public void removeStock(String stockName, int quantity) {
        if (stocks.containsKey(stockName)) {
            int currentQty = stocks.get(stockName);
            if (currentQty <= quantity) {
                stocks.remove(stockName);
            } else {
                stocks.put(stockName, currentQty - quantity);
            }
        }
    }

    public boolean hasStock(String stockName, int quantity) {
        return stocks.containsKey(stockName) && stocks.get(stockName) >= quantity;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void displayPortfolio() {
        System.out.println("\n--- Portfolio ---");
        if (stocks.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {
            for (String stock : stocks.keySet()) {
                System.out.println(stock + " : " + stocks.get(stock) + " shares");
            }
        }
        System.out.println("Balance: ₹" + balance);
    }
}