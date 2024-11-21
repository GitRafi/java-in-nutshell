public class ExtendedStudent extends StudentRecord {
   private double computerGrade;

   public double getComputer() {
        return computerGrade;
   }

   @Override
   public void getAverage() {
        System.out.println("Rata-rata nilai: " + ((getMath() + getEnglish() + getScince() + getComputer()) / 3));
   }
   
}
