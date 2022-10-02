package Exercise_ObjectSerialization;


import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public final class ClientStore {
    private ClientStore() {
        // No instantiation
    }

    public static List<UdacisearchClient> getClients() {
        return List.of(
                new UdacisearchClient(
                        "CatFacts LLC",
                        1,
                        8000,
                        5,
                        ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneId.of("Etc/UTC")).toInstant(),
                        Duration.ofDays(180),
                        ZoneId.of("America/Los_Angeles"),
                        "555 Meowmers Ln, Riverside, CA 92501"),
                new UdacisearchClient(
                        "Marmot Memorabilia",
                        2,
                        2500,
                        3,
                        ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.of("Etc/UTC")).toInstant(),
                        Duration.ofDays(365 * 5),
                        ZoneId.of("America/Denver"),
                        "Somewhere in the Rocky Mountains"),
                new UdacisearchClient(
                        "Tapir Trivia",
                        3,
                        8000,
                        200,
                        ZonedDateTime.of(2019, 1, 1, 0, 0, 0, 0, ZoneId.of("Etc/UTC")).toInstant(),
                        Duration.ofDays(365 * 2),
                        ZoneId.of("Asia/Manila"),
                        "555 Meowmers Ln, Riverside, CA 92501"),
                new UdacisearchClient(
                        "Dingo Details Inc.",
                        4,
                        9000,
                        10_000,
                        ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneId.of("Etc/UTC")).toInstant(),
                        Duration.ofDays(365 * 4),
                        ZoneId.of("Australia/NSW"),
                        "42 Wallaby Way"));
    }
}
