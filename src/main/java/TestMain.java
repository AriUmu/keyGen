import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestMain {

    public static final String EMPTY = "";

    public static void main(String[] args) {
        System.out.println("Enter your login! \n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String login = reader.readLine();
            if (login != null && !EMPTY.equals(login)) {
                int generationOfKey = generationOfKey(login);
                System.out.println("Your key is -> " + generationOfKey);
            } else {
                System.err.println("You login is empty, try again");
            }
        } catch (IOException e) {
            System.err.println("You put bad login, try again");
        }
    }


    private static int generationOfKey(String login) {
        int sumOfLogin = Arrays.stream(login.split(EMPTY))
                .map(entry -> {
                    int x = entry.charAt(0);
                    if (x >= 90) {
                        x =  90 - 32;
                    }
                    return x;
                }).reduce(Integer::sum).get();
        return (sumOfLogin ^ 0x5678 ^ 0x1234);
    }
}
