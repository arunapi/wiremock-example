package com.arunapi.wiremock.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {
    public static void saveMapping(String mappingFileName, String json) throws Exception{
        Path path = Paths.get("mappings/"+mappingFileName+".json");
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            //To specifiy a charset you can use
            Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
            bw.write(json);
        } catch (IOException e) {
            throw e;
        }
    }
}
