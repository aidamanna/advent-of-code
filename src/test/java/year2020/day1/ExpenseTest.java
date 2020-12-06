package year2020.day1;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {

    @Test
    void returnsMultiplicationOfTwoNumbersThatSum2020() {
        List<Integer> expenses = List.of(1721, 979, 366, 299, 675, 1456);
        Expense expense = new Expense(expenses);

        assertEquals(514579, expense.calculateForTwoNumbers());
    }

    @Test
    void returnsMultiplicationOfThreeNumbersThatSum2020() {
        List<Integer> expenses = List.of(1721, 979, 366, 299, 675, 1456);
        Expense expense = new Expense(expenses);

        assertEquals(241861950, expense.calculateForThreeNumbers());
    }
}
