// import java.util.Scanner;
// import java.util.Random;

// public class RockPaperScissors {

//     static String playRound(String playerMove, String computerMove) {
//         if (playerMove.equals(computerMove)) {
//             return "Draw";
//         }

//         if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
//             (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
//             (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
//             return "Player Wins";
//         }

//         return "Computer Wins";
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Random r = new Random();

//         String[] moves = {"Rock", "Paper", "Scissors"};

//         int wins = 0;
//         int losses = 0;
//         int draws = 0;

//         for (int i = 1; i <= 5; i++) {
//             System.out.print("Enter Rock, Paper or Scissors: ");
//             String playerMove = sc.nextLine();

//             int n = r.nextInt(3);
//             String computerMove = moves[n];

//             String result = playRound(playerMove, computerMove);

//             System.out.println("Round " + i);
//             System.out.println("Player: " + playerMove);
//             System.out.println("Computer: " + computerMove);
//             System.out.println("Result: " + result);

//             if (result.equals("Player Wins")) {
//                 wins++;
//             } else if (result.equals("Computer Wins")) {
//                 losses++;
//             } else {
//                 draws++;
//             }
//         }

//         double winPercentage = (wins / 5.0) * 100;

//         System.out.println("\nFinal Summary");
//         System.out.println("Wins: " + wins);
//         System.out.println("Losses: " + losses);
//         System.out.println("Draws: " + draws);
//         System.out.println("Win Percentage: " + winPercentage + "%");
//     }
// }

// import java.util.Scanner;

// public class PalindromeChecker {

//     static boolean isPalindromeIterative(String text) {
//         int start = 0;
//         int end = text.length() - 1;

//         while (start < end) {
//             if (text.charAt(start) != text.charAt(end)) {
//                 return false;
//             }

//             start++;
//             end--;
//         }

//         return true;
//     }

//     static boolean isPalindromeRecursive(String text) {
//         if (text.length() <= 1) {
//             return true;
//         }

//         if (text.charAt(0) != text.charAt(text.length() - 1)) {
//             return false;
//         }

//         return isPalindromeRecursive(text.substring(1, text.length() - 1));
//     }

//     static boolean isPalindromeArrayReversal(String text) {
//         char[] arr = text.toCharArray();

//         int start = 0;
//         int end = arr.length - 1;

//         while (start < end) {
//             char temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;

//             start++;
//             end--;
//         }

//         String reverse = new String(arr);

//         return text.equals(reverse);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter text: ");
//         String text = sc.nextLine();

//         boolean a = isPalindromeIterative(text);
//         boolean b = isPalindromeRecursive(text);
//         boolean c = isPalindromeArrayReversal(text);

//         System.out.println("Iterative: " + (a ? "Palindrome" : "Not Palindrome"));
//         System.out.println("Recursive: " + (b ? "Palindrome" : "Not Palindrome"));
//         System.out.println("Array Reversal: " + (c ? "Palindrome" : "Not Palindrome"));
//     }
// }

// public class BMICalculator {

//     static String getBmiStatus(double bmi) {
//         if (bmi < 18.5) {
//             return "Underweight";
//         } else if (bmi < 25) {
//             return "Normal";
//         } else if (bmi < 30) {
//             return "Overweight";
//         } else {
//             return "Obese";
//         }
//     }

//     static void printWellnessReport(double[] heights, double[] weights) {
//         System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

//         for (int i = 0; i < heights.length; i++) {
//             double bmi = weights[i] / (heights[i] * heights[i]);

//             System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
//                     i + 1,
//                     heights[i],
//                     weights[i],
//                     bmi,
//                     getBmiStatus(bmi));
//         }
//     }

//     public static void main(String[] args) {

//         double[] heights = {1.75, 1.60, 1.68, 1.72};
//         double[] weights = {70, 90, 65, 80};

//         printWellnessReport(heights, weights);
//     }
// }



// import java.util.Scanner;

