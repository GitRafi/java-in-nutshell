public class StudentRecord {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private String password;

    //Constructo for counting instance object and set age to 15
    private static int studentCound;

    public StudentRecord() {
        studentCound++;
    }

    public StudentRecord(int age) {
        this.age = age;
    }

    public static int getStudentCount() {
        return studentCound;
    }

    //Accessor or you may call it getter ;)
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getMath() {
        return mathGrade;
    }

    public double getEnglish() {
        return englishGrade;
    }
    
    public double getScince() {
        return scienceGrade;
    }

    public double getAverage() {
        return ((mathGrade + englishGrade + scienceGrade) / 3);
    }

    //Mutator or you may call it setter ;)
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMath(double grade) {
        this.mathGrade = grade;
    }

    public void setEnglish(double grade) {
        this.englishGrade = grade;
    }

    public void setScience(double grade) {
        this.scienceGrade = grade;
    }

    //Private method (who knows right?)
    private void setPassword(String password) {
        this.password = password; 
    }

    private String getPassword() {
        return password;
    }

    //Overloading method (basicly 1 method can use various params)
    public void printInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Alamat: " + address);
        System.out.println("Umur: " + age);
    }

    public void printInfo(double mathGrade, double englishGrade, double scienceGrade) {
        System.out.println("Name: " + name);
        System.out.println("Math Grade: " + mathGrade);
        System.out.println("English grade: " + englishGrade);
        System.out.println("Science grade: " + scienceGrade);
    }

    public static void main(String[] args) {
        StudentRecord alim = new StudentRecord();
        StudentRecord bagas = new StudentRecord();
        StudentRecord delulu = new StudentRecord();

        //Setup the name
        alim.setName("Alim");
        bagas.setName("Bagas");
        delulu.setName("Delulu");

        //Print the name
        System.out.println(alim.getName());
        System.out.println(bagas.getName());
        System.out.println(delulu.getName());
        System.out.println("Jumlah object dari class: " + StudentRecord.getStudentCount() + "\n");

        //test overloading method
        alim.setMath(93.3);
        alim.setEnglish(99);
        alim.setScience(92.3);
        alim.setAddress("Perempatan New York");
        alim.setAge(17);
        alim.printInfo();
        alim.printInfo(alim.getMath(), alim.getEnglish(), alim.getScince());

        /*
         * Can i call the psswd method?
         * Of course because we are in the same class.
         */
        alim.setPassword("Str0ngP@ssw0rd!");
        System.out.println("Alim password: " + alim.getPassword());

    }

}
