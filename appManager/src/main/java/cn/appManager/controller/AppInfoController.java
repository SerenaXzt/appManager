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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.app.criteria.CriteriaApp;
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

	
	@RequestMapping(value="/appsInfo",method=RequestMethod.GET)
	public String showAllApp(
			@RequestParam(value="pageNum",required=false,defaultValue="1")Integer pageNum,
			Model model,HttpSession session){
		PageHelper.startPage(pageNum, 4);
		List<AppInfoVo> list  = appifs.queryAll(null);
		PageInfo<AppInfoVo> page = new PageInfo<>(list,4);
		model.addAttribute("page", page);
		model.addAttribute("dataDictionaryVo",AppInfoVo.getStatusMap());
		return "appList/devUserAppList";
	}
	
	@RequestMapping(value="/appsInfo/{appId}",method=RequestMethod.GET)
	public String showOneApp(@PathVariable("appId")Integer appId,Model model){
		AppInfoVo appInfoVo  = appifs.queryById(appId);
		if(appInfoVo != null){
			model.addAttribute("appInfoVo",appInfoVo);
		}
		return "appInfo/info";
	}
	
	@RequestMapping(value="/appsUpdate/{appId}",method=RequestMethod.GET)
	public String goUpdate(@PathVariable("appId")Integer appId,Model model){
		AppInfoVo appInfoVo  = appifs.queryById(appId);
		if(appInfoVo != null){
			model.addAttribute("appInfoVo",appInfoVo);
			model.addAttribute("dataDictionaryVo",AppInfoVo.getStatusMap());
		}
		return "appInfo/update";
	}
	
	

	@RequestMapping(value="/appsUpdate",method=RequestMethod.PUT)
	public String updateApp(@RequestParam(value="_status",required=false)Long _status, AppInfo appInfo , HttpSession session){
		DevUser devuser = (DevUser) session.getAttribute(Constants.USER_SESSION);
		appInfo.setModifyby(devuser.getId());
		appInfo.setModifydate(new Date());
		appInfo.setUpdatedate(new Date());
		if(_status != null){
			appInfo.setStatus(_status);
		}
		appifs.updateApp(appInfo);
		return "redirect:/appsInfo";
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
				File targetFile = new File(path, oldFileName);
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
				logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+oldFileName;
				logoLocPath = path + File.separator + oldFileName;
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
		if (appifs.deleteVersion(appId) > 0 && appifs.deleteApp(appId) > 0) {
			return Msg.success();
		}else if(appifs.deleteApp(appId) > 0) {
			return Msg.success();
		}
		return Msg.fail();
	}
	//根据条件进行搜索
		@RequestMapping(value="/appsSearch",method=RequestMethod.POST)
		public String showAllApp(@RequestParam(value="pageNum",required=true,defaultValue="1") Integer pageNum,CriteriaApp ca , Model model){
			PageHelper.startPage(pageNum, 4);
			List<AppInfoVo> list  = appifs.queryAll(ca);
			PageInfo page = new PageInfo<>(list,4);
			model.addAttribute("page", page);
			model.addAttribute("dataDictionaryVo",AppInfoVo.getStatusMap());
			return "appList/devUserAppList";
		}
		
		@RequestMapping("/appsPutOrDwon")
		@ResponseBody
		public Msg putOrDown(@RequestParam(value="appId",required=true) Integer appId,
				@RequestParam(value="opt",required=true) Integer opt){
			if(appId != null && opt !=null ){
				int count = appifs.modifyAppPutOrDown(appId, opt);
				if(count > 0){
					return Msg.success();
				}
				return Msg.fail();
			}
			return Msg.fail();
		}
}