package Exercise_ExternalSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public final class MergeShards {

    public static void merge(String[] paths) throws IOException {
        List<Path> inputs = Files.walk(Path.of(paths[0]), 1).skip(1).collect(Collectors.toList());
        List<BufferedReader> readers = new ArrayList<>(inputs.size());
        Path outputPath = Path.of(paths[1]);

        // TODO: Inside a try-finally block, create the List of BufferedReaders: one for each "input"
        //       Path. Without modifying the shard files, merge them together into a single text file
        //       whose location is specified by the "outputPath".
        //
        //       To do this, you should put words in a PriorityQueue<WordEntry>, but make sure the
        //       priority queue never contains more entries than there are input files. The whole point
        //       of doing a distributed merge sort is that there are too many words to fit into memory!
        //
        //       In the "finally" part of the try-finally block, make sure to close all the
        //       BufferedReaders.
        try {
            PriorityQueue<WordEntry> queue = new PriorityQueue<>();
            for (Path path: inputs) {
                BufferedReader reader = Files.newBufferedReader(path);
                readers.add(reader);
                String word;
                if ((word = reader.readLine()) != null){
                    queue.add(new WordEntry(word, reader));
                }
            }

            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)){
                while (!queue.isEmpty()){
                    WordEntry entry = queue.poll();
                    writer.write(entry.word);
                    writer.write(System.lineSeparator());
                    String word = entry.reader.readLine();
                    if (word!= null){
                        queue.add(new WordEntry(word, entry.reader));
                    }
                }
            }
        } finally {
            for (BufferedReader reader: readers){
                try{
                    reader.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String[] paths = {"E:/JavaNanodegree/FilesIO/src/Exercise_ExternalSort/resultFolder",
                "E:\\JavaNanodegree\\FilesIO\\src\\Exercise_ExternalSort\\sorted.txt"};
        merge(paths);
    }

    private static final class WordEntry implements Comparable<WordEntry> {
        private final String word;
        private final BufferedReader reader;

        private WordEntry(String word, BufferedReader reader) {
            this.word = Objects.requireNonNull(word);
            this.reader = Objects.requireNonNull(reader);
        }

        @Override
        public int compareTo(WordEntry other) {
            return word.compareTo(other.word);
        }
    }
}
