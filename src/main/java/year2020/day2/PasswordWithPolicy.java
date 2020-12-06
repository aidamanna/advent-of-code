package year2020.day2;

public class PasswordWithPolicy {

    private final int firstPosition;
    private final int secondPosition;
    private final Character character;
    private final String password;

    public PasswordWithPolicy(int firstPosition, int secondPosition, Character character, String password) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.character = character;
        this.password = password;
    }

    public static PasswordWithPolicy from(String rawPasswords) {
        String[] rawPasswordsSplit = rawPasswords.split("[-: ]");

        return new PasswordWithPolicy(
                Integer.valueOf(rawPasswordsSplit[0]),
                Integer.valueOf(rawPasswordsSplit[1]),
                rawPasswordsSplit[2].toCharArray()[0],
                rawPasswordsSplit[4]);
    }

    public boolean isValid() {
        return character.equals(password.charAt(firstPosition - 1)) ^
                character.equals(password.charAt(secondPosition - 1));
    }
}
