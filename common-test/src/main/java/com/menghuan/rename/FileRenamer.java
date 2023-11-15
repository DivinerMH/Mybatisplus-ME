package com.menghuan.rename;

import java.io.File;

public class FileRenamer {

    public static void main(String[] args) {
        // 指定你的文件夹路径
        String folderPath = "C:\\Users\\Administrator.DESKTOP-2P9IO8R\\Desktop\\湛江地块图层";
        renameFilesInFolder(folderPath);
    }

    public static void renameFilesInFolder(String folderPath) {
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            File[] subFolders = folder.listFiles();

            if (subFolders != null) {
                for (File subFolder : subFolders) {
                    if (subFolder.isDirectory()) {
                        String folderName = subFolder.getName();
                        File[] files = subFolder.listFiles();

                        if (files != null) {
                            for (File file : files) {
                                String fileName = file.getName();
                                File newFile = new File(subFolder, folderName);

                                if (!fileName.equals(folderName)) {
                                    newFile = new File(subFolder, fileName);
                                }

                                if (file.renameTo(newFile)) {
                                    System.out.println("Renamed: " + fileName + " to " + newFile.getName());
                                } else {
                                    System.err.println("Failed to rename: " + fileName);
                                }
                            }
                        }

                        // 递归处理子文件夹
                        renameFilesInFolder(subFolder.getPath());
                    }
                }
            }
        }
    }
}
