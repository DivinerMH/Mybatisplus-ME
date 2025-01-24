package com.helper.zip;

import java.io.*;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import cn.hutool.log.Log;

/**
 * import com.github.junrar.Archive; import com.github.junrar.rarfile.FileHeader; import org.apache.tools.zip.ZipEntry;
 * import org.apache.tools.zip.ZipFile;
 */
public class UnZipAnRar {

    // 解压Zip
    public static void unZip(File zipFile, String outDir) throws IOException {

        File outFileDir = new File(outDir);
        if (!outFileDir.exists()) {
            boolean isMakDir = outFileDir.mkdirs();
            if (isMakDir) {
                System.out.println("创建压缩目录成功");
            }
        }

        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration enumeration = zip.getEntries(); enumeration.hasMoreElements();) {
            ZipEntry entry = (ZipEntry)enumeration.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);

            Log.get(zipEntryName);

            if (entry.isDirectory()) { // 处理压缩文件包含文件夹的情况
                File fileDir = new File(outDir + zipEntryName);
                fileDir.mkdir();
                continue;
            }

            File file = new File(outDir, zipEntryName);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) > 0) {
                out.write(buff, 0, len);
            }
            in.close();
            out.close();
        }
    }

    // 解压Rar
    public static void unRar(File rarFile, String outDir) throws Exception {
        File outFileDir = new File(outDir);
        if (!outFileDir.exists()) {
            boolean isMakDir = outFileDir.mkdirs();
            if (isMakDir) {
                System.out.println("创建压缩目录成功");
            }
        }
        Archive archive = new Archive(rarFile);
        FileHeader fileHeader = archive.nextFileHeader();
        while (fileHeader != null) {
            if (fileHeader.isDirectory()) {
                fileHeader = archive.nextFileHeader();
                continue;
            }
            File out = new File(fileHeader.getFileNameW());
            InputStream inputStream = new FileInputStream(out);
            String fileNameString = fileHeader.getFileNameString();

            if (!out.exists()) {
                if (!out.getParentFile().exists()) {
                    out.getParentFile().mkdirs();
                }
                out.createNewFile();
            }
            FileOutputStream os = new FileOutputStream(out);
            archive.extractFile(fileHeader, os);

            os.close();

            fileHeader = archive.nextFileHeader();
        }
        archive.close();
    }
}
