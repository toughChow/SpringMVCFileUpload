package com.qingshixun.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="myFile")
public class FileController {
	
	@RequestMapping(value = "toUpload")
	public String jumpToUpload(){
		return "upload";
	}
	@RequestMapping(value = "toUploadSyn")
	public String jumpToUploadSyn(){
		return "uploadSyn";
	}

	@ResponseBody
	@RequestMapping(value = "doUpload",method=RequestMethod.POST)
	public String uploadFile(MultipartFile myFile, HttpServletRequest request) {

		boolean message = false;
		
		// 文件重命名
		String fileName = myFile.getOriginalFilename();
		String newFileName = UUID.randomUUID().toString()
				+ fileName.substring(fileName.indexOf("."), fileName.length());
		String url = request.getServletContext().getRealPath("/upload");
		
		System.out.println("Your url:"+url);
		
		// 若不存在 则创建
		if(!new File(url).exists()){
			new File(url).mkdir();
		}
		
		try {
			FileUtils.copyInputStreamToFile(myFile.getInputStream(), 
					new File(url + File.separator + newFileName));
			message = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", message);
		jsonObject.put("url", File.separator + "upload" + File.separator + newFileName);
		return jsonObject.toJSONString();
	}
	
	//同步上传
	@RequestMapping(value="uploadSyn",method=RequestMethod.POST)
	public String fileUploadSyn(MultipartFile file,HttpServletRequest request){
		
		//文件名
		String fileName = file.getOriginalFilename();
		String newFileName = UUID.randomUUID().toString()
				+fileName.substring(fileName.indexOf("."),fileName.length());
		
		
		//test error
//		int i = 1/0;
		
		// 获取路径
		String path = request.getServletContext().getRealPath("/upload");
		
		if(!new File(path).exists()){
			new File(path).mkdir();
		}
		
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					new File(path + File.separator + newFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

}
