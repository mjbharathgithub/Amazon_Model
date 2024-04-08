import java.util.HashMap;

class Seller{
    String sellerName;
    HashMap<String,Product> products=new HashMap<>();
    Seller(String sellerName){
        this.sellerName=sellerName;
    }
    public void addProduct(Product p){
        products.put(p.product_name,p);
    }
    public void getProductByName(String productName){
        if(products.containsKey(productName)){
            Product p=products.get(productName);
            System.out.println("PRODUCT NAME : "+p.product_name);
            System.out.println("PRODUCT PRICE : "+p.price);
            System.out.println("PRODUCT NAME : "+p.quantity);
        }else{
            System.out.println("PRODUCT DOES NOT EXIST!");
        }
    }

    public void displayProducts(){
        for(String pName:products.keySet()){
            getProductByName(pName);
            System.out.println();
        }
    }
    public void displayHistory(){

    }



}