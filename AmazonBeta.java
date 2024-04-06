package AmazonBeta;

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
                        System.out.println("\n1.PENDING REQUESTS \n2.VIEW INVENTORY \n3.REMOVE SELLER \n4.REMOVE PRODUCT");
                        int adminChoosen = sc.nextInt();
                        if(adminChoosen == 1){
                            adminObj.displayRequest();
                        }
                        else if(adminChoosen == 2){
                            adminObj.displayInventory();
                        }
                        else if(adminChoosen==3){
                            System.out.println("ENTER SELLERNAME: ");
                            String sname = sc.nextLine();
                            adminObj.removeSeller(sname);
                        }
                        else if(adminChoosen == 4){
                            System.out.println("ENTER SELLER NAME: ");
                            String sname = sc.nextLine();
                            System.out.println("ENTER PRODUCT NAME: ");
                            String pname = sc.nextLine();
                            adminObj.removeProduct(sname,pname);
                        }
                        System.out.println("DO YOU WANT TO CONTINUE (Y/N)? ");
                        String conti = sc.nextLine();
                        adminFlag = conti.equals("Y");
                    }
                }
                else System.out.println("WRONG ADMIN PASSWORD!");
            }
        }    
        
    }
}
