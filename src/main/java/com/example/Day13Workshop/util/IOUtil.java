package com.example.Day13Workshop.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOUtil {
    private static final Logger logger
                = LoggerFactory.getLogger(IOUtil.class);

    public static void createDirectory(String path){
        try{
            File dir = new File(path);
            dir.mkdirs();
            String perm = "rwxrwx--";
            Set<PosixFilePermission> permissions 
                    = PosixFilePermissions.fromString(perm);
            Files.setPosixFilePermissions(dir.toPath(), permissions);

        } catch(IOException e){
            logger.error("Error creating directory", e);
        }
    }
}


