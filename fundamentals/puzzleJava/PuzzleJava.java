import java.util.Random;

public class PuzzleJava {
    public static Random random = new Random();

    public int[] getTenRolls() {
        int[] res = new int[10];

        for (int i = 0; i < res.length; i++) {
            res[i] = PuzzleJava.random.nextInt(20) + 1;
        }
        return res;
    }
    public char getRandomLetter() {
        char[] alphabet = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        return alphabet[PuzzleJava.random.nextInt(26)];
    }
    public String generatePassword() {
        String res = "";
        for (int i = 1; i <= 8; i++) {
            res += this.getRandomLetter();
        }
        return res;
    }
    public String[] getNewPasswordSet(int length) {
        String[] res = new String[length];
        for (int i = 0; i < length; i++) {
            res[i] = this.generatePassword();
        }
        return res;
    }
    // Fisher-Yates shuffle algorithm
    public int[] shuffleArray(int[] array) {
        // start at i at the last element and swap it with a random element between 0 and i
        // move one element to the left, repeat until i is at the second element
        for (int i = array.length - 1; i > 0; i--) {
            int randomIdx = PuzzleJava.random.nextInt(i + 1);
            int tmp = array[i];
            array[i] = array[randomIdx];
            array[randomIdx] = tmp;
        }
        return array;
    }
}