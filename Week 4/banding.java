import java.util.Scanner;

public class banding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Word 1 : ");
        String word1= input.nextLine();
        System.out.print("Word 2 : ");
        String word2=input.nextLine();

        System.out.println(word1 + word2);
        if (word1.equals(word2)) {
            System.out.println("sama");
        } else {
            System.out.println("beda");
        }
        input.close();
    }
}
