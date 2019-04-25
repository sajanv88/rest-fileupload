package com.sajan.fileupload.fileupload.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sajan.fileupload.fileupload.model.FileResponseModel;
import com.sajan.fileupload.fileupload.service.FileuploadService;

@RestController
@RequestMapping(path = "/api")
public class FileuploadController {
	
	@Autowired
	FileuploadService fs;

	@PostMapping(path = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FileResponseModel> upload(@RequestParam("file") MultipartFile file) throws IOException {
		File newFile = new File("./"+file.getOriginalFilename());
		FileResponseModel frm = fs.upload(newFile, file.getBytes());
		return new ResponseEntity<FileResponseModel>(frm, HttpStatus.ACCEPTED);
	}
}
