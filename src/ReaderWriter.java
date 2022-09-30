import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderWriter {

    /**
     * Readers and Writers are the next level of abstraction built on top of input and output streams.
     * These interfaces read and write text characters.
     *
     * Character Encodings
     *
     * A character encoding is a way to convert between binary data
     * and human-readable text characters in a character set.
     *
     * Generally speaking, you should use UTF-8. Most HTML documents use this encoding.
     *
     * It uses at least 8 bits of data to store each character. This can lead to more efficient storage, especially when the text contains mostly English ASCII characters. But higher-order characters,
     * such as non-ASCII characters, may require up to 24 bits each!
     */

    public static void main(String[] args) throws IOException {

        //Just like input streams, Readers are usually created with the Files API.
        // But instead of reading bytes, we are reading chars.

        char[] data = new char[10];
        Reader reader =
                Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);
        while (reader.read(data) != -1){
            //useData(data);
        }
        reader.close();

        //The Writer is pretty much what you would expect.
        // This time we are writing encoded Strings of data instead of raw bytes.
        Writer writer =
                Files.newBufferedWriter(Path.of("test"), StandardCharsets.UTF_8);
        writer.write("hello, world");
        writer.close();
    }

}
