package Exercise_Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {

    public static void main(String[] args) throws Exception{
        String path = "src\\Exercise_Jackson\\out.json";
        transJSON(path);
    }

    public static void transJSON(String path) throws Exception {

        UdacisearchClient client =
                new UdacisearchClient(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        Instant.now(),
                        Duration.ofDays(180),
                        ZoneId.of("America/Los_Angeles"),
                        "555 Meowmers Ln, Riverside, CA 92501");


        Path outputPath = Path.of(path);

        // TODO: Write the "client" variable to the "outputPath", using a
        //       com.fasterxml.jackson.databind.ObjectMapper to serialize it into JSON. You will have to
        //       register the com.fasterxml.jackson.datatype.jsr310.JavaTimeModule with the ObjectMapper
        //       in order for it to work with the java.time fields in Exercise_Jackson.UdacisearchClient.
        //
        //       Next, read the JSON back and deserialize it using a ObjectInputStream.

        ObjectMapper output = new ObjectMapper();
        output.registerModule(new JavaTimeModule());
        output.writeValue(Files.newBufferedWriter(outputPath), client);
        System.out.println("Wrote to " + outputPath.toAbsolutePath().toString());

        UdacisearchClient deserialized = output.readValue(Files.newBufferedReader(outputPath),
                UdacisearchClient.class);
        System.out.println("Deserialized " + deserialized);
    }
}