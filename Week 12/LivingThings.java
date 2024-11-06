public abstract class LivingThings {
    public void breath() {
        System.out.println("Breathing...");
    }

    public abstract void walk();
    public abstract void swim();
    
    public static void main(String[] args) {
        Human orang = new Human();
        orang.breath();
        orang.walk();
        orang.swim();
    }
}

class Human extends LivingThings {
    public void walk() {
        System.out.println("is walking...");
    }
    public void swim() {
        System.out.println("is swimming...");
    }
}

