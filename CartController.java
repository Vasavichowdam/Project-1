import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shopping_Cart.Dao.CartDao;
import com.jsp.Shopping_Cart.Dao.CustomerDao;
import com.jsp.Shopping_Cart.dto.Cart;
import com.jsp.Shopping_Cart.dto.Customer;
import com.jsp.Shopping_Cart.dto.Item;

@Controller
public class CartController 
{
	@Autowired
	CartDao dao;
	
	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItemsFromCart(HttpSession session)
	{
		Customer c = (Customer) session.getAttribute("customerinfo");
		
		Customer customer = custdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		List<Item> items=cart.getItems();
		
		ModelAndView mav = new ModelAndView();
        mav.addObject("itemlist", items);
        mav.addObject("totalprice", cart.getTotalprice());
        mav.setViewName("displaycartitemstocustomer");
        
        return mav;
		
	}

}
