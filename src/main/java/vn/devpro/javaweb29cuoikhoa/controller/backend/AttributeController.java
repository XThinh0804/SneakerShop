package vn.devpro.javaweb29cuoikhoa.controller.backend;

import java.util.Date;
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
import vn.devpro.javaweb29cuoikhoa.model.Attribute;
import vn.devpro.javaweb29cuoikhoa.model.Category;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.AttributeService;
import vn.devpro.javaweb29cuoikhoa.service.ProductService;
import vn.devpro.javaweb29cuoikhoa.service.UserService;

@Controller
@RequestMapping("/admin/attribute/")
public class AttributeController extends BaseController implements Jw29Contant {
	@Autowired
	private AttributeService attributeService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String ListAttribute(final Model model, final HttpServletRequest request) {
		List<Attribute> attributes = attributeService.findAllActive();
		// Phân trang
		SearchModel attributePagination = new SearchModel();
		attributePagination.setTotalItems(attributes.size());
		attributePagination.setCurrentPage(1);// Ban đầu luôn là 1
		// Kiểm tra bấm nút chọn trang
		if (!StringUtils.isEmpty(request.getParameter("currentPage"))) {
			attributePagination.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}
		// Số bản ghi trên một trang
		attributePagination.setSizeOfPage(SIZE_OF_PAGE);
		// Tổng số trang
		int totalPages = attributes.size() / SIZE_OF_PAGE;
		if (attributes.size() % SIZE_OF_PAGE != 0) {
			totalPages++;
		}
		attributePagination.setTotalPages(totalPages);
		// Lấy danh sách trang hiện tại để hiển thị
		int firstIndex = (attributePagination.getCurrentPage() - 1) * SIZE_OF_PAGE;
		int lastIndex = firstIndex + SIZE_OF_PAGE;
		if (lastIndex > attributes.size()) {
			lastIndex = attributes.size();
		}
		List<Attribute> allAttribute = attributes.subList(firstIndex, lastIndex);
		model.addAttribute("attributes", allAttribute);
		model.addAttribute("attributePagination",attributePagination);
		return "backend/attribute-list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addAttribute(final Model model) {
		List<User> users = userService.findAllActive();
		List<Product> products = productService.findAllActive();
		Attribute attribute = new Attribute();
		attribute.setCreateDate(new Date());
		model.addAttribute("attribute", attribute);
		model.addAttribute("users", users);
		model.addAttribute("products", products);
		return "backend/attribute-add";
	}

	@RequestMapping(value = "add-save", method = RequestMethod.POST)
	public String saveAddAttribute(final Model model, @ModelAttribute("Attribute") Attribute attribute) {
		attributeService.saveOrUpdate(attribute);
		return "redirect:add";
	}
	@RequestMapping(value = "edit/{attributeId}", method =RequestMethod.GET)
	public String editAttribute(final Model model,
			@PathVariable("attributeId") int attributeId) {
		Attribute attribute = attributeService.getById(attributeId);
		attribute.setUpdateDate(new Date());
		List<User> users = userService.findAllActive();
		List<Product> products = productService.findAllActive();
		model.addAttribute("products",products);
		model.addAttribute("users", users);
		model.addAttribute("attribute",attribute);
		return "backend/attribute-edit";
	}
	
	@RequestMapping(value = "edit-save", method =RequestMethod.POST)
	public String saveEditAttribute(final Model model,
			@ModelAttribute("attribute") Attribute attribute) {
		attributeService.saveOrUpdate(attribute);
		return "redirect:list";
	}
	@RequestMapping(value = "delete/{attributeId}", method = RequestMethod.GET)
	public String deleteAttribute(final Model model,
			@PathVariable("attributeId") int attributeId) {
		
		Attribute attribute = attributeService.getById(attributeId);
		attribute.setStatus(false);
		attributeService.saveOrUpdate(attribute);
		return "redirect:/admin/attribute/list";
	}
}
