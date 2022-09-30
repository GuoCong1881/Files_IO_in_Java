import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InputOutputStream {


    public static void main(String[] args) throws IOException {
        /**
         * Files API: to work with files
         *
         *
         *
         * Path API: a Path is Java's way to refer to a file on a file system
         *
         * All paths either refer to files or directories.
         *
         * - A file contains stored data or bytes.
         * - A directory contains zero or more files.
         *
         * All paths are either absolute or relative.
         *
         * Absolute paths start with a forward-slash (/) (known as the root directory on Mac and Linux),
         * or a drive name on Windows.
         * Relative paths are only meaningful relative to some other starting point.
         * They do not start with a forward slash or drive name.
         * Note that the Path object in Java always uses forward-slashes to delimit the parts of the path String,
         * even if the underlying file system uses backslashes (such as the NTFS file system on Windows).
         *
         * File Open Modes, common StandardOpenOptions:
         * - READ
         * - CREATE
         * - CREATE_NEW
         * - WRITE
         * - APPEND
         *
         *
         */

        //"." refers to current working directory
        Path p = Path.of(".");
        System.out.println("Path: " + p);
        System.out.println("Path: " + p.toAbsolutePath());
        System.out.println("Path: " + p.toAbsolutePath().normalize());
        System.out.println("Path: " + p.toAbsolutePath().resolve("..").normalize());
        System.out.println("Path: " + p.toAbsolutePath().resolve("..").normalize().toUri());

        /**
         * Input/Ouput Streams
         *
         * In Java, the utilities for reading and writing data are built on top of each other.
         * This diagram shows you what that means. When you use a BufferedReader to read lines of text,
         * that buffered reader is reading from another underlying Reader that provides characters of text.
         * That Reader, in turn, is itself using an InputStream behind the scenes to read the raw data.
         *
         * Input and output streams are the lowest level utilities Java provides.
         * They give you access to the raw data, in the form of bytes. This data can come from
         * a file, from user input on the command-line, or from a network or other source.
         * These are the lowest level APIs Java offers for reading or writing a stream of bytes.
         *
         */

        /**
         * InputStream Example:
         *
         * This code creates a file called "test" using newInputStream() method of the Files API.
         * The code calls the read() method, which reads the data into a byte[] and
         * returns the number of bytes that were read. If no bytes were read, it returns -1.
         * This code will read the entire file, 10 bytes at a time, until the loop reaches
         * the end of the file.
         */
        InputStream in =
                Files.newInputStream(Path.of("test"), StandardOpenOption.READ);
        byte[] data = new byte[10];
        while (in.read(data) != -1){
            //return the number of bytes read
            //useData(data);
        }
        in.close();

        /**
         * OutputStream example
         *
         * The basic write() method only deals with bytes. It's pretty self-explanatory:
         * you give the write() method a byte[], and it writes those bytes to the output stream.
         */

        OutputStream out = Files.newOutputStream(Path.of("test"));
        out.write("Hello, world".getBytes());
        out.close();
    }





}
