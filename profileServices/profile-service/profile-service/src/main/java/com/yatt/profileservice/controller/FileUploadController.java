package com.yatt.profileservice.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yatt.profileservice.util.FileUploadUtil;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	String uploadDir = "user-photos/";
	
	@PostMapping("/{id}")
	public HttpStatus newProfilePicuter(@PathVariable String id, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		
		FileUploadUtil.saveFile(uploadDir+id, fileName, multipartFile);
		
		return HttpStatus.OK;
	}
	
	@PutMapping("/{id}")
	public HttpStatus updateProfilePictuer(@PathVariable String id, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		
		FileUploadUtil.saveFile(uploadDir+id, fileName, multipartFile);
		
		return HttpStatus.OK;
	}


	@GetMapping("/profile/picture/{id}")
	HttpStatus one(@PathVariable String id) throws Exception {
		
		return HttpStatus.OK;
	}
	
	
}
