import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidSubSequneceTest {
    @Test
    void testIsValidSubsequence() {

        int[] array = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {1, 6, -1, 10};


        boolean result = ValidSubSequnece.isValidSubsequence( array, sequence );

        assertEquals(true, result);
    }
}
