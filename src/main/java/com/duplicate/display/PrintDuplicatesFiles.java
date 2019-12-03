package com.duplicate.display;

import java.io.File;
import java.util.List;

public class PrintDuplicatesFiles implements DuplicateResult {
    private final List<File> files;

    public PrintDuplicatesFiles(List<File> files) {
        this.files = files;
    }

    /**
     * Found duplicate files:
     * 0. ${f1}
     * 1. ${f2}
     * 2. ${f3}
     * …
     * 
     * What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)
     */
    @Override
    public void diplay() {
        if (!files.isEmpty()) {
            System.out.println("Found duplicate files:");
            for (int i = 0; i < files.size(); i++) {
                System.out.println(String.format("%d. %s", i, files.get(i)));
            }
            System.out.println();
            System.out.println("What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)");
        }else {
            System.out.println("No file is duplicated");
        }
    }
}
