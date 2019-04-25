package com.sajan.fileupload.fileupload.model;

import java.util.Map;

public class FileResponseModel {
	private Map fileRef;

	public FileResponseModel(Map fileRef) {
		this.fileRef = fileRef;
	}

	public Map getFileRef() {
		return fileRef;
	}
	
}
