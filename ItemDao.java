import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shopping_Cart.dto.Item;


@Repository
public class ItemDao 
{
	@Autowired
    EntityManagerFactory emf;
	
	public void saveItem(Item item)
	{
		EntityManager em=emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    et.begin();
	    em.persist(item);
	    et.commit();
	    
	 }
	
	public void updateItem(Item i)
	{
		EntityManager em=emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    et.begin();
	    em.merge(i);
	    et.commit();
	}
	
	public void deleteItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    Item i = em.find(Item.class, id);
	    
	    et.begin();
	    em.remove(i);
	    et.commit();
	}
	
	public Item findItemById( int id)
	{
		EntityManager em=emf.createEntityManager();
		
	    //EntityTransaction et = em.getTransaction();
	    
	    Item i = em.find(Item.class, id);
	    
	    if(i!=null)
		{
			return i;
		}
		else
		{
			return null; //We have to understand that there is no data in the database
		}
	    
	 }


}
