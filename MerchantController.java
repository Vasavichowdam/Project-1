import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shopping_Cart.Dao.MerchantDao;
import com.jsp.Shopping_Cart.dto.Merchant;


@Controller
public class MerchantController 
{
	
	@Autowired
	MerchantDao dao;
	
	@RequestMapping("/addMerchant")
	public ModelAndView addMerchant()
	{
		Merchant m=new Merchant();
	
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("merchantobj", m);
		mav.setViewName("Merchantform"); //Merchantform.jsp used to register the details//
		
		return mav;
	}
	
	@RequestMapping("/saveMerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj") Merchant m)
	{
		dao.saveMerchant(m);
		ModelAndView mav =new ModelAndView();
		
		mav.addObject("message", "data saved successfully");
		mav.setViewName("Menu");
		
		return mav;
	}
	
	@RequestMapping("/LoginValidation")
	public ModelAndView Login(ServletRequest req, HttpSession session) //login method returns null means if the entered credentioals are invalid//
	{
		String email = req.getParameter("email");
		String pswrd = req.getParameter("pswrd");
		
		Merchant m=dao.login(email, pswrd);
		ModelAndView mav= new ModelAndView();
		
		if(m!=null)
		{
			mav.addObject("msg", "Successfully loged in");
			mav.setViewName("MerchantOptions");
			
			session.setAttribute("merchantinfo", m);
			
			return mav;
		}
		else
		{
			mav.addObject("msg", "invalid credentials");
			mav.setViewName("MerchantLoginForm"); //Merchant login form is used to login the credentials//
			
			
			return mav;
		}
		
	}
}
