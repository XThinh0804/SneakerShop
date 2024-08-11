package vn.devpro.javaweb29cuoikhoa.controller.frontend;

import java.io.IOException;
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

import vn.devpro.javaweb29cuoikhoa.model.ProductImage;
import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.dto.SearchModel;
import vn.devpro.javaweb29cuoikhoa.model.Attribute;
import vn.devpro.javaweb29cuoikhoa.model.Category;
import vn.devpro.javaweb29cuoikhoa.model.Contact;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.service.AttributeService;
import vn.devpro.javaweb29cuoikhoa.service.CategoryService;
import vn.devpro.javaweb29cuoikhoa.service.ContactService;
import vn.devpro.javaweb29cuoikhoa.service.ProductImageService;
import vn.devpro.javaweb29cuoikhoa.service.ProductService;
@Controller
public class HomeController extends BaseController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private AttributeService attributeService;
	//Action method cho index view
	@RequestMapping(value="/index",method =RequestMethod.GET)
	public String home(final Model model) {
		List<Category> category = categoryService.findAllActive();
		model.addAttribute("categories",category);
		List<Product> productIsHots = productService.findAllActiveIsHot();
		model.addAttribute("productIsHots",productIsHots);
		return "frontend/index";
	}
	@RequestMapping(value="/product-detail/{productId}",method =RequestMethod.GET)
	public String productDetail(final Model model,
			@PathVariable("productId") int productId) {
		List<Category> category = categoryService.findAllActive();
		List<Attribute> attributes = attributeService.getAttributeByProductId(productId);
		model.addAttribute("categories",category);
		//Lấy sản phẩm trong db
		Product product = productService.getById(productId);
		List<ProductImage> productImages = productImageService.getImageByProductId(productId);
		model.addAttribute("product",product);
		model.addAttribute("productImages",productImages);
		model.addAttribute("attributes", attributes);
		return "frontend/product-detail";
	}
	@RequestMapping(value="/shop",method =RequestMethod.GET)
	public String productShop(final Model model,
			final HttpServletRequest request) {
		List<Category> categories = categoryService.findAllActive();
		model.addAttribute("categories", categories);
		SearchModel productSearch = new SearchModel();
//		Thông tin tìm kiếm theo price
//		productSearch.setPrice(0);//Ban đầu luôn là all
//		String price = request.getParameter("checkPrice");
//		if(!StringUtils.isEmpty(price)) {
//			productSearch.setStatus(Integer.parseInt(price));
//			System.out.println(productSearch.getPrice());
//		}
//		//Thông tin tìm kiếm theo keyword
		productSearch.setKeyword(null);
		String keyword = request.getParameter("keyword");
		if(keyword != null && !StringUtils.isEmpty(keyword)) {
			productSearch.setKeyword(keyword);
		}
		List<Product> allProducts = productService.searchShopProduct(productSearch);
		//Phân trang
		productSearch.setTotalItems(allProducts.size());
		productSearch.setCurrentPage(1);//Ban đầu luôn là 1
		//Kiểm tra bấm nút chọn trang
		if(!StringUtils.isEmpty(request.getParameter("currentPage"))) {
			productSearch.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}
		//Số bản ghi trên một trang
		productSearch.setSizeOfPage(9);
		//Tổng số trang
		int totalPages = allProducts.size() / 9;
		if(allProducts.size() % 9 != 0 ) {
			totalPages++;
		}
		productSearch.setTotalPages(totalPages);
		//Lấy danh sách trang hiện tại để hiển thị
		int firstIndex = (productSearch.getCurrentPage() - 1)*9;
		int lastIndex = firstIndex + 9;
		if(lastIndex > allProducts.size()) {
			lastIndex = allProducts.size();
		}
		List<Product> products = allProducts.subList(firstIndex, lastIndex);
//		List<Product> products = productService.findAllActive();
		model.addAttribute("products",products);
		model.addAttribute("productSearch",productSearch);
		return "frontend/shop";
	}
	@RequestMapping(value="/contact",method =RequestMethod.GET)
	public String contactView(final Model model) {
		List<Category> category = categoryService.findAllActive();
		Contact contact = new Contact();
		model.addAttribute("contact",contact);
		model.addAttribute("categories",category);
		return "frontend/contact";
	}
	@RequestMapping(value="/contact/send",method =RequestMethod.POST)
	public String contactSend(final Model model,
			@ModelAttribute("contact") Contact contact) throws IOException {
		contactService.saveOrUpdate(contact);
		String message = "Cảm ơn "+contact.getName() +" đã liên hệ! Shop sẽ sớm phản hồi cho bạn!";
		List<Category> category = categoryService.findAllActive();
		model.addAttribute("message",message);
		model.addAttribute("categories",category);
		return "frontend/contact";
	}
}
