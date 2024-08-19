package vn.devpro.javaweb29cuoikhoa.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.devpro.javaweb29cuoikhoa.dto.Cart;
import vn.devpro.javaweb29cuoikhoa.model.User;

@Controller
public class BaseController {
	@ModelAttribute("totalCartProducts")
	public BigInteger totalCartProducts(final HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") == null) {//Không có giỏ hàng
			return BigInteger.ZERO;
		}else {
			//Có giỏ hàng
			Cart cart =(Cart) session.getAttribute("cart");
			return cart.totalCartProduct();
		}
		
	}
	@ModelAttribute("loginedUser")
	public User getLoginedUser() {
		Object loginedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(loginedUser != null && loginedUser instanceof UserDetails) {
			User user = (User) loginedUser;
			return user;
		}
		return new User();
	}
	//Kiểm tra đã login hay chưa?
	@ModelAttribute("isLogined")
	public boolean isLogined() {
		Object loginedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(loginedUser != null && loginedUser instanceof UserDetails) {
			return true;
		}
		return false;
	}
}
