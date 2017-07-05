package cn.lxc.controller;

import java.io.IOException;
import java.util.List;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.lxc.service.UserService;
import cn.lxc.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		List<User> list = userService.getList();
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("list", list);
		try {
			response.getWriter().print("草泥马");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/create.do")
	public ModelAndView create(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	@InitBinder("user")//给对象的属性绑定前缀    
    public void initBinder(WebDataBinder binder) {    
        binder.setFieldDefaultPrefix("user.");    
    }  
	@RequestMapping("/save.do")
	public String save(User user) throws IOException{
		userService.save(user);
		return "redirect:list.do";
	}
	@RequestMapping("/{id}/edit.do")
	public ModelAndView edit(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("edit");
		User user = userService.showInfoById(id);
		mv.addObject(user);
		return mv;
	}
	@RequestMapping("/update.do")
	public String update(User user) throws IOException{
		userService.update(user);
		return "redirect:list.do";
	}
	@RequestMapping("/{id}/delete.do")
	public String delete(@PathVariable("id") int id){
		if(userService.delete(id)>0){
			return "redirect:/user/list.do";
		}
		return "redirect:list.do";
	}
	/**************************getter&setter*************************/
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
