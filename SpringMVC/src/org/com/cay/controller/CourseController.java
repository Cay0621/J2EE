package org.com.cay.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.com.cay.entity.Course;
import org.com.cay.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = { "/course" })
public class CourseController {

	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	// @RequestParam表示请求参数
	// course/view?courseId=123
	@RequestMapping(value = { "/view" }, method = RequestMethod.GET)
	public String viewCourse(@RequestParam(name = "courseId") Integer courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course", course);
		return "course_overview";
	}

	// @PathVariable表示路径变量
	// course/view2/courseId
	@RequestMapping(value = { "/view2/{courseId}" }, method = RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
		Course course = courseService.getCourseById(courseId);
		model.put("course", course);
		return "course_overview";
	}

	// 使用HttpServletRequest获取请求参数
	// course/view?courseId=123
	@RequestMapping(value = "/view3")
	public String viewCourse3(HttpServletRequest request) {
		Integer courseId = Integer.parseInt(request.getParameter("courseId"));
		Course course = courseService.getCourseById(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}

	//params表示请求的参数为指定的参数才映射到该函数
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String createCourse() {
		return "course_admin/edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String doSave(@ModelAttribute Course course) {// ModelAttribute用于绑定model，非必须

		// 进行一些数据持久化
		course.setCourseId(123);

		// redirect:重定向
		// forward:转发
		return "redirect:view2/" + course.getCourseId();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage() {
		return "course_admin/file";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam(name = "file") MultipartFile file) throws IOException {

		if (file != null) {
			String fileName = file.getOriginalFilename();
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File("F:\\Code\\JavaWeb\\SpringMVC/tmp/", System.currentTimeMillis() + fileName));
		}

		return "success";
	}
	
	@RequestMapping(value="/jsontype/{courseId}",method=RequestMethod.GET)
	public @ResponseBody Course getCourseJson(@PathVariable Integer courseId){
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(value="/jsontype2/{courseId}", method=RequestMethod.GET)
	public ResponseEntity<Course> getCourseJson2(@PathVariable Integer courseId){
		Course course = courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
}
