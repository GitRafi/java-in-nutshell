import javax.swing.JOptionPane;
public class star {
    public static void main(String[] args) {
        String angka = JOptionPane.showInputDialog("Masukkan angka yang diinginkan : ");
        int n = Integer.parseInt(angka);

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*"); 
            }
            String space = " ";
            System.out.print(space.repeat(n-(i-1)));
            for(int a=n;a>=i;a--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
