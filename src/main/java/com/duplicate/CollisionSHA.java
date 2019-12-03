package com.duplicate;

import com.duplicate.display.DuplicateResult;
import com.duplicate.display.PrintDuplicatesFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collision between two files after application of SHA256 hash function
 *
 * @author Michal Jombik
 *
 */
public class CollisionSHA {

    private List<File> duplicates;
    private DuplicateResult duplicateResult;
    private final String path;

    public CollisionSHA(String path) {
        this.path = path;
        this.duplicates = getDuplicateFiles();
        this.duplicateResult = new PrintDuplicatesFiles(duplicates);
    }

    public void diplay(){
        duplicateResult.diplay();
    }

    /**
     * Method get list of files in particular directory.
     *
     * @return List<String> all regular files in directory
     */
    private List<String> getFiles() {
        List<String> result;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method get list of duplicates files in particular repository.
     *
     * @return List<String> all duplicates files in directory
     */
    private List<File> getDuplicateFiles() {
        List<File> duplicate = new ArrayList<>();
        List<String> paths = getFiles();
        for (int i = 0; i < paths.size(); i++){
            for (int j = i + 1; j < paths.size(); j++){
                if (Arrays.equals(getFileHash(paths.get(i)), getFileHash(paths.get(j)))){
                    duplicate.add(new File(paths.get(i)));
                    duplicate.add(new File(paths.get(j)));
                }
            }
        }
        return duplicate;
    }

    /**
     *
     * @return byte[] file hashcode using MessageDigest
     */
    private byte[] getFileHash(String path) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Files.readAllBytes(Paths.get(path)));
            return md.digest();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
