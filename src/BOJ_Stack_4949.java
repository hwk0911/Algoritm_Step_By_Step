import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_Stack_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = "";

        while (!(words += br.readLine()).equals(".")) {
            if (words.charAt(words.length() - 1) == '.') {
                words = changeWord(words);
                System.out.println(checkBalance(words));

                words = "";
            }
        }
    }

    public static String changeWord(String words) {
        String subWords = "";

        for (int index = 0, size = words.length(); index < size; ++index) {
            switch (words.charAt(index)) {
                case '(':
                case ')':
                case '[':
                case ']':
                    subWords += words.charAt(index);
            }
        }

        return subWords;
    }

    public static String checkBalance(String words) {
        ArrayList<Character> check = new ArrayList<>();

        for (int index = 0, size = words.length(); index < size; ++index) {
            if(words.charAt(index) == ')'){
                if(check.isEmpty() || check.get(check.size() - 1) != '('){
                    return "no";
                }
                else{
                    check.remove(check.size() - 1);
                }
            }
            else if(words.charAt(index) == ']'){
                if(check.isEmpty() || check.get(check.size() - 1) != '['){
                    return "no";
                }
                else{
                    check.remove(check.size() - 1);
                }
            }
            else{
                check.add(words.charAt(index));
            }
        }

        if(check.isEmpty()){
            words = "yes";
        }
        else{
            words = "no";
        }

        return words;
    }
}
