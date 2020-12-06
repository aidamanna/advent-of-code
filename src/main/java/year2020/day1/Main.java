package year2020.day1;

public class Main {

    public static void main(String[] args) {
        ExpenseReportRepository repository = new ExpenseReportRepository();
        Expense expense = new Expense(repository.getExpenses());

        System.out.println("Expense calculator for two numbers is: " + expense.calculateForTwoNumbers());
        System.out.println("Expense calculator for three numbers is: " + expense.calculateForThreeNumbers());
    }

}
