import java.util.Arrays;
import com.jakewharton.fliptables.FlipTable;

public class AddressBook {
    private String name;
    private String address;
    private String telp_number;
    private String email;
    private static String[] headers = {"Nomer", "Nama", "Alamat", "Telepon", "Email"};
    public static String[][] data = new String[10][5];

    //Buat ngitung instancenya
    private static int numberInstance = 0;

    public AddressBook() {
        numberInstance++;
    }

    public AddressBook(String name, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telp_number = telephone;
        this.email = email;

        //Just put the data into data arrays
        data[numberInstance][1] = name;
        data[numberInstance][2] = address;
        data[numberInstance][3] = telephone;
        data[numberInstance][4] = email;
        numberInstance++;
        
        for (int i=0;i<data.length;i++) {
            data[i][0] = String.valueOf(i+1);
        }

    }

    public static int getInstanceCount() {
        return numberInstance;
    }

    //Method Read
    public static void showData() {
        System.out.println(FlipTable.of(headers, data));
    }

    //Method Update
    public static void updateData(int baris_data, String name, String address, String telephone, String email) {
        int row = (baris_data - 1);

        data[row][1] = name;
        data[row][2] = address;
        data[row][3] = telephone;
        data[row][4] = email;
    }

    //Method Delete
    public static void deleteData(int baris_data) {
        int row = (baris_data - 1);

        for (int i=row;i<data.length - 1;i++) {
            data[i] = data[i+1];
        }
        
        for (int i=0;i<data.length;i++) {
            data[i][0] = String.valueOf(i+1);

            if (i==(data.length-1)) {
                data[i][0] = String.valueOf(i);
            }
        }
        
        data = Arrays.copyOf(data, data.length-1);
    }

    //Ini method Accessor/getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelp() {
        return telp_number;
    }

    public String getEmail() {
        return email;
    }

    //Ini method Modifier/setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelp(String telp_number) {
        this.telp_number = telp_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}