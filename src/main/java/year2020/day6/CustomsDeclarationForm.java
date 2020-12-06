package year2020.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomsDeclarationForm {

    public long getCountForAnyoneYes(String rawAnswers) {
        return Arrays.asList(rawAnswers.split("\n\n")).stream()
                .map(groupAnswers -> groupAnswers.replace("\n", "").chars().distinct().count())
                .reduce(0L, Long::sum);
    }

    public long getCountForEveryoneYes(String rawAnswers) {
        List<List<String>> groupsAnswers = getGroupAnswers(rawAnswers);

        List<Map<Integer, Integer>> groupsAnswersCount = getGroupAnswersCount(groupsAnswers);

        return countGroupsAnswersForEveryoneYes(groupsAnswers, groupsAnswersCount);
    }

    private List<List<String>> getGroupAnswers(String rawAnswers) {
        return Arrays.asList(rawAnswers.split("\n\n")).stream()
                .map(groupAnswers -> Arrays.asList(groupAnswers.split("\n")))
                .collect(Collectors.toList());
    }

    private List<Map<Integer, Integer>> getGroupAnswersCount(List<List<String>> groupsAnswers) {
        return groupsAnswers.stream()
                .map(groupAnswers -> {
                    HashMap<Integer, Integer> groupAnswersCount = new HashMap<>();
                    for (String personAnswer : groupAnswers) {
                        personAnswer.chars().forEach(ch ->
                                groupAnswersCount.put(ch, groupAnswersCount.get(ch) == null ? 1 : groupAnswersCount.get(ch) + 1));
                    }
                    return groupAnswersCount;
                }).collect(Collectors.toList());
    }

    private int countGroupsAnswersForEveryoneYes(List<List<String>> groupsAnswers, List<Map<Integer, Integer>> groupsAnswersCount) {
        int countForEveryoneYes = 0;

        for (int i = 0; i < groupsAnswers.size(); i++) {
            int groupSize = groupsAnswers.get(i).size();
            for (Map.Entry<Integer, Integer> entry : groupsAnswersCount.get(i).entrySet()) {
                if(groupSize == entry.getValue()) countForEveryoneYes++;
            }
        }

        return countForEveryoneYes;
    }
}
