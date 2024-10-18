import java.io.*;

public class Test {
    public static void main(String[] args) {
        // This is reading the stream of bytes from the file
        try (FileInputStream fis = new FileInputStream("test.txt")) {

            // This is converting byte stream to char stream
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

