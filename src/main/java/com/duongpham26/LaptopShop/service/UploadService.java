package com.duongpham26.LaptopShop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {

   private final ServletContext servletContext;

   public UploadService(ServletContext servletContext) {
      this.servletContext = servletContext;
   }

   public String handleSaveUploadFile(MultipartFile file, String folder) {
		if(file.isEmpty()) {
			return "";
		}
		String pathAvatar = null;
      if (!file.isEmpty()) {
			try {
				String rootPath = this.servletContext.getRealPath("/resources/images");
				byte[] bytes = file.getBytes();
				File dir = new File(rootPath + File.separator + folder);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				pathAvatar = dir.getAbsolutePath()+ File.separator + System.currentTimeMillis() + "-" + file.getOriginalFilename();
				File serverFile = new File(pathAvatar);
            //uuid => tao id kh trung
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				// return "You failed to upload " + user + " => " + e.getMessage();
			}
		} else {
			// return "You failed to upload " + user + " because the file was empty.";
		}
		return pathAvatar;
   }

	public void handleDeleteFile(String path)throws IOException {
		if(!path.isEmpty()) {
			Path fileToDeletePath = Paths.get(path);
			Files.delete(fileToDeletePath);
		}
	}
}
