package com.example.Day13Workshop;

import com.example.Day13Workshop.util.IOUtil.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13WorkshopApplication {
	private static final Logger logger 
			= LoggerFactory.getLogger(Day13WorkshopApplication.class);

	public static final String Data_Dir = "dataDir";
	public static void main(String[] args) {
		
		//init the spring app
		SpringApplication app = new SpringApplication(Day13WorkshopApplication.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		//create a list with a function that enable program to take in cmd line arg
		List<String> optsVal = appArgs.getOptionValues("dataDir");
		if(optsVal != null){
			createDirectory((String)optsVal.get(0));

		} else{
			logger.info("No data directory is provided!");
			System.exit(1);
		}

		app.run(args);

	}
	public static void createDirectory(String path){
        //try{
            File dir = new File(path);
            dir.mkdirs();
            //String perm = "rwxrwx--";
            //Set<PosixFilePermission> permissions 
            //        = PosixFilePermissions.fromString(perm);
            //Files.setPosixFilePermissions(dir.toPath(), permissions);

        //} catch(IOException e){
          //  logger.error("Error creating directory", e);
        //}
    }

}
