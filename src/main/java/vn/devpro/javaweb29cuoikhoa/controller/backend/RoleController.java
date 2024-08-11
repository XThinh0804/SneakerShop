package vn.devpro.javaweb29cuoikhoa.controller.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.model.Role;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.RoleService;
import vn.devpro.javaweb29cuoikhoa.service.UserService;

@Controller
@RequestMapping("/admin/role/")
public class RoleController extends BaseController{
	//khai báo service
		@Autowired
		private RoleService roleService;
		@Autowired
		private UserService userService;
		@RequestMapping(value = "list", method =RequestMethod.GET)
		public String viewRole(final Model model) {
			List<Role> roles = new ArrayList<Role>();
			roles = roleService.findAllActive();//Chỉ hiện thị những category status=true
			model.addAttribute("roles",roles);
			return "backend/role-list";
		}
		
		@RequestMapping(value = "add", method =RequestMethod.GET)
		public String addRole(final Model model) {
			List<User> users = userService.findAllActive();
			Role role = new Role();
			role.setCreateDate(new Date());
			model.addAttribute("role",role);
			model.addAttribute("users",users);
			return "backend/role-add";
		}
		
		@RequestMapping(value = "add-save", method =RequestMethod.POST)
		public String saveAddRole(final Model model,
				@ModelAttribute("role") Role role) {
			roleService.saveOrUpdate(role);
			return "redirect:add";
		}
		
		@RequestMapping(value = "edit/{roleId}", method =RequestMethod.GET)
		public String editRole(final Model model,
				@PathVariable("roleId") int roleId) {
			Role role = roleService.getById(roleId);
			List<User> users = userService.findAll();
			model.addAttribute("role",role);
			model.addAttribute("users",users);
			return "backend/role-edit";
		}
		
		@RequestMapping(value = "edit-save", method =RequestMethod.POST)
		public String saveEditRole(final Model model,
				@ModelAttribute("role") Role role) {
			roleService.saveOrUpdate(role);
			return "redirect:list";
		}
		
		@RequestMapping(value = "delete/{roleId}", method = RequestMethod.GET)
		public String deleteRole(final Model model,
				@PathVariable("roleId") int roleId) {
			Role role = roleService.getById(roleId);
			role.setStatus(false);
			roleService.saveOrUpdate(role);
			return "redirect:/admin/role/list";
		}
}
