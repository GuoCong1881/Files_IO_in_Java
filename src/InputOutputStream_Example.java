import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutputStream_Example {

    public static void copy(String[] paths) throws IOException {
        InputStream in = Files.newInputStream(Path.of(paths[0]));
        OutputStream out = Files.newOutputStream(Path.of(paths[1]));

        byte[] data = new byte[10];
        while (in.read(data) != -1){
            out.write(data);
        }
        in.close();
        out.close();
    }

    public static void copy_transfer(String[] paths) throws IOException {
        InputStream in = Files.newInputStream(Path.of(paths[0]));
        OutputStream out = Files.newOutputStream(Path.of(paths[1]));
        in.transferTo(out);
        in.close();
        out.close();
    }

    public static void copy_FilesAPI(String[] paths) throws IOException {
        Files.copy(Path.of(paths[0]), Path.of(paths[1]));
    }


    public static void main(String[] args) throws IOException {

    }
}
