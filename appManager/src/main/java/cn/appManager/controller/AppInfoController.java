package cn.appManager.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.omg.Messaging.SyncScopeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.app.pojo.AppInfo;
import cn.app.pojo.DevUser;
import cn.app.service.appinfo.AppInfoService;
import cn.app.tools.Constants;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;
import cn.app.vo.Msg;

@Controller
public class AppInfoController {
	
	private Logger logger = Logger.getLogger(AppInfoController.class);

	@Autowired
	private AppInfoService appifs;

	@RequestMapping(value = "/appsInfo", method = RequestMethod.GET)
	public String showAllApp(Model model) {
		List<AppInfoVo> list = appifs.queryAll();
		model.addAttribute("appInfoVoList", list);
		return "appList/devUserAppList";
	}

	@RequestMapping(value = "/appAdd", method = RequestMethod.GET)
	public String gotoAddApp() {
		return "app_add";
	}

	@RequestMapping(value = "/appAdd", method = RequestMethod.POST)
	public String gotoAddApp2(@Valid AppInfo appInfo, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request, @RequestParam(value = "logoPicPath", required = false) MultipartFile attach) {

		String logoPicPath = null;
		String logoLocPath = null;
		// 判断文件是否为空
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");
			logger.info("uploadFile path ============== > " + path);
			String oldFileName = attach.getOriginalFilename();// 原文件名
			logger.info("uploadFile oldFileName ============== > " + oldFileName);
			String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
			logger.debug("uploadFile prefix============> " + prefix);
			int filesize = 500000;
			logger.debug("uploadFile size============> " + attach.getSize());
			if (attach.getSize() > filesize) {// 上传大小不得超过 500k
				request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
				return "useradd";
			} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// 上传图片格式不正确
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt() + "_Personal.jpg";
				logger.debug("new fileName======== " + attach.getName());
				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", " * 上传失败！");
					return "app_add";
				}
				logoPicPath = oldFileName;
				logoLocPath = path + File.separator + fileName;
			} else {
				request.setAttribute("uploadFileError", " * 上传图片格式不正确");
				return "app_add";
			}
		}

		if (bindingResult.hasErrors()) {
			System.out.println("=======had errors=======");
			return "app_add";
		}

		System.out.println("add()================");

		DevUser devuser = (DevUser) session.getAttribute(Constants.USER_SESSION);
		appInfo.setCreationdate(new Date());
		appInfo.setCreatedby(devuser.getId());
		appInfo.setLogopicpath(logoPicPath);
		appInfo.setLogolocpath(logoLocPath);
		if (appifs.addApp(appInfo) > 0) {
			return "redirect:/appsInfo";
		} else {
			return "app_add";
		}
	}

	@RequestMapping(value = "/showCategory/{parentId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg showCategory(@PathVariable Integer parentId) {
		if (parentId != null && parentId >= 0) {
			List<AppCategoryVo> categoryList = appifs.queryAllByParentId(parentId);
			return Msg.success().addExtend("categoryList", categoryList);
		}
		return Msg.fail();
	}

	@RequestMapping(value = "/deleteApp/{appId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg deleteApp(@PathVariable("appId") Long appId) {
		System.out.println("delete===========");
		if (appifs.deleteApp(appId) > 0) {
			return Msg.success();
		}
		return Msg.fail();
	}

	@RequestMapping(value="/validate/{name}",method=RequestMethod.GET)
	@ResponseBody
	public Msg validate(@PathVariable("name") String softwarename) {
		if(appifs.selectBySoftwarename(softwarename) > 0) {
			System.out.println("app名称已存在！");
			return Msg.fail();
		}
		return Msg.success();
	}
}