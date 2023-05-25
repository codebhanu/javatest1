import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("RPG LOAN PROVIDERS");
            System.out.println("Loan Type\t\tInterest Rate");
            System.out.println("1. Home Loan\t\t4.2%");
            System.out.println("2. Car Loan\t\t3.9%");
            System.out.println("3. Gold Loan\t\t5.2%");
            System.out.println("4. Study Loan\t\t2.8%");
            System.out.println("5. Business Loan\t5.8%");
            System.out.println("6. Exit\n");

            System.out.print("Enter your family annual income: $");
            double A_income = scanner.nextDouble();

            if (A_income < 80000) {
                System.out.println("Your family income is not sufficient for loan");
                break;
            }

            System.out.println("You are eligible for a loan. you must select at  least two loan types from the menu.");

            String loan_select = "";
            while (loan_select.isEmpty()) {
                System.out.print("Enter loan types  separated by spaces): ");
                scanner.nextLine(); 
                loan_select = scanner.nextLine().trim();
            }
            String[] loan_num = loan_select.split(" ");

            if (loan_num.length < 2) {
                System.out.println("Error: You must select at least two loans from the menu.");
                break;
            }

            int monthly_insta = 0;
            while (monthly_insta < 6 || monthly_insta > 60) {
                System.out.print("Enter the number of monthly installments (6-60 months): ");
                monthly_insta = scanner.nextInt();

                if (monthly_insta < 6 || monthly_insta > 60) {
                    System.out.println("Error: Number of monthly installments must be between 6 and 60.");
                }
            }

            double total_loan_amount = 0;
            for (String numbers : loan_num) {
                double i_Rate = 0;
                String loanType = "";
                switch (numbers) {
                    case "1":
                        i_Rate = 4.2;
                        loanType = "Home Loan";
                        break;
                    case "2":
                        i_Rate = 3.9;
                        loanType = "Car Loan";
                        break;
                    case "3":
                        i_Rate = 5.2;
                        loanType = "Gold Loan";
                        break;
                    case "4":
                        i_Rate = 2.8;
                        loanType = "Study Loan";
                        break;
                    case "5":
                        i_Rate = 5.8;
                        loanType = "Business Loan";
                        break;
                    default:
                        System.out.println("Invalid loan number: " + numbers);
                        break;
                }

                double loan_amount = 0;
                while (loan_amount <= 0) {
                    System.out.print("Enter the amount for " + loanType + ": $");
                    loan_amount = scanner.nextDouble();

                    if (loan_amount <= 0) {
                        System.out.println("Error: Loan amount must be greater than 0.");
                    }
                }

                if (loan_amount > 500000) {
                    i_Rate -= 0.1;
                }

                total_loan_amount += loan_amount * (1 + (i_Rate / 100));
            }

            double Installment_pay = total_loan_amount / monthly_insta;

            System.out.println("\nTotal loan amount to pay: $" + total_loan_amount);
            System.out.println("Payment installment amount per month: $" + Installment_pay);

        }

        scanner.close();
    }
}
