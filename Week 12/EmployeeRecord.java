public class EmployeeRecord {
    protected String kompetensi;
    protected String keahlian;
    protected int gaji;
    protected byte usia;
    protected String posisi;
}

class ExtendedEmployee extends EmployeeRecord {
    public void getKompetensi() {
        System.out.println(kompetensi);
    }

    public void getKeahlian() {
        System.out.println(keahlian);
    }

    public void getGaji() {
        System.out.println(gaji);
    }
    public void getUsia() {
        System.out.println(usia);
    }
    public void getPosisi() {
        System.out.println(posisi);
    }
}
