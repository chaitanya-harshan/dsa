
import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {

        // int[] array =
        // int array[] =
        // int[] array_without_elements = new int[4]
        int[] numbers = {1,2,3};

        int[] bitches = new int[4];
        bitches[0] = 1;
        bitches[1] = 2;
        bitches[2] = 3;
        bitches[3] = 4;

        System.out.println(Arrays.toString(numbers));
         // prints the array id of sort rather then the contents of the array
        System.out.println(bitches);
        System.out.println(Arrays.toString(bitches));

        System.out.println(numbers.length +","+ bitches.length);


        // sorting
        int[] unsorted = {2,4,5,1,3};
        Arrays.sort(unsorted);
        System.out.println("AFter sorting \n"+Arrays.toString(unsorted));


        // Matrix
        int[][] Matrix = new int[2][3];
        Matrix[0][0] = 1;
        int[][] matix2 = {{1,2,3},{4,5,6}};

        System.out.println("Matrix\n"+Arrays.deepToString(matix2));
    }
}
