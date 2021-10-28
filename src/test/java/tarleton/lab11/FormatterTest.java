package tarleton.lab11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe Meier
 */
public class FormatterTest {
        
    @Test
    public void testFile1() throws IOException {
        String inFile = "input.txt";
        String outFile = "output.txt";
        Formatter instance = new Formatter();
        instance.format(inFile, outFile);
        Path pc1 = Paths.get(inFile);
        Path pc2 = Paths.get(outFile);
        assertTrue(Files.exists(pc1));
        assertTrue(Files.isReadable(pc1));
        assertTrue(Files.isExecutable(pc1));
        assertTrue(Files.exists(pc2));
        assertTrue(Files.isWritable(pc2));
        assertTrue(Files.isExecutable(pc2));
    }
    
    @Test
    public void testFile2() throws IOException {
        String inFile = "input";
        String outFile = "output";
        Formatter instance = new Formatter();
        instance.format(inFile, outFile);
        Path pc1 = Paths.get(inFile);
        Path pc2 = Paths.get(outFile);
        assertTrue(Files.notExists(pc1));
        assertFalse(Files.isReadable(pc1));
        assertFalse(Files.isExecutable(pc1));
        assertTrue(Files.notExists(pc2));
        assertFalse(Files.isWritable(pc2));
        assertFalse(Files.isExecutable(pc2));
    }
    
    @Test
    public void testFormat1() throws IOException {
        String inFile = "input.txt";
        String outFile = "output.txt";
        Formatter instance = new Formatter();
        instance.format(inFile, outFile);
        Path pc1 = Paths.get(inFile);
        Path pc2 = Paths.get(outFile);        
        assertEquals(59,Files.size(pc1));
        assertEquals(38,Files.size(pc2));
    }
    
    @Test
    public void testFormat2() throws IOException {
        String inFile = "input.txt";
        String outFile = "output.txt";
        Formatter instance = new Formatter();
        instance.format(inFile, outFile);
        Path pc1 = Paths.get(inFile);
        Path pc2 = Paths.get(outFile);
        Charset cs = Charset.forName("UTF-8");
        List<String> inLines = Files.readAllLines(pc1,cs);
        List<String> outLines = Files.readAllLines(pc2,cs);
        for (int i = 0; i < inLines.size(); i++){
            assertEquals(inLines.get(i).trim().replaceAll("\\s+", " "),
                    outLines.get(i));
        }
    }
}
