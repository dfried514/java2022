public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        // int[] tenRolls = puzzle.getTenRolls();
        // for (int r : tenRolls) {
        //     System.out.print(r + ", ");
        // }
        // char character = puzzle.getRandomLetter();
        // System.out.println("Random character: " + character);
        // String password = puzzle.generatePassword();
        // System.out.println("password: " + password);
        // String[] passwordSet = puzzle.getNewPasswordSet(6);
        // for (String p : passwordSet) {
        //     System.out.print(p + ", ");
        // }
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
        int[] shuffleArray = puzzle.shuffleArray(array);
        for (int i : shuffleArray) {
            System.out.print(i + ", ");
        }
    }
}