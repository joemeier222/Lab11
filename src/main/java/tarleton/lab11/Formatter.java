package tarleton.lab11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Joe Meier
 */
public class Formatter {
    public void format(String inFile, String outFile) throws IOException {
        try {Path pc = Paths.get(inFile);
            Charset cs = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(pc,cs);       
            try(PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                    new FileOutputStream(outFile),"UTF-8"))) {
                        for (String line : lines){
                            line = line.trim().replaceAll("\\s+", " ");
                            out.println(line);
                    }
            }
        }catch (IOException e) {
            e.getStackTrace();
        }
    }
}
