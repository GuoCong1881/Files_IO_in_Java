import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedStreams {

    /**
     * Buffered Streams: BufferedReader, BufferedWriter
     *
     * - Buffered streams reduce the number of I/O operations performed by your program.
     * This can significantly shrink the amount of time your program spends doing I/O!
     *
     * - When your code calls BufferedReader.read(), the BufferedReader reads ahead,
     * and fetches more data than you asked for. Whatever it reads is stored in an array, which is also called a buffer.
     * The next time you call read(), if the data you requested is already in the buffer,
     * the BufferedReader will give you that cached data, without having to do another read from disk!
     *
     * - BufferedWriter also uses an in-memory buffer to store writes,
     * and then periodically writes contents of the buffer in batches.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);
        String line;
        while ((line = reader.readLine()) != null){
            //useString(line);
        }
        reader.close();

        BufferedWriter writer =
                Files.newBufferedWriter(Path.of("test3"), StandardCharsets.UTF_8);
        writer.write("Hello, ");
        writer.write("world! ");
        writer.flush();
        writer.close();

    }
}
