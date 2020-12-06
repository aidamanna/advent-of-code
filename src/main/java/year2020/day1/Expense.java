package year2020.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expense {

    public static final int SUM = 2020;
    private final List<Integer> expenses;

    public Expense(List<Integer> expenses) {
        this.expenses = new ArrayList<>(expenses);
    }

    public int calculateForTwoNumbers() {
        Collections.sort(expenses);

        int leftIndex = 0;
        int rightIndex = expenses.size() - 1;

        while(1 < rightIndex) {
            if (expenses.get(leftIndex) + expenses.get(rightIndex) == SUM)
                return (expenses.get(leftIndex) * expenses.get(rightIndex));

            if (expenses.get(leftIndex) + expenses.get(rightIndex) < SUM)
                leftIndex++;
            else
                rightIndex--;
        }

        return 0;
    }

    public int calculateForThreeNumbers() {
        Collections.sort(expenses);

        for(int i = 0; i < expenses.size() - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = expenses.size() - 1;

            while(leftIndex < rightIndex) {
                if (expenses.get(i) + expenses.get(leftIndex) + expenses.get(rightIndex) == SUM)
                    return (expenses.get(i) * expenses.get(leftIndex) * expenses.get(rightIndex));

                if (expenses.get(i) + expenses.get(leftIndex) + expenses.get(rightIndex) < SUM)
                    leftIndex++;
                else
                    rightIndex--;
            }
        }


        return 0;
    }
}
