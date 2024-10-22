import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class inputarray {
    public static void main(String[] args) {
        int n=10;
        int[] array = new int[n]; 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 

        //Take input from JOption
        for(int i=0;i<5;i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan angka ke-" + (i+1)));
            if (i == 4) {
                JOptionPane.showMessageDialog(null, "Masukkan angka selanjutnya di Terminal!");
            }
        }
        //Take input from Buffered reader
        System.out.println("Masukkan 5 angka selanjutnya :");
        for(int i=5;i<10;i++) {
            try {
                array[i] = Integer.parseInt(input.readLine());
            } catch (IOException e) {
                System.out.println("Invalid Number");
            }
        }

        Arrays.sort(array);
        System.out.println("Angka terbesar yang diinputkan : " + array[array.length - 1]);

    }
}
