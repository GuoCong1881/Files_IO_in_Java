import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLeak {

    /**
     * Why should we prevent resource leaks?
     *
     * - Leaving files open wastes memory and other system resources.
     * - Most operating systems limit the number of files that can be open at one time, so,
     *  when you leave a file open after you're done using it, you're potentially depriving programs of the ability to open other files in the future.
     * - If you are using a buffered writer and forget to close it, the buffered writes
     * might never actually be written to disk.
     */
    public static void main(String[] args){

        /**
         * try - catch - finally Example
          */

        /**
         * The code in the finally block is guaranteed to execute after the code in the try block,
         * even if the try block returns a value or throws an exception.
         * This code also has a catch block, but that is optional.
         */

        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Path.of("test"));
            writer.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * try - with - resources Example
         */

        /**
         * Java 7 introduced the try-with-resources syntax. This new syntax allows you
         * to initialize your resources in parenthesis right before the start of the try
         * block. Resources initialized in this way are guaranteed to be closed after the try block finishes executing.
         */
        try (Writer writer2 = Files.newBufferedWriter(Path.of("test2"))){
            writer2.write("Hello, world!");
        } catch (IOException e){
            e.printStackTrace();
        }

        /**
         * initialize multiple resources in the same try statement
         *
         *
         *
         */
        try (InputStream in = Files.newInputStream(Path.of("test"));
             OutputStream out = Files.newOutputStream(Path.of("test6"))){
            out.write(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Closeable and Autocloseable
         *
         * - Only Closeable or AutoCloseable objects can be used in the try statement.
         * - Most of the I/O classes we've talked about, including Stream, Reader, Writer, InputStream, and OuptutStream,
         * already implement the Closeable interface, whose close() method can throw an IOException.
         * - AutoCloseable.close() does not throw IOException.
         * - Closeable and AutoCloseable are just regular Java interfaces, which means you can write your own
         * implmentations and then use them in a try-with-resources block!
         *
         */
    }

}
