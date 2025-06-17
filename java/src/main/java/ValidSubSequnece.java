public class ValidSubSequnece {
    
    public static void main () {

    }

    public static boolean isValidSubsequence(int[] array, int[] sequence) {

        int aPtr = 0;
        int sPtr = 0;

        while( aPtr < array.length) {
            if( array[aPtr] == sequence[sPtr]) {
                sPtr++;
            }

            aPtr++;
        }

        return sPtr == sequence.length;
    }
}