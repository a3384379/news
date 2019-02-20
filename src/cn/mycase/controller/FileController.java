package cn.mycase.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping(value="upload.action") //abc.png
	public String testUpload(@RequestParam("desc") String desc  , @RequestParam("file") MultipartFile file,HttpServletRequest request  ) throws IOException {
		
		System.out.println("�ļ�������Ϣ��"+desc);
		//jsp���ϴ����ļ���file
		
		InputStream input = file.getInputStream() ;//IO
		String fileName = file.getOriginalFilename() ;
		
		OutputStream out = new FileOutputStream("D:\\spring-tool-suite-3.9.6.RELEASE-e4.9.0-win32-x86_64\\workpace\\news\\WebContent\\image\\"+fileName) ;
		
		
		byte[] bs = new byte[1024];
		int len = -1;
		while(( len = input.read(bs)) !=-1 ) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		//��file�ϴ����������е� ĳһ��Ӳ���ļ���
	System.out.println("�ϴ��ɹ���");
		
		return "categoryList.action?url=admin/category/list.jsp";
	}
}
