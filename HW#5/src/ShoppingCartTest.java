/***
 * 03/02/2017
 * Kien Nguyen & Thi Nguyen
 * SWE 437 - Software Testing and Maintenance 
 * Java Mocking Tools: Mockito
 */
import static org.mockito.Mockito.*;

/*
 * ShoppingCartTest will test the ShoppingCart (the software component under test)
 * which uses the CartService interface ( which is a seam).
 * We create a mock object of CartService using mockito and test the 
 * communication of the mock cartService with the ShoppingCart
 */
import java.util.ArrayList;

public class ShoppingCartTest {
	private ShoppingCart mycart;
	private CartService cartService;
	
	public static void main(String[] args) {
		ShoppingCartTest theTest = new ShoppingCartTest();
		theTest.setUpTest();
		theTest.testShoppingCart();
	}
	
	public void setUpTest(){
		
		mycart = new ShoppingCart();
		
		//initialize cartService to mock object
		cartService = mock(CartService.class);
		
		//inject my fake service into the shopping cart
		mycart.setCardService(cartService);
		
	}
	
	public void testShoppingCart(){
		/* prepare some products to add to my shopping cart */
		Product p1 = new Product(1001, "T-Shirt 1", 0, 1000);				
		Product p2 = new Product(1002, "T-Shirt 2", 0, 2000);		
		Product p3 = new Product(1002, "T-Shirt 2", 0, 2000);
		
		//in the following lines, we teach our mock object
		int cartId = 10;
		when(cartService.initCart()).thenReturn(cartId);
		when(cartService.addProduct(cartId, p1,4)).thenReturn(4000);				
		when(cartService.addProduct(cartId, p2,2)).thenReturn(8000);				
		when(cartService.adjustQty(cartId, p2, 1)).thenReturn(6000);
		
		when(cartService.addProduct(cartId, p3,-4)).thenThrow(new IllegalArgumentException());	
		
		when(cartService.getProductQty(p1)).thenReturn(4);
		when(cartService.getProductQty(p2)).thenReturn(1);
		when(cartService.getProductPrice(p1)).thenReturn(1000);
		when(cartService.getProductPrice(p2)).thenReturn(2000);
		
		when(cartService.checkOut(cartId, "")).thenReturn(false);				//invalid credit card
		
		// Now we test the ShoppingCart using fake cartService. 
		// As we will give the ShoppingCart object similar data that we used to teach the fake object
		// we expect the ShoppingCart object to give us the same data as the mock return
		System.out.printf("test init cart %s\n", mycart.initCart()==cartId ? "pass" : "fail");
		System.out.printf("test add product %s\n", mycart.addProduct(p1,4)==4000 ? "pass" : "fail");
		System.out.printf("test add another product %s\n", mycart.addProduct(p2,2)==8000 ? "pass" : "fail");
		System.out.printf("test ajust quantity %s\n", mycart.adjustQty(p2,1)==6000 ? "pass" : "fail");
		try {
			mycart.addProduct(p3, -4);
		} catch (IllegalArgumentException e1) {
			System.out.printf("Test exception throw test: pass\n");
		} catch (Exception e2) {
			System.out.printf("Test exception throw test: fail\n"); 
		}
		
		ArrayList<Product> arl = new ArrayList<Product>();
		arl.add(p1);
		arl.add(p2);
		
		mycart.setProductList(arl);
		
		System.out.printf("test %s\n", mycart.getCartValue()==6000 ? "pass" : "fail");
		System.out.printf("test check out: %s\n", mycart.checkOut("") ? "pass" : "fail");
	}
}	