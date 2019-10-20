public class lewis_p2 {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("Interest Rate: 4.0%");
        int i;
        for(i = 0; i < 12; ++i) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println("Month: " + (i+1));
            System.out.print("Saver 1: ");
            saver1.ReturnSavingsBalance();
            System.out.print("Saver 2: ");
            saver2.ReturnSavingsBalance();
            System.out.println("");
        }

        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("Interest Rate: 5.0%");
        for(i = 0; i < 12; ++i) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println("Month: " + (i+1));
            System.out.print("Saver 1: ");
            saver1.ReturnSavingsBalance();
            System.out.print("Saver 2: ");
            saver2.ReturnSavingsBalance();
            System.out.println("");
        }
        return;
    }
}

class SavingsAccount {
    public static double annualInterestRate = 0.0;
    private double savingsBalance;

    public SavingsAccount(double inputAmount) {
        savingsBalance = inputAmount;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * annualInterestRate / 12.0;
        savingsBalance = savingsBalance + monthlyInterest;
    }

    public static void modifyInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public void ReturnSavingsBalance() {
        System.out.printf("%.2f\n", savingsBalance);
    }
}