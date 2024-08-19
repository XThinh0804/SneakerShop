package vn.devpro.javaweb29cuoikhoa.controller.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.dto.Jw29Contant;
import vn.devpro.javaweb29cuoikhoa.dto.SearchModel;
import vn.devpro.javaweb29cuoikhoa.model.Role;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.RoleService;
import vn.devpro.javaweb29cuoikhoa.service.UserService;

@Controller
@RequestMapping("/admin/user/")
public class UserController extends BaseController implements Jw29Contant{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "list", method =RequestMethod.GET)
	public String viewUser(final Model model,final HttpServletRequest request) {
		List<User> users = new ArrayList<User>();
		users = userService.findAllActive();
		List<Role> roles = roleService.findAllActive();
		//Phân trang
		SearchModel userPagination = new SearchModel();
		userPagination.setTotalItems(users.size());
		userPagination.setCurrentPage(1);//Ban đầu luôn là 1
		//Kiểm tra bấm nút chọn trang
		if(!StringUtils.isEmpty(request.getParameter("currentPage"))) {
			userPagination.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}
		//Số bản ghi trên một trang
		userPagination.setSizeOfPage(SIZE_OF_PAGE);
		//Tổng số trang
		int totalPages = users.size() / SIZE_OF_PAGE;
		if(users.size() % SIZE_OF_PAGE != 0 ) {
			totalPages++;
		}
		userPagination.setTotalPages(totalPages);
		//Lấy danh sách trang hiện tại để hiển thị
		int firstIndex = (userPagination.getCurrentPage() - 1)*SIZE_OF_PAGE;
		int lastIndex = firstIndex + SIZE_OF_PAGE;
		if(lastIndex > users.size()) {
			lastIndex = users.size();
		}
		List<User> allUsers = users.subList(firstIndex, lastIndex);
		model.addAttribute("users",allUsers);
		model.addAttribute("userPagination",userPagination);
		model.addAttribute("roles",roles);
		return "backend/user-list";
	}
	
	@RequestMapping(value = "add", method =RequestMethod.GET)
	public String addUser(final Model model) {
		List<Role> roles = roleService.findAllActive();
		List<User> users = userService.findAllActive();
		User user = new User();
		user.setCreateDate(new Date());
		model.addAttribute("users",users);
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		return "backend/user-add";
	}
	
	@RequestMapping(value = "add-save", method =RequestMethod.POST)
	public String saveAddUser(final Model model,final HttpServletRequest request,
			@ModelAttribute("user") User user) {
		Role role =roleService.getById(Integer.parseInt(request.getParameter("roleId")));
		user.addRelationalUserRole(role);
		user.setPassword(new BCryptPasswordEncoder(4).encode(request.getParameter("password")));
		userService.saveOrUpdate(user);
		return "redirect:add";
	}
	
	@RequestMapping(value = "edit/{userId}", method =RequestMethod.GET)
	public String editCategories(final Model model,
			@PathVariable("userId") int userId) {
		User user = userService.getById(userId);
		user.setUpdateDate(new Date());
		List<User> users = userService.findAllActive();
		model.addAttribute("users",users);
		model.addAttribute("user",user);
		return "backend/user-edit";
	}
	@RequestMapping(value = "edit-save", method =RequestMethod.POST)
	public String saveEditUser(final Model model,
			@ModelAttribute("user") User user) {
		userService.saveOrUpdate(user);
		return "redirect:list";
	}
	@RequestMapping(value = "delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(final Model model,
			@PathVariable("userId") int userId) {
		
		User user = userService.getById(userId);
		user.setStatus(false);
		userService.saveOrUpdate(user);
		return "redirect:/admin/user/list";
	}
}
