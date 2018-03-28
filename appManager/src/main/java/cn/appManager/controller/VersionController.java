package cn.appManager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;
import cn.app.pojo.DevUser;
import cn.app.service.version.AppVersionService;
import cn.app.tools.Constants;
import cn.app.vo.AppVersionVo;
@Controller
public class VersionController {

	@Autowired
	private AppVersionService appvs;
	
	private Logger logger = Logger.getLogger(AppInfoController.class);
	
	@RequestMapping(value="/appVersion/{appId}",method=RequestMethod.GET)
	public String addVersion(@PathVariable("appId") Long id, Model model) {
		List<AppVersionVo> appversionvo = appvs.selectVersionById(id);
		if(appversionvo != null) {
			model.addAttribute("appversionvo", appversionvo);
		}
		return "appInfo/version";
	}
	
	@RequestMapping(value = "/addVersion", method = RequestMethod.POST)
	public String gotoAddApp2(@Valid AppVersion appversion, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request, @RequestParam(value = "apkfilename", required = false) MultipartFile attach) {

		String apkFileName = null;
		String apkLocPath = null;
		// �ж��ļ��Ƿ�Ϊ��
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");
			logger.info("uploadFile path ============== > " + path);
			String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
			logger.info("uploadFile oldFileName ============== > " + oldFileName);
			String suffix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
			logger.debug("uploadFile prefix============> " + suffix);
			int filesize = 500000000;
			logger.debug("uploadFile size============> " + attach.getSize());
			if (attach.getSize() > filesize) {// �ϴ���С���ó��� 500k
				request.setAttribute("uploadFileError", " * �ϴ���С���ó��� 500k");
				return "redirect:/appInfo/version";
			} else if (suffix.equalsIgnoreCase("apk")) {// �ϴ�ͼƬ��ʽ����ȷ
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt() + "_version.apk";
				logger.debug("new fileName======== " + attach.getName());
				File targetFile = new File(path, oldFileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// ����
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", " * �ϴ�ʧ�ܣ�");
					return "redirect:/appInfo/version";
				}
				apkFileName = oldFileName;
				apkLocPath = path + File.separator + oldFileName;
			} else {
				request.setAttribute("uploadFileError", " * �ϴ��ļ���ʽ����ȷ");
				return "redirect:/appInfo/version";
			}
		}

		System.out.println("add()================");

		appversion.setModifydate(new Date());
		appversion.setApkfilename(apkFileName);
		appversion.setApklocpath(apkLocPath);
		if (appvs.addVersion(appversion) > 0) {
			return "redirect:/appVersion/"+appversion.getAppid();
		} else {
			return "redirect:/appInfo/version";
		}
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam("fileName")String fileName,HttpSession session) throws IOException {
	   // File file = new File("E:\\apache-tomcat-8.5.24\\webapps\\appManager\\statics\\uploadfiles\\com.doodleapps.powdertoy.png");
	    byte[] body = null;
        ServletContext context = session.getServletContext();
        InputStream is = context.getResourceAsStream("/statics/uploadfiles/"+fileName);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, header, status);
		return response;
	}
}
