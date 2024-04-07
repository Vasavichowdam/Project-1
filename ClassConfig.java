import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan(basePackages ="com")  //in the place of component we can use repository and service
@Configuration


public class ClassConfig 
{
	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setSuffix(".jsp");// set suffix used to specifies the view technology//
		
		resolver.setPrefix("/");// set prefix used to specifies the view(jsp) files//
		
		return resolver;
	}
	
	@Bean
	public EntityManagerFactory getEMF()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		return emf;
	}
