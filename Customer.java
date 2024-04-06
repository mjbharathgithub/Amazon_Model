import java.util.*;
class Customer{
    String CustomerName = "";
public Customer(String name ){
    CustomerName = name;
}
    List<Product> cart = new ArrayList<>();
    
    public void addToCart(Product product) {
    	cart.add(product);//add each product to cart
		
	}
    
    public List<Product> placeOrder() {
    	return this.cart;//return all the product added when orer placed
		}
    

}