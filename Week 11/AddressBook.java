import java.util.Arrays;

public class AddressBook {
    private String name;
    private String address;
    private String telp_number;
    private String email;
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

    //Method Delete
    public static void deleteData(int baris_data) {
        int row = (baris_data - 1);

        for (int i=row;i<data.length - 1;i++) {
            data[i] = data[i+1];
        }
        
        for (int i=0;i<data.length;i++) {
            data[i][0] = String.valueOf(i+1);
        }
        Arrays.copyOf(data, data.length-1);
        // data[data.length - 1] = null;
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

    // public void setdata(String name) {
    //     this.data[numberInstance] = name;
    // }

    // public void setAddress(String address) {
    //     this.addresses[numberInstance] = address;
    // }
    
}