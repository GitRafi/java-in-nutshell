public class EntryBukuAlamat {
    public static void main(String[] args) {
        AddressBook book1 = new AddressBook();
        book1.setName("Sia");
        book1.setAddress("Perempatan Brooklyn");
        book1.setTelp("+1 242 213");
        book1.setEmail("sia@sia-sia.com");
        
        AddressBook book2 = new AddressBook();
        book2.setName("Iferg");
        book2.setAddress("Deket indomaret Queens");
        book2.setTelp("+1 242 950");
        book2.setEmail("iferg69@well.com");

        AddressBook.getInstanceCount();
    }
}

class AddressBook {
    private String name;
    private String address;
    private String telp_number;
    private String email;

    //Buat ngitung instancenya
    private static int numberInstance = 0;

    public AddressBook() {
        numberInstance++;
    }

    public static int getInstanceCount() {
        return numberInstance;
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