package _extras.z_exps.infosys;

public class chess_board_2_piece_combinations {
    public static void main(String[] args) {
        System.out.println(combinations(1, 1, 1, 1, 2, 2, 2, 2));
        System.out.println(combinations(1, 1, 1, 1, 1, 1, 2, 2));
        System.out.println(combinations(1, 2, 1, 2, 3, 4, 3, 4));
    }

    public static int combinations(int au, int ad, int al, int ar, int bu, int bd, int bl, int br) {
        int total_combinations = 0;

        for (int a_row = au; a_row <= ad; a_row++) {
            for (int a_col = al; a_col <= ar; a_col++) {
                for (int b_row = bu; b_row <= bd; b_row++) {
                    for (int b_col = bl; b_col <= br; b_col++) {
                        if (a_row == b_row && a_col == b_col) continue;
                        if ((a_row+b_row)%2 != (a_col+b_col)%2) continue;
                        total_combinations++;
                    }
                }
            }
        }
        return total_combinations;
    }
}