// public class FirstNonRepeating {

//     static char findFirstNonRepeatingChar(String text) {

//         for (int i = 0; i < text.length(); i++) {

//             int count = 0;

//             for (int j = 0; j < text.length(); j++) {

//                 if (text.charAt(i) == text.charAt(j)) {
//                     count++;
//                 }
//             }

//             if (count == 1) {
//                 return text.charAt(i);
//             }
//         }

//         return '\0';
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter text: ");
//         String text = sc.nextLine();

//         char result = findFirstNonRepeatingChar(text);

//         if (result == '\0') {
//             System.out.println("No Non-Repeating Character Found");
//         } else {
//             System.out.println("First Non-Repeating Character: '" + result + "'");
//         }
//     }
// }

// import java.util.Scanner;

// public class ReverseCustomerName {

//     static String reverseCustomerName(String customerName) {

//         String reverse = "";

//         for (int i = customerName.length() - 1; i >= 0; i--) {
//             reverse = reverse + customerName.charAt(i);
//         }

//         return reverse;
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter customer name: ");
//         String customerName = sc.nextLine();

//         String reverse = reverseCustomerName(customerName);

//         System.out.println("Original Name: " + customerName);
//         System.out.println("Reversed Name: " + reverse);
//     }
// }
// 


// import java.util.Scanner;

// public class TrafficStreakAnalyzer {

//     static void findLongestStreak(String signalLog) {

//         if (signalLog.length() == 0) {
//             System.out.println("No Signal Data");
//             return;
//         }

//         char longestColor = signalLog.charAt(0);
//         int longest = 1;

//         char currentColor = signalLog.charAt(0);
//         int current = 1;

//         for (int i = 1; i < signalLog.length(); i++) {

//             if (signalLog.charAt(i) == currentColor) {
//                 current++;
//             } else {
//                 currentColor = signalLog.charAt(i);
//                 current = 1;
//             }

//             if (current > longest) {
//                 longest = current;
//                 longestColor = currentColor;
//             }
//         }

//         System.out.println("Longest Streak: '" + longestColor +
//                 "' repeated " + longest + " times");
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter signal log: ");
//         String signalLog = sc.nextLine();

//         findLongestStreak(signalLog);
//     }
// }



// import java.util.Scanner;

// public class WarehouseInventory {

//     static void analyzeInventory(int[] sectionA, int[] sectionB) {

//         int totalA = 0;
//         int totalB = 0;

//         for (int i = 0; i < sectionA.length; i++) {
//             totalA = totalA + sectionA[i];
//             totalB = totalB + sectionB[i];
//         }

//         String status;

//         if (totalA == totalB) {
//             status = "Balanced";
//         } else {
//             status = "Not Balanced";
//         }

//         int highest = sectionA[0];
//         String section = "Section A";
//         int index = 0;

//         for (int i = 0; i < sectionA.length; i++) {

//             if (sectionA[i] > highest) {
//                 highest = sectionA[i];
//                 section = "Section A";
//                 index = i;
//             }

//             if (sectionB[i] > highest) {
//                 highest = sectionB[i];
//                 section = "Section B";
//                 index = i;
//             }
//         }

//         System.out.println("Section A Total: " + totalA);
//         System.out.println("Section B Total: " + totalB);
//         System.out.println("Status: " + status);
//         System.out.println("Highest Quantity: " + highest);
//         System.out.println(section + ", Item " + (index + 1));
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of items: ");
//         int n = sc.nextInt();

//         int[] sectionA = new int[n];
//         int[] sectionB = new int[n];

//         System.out.println("Enter Section A quantities:");

//         for (int i = 0; i < n; i++) {
//             sectionA[i] = sc.nextInt();
//         }

//         System.out.println("Enter Section B quantities:");

//         for (int i = 0; i < n; i++) {
//             sectionB[i] = sc.nextInt();
//         }

//         analyzeInventory(sectionA, sectionB);
//     }
// }

