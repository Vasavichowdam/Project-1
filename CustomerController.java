import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shopping_Cart.Dao.CustomerDao;
import com.jsp.Shopping_Cart.dto.Customer;


@Controller
public class CustomerController
{
	
	@Autowired
	CustomerDao cdao;
	
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer()
	{
		Customer c = new Customer();
	
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("Customerobj", c);
		mav.setViewName("Customerform"); //Merchantform.jsp used to register the details//
		
		return mav;
	}
	
	@RequestMapping("/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("Customerobj") Customer c)
	{
		cdao.saveCustomer(c);
		ModelAndView mav =new ModelAndView();
		
		mav.addObject("msg", "Registered successfully");
		mav.setViewName("CustomerLoginForm");
		
		return mav;
	}
	
	@RequestMapping("/CustomerloginValidation")
	public ModelAndView LoginValidation(ServletRequest req, HttpSession session) //login method returns null means if the entered credentioals are invalid//
	{
		String email = req.getParameter("email");
		String pswrd = req.getParameter("pswrd");
		
		Customer c= cdao.login(email, pswrd);
		//ModelAndView mav= new ModelAndView();
		
		if(c!=null)
		{
			ModelAndView mav= new ModelAndView();
			mav.addObject("msg", "Login successfully");//
			mav.setViewName("customerOptions"); //to specify the view name we will use setViewName
			
			session.setAttribute("customerinfo", c);
			
			return mav;
		}
		else
		{
			ModelAndView mav= new ModelAndView();
			mav.addObject("msg", "invalid credentials");
			mav.setViewName("CustomerLoginForm"); //Customer login form is used to login the credentials//
			
			
			return mav;
		}
		
	}

}
