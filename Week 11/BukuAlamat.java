public class BukuAlamat {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //Tambah data
        AddressBook person1 = new AddressBook("Ali", "Jordania", "+12 21423", "ali@sialim.com" );
        AddressBook person2 = new AddressBook("Bina", "Russia", "+24 123452", "bina12@binana.com" );
        AddressBook person3 = new AddressBook("Cici", "Greek", "+92 123452", "cici@ciciku.com" );
        AddressBook person4 = new AddressBook("Doka", "Japan", "+2 123452", "doka22@sekai.com" );
        AddressBook person5 = new AddressBook("Ethan", "US", "+1 123452", "EthanWinters@rere88.com" );
        AddressBook person6 = new AddressBook("Euler", "Germany", "+921 123452", "euler@rule.com" );
        AddressBook person7 = new AddressBook("Felix", "Great Britain", "+2 123452", "Fell00@myuk.com" );
        AddressBook person8 = new AddressBook("Gala", "Indonesia", "+62 123452", "galaku@indoid.com" );
        AddressBook person9 = new AddressBook("Hana", "Kazakstan", "+24 21452", "hana@hanami.com" );
        AddressBook person10 = new AddressBook("Iain", "Mongolia", "+52 92149", "ian@gmail.com" );

        //Update data
        AddressBook.updateData(1, "Abdul", "Sleman", "+62 12324123", "abdulhakim@gmail.com");

        //Delete data
        AddressBook.deleteData(2);

        //Read data
        AddressBook.showData();
    }
}