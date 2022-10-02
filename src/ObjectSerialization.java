import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ObjectSerialization {
    /**
     * Serialization
     *
     * Serialization is the process of converting an object into a data format that can later
     * be deserialized back into the original object.
     *
     * To serialize the Java object, create an ObjectOutputStream, and pass the object to the streams writeObject() method.
     * The ObjectOutputStream writes a sequence of bytes, and its constructor takes another stream as an argument.
     * To recreate the original Java object from the serialized bytes, read the bytes back into a ObjectInputStream.
     *
     */

    public static void main(String[] args) throws Exception{
        Path path = Path.of("list.bin");
        try (var out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(List.of("Hello", " ", "World!"));
        }
        try (var in = new ObjectInputStream(Files.newInputStream(path))){
            List<String> deserialized = (List<String>) in.readObject();
            System.out.println(deserialized);
        }
    }

}
