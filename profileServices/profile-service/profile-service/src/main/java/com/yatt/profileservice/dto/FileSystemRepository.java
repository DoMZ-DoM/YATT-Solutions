package com.yatt.profileservice.dto;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;


@Service
public class FileSystemRepository {

	String RESOURCES_DIR = FileSystemRepository.class.getResource("/").getPath();

	String save(byte[] content, String imageName) throws Exception {
		Path newFile = Paths.get(RESOURCES_DIR + new Date().getTime() + "-" + imageName);
		Files.createDirectories(newFile.getParent());

		Files.write(newFile, content);

		return newFile.toAbsolutePath().toString();
	}

	FileSystemResource findInFileSystem(String location) {
		try {
			return new FileSystemResource(Paths.get(location));
		} catch (Exception e) {
			// Handle access or file not found problems.
			throw new RuntimeException();
		}
	}

}
