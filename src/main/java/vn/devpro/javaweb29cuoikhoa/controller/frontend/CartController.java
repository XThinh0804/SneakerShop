package vn.devpro.javaweb29cuoikhoa.controller.frontend;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb29cuoikhoa.model.SaleOrder;
import vn.devpro.javaweb29cuoikhoa.model.SaleOrderProduct;
import vn.devpro.javaweb29cuoikhoa.model.User;
import vn.devpro.javaweb29cuoikhoa.service.SaleOrderService;
import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.dto.Cart;
import vn.devpro.javaweb29cuoikhoa.dto.CartProduct;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.service.ProductService;

@Controller
public class CartController extends BaseController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(final Model model, @RequestBody CartProduct cartProduct,
			final HttpServletRequest request) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		if (cartProduct.getQuantity().intValue() <= 0) {
			jsonResult.put("message", "Số lượng không hợp lệ");
		} else {// Sản phẩm hợp lệ, thêm vào giỏ hàng
				// Kiểm tra xem có giỏ hàng hay chưa
			Cart cart = null;
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") == null) {// chưa tạo giỏ hàng
				cart = new Cart();
				session.setAttribute("cart", cart);
			}

			// Lấy giỏ hàng để xử lý (Thêm sản phẩm)
			cart = (Cart) session.getAttribute("cart");

			// Kiểm tra xem sản phẩm có trong giỏ hàng hay chưa
			int index = cart.findProductById(cartProduct.getId());
			if (index != -1) {// Sản phẩm đã có trong giỏ hàng
				cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
			} else {
				// Lấy sản phẩm trong db product
				Product dbproduct = productService.getById(cartProduct.getId());
				cartProduct.setAvatar(dbproduct.getAvatar());
				cartProduct.setPrice(dbproduct.getPrice());
				// Thêm sản phẩm vào giỏ hàng
				cart.getCartProducts().add(cartProduct);
			}
			jsonResult.put("code", "200");
			jsonResult.put("message", "Đã thêm sản phẩm vào giỏ hàng");
			jsonResult.put("totalCartProducts", cart.totalCartProduct());
		}
		return ResponseEntity.ok(jsonResult);
	}
	public StringBuilder toCurrency(BigDecimal num) {
		StringBuilder str = new StringBuilder("" + num.longValue());
		int i = str.length();
		int j = 0;
		while (i > 1) {
			i--;
			j++;
			if (j % 3 == 0) {
				str.insert(i, ",");
			}
		}
		return str;
	}
	@RequestMapping(value = "/cart-view")
	public String cartView(final Model model, final HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") != null) {// Có giỏ hàng
			Cart cart = (Cart) session.getAttribute("cart");
			String message = "Có " + cart.getCartProducts().size() + " loại sản phẩm với tổng cộng "
					+ cart.totalCartProduct() + " sản phẩm";
			model.addAttribute("message", message);
			BigDecimal totalCartPrice = cart.totalCartPrice();
			model.addAttribute("totalCartProducts", cart.totalCartProduct());
			model.addAttribute("totalCartPrice", totalCartPrice);
		}
		return "frontend/cart-view";
	}

	@RequestMapping(value = "/update-product-quantity", method = RequestMethod.POST)
	ResponseEntity<Map<String, Object>> updateProductQuantity(@RequestBody CartProduct cartProduct,
			final HttpServletRequest request) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") != null) {
			Cart cart = (Cart) session.getAttribute("cart");
			int index = cart.findProductById(cartProduct.getId());
			if (index != -1) {
				// Kiểm tra trường hợp bấm nút - (giảm)
				if (cartProduct.getQuantity().intValue() == -1) {
					if (cart.getCartProducts().get(index).getQuantity().intValue() > 1) {
						cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
					}
				} else {// Bấm nút +
					cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
				}
			}
			jsonResult.put("newQuantity", cart.getCartProducts().get(index).getQuantity());
			jsonResult.put("totalPrice", toCurrency(cart.getCartProducts().get(index).totalPrice()));
			jsonResult.put("totalCartProducts", cart.totalCartProduct());
			jsonResult.put("totalCartPrice", toCurrency(cart.totalCartPrice()));
			jsonResult.put("productId", cartProduct.getId());
		}
		return ResponseEntity.ok(jsonResult);
	}
	@Autowired
	private SaleOrderService saleOrderService;
	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody User user, HttpServletRequest request) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		if (user.getName().trim() == null || user.getName().length() <= 0) {
			jsonResult.put("message", "Bạn chưa nhập tên!");
		} else if (user.getMobile().trim() == null || user.getMobile().trim().length() < 10) {
			jsonResult.put("message", "Bạn chưa nhập đúng số điện thoại!");
		} else {
			// Lấy giỏ hàng
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") == null) {
				jsonResult.put("message", "Bạn chưa có giỏ hàng");
			} else {
				Cart cart = (Cart) session.getAttribute("cart");
				SaleOrder saleOrder = new SaleOrder();
				for (CartProduct cartProduct : cart.getCartProducts()) {
					// Lấy sản phẩm trong db
					Product product = productService.getById(cartProduct.getId());
					SaleOrderProduct saleOrderProduct = new SaleOrderProduct();
					saleOrderProduct.setProduct(product);
					saleOrderProduct.setQuantity(cartProduct.getQuantity().intValue());
					saleOrderProduct.setProduct_name(product.getName());
					saleOrder.addRelationalSaleOrderProduct(saleOrderProduct);
				}
				// Lưu đơn hàng vào db
				Calendar cal = Calendar.getInstance();
				String code = user.getMobile() + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH)
						+ cal.get(Calendar.DATE) + cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE)
						+ cal.get(Calendar.SECOND);
				saleOrder.setCode(code);
				user.setId(1);
				saleOrder.setUser(user);
				saleOrder.setCreateDate(new Date());
				saleOrder.setTotal(cart.totalCartPrice());
				saleOrder.setCustomer_name(user.getName());
				saleOrder.setCustomer_mobile(user.getMobile());
				saleOrder.setCustomer_email(user.getEmail());
				saleOrder.setCustomer_address(user.getAddress());
				saleOrder.setCreateDate(new Date());
				saleOrderService.saveOrder(saleOrder);
				jsonResult.put("message", "Giỏ hàng của bạn đã được lưu");
				//Xóa giỏ hàng
				
				cart = new Cart();
				session.setAttribute("cart", cart);
			}
		}
		return ResponseEntity.ok(jsonResult);
	}
}
