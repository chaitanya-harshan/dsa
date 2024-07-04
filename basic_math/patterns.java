
public class patterns {

    public static void main(String[] args) {
        // 1
        // 12
        // 123
        // 1234
        // 12345            

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < i + 2; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 1
        // 22
        // 333
        // 4444
        // 55555
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        //      *
        //     ***
        //    *****
        //   *******
        //  *********
        //  *********
        //   *******
        //    *****
        //     ***
        //      *
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            for (int l = 1; l <= i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 5; i > 0; i--) {
            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            for (int l = 1; l < i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 1
        // 01
        // 010
        // 1010
        // 10101

        {
            int num = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(num % 2 == 0 ? "0" : "1");
                    num++;
                }
                System.out.println();
            }
        }


        // 1      1
        // 12    21
        // 123  321
        // 12344321
        for (int i = 0; i < 4; i++) {
            for (int j = 0, num = 1; j < i+1; j++, num++) {
                System.out.print(num);
            }
            for (int k = 3; k > i; k = k-1) {
                System.out.print("  ");
            }
            for (int l = i+1; l >= 1; l--) {
                System.out.print(l);
            }
            System.out.println();
        }


        // A
        // AB
        // ABC
        // ABCD
        // ABCDE
        for (int i = 0; i < 5; i++) {
            for (char ch = 'A'; ch <= 'A'+i; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        // A
        // BB
        // CCC
        // DDDD
        // EEEEE
        for (int i = 0, ch = 'A'; i < 5; i++, ch++) {
            
            for (int j = 0; j < i+1; j++) {
                // char ch = (char)( 'A' + i );
                System.out.print( (char)ch );
            }
            System.out.println();
        }   

        //      A
        //     ABA
        //    ABCBA
        //   ABCDCBA
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > i; j--) {
                System.out.print(" ");
            }
            for (char ch = 'A'; ch <= 'A'+i; ch++) {
                System.out.print(ch);
            }
            for (char ch = (char)('A'+i-1); ch >= 'A'; ch--) {
                System.out.print(ch);
            }
            System.out.println();
        }


        // E
        // DE
        // CDE
        // BCDE
        // ABCDE
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1; j++) {
                int diff = i-j;
                int ch = 'E'-diff;
                System.out.print( (char)ch );
                diff--;
            }
            System.out.println();
        }


        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int k = 4; k >= i; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for (int k = 4; k > i; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for (int k = 4; k > i; k--) {
                System.out.print("  ");
            }
            for (int l = 0; l < i+1; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // for (int i = 4; i > 0; i--) {
        //     for (int j = 0; j < i; j++) {
        //         System.out.print("*");
        //     }
        //     for (int k = 4; k >= i; k--) {
        //         System.out.print("  ");
        //     }
        //     for (int l = 0; l < i; l++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // PRINTED THE BOTTON HALF BY ONLY CHANGING THE 'i' logic 
        // As for a given 'i' the same lines will be printed 
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for (int k = 4; k > i; k--) {
                System.out.print("  ");
            }
            for (int l = 0; l < i+1; l++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ******
        // *    *
        // *    *
        // *    *
        // *    *
        // ******
        hollowBox(6);

        // 5 5 5 5 5 5 5 5 5
        // 5 4 4 4 4 4 4 4 5
        // 5 4 3 3 3 3 3 4 5
        // 5 4 3 2 2 2 3 4 5
        // 5 4 3 2 1 2 3 4 5
        // 5 4 3 2 2 2 3 4 5
        // 5 4 3 3 3 3 3 4 5
        // 5 4 4 4 4 4 4 4 5
        // 5 5 5 5 5 5 5 5 5
        box(5);
        box_betterWay(6);
    }

    static void hollowBox(int n){
        int lines = n-2;
        int spaces = lines;
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        String line = "*"+" ".repeat(spaces)+"*";
        for (int i = 0; i < lines; i++) {
            System.out.println(line);            
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void box(int N){
        int numWidth = 2*N-1-2;

        for (int i = N; i > 0; i--, numWidth = numWidth-2) {
            for (int j = N; j >= i ; j--) {
                System.out.print(j+" ");
            }
            for (int k = 0; k < numWidth; k++) {
                System.out.print(i+" ");
            }
            for (int l = i; l <= N; l++) {
                if (l != 1) System.out.print(l+" "); // to make sure '1' is printed one time only
            }
            System.out.println();
        }
        numWidth = 1;
        for (int i = 2; i <= N; i++, numWidth = numWidth+2) {
            for (int j = N; j >= i ; j--) {
                System.out.print(j+" ");
            }
            for (int k = 0; k < numWidth; k++) {
                System.out.print(i+" ");
            }
            for (int l = i; l <= N; l++) {
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

    static void box_betterWay(int N){
        int height = 2*N-1;
        int width = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top = i;
                int left = j;
                int bottom = 2*N-1-1-i;
                int right = 2*N-1-1-j;
                
                int num = Math.min(Math.min(top, left), Math.min(right, bottom));
                System.out.print(N-num +" ");
            }
            System.out.println();
        }
    }
}
