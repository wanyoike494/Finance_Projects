import java.util.Scanner;

public class Main {
    
    static double calculateNPV(int numYears, double[] cashFlows, double initialInvestment, double discountRate) {
        double[] presentValues = new double[numYears];
        
        // Convert discount rate from percentage to decimal
        discountRate /= 100;
        
        for (int i = 0; i < numYears; i++) {
            presentValues[i] = cashFlows[i] / Math.pow(1 + discountRate, i + 1);
        }
        
        double npv = 0;
        for (double presentValue : presentValues) {
            npv += presentValue;
        }
        npv -= initialInvestment;
        return npv;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter the number of years
        System.out.print("Enter the number of years: ");
        int numYears = scanner.nextInt();
        
        // Prompt user to enter cash flows for each year
        double[] cashFlows = new double[numYears];
        for (int i = 0; i < numYears; i++) {
            System.out.print("Enter cash flow for Year " + (i + 1) + ": ");
            cashFlows[i] = scanner.nextDouble();
        }
        
        // Prompt user to enter initial investment
        System.out.print("Enter initial investment: ");
        double initialInvestment = scanner.nextDouble();
        
        // Prompt user to enter discount rate in percentage
        System.out.print("Enter discount rate (%): ");
        double discountRate = scanner.nextDouble();
        
        // Calculate NPV
        double npv = calculateNPV(numYears, cashFlows, initialInvestment, discountRate);
        
        // Print the result
        System.out.printf("The Net Present Value (NPV) of the project is: %.2f\n", npv);
        
        // Close the scanner
        scanner.close();
    }
}

