import java.util.*;

class Customer{
    String CustomerName = "";
public Customer(String name ){
    CustomerName = name;
}
    List<Product> cart = new ArrayList<>();
    
    public void addToCart(Product product) {
    	this.cart.add(product);//add each product to cart
    	System.out.println(product+" IS ADDED TO YOUR CART");
    	
		
	}
    
    public void removeFromCart(String product) {
    	for(Product pdt:cart){
            if(pdt.product_name ==product){
                cart.remove(pdt);
                System.out.println(product+" IS REMOVED FROM YOUR CART");
            }
            else System.out.println(product+"IS UNAVAILABLE IN YOUR CART");
        }
    	
		
	}
    public int getPrice(){
        return 1;
    }
    
    public void viewCart() {
        System.out.println("YOUR CART");
        this.cart.forEach(product -> System.out.println("PRODUCT NAME : " + product.product_name +
                                                         "\nPRICE : " + product.price +
                                                         "\nQUANTITY : " + product.quantity));
    }

    public void clearCart() {
    	this.cart.clear();
		
	}
    public List<Product> placeOrder() {
        cart.clear();
    	return this.cart;//return all the product added when orer placed
        
		}
    

}