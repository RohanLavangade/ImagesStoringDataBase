package com.imaeStore.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
   
	@PostMapping("/upload")
	public String uploadImage(@RequestParam MultipartFile file) throws Exception {
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
//		String Path_Directory="C:\\Users\\DELL\\Downloads\\ImageStoring\\ImageStoring\\src\\main\\resources\\static\\images";
		String Path_Directory=new ClassPathResource("static/images/").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(),Paths.get(Path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		return "Successfully Added the image";
	}
}
