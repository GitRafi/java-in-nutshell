public class twodarray2 {
    public static void main(String[] args) {
        int baris, kolom;
        int[][] bil = {
            {234, 253, 35, 327, 106, 329, 603, 428, 45, 250},
            {652, 195, 193, 506, 283, 394, 195, 284, 692, 392},
            {936, 23, 457, 235, 406, 936, 956, 954, 296, 304},
            {294, 206, 364, 596 ,694, 673, 832, 624, 247, 183},
            {814, 425, 620, 834, 173, 864, 836, 924, 468, 193},
            {723, 849, 184, 537, 905, 635, 748, 263, 319, 483},
            {671, 208, 437, 543, 176, 592, 832, 365, 798, 261},
            {192, 604, 823, 389, 571, 740, 614, 236, 469, 785},
            {527, 834, 293, 406, 908, 675, 728, 382, 592, 103},
            {412, 978, 523, 806, 183, 742, 635, 451, 289, 390}
        };

        for (baris = 0; baris < 10; baris++){
            for(kolom = 0; kolom < 10; kolom++) {
                System.out.println("Element indeks ke [" + baris + "," + kolom + "]" + " " + bil[baris][kolom]);
            }
        }
    }
}
