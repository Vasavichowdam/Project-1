import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shopping_Cart.Dao.CartDao;
import com.jsp.Shopping_Cart.Dao.CustomerDao;
import com.jsp.Shopping_Cart.Dao.OrderDao;
import com.jsp.Shopping_Cart.Dao.ProductDao;
import com.jsp.Shopping_Cart.dto.Cart;
import com.jsp.Shopping_Cart.dto.Customer;
import com.jsp.Shopping_Cart.dto.Item;
import com.jsp.Shopping_Cart.dto.Orders;
import com.jsp.Shopping_Cart.dto.Product;

@Controller
public class OrdersController 
{
	@Autowired
	OrderDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cartdao;
	
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder()
	{
		Orders o = new Orders();
		ModelAndView mav = new ModelAndView();  
		
		mav.addObject("ordersobj", o);
		mav.setViewName("ordersform");
		
		return mav;
		
	}
	
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o, HttpSession session)
	{
		Customer c = (Customer) session.getAttribute("customerinfo"); //first customer object used to login customer
		Customer customer = cdao.findCustomerById(c.getId()); //second customer object to get updated cart details
		Cart cart = customer.getCart();
		
		List<Item> items = cart.getItems();
		                 //whenever quantity is greater than the stock we should send a msg like item removed from the stock
		
		
		List<Item> itemslist = new ArrayList<>();
		
		List<Item> itemswithGreaterQuantity = new ArrayList<>();
		
		for(Item i : items)
		{
			Product p= pdao.findProductById(i.getP_id());
			
			if(i.getQuantity() < p.getStock()) {
			itemslist.add(i);
			p.setStock(p.getStock() - i.getQuantity());
			
			pdao.updateProduct(p);
		 } else {
				    itemswithGreaterQuantity.add(i);
			}
		
	}
	  o.setItems(itemslist);
	   double totalpriceoforder = 0;
	   
	   for(Item i : items)
	   {
		   totalpriceoforder = totalpriceoforder + i.getPrice();
	   }
	   o.setTotalprice(totalpriceoforder);
	   
	   cart.setItems(itemswithGreaterQuantity);
	   
	   double totalprice=0; 
	   for(Item i :itemswithGreaterQuantity)
	   {
		   totalprice = totalprice + i.getPrice();
	   }
	   
	   cart.setTotalprice(totalprice);
	  
	  List<Orders> orders = customer.getOrders();
	  
	  if(orders.size()>0)
	  {
		  orders.add(o);
		  customer.setOrders(orders);
	  }
	  else
	  {
		  List<Orders> orders1 = new ArrayList<>() ;
		  orders1.add(o);
		  customer.setOrders(orders1);
		  
	  }
	  customer.setCart(cart);
	  cartdao.updateCart(cart);
	  dao.saveOrder(o);
	  cdao.updateCustomer(customer);
	  
	  ModelAndView mav = new ModelAndView();  
		
		mav.addObject("msg", "order placed successfully");
		mav.addObject("orderdetails", o);
		mav.setViewName("CustomerBill");
		
		return mav;
	  
	  
	}
}
