package tarleton.lab11;

import java.io.IOException;

/**
 *
 * @author Joe Meier
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Formatter f = new Formatter();
        f.format("input.txt", "output.txt"); 
    }
}
