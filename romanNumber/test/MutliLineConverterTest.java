import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutliLineConverterTest {
    @Test
    public void should_generate_correct_output_with_given_input() {
        String input = "III\n" +
                "29\n" +
                "38\n" +
                "CCXCI\n" +
                "1999";
        String expectedOutput = "3\n" +
                "XXIX\n" +
                "XXXVIII\n" +
                "291\n" +
                "MCMXCIX";
        String output = new MultiLineConverter().convert(input);
        assertEquals(expectedOutput,output);
    }
}
