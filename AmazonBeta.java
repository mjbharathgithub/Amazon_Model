import java.util.Scanner;

public class AmazonBeta {
    
    public static void main(String args[]){
        Admin adminObj = new Admin();
        Scanner sc = new Scanner(System.in);
        boolean userFlag = true;
        while(userFlag){
            System.out.println("ENTER YOUR IDENTITY: \n1.ADMIN \n2.SELLER \n3.CUSTOMER ");
            int choosen = sc.nextInt();
            if(choosen == 1){
                System.out.println("ENTER ADMIN PASSWORD: ");
                String pass = sc.nextLine();
                if(adminObj.passCheck(pass)){
                    boolean adminFlag = true;
                    while (adminFlag){
                        System.out.println("\n1.PENDING REQUESTS \n2.APPROVE REQUEST \n3.VIEW INVENTORY \n4.REMOVE SELLER \n5.REMOVE PRODUCT");
                        int adminChoosen = sc.nextInt();
                        if(adminChoosen == 1){
                            adminObj.displayRequest();
                        }
                        else if(adminChoosen ==2){
                            System.out.println("ENTER THE SELLER NAME FOR APPROVAL: ");
                            String as = sc.nextLine();
                            System.out.println("ENTER THE PRODUCT NAME FOR APPROVAL: ");
                            String ap = sc.nextLine();
                            Seller seller = adminObj.findSeller(as);
                            if(seller != null){
                                adminObj.addInventory(seller, ap);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                        }
                        else if(adminChoosen == 3){
                            adminObj.displayInventory();
                        }
                        else if(adminChoosen==4){
                            System.out.println("ENTER SELLERNAME: ");
                            String sname = sc.nextLine();
                            Seller seller = adminObj.findSeller(sname);
                            if(seller != null){
                                adminObj.removeSeller(seller);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                        }
                        else if(adminChoosen == 5){
                            System.out.println("ENTER SELLER NAME: ");
                            String sname = sc.nextLine();
                            System.out.println("ENTER PRODUCT ID: ");
                            int  id = sc.nextInt();
                            Seller seller = adminObj.findSeller(sname);
                            if(seller != null){
                                adminObj.removeProduct(seller, id);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                            
                        }
                        System.out.println("DO YOU WANT TO CONTINUE AS ADMIN (Y/N)? ");
                        String conti = sc.nextLine();
                        adminFlag = conti.equals("Y");
                    }
                }
                else System.out.println("WRONG ADMIN PASSWORD!");
            }
            else if(choosen ==2){
                System.out.println("ENTER SELLER ID: ");
                String sellername = sc.nextLine();
                Seller thisSeller = adminObj.findSeller(sellername);
                if(thisSeller == null){
                    thisSeller = new Seller(sellername);
                    adminObj.addSeller(sellername,thisSeller);
                    System.out.println("HURRAY!,NEW ACCOUNT FOR YOU HAS BEEN CREATED.\nGIVE REQUEST TO ADD PRODUCTS!");
                }
                else System.out.println("WELCOME BACK "+sellername+"!");
                boolean sellerFlag = true;
                while(sellerFlag){
                    System.out.println("\n1.MY PRODUCTS \n2.ADD PRODUCT \n3.TRANSACTIONS HISTORY");
                    int sellerChoosen = sc.nextInt();
                    if(sellerChoosen == 1){
                        adminObj.displayRequest(thisSeller);
                    }
                    else if(sellerChoosen ==2){
                        System.out.println("ENTER NAME OF THE PRODUCT: ");
                        String prod = sc.nextLine();
                        System.out.println("ENTER QUANTITY: ");
                        int quantity = sc.nextInt();
                        System.out.println("ENTER PRICE: ");
                        int price = sc.nextInt();
                        thisSeller.addProduct(prod, price, quantity);
                    }
                    else if(sellerChoosen ==3){
                        thisSeller.displayHistory();
                    }
                    System.out.println("DO YOU WANT TO CONTINUE AS SELLER (Y/N)? ");
                    String conti = sc.nextLine();
                    sellerFlag = conti.equals("Y"); 
                }
            }
            else if(choosen ==3){
                System.out.println("ENTER YOUR NAME : ");
                String cusName = sc.nextLine();
                Customer thisCus = adminObj.findCustomer(cusName);
                if(thisCus == null){
                    thisCus = new Customer(cusName);
                    adminObj.addCustomer(cusName, thisCus);
                    System.out.println("HURRAY!,NEW ACCOUNT FOR YOU HAS BEEN CREATED.\n-> SHOP FROM THE TOPPEST!");
                }
                else System.out.println("WELCOME BACK "+cusName+"!");
                boolean cusFlag = true;
                while(cusFlag){
                    System.out.println("\n1.PRODUCTS \n2.MY CART \n3.CLEAR CART \n4.REMOVE FROM CART \n5.PLACE ORDER");
                    int cusChoosen = sc.nextInt();
                    if(cusChoosen ==1){
                        adminObj.displayInventory();
                    }
                    else if(cusChoosen == 2){
                        thisCus.viewCart();
                    }
                    else if(cusChoosen == 3){
                        thisCus.clearCart();
                    }
                    else if(cusChoosen == 4){
                        System.out.println("ENTER YOUR PRODUCT TO BE REMOVED : ");
                        String remPrd = sc.nextLine();
                        thisCus.removeFromCart(remPrd);
                    }
                    else if(cusChoosen ==5){
                        System.out.println("ARE YOU SURE TO PLACE ORDER (Y/N) ?");
                        String sure = sc.nextLine();
                        if(sure=="Y"){
                            int price = thisCus.getPrice();
                            System.out.println("ONE STEP BEFORE ORDER PLACEMENT! \n PAYABLE AMOUNT : INR."+price+"/-");
                            System.out.println("ENTER TO BE PAID :");
                            int amount = sc.nextInt();
                            if(amount ==price){
                                adminObj.order(thisCus.placeOrder());
                            }
                            else System.out.println("INVALID AMOUNT ENTERED!");
                        }
                    }
                    System.out.println("DO YOU WANT TO CONTINUE AS CUSTOMER (Y/N)? ");
                    String conti = sc.nextLine();
                    cusFlag = conti.equals("Y");
                }
            }
            
            System.out.println("DO YOU WANT TO CONTINUE (Y/N)? ");
            String conti = sc.nextLine();
            userFlag = conti.equals("Y"); 
        }    
        
    }
}
