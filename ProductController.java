import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shopping_Cart.Dao.MerchantDao;
import com.jsp.Shopping_Cart.Dao.ProductDao;
import com.jsp.Shopping_Cart.dto.Merchant;
import com.jsp.Shopping_Cart.dto.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDao dao;
	@Autowired
	MerchantDao mdao;

	@RequestMapping("/addProduct")
	public ModelAndView addProduct()
	{
		Product p = new Product();
	
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("ProductObj", p);
		mav.setViewName("Productform"); //
		
		return mav;
}
	
	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("ProductObj") Product p, HttpSession session)
	{
		Merchant merchant =(Merchant)session.getAttribute("merchantinfo");
		List<Product> products = merchant.getProducts();
		
		if(products.size() > 0)
		{
			products.add(p);
			merchant.setProducts(products);
		}
		else
		{
			List<Product> productslist = new ArrayList<Product>();
			productslist.add(p);
			
			merchant.setProducts(productslist);
		}
		
 		dao.saveProduct(p);
 		
 		mdao.updateMerchant(merchant);
 		
		ModelAndView mav =new ModelAndView();
		
		mav.addObject("message", "data saved successfully");
		
		mav.setViewName("MerchantOptions");
		
		return mav;
	}
	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session)
	{
		Merchant merchant = (Merchant)session.getAttribute("Merchantinfo");
		
		Merchant m = mdao.deleteProductFromMerchant(merchant.getId(), id);
		
		mdao.updateMerchant(m);
		dao.deleteProductById(id);
		
		session.setAttribute("merchantinfo", m);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewAllproducts");
		return mav;
	}
	
	@RequestMapping("/displayProducts")
	public ModelAndView displayProducts()
	{
		List<Product> products = dao.fetchAllProducts();
		ModelAndView mav =new  ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproductstocustomer");
		
		return mav;
	}
	
	@RequestMapping("/displayproductsbybrand")
	public ModelAndView displayProductsByBrand(ServletRequest req)
	{
		String brand = req.getParameter("brand");
		List<Product> products = dao.fetchProductByBrand(brand);
		ModelAndView mav =new  ModelAndView();
		
		mav.addObject("productslist", products);
		mav.setViewName("viewallproductstocustomer");
		
		return mav;
	}	
	
	
	
}
