public class String2D {
    public static void main(String[] args) {
        String[][] alamat = {{ "Florance", "735-1234", "Manila" },
                             {"Joyce", "983-3333", "Quezon City"},
                             {"Becca", "456-3322", "Manila"}};

        for(int i=0;i<3;i++){
        System.out.println("Name    : " + alamat[i][0]);
        System.out.println("Telp. # : " + alamat[i][1]);
        System.out.println("Address : " + alamat[i][2]);
        System.out.println();
        }
    }
}
