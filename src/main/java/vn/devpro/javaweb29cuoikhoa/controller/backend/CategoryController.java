package vn.devpro.javaweb29cuoikhoa.controller.backend;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import vn.devpro.javaweb29cuoikhoa.model.Category;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.CategoryService;
import vn.devpro.javaweb29cuoikhoa.service.UserService;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController extends BaseController implements Jw29Contant{
	//khai báo service
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "list", method =RequestMethod.GET)
	public String viewCategories(final Model model,final HttpServletRequest request) {
		List<Category> categories = new ArrayList<Category>();
//		categories = categoryService.findAll();
		categories = categoryService.findAllActive();//Chỉ hiện thị những category status=true
		//Phân trang
		SearchModel categoryPagination = new SearchModel();
		categoryPagination.setTotalItems(categories.size());
		categoryPagination.setCurrentPage(1);//Ban đầu luôn là 1
		//Kiểm tra bấm nút chọn trang
		if(!StringUtils.isEmpty(request.getParameter("currentPage"))) {
			categoryPagination.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}
		//Số bản ghi trên một trang
		categoryPagination.setSizeOfPage(SIZE_OF_PAGE);
		//Tổng số trang
		int totalPages = categories.size() / SIZE_OF_PAGE;
		if(categories.size() % SIZE_OF_PAGE != 0 ) {
			totalPages++;
		}
		categoryPagination.setTotalPages(totalPages);
		//Lấy danh sách trang hiện tại để hiển thị
		int firstIndex = (categoryPagination.getCurrentPage() - 1)*SIZE_OF_PAGE;
		int lastIndex = firstIndex + SIZE_OF_PAGE;
		if(lastIndex > categories.size()) {
			lastIndex = categories.size();
		}
		List<Category> allCategories = categories.subList(firstIndex, lastIndex);
		model.addAttribute("categories",allCategories);
		model.addAttribute("categoryPagination",categoryPagination);
		return "backend/category-list";
	}
	
	@RequestMapping(value = "add", method =RequestMethod.GET)
	public String addCategories(final Model model) {
		List<User> users = userService.findAll();
		Category category = new Category();
		category.setCreateDate(new Date());
		model.addAttribute("category",category);
		model.addAttribute("users",users);
		return "backend/category-add";
	}
	
	@RequestMapping(value = "add-save", method =RequestMethod.POST)
	public String saveAddCategories(final Model model,
			@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdate(category);
		return "redirect:add";
	}
	
	@RequestMapping(value = "edit/{categoryId}", method =RequestMethod.GET)
	public String editCategories(final Model model,
			@PathVariable("categoryId") int categoryId) {
		Category category = categoryService.getById(categoryId);
		category.setUpdateDate(new Date());
		List<User> users = userService.findAll();
		model.addAttribute("category",category);
		model.addAttribute("users",users);
		return "backend/category-edit";
	}
	
	@RequestMapping(value = "edit-save", method =RequestMethod.POST)
	public String saveEditCategories(final Model model,
			@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdate(category);
		return "redirect:list";
	}
	
//	@RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
//	public String deleteCategories(final Model model,
//			@PathVariable("categoryId") int categoryId) {
//		
//		categoryService.deleteCategory(categoryId);
//		return "backend/category-list";
//	}
	
	//Inactive:Bthg k nên xóa dữ liệu chỉ nên ẩn dữ liệu
	@RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
	public String deleteCategories(final Model model,
			@PathVariable("categoryId") int categoryId) {
		
		Category category = categoryService.getById(categoryId);
		category.setStatus(false);
		categoryService.saveOrUpdate(category);
		return "redirect:/admin/category/list";
	}
}
