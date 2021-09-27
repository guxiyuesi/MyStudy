package test;

public class GetRange {
    public static void main(String[] args) {

        int r = 50, c = 50;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int rand = ((int)(Math.random() * 100)) % 11;
                System.out.print(getR(rand));
            }
            System.out.println();
        }
    }

    public static char getR(int num) {
        switch (num) {
            case 0:
               return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            default:
                return 'K';
        }
    }
}
