import java.util.Scanner;

public class findchar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
         'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};

        System.out.print("Masukkan element yang ingin dicari : ");
        char user_input = input.next().charAt(0);

        for(int i=0;i<letters.length;i++) {
            if(user_input == letters[i]) {
                System.out.println("Element ditemukan pada indeks " + i);
            }
        }
        input.close();
    }
}
