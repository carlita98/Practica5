package es.ucm.fdi.util;

import es.ucm.fdi.launcher.Main;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Tests all sample inputs and outputs
 */
public class FullTest {

    private void runTests(String folderName, boolean expectException) throws Exception {
        try {
            Main.test("src/test/resources/" + folderName);
            if (expectException) {
                fail("Did not expect to reach this line");
            }
        } catch (Exception e) {
            if ( ! expectException) {
                throw new Exception("When running tests on " + folderName, e);
            }
        }
    }

    @Test
    public void testBasic() throws Exception {
        runTests("basic", false);
    }
    @Test
    public void testAdvanced() throws Exception {
        runTests("advanced", false);
    }
    @Test
    public void testError() throws Exception {
        runTests("err", true);
    }
}