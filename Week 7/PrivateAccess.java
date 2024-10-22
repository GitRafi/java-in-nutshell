import java.util.Random;
class SomeMethod {
    private int randnumber(int batas){
        Random random = new Random();
        int randomInt = random.nextInt(batas);
        return randomInt;
    }
    //They will never know, that i reusing Random class XD
    public int generateInt(int input) {
        return randnumber(input);
    }
}
public class PrivateAccess {
    public static void main(String[] args) {
       SomeMethod SM = new SomeMethod();
       System.out.println(SM.generateInt(10000));
    }
}

