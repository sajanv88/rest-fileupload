package com.sajan.fileupload.fileupload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class FileUploadConfig {
	private static String CLOUD_NAME = "place your cloudinary name";
	private static String API_KEY = "place your cloudinary api key";
	private static String API_SECRET = "place your cloudinary secret";

	public static Cloudinary cloudinaryInstance() {
		Cloudinary c = new Cloudinary(
				ObjectUtils
				.asMap(
						"cloud_name", FileUploadConfig.CLOUD_NAME,
						"api_key", FileUploadConfig.API_KEY,
						"api_secret", FileUploadConfig.API_SECRET));
		return c;
	}
	
}
