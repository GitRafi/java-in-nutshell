public class multiply2d {
    public static void main(String[] args) {
        int[][] data = {{4,1,3},
                        {5,2,7}};
        int pengkali = 5;

        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data[i].length;j++) {
                data[i][j] *= pengkali;
            }
        }

        System.out.println("Hasil perkalian : ");
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
