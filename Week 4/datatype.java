import java.util.Locale;
import java.text.NumberFormat;

public class datatype {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte umur_saatsd = 6;
        byte umur_now = 19;
        short uang_saku = 20000;
        int saldo_bank = 150000;
        long saldo_impian = 9000000000000L;
        char a = 'U';
        char b = 'N';
        char c = 'Y';
        boolean gender_male = true;

        //Char biasanya hanya digunakan untuk menyimpan singel character
        

        String f = "Aku";
        String g = "UNYEAH";

        String r = (String) (f + g);

        String kampus = "" + a + b + c;
        
        
        
        String nama = "Rafi";

        /*float hanya presisi sampai 6 digit dibelakang koma sedangkan
        double hanya presisi sampai 15 digit dibelakang koma */
        double tinggi_badan = 179.141592653589793;
        float berat_badan = 64.92f;
    
        //Operasi Aritmatika
        byte lama_sekolah = (byte) (umur_now - umur_saatsd);
        int uang_total = (int) (saldo_bank + uang_saku);
        double tambah_tinggiberat = (double) (tinggi_badan + berat_badan);
        long asset_impian = (long) (saldo_impian * 10);
        byte jumlah_donut = (byte) (uang_saku / 2500);

        //Konversi berat ke string
        String berat = String.valueOf(berat_badan);

        //StringBuilder sb = new StringBuilder('a').append('b').append('c');
        System.out.println(kampus);

        //Format Currency
        @SuppressWarnings("deprecation")
        NumberFormat formatrp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String uangtotal_format = formatrp.format(uang_total);
        String asset_format = formatrp.format(asset_impian);

        //printing
        System.out.println("Abjad pertama : " + a);
        System.out.println("Namaku adalah : " + nama);
        System.out.print("Aku telah bersekolah selama : ");
        System.out.println(lama_sekolah + " Tahun");
        System.out.print("Jumlah uangku saat ini : ");
        System.out.println(uangtotal_format);
        System.out.print("Jumlah tinggi dan berat badanku : ");
        System.out.println(tambah_tinggiberat);
        System.out.print("Aku ingin mempunyai asses senilai : ");
        System.out.println(asset_format);
        System.out.print("Dengan uang saku Rp20.000, aku bisa membeli donut sebanyak " + jumlah_donut + " buah");
        System.out.println(r);
    }
}