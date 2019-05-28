import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DataValidatorTest {

    @Test
    public void testCheckSum() {
        DataValidator validator = new DataValidator();
        assertNotEquals(0, validator.getChecksum("666666666"));
        assertEquals(0, validator.getChecksum("777777777"));
    }
}
