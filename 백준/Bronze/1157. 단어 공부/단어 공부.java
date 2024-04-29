import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        input = input.toUpperCase();

        if (input.length() == 1) {
            System.out.println(input.charAt(0));
            return;
        }

        HashMap<Character, Integer> alph = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            alph.put(input.charAt(i), alph.getOrDefault(input.charAt(i), 0) + 1);
        }

        List<Character> keySet = new ArrayList<>(alph.keySet());
        if (keySet.size() == 1) {
            System.out.println(keySet.get(0));
            return;
        }
        
        keySet.sort(((o1, o2) -> alph.get(o2).compareTo(alph.get(o1))));
        
        if (alph.get(keySet.get(0)).equals(alph.get(keySet.get(1)))) {
            System.out.println("?");
        } else {
            System.out.println(keySet.get(0));
        }
    }
}