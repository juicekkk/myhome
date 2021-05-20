package com.jsk.mylogue.main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * 파일 업로드
 */
public class FileUtil {

	@Controller
	public class FileAction {
		private static final String SAVE_PATH = "D:/test";

		public ModelAndView upload(
				@RequestParam(value="file1", required = false) MultipartFile mf) {
			ModelAndView mv = new ModelAndView("uploadView");


			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			String safeFile = SAVE_PATH + System.currentTimeMillis() + originalFileName;


			try {
				mf.transferTo(new File(safeFile));

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return mv;
		}

	}

}