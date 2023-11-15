package com.menghuan.rename;

import java.io.File;

public class FileRenameOne {

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
                                String fileExtension = "";

                                // int dotIndex = fileName.lastIndexOf(".");
                                int dotIndex = fileName.indexOf(".");
                                if (dotIndex > 0) {
                                    fileExtension = fileName.substring(dotIndex);
                                }

                                String newFileName = folderName + fileExtension;
                                File newFile = new File(subFolder, newFileName);
                                if (file.renameTo(newFile)) {
                                    System.out.println("Renamed: " + fileName + " to " + newFileName);
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
