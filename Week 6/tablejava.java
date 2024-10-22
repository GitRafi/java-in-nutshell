import com.jakewharton.fliptables.FlipTable;

public class tablejava {
    public static void main(String[] args) {

        String[] headers = {"Nama", "NO HP", "Alamat"};
        String[][] data = {{"ABDUL", "085646668991", "Kediri"}, {"KUSNO", "085646668992",
                            "Trenggalek"}, {"PONIRAN", "085646668999", "Bojonegoro"}};

        String table = FlipTable.of(headers, data);
        System.out.println(table);
    }
}
