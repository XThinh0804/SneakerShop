package vn.devpro.javaweb29cuoikhoa.controller.backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.dto.Jw29Contant;
import vn.devpro.javaweb29cuoikhoa.dto.SearchModel;
import vn.devpro.javaweb29cuoikhoa.model.Category;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.model.ProductImage;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.CategoryService;
import vn.devpro.javaweb29cuoikhoa.service.ProductImageService;
import vn.devpro.javaweb29cuoikhoa.service.ProductService;
import vn.devpro.javaweb29cuoikhoa.service.UserService;

@Controller
@RequestMapping("/admin/product/")
public class ProductController extends BaseController implements Jw29Contant{
	//khai báo service
		@Autowired
		private ProductService productService;
		@Autowired
		private CategoryService categoryService;
		@Autowired
		private UserService userService;
		@Autowired
		private ProductImageService productImageService;
	@RequestMapping(value = "list", method =RequestMethod.GET)
	public String viewProducts(final Model model,
			final HttpServletRequest request) {
		List<Category> categories = categoryService.findAllActive();
		model.addAttribute("categories",categories);
		SearchModel productSearch = new SearchModel();
		//Thông tin tìm kiếm theo status
		productSearch.setStatus(2);//Ban đầu luôn là all
		String status = request.getParameter("status");
		if(!StringUtils.isEmpty(status)) {
			productSearch.setStatus(Integer.parseInt(status));
		}
		//Thông tin tìm kiếm theo category
		productSearch.setCategoryId(0);//All Category
		String categoryId = request.getParameter("categoryId");
		if(!StringUtils.isEmpty(categoryId)) {
			productSearch.setCategoryId(Integer.parseInt(categoryId));
		}
		//Thông tin tìm kiếm theo keyword
		productSearch.setKeyword(null);
		String keyword = request.getParameter("keyword");
		if(keyword != null && !StringUtils.isEmpty(keyword)) {
			productSearch.setKeyword(keyword);
		}
		//Tìm từ ngày đến ngày
		productSearch.setBeginDate(null);
		productSearch.setEndDate(null);
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		if(!StringUtils.isEmpty(beginDate) && !StringUtils.isEmpty(endDate)) {
			productSearch.setBeginDate(beginDate);
			productSearch.setEndDate(endDate);
		}
		
		List<Product> allProducts = productService.searchProduct(productSearch);
		//Phân trang
		productSearch.setTotalItems(allProducts.size());
		productSearch.setCurrentPage(1);//Ban đầu luôn là 1
		//Kiểm tra bấm nút chọn trang
		if(!StringUtils.isEmpty(request.getParameter("currentPage"))) {
			productSearch.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}
		//Số bản ghi trên một trang
		productSearch.setSizeOfPage(SIZE_OF_PAGE);
		//Tổng số trang
		int totalPages = allProducts.size() / SIZE_OF_PAGE;
		if(allProducts.size() % SIZE_OF_PAGE != 0 ) {
			totalPages++;
		}
		productSearch.setTotalPages(totalPages);
		//Lấy danh sách trang hiện tại để hiển thị
		int firstIndex = (productSearch.getCurrentPage() - 1)*SIZE_OF_PAGE;
		int lastIndex = firstIndex + SIZE_OF_PAGE;
		if(lastIndex > allProducts.size()) {
			lastIndex = allProducts.size();
		}
		List<Product> products = allProducts.subList(firstIndex, lastIndex);
		model.addAttribute("products",products);
		model.addAttribute("productSearch",productSearch);
		return "backend/product-list";
	}
	
	@RequestMapping(value = "add", method =RequestMethod.GET)
	public String addProduct(final Model model) {
		List<User> users = userService.findAllActive();
		List<Category> categories = categoryService.findAllActive();
		Product product = new Product();
		product.setCreateDate(new Date());
		model.addAttribute("product",product);
		model.addAttribute("categories",categories);
		model.addAttribute("users",users);
		return "backend/product-add";
	}
	
	@RequestMapping(value = "add-save", method =RequestMethod.POST)
	public String saveAddProduct(final Model model,
			@ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles) 
			throws IOException {
		productService.saveProduct(product,avatarFile,imageFiles);
		return "redirect:add";
	}
	@RequestMapping(value = "edit/{productId}", method =RequestMethod.GET)
	public String editProduct(final Model model,
			@PathVariable("productId") int productId) {
		Product product = productService.getById(productId);
		List<User> users = userService.findAll();
		List<Category> categories = categoryService.findAllActive();
		product.setUpdateDate(new Date());
		model.addAttribute("product",product);
		model.addAttribute("users",users);
		model.addAttribute("categories",categories);
		return "backend/product-edit";
	}
	@RequestMapping(value = "edit-save", method =RequestMethod.POST)
	public String saveEditProduct(final Model model,
			@ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles)
					throws IOException{
		productService.saveEditProduct(product,avatarFile,imageFiles);
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(final Model model,
			@PathVariable("productId") int productId) {
		Product product = productService.getById(productId);
		if(product.getAvatar() != null && !product.getAvatar().isEmpty()) {
			String path = FOLDER_UPLOAD + product.getAvatar();
			File file = new File(path);
			file.delete();
		}
		
		//Xóa các file ảnh trong thư mục Product/Image
		List<ProductImage> productImages = productImageService.getImageByProductId(productId);
		for(ProductImage productImage : productImages) {
			String path = FOLDER_UPLOAD + productImage.getPath();
			File file = new File(path);
			file.delete();
		}
		productService.delete(product);
		return "redirect:/admin/product/list";
	}
	//Làm thêm inactive product
}
