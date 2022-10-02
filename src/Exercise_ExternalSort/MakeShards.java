package Exercise_ExternalSort;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * There's just one problem — the text file is so big it won't even fit into your computer's memory!
 * (Note: For the purposes of this exercise, we are only sorting 10,000 words, so they in fact do fit in memory.
 * Just pretend they don't!)
 *
 * To deal with this limitation, you will use a technique known as External Sorting,
 * which is a way to sort large amounts of data. At a high level, this will involve
 * - sharding the large file, which means splitting it up into a bunch of smaller files that can individually fit into memory;
 * - sorting the shard files; and
 * - merging the sorted shards into a single large sorted file. The merge can be done
 * in a way that does not require loading all the sorted words into memory at once.
 */

public final class MakeShards {
    private static final int SHARD_SIZE = 100;

    public static void main(String[] args) throws Exception {
        String[] paths = {"E:\\JavaNanodegree\\FilesIO\\src\\Exercise_ExternalSort\\unsorted.txt",
                "E:/JavaNanodegree/FilesIO/src/Exercise_ExternalSort/resultFolder"};
        shards(paths);
    }

    public static void shards(String[] paths) throws Exception {
        if (paths.length != 2) {
            System.out.println("Usage: MakeShards [input file] [output folder]");
            return;
        }

        Path input = Path.of(paths[0]);
        Path outputFolder = Files.createDirectory(Path.of(paths[1]));

            // TODO: Read the unsorted words from the "input" Path, line by line. Write the input words to
            //       many shard files. Each shard file should contain at most SHARD_SIZE words, in sorted
            //       order. All the words should be accounted for in the output shard files; you should not
            //       skip any words. Write the shard files in the newly created "outputFolder", using the
            //       getOutputFileName(int) method to name the individual shard files.
        try (BufferedReader reader = Files.newBufferedReader(input)){
            int shardNum = 1;
            String word = reader.readLine();
            while (word!=null) {
                List<String> shard = new ArrayList<>(SHARD_SIZE);
                while (shard.size() < SHARD_SIZE && word != null) {
                    shard.add(word);
                    word = reader.readLine();
                }
                shard.sort(String::compareTo);

                Path output = Path.of(outputFolder.toString(), getOutputFileName(shardNum));
                try (Writer writer = Files.newBufferedWriter(output);){

                    for (int i = 0; i < shard.size(); i++) {
                        writer.write(shard.get(i));
                        if (i < shard.size() - 1) {
                            writer.write(System.lineSeparator());
                        }
                    }
                }
                shardNum ++;
            }
        }
    }

    private static String getOutputFileName(int shardNum) {
        return String.format("shard%02d.txt", shardNum);
    }
}

