package com.sajan.fileupload.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sajan.fileupload.fileupload.FileUploadConfig;
import com.sajan.fileupload.fileupload.model.FileResponseModel;

@Service
public class FileuploadService {
	
	public FileResponseModel upload(File file, byte[] b) throws IOException {
		Cloudinary c = FileUploadConfig.cloudinaryInstance();
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(b);
		fo.close();
		Map uploadResult = c.uploader().upload(file, ObjectUtils.emptyMap());
		this.clean(file.getName());
		return new FileResponseModel(uploadResult);
	}
	
	private void clean(String fileName) {
		File newFile = new File("./"+fileName);
		newFile.delete();
	}
}
