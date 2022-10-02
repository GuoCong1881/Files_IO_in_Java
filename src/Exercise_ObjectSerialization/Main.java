package Exercise_ObjectSerialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void serialization(String path) throws IOException, ClassNotFoundException {
         UdacisearchClient client = new UdacisearchClient(
                "CatFacts LLC",
                1,
                8000,
                5,
                ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneId.of("Etc/UTC")).toInstant(),
                Duration.ofDays(180),
                ZoneId.of("America/Los_Angeles"),
                "555 Meowmers Ln, Riverside, CA 92501");

        try(ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Path.of(path)))){
            output.writeObject(client);
        }
        System.out.println("Wrote to " + Path.of(path).toAbsolutePath().toString());

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Path.of(path)))){
            UdacisearchClient de_client = (UdacisearchClient) input.readObject();
            System.out.println("Deserialized " + de_client);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String outputPath = "clientObject";
        serialization(outputPath);
    }
}
