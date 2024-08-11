package vn.devpro.javaweb29cuoikhoa.controller.backend;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb29cuoikhoa.controller.BaseController;
import vn.devpro.javaweb29cuoikhoa.model.SaleOrder;
import vn.devpro.javaweb29cuoikhoa.service.SaleOrderService;

@Controller
@RequestMapping("/admin/order/")
public class SaleOrderController extends BaseController{
	@Autowired
	private SaleOrderService saleOrderService;
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String saleOrderList(final Model model) {
		List<SaleOrder> saleOrders = saleOrderService.findAllActive();
		BigDecimal totalSales = BigDecimal.ZERO;
		for(SaleOrder order : saleOrders) {
			totalSales = totalSales.add(order.getTotal());
		}
		model.addAttribute("saleOrders",saleOrders);
		model.addAttribute("totalSales",totalSales);
		return "backend/order-list";
	}

}
