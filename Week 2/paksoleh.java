import java.text.NumberFormat;
import java.util.Locale;

public class paksoleh {
    public static void main(String[] args) {
        int biaya_haji = 50000000;
        int tabungan_rumah = 20000000;
        int biaya_haji_sisa = biaya_haji - (tabungan_rumah/2);
        byte lama_cicilan = 24;
        int cicilan_perbulan = (int) (biaya_haji_sisa / lama_cicilan);

        //Format int to IDR
        @SuppressWarnings("deprecation")
        NumberFormat formatrp = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String cicilan_format = formatrp.format(cicilan_perbulan);

        System.out.println("Jumlah uang yang harus dicicil perbulan : " + cicilan_format);
    }
}
