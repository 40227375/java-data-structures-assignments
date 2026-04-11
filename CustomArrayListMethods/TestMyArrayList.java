// Test class to demonstrate the functionality
public class TestMyArrayList {
    public static void main(String[] args) {
        // Run tests
        testGetMax();
        testGetMin();
        testGetUnique();
        testIsPalindrome();
        testGetFiltered();
    }

    // Test for getMax method
    public static void testGetMax() {
        MyArrayList<Team> league = new MyArrayList<>();
        league.add(0, new Team("Real Madrid", 76, 67));
        league.add(1, new Team("Barcelona", 74, 65));
        league.add(2, new Team("Atletico Madrid", 70, 60));

        System.out.println("Testing getMax:");
        System.out.println("League: " + league);
        System.out.println("Team with maximum points: " + league.getMax());
        System.out.println();
    }

    // Test for getMin method
    public static void testGetMin() {
        MyArrayList<Team> league = new MyArrayList<>();
        league.add(0, new Team("Real Madrid", 76, 67));
        league.add(1, new Team("Barcelona", 74, 65));
        league.add(2, new Team("Sevilla", 65, 55));

        System.out.println("Testing getMin:");
        System.out.println("League: " + league);
        System.out.println("Team with minimum points: " + league.getMin());
        System.out.println();
    }

    // Test for getUnique method
    public static void testGetUnique() {
        MyArrayList<Team> league = new MyArrayList<>();
        league.add(0, new Team("Real Madrid", 76, 67));
        league.add(1, new Team("Barcelona", 74, 65));
        league.add(2, new Team("Real Madrid", 76, 67));
        league.add(3, new Team("Atletico Madrid", 70, 60));

        System.out.println("Testing getUnique:");
        System.out.println("League: " + league);
        System.out.println("Unique teams: " + league.getUnique());
        System.out.println();
    }

    // Test for isPalindrome method
    public static void testIsPalindrome() {
        MyArrayList<Team> league = new MyArrayList<>();
        league.add(0, new Team("Real Madrid", 76, 67));
        league.add(1, new Team("Barcelona", 74, 65));
        league.add(2, new Team("Barcelona", 74, 65));
        league.add(3, new Team("Real Madrid", 76, 67));

        System.out.println("Testing isPalindrome:");
        System.out.println("League: " + league);
        System.out.println("Is the league a palindrome? " + league.isPalindrome());
        System.out.println();
    }

    // Test for getFiltered method
    public static void testGetFiltered() {
        MyArrayList<Team> league = new MyArrayList<>();
        league.add(0, new Team("Real Madrid", 76, 67));
        league.add(1, new Team("Barcelona", 74, 65));
        league.add(2, new Team("Atletico Madrid", 70, 60));
        league.add(3, new Team("Sevilla", 65, 55));

        System.out.println("Testing getFiltered (points > 70):");
        System.out.println("League: " + league);
        System.out.println("Teams with more than 70 points: " + league.getFiltered(new Team("", 70, 0)));
        System.out.println();
    }
}
