/***
 * 03/02/2017
 * Kien Nguyen & Thi Nguyen
 * SWE 437 - Software Testing and Maintenance 
 * Using Mockito Java Mocking Tools
 */
public interface CartService {
	
	public int initCart();
	
	//return the value in cents of the cart after adding, remove, adjust, clear cart
	//amount of cart represented in cents (type int)
	public int addProduct(int cartId,Product p, int qty);								
	public int removeProduct(int cartId,Product p);				
	public int adjustQty(int cartId, Product p, int newQty);	
	public int clearCart(int cartId);
	public int getProductQty(Product p);
	public int getProductPrice(Product p);
	
	//success return true, failure return false, if credit card is empty, return false
	public boolean checkOut(int cartId, String creditcard);				
	public CartService getInstance();
}