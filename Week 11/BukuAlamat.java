import com.jakewharton.fliptables.FlipTable;
// import com.jakewharton.fliptables.FlipTableConverters;

import java.util.Arrays;

@SuppressWarnings("unused")
public class BukuAlamat {
    public static void main(String[] args) {
        String[] headers = {"No", "Nama", "Alamat", "Telepon", "Email"};
        AddressBook person1 = new AddressBook("Ali", "Jordania", "+12 21423", "ali@sialim.com" );
        AddressBook person2 = new AddressBook("Bina", "Russia", "+24 123452", "bina12@binana.com" );
        // AddressBook.deleteData(2);
        System.out.println(FlipTable.of(headers, AddressBook.data));
        System.out.println(AddressBook.data.length);
        
    }
}