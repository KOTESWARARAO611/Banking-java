package ATM;
import java.util.Scanner;
public class Services extends NewAccount{
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String VIO = "\u001B[35m";
    public static final String SKY = "\u001B[36m";
    public static final long id=123454321;
    public static final String password="Admin@123.";
    public static boolean b=true;
    NewAccount nc[]=new NewAccount[100];
    int usercount=0;
    //admin login
    public void adminlogin(Scanner sc) {
    	int count=0;
    	while(count<3) {
    		System.out.println(SKY+"Enter admin ID: "+RESET);
        	long inputid=sc.nextLong();
        	System.out.println(SKY+"Enter password: "+RESET);
        	String inputpassword=sc.next();
        	if(id==inputid && password.equals(inputpassword)) {
        		System.out.println(GREEN+"Login successfull "+RESET);
        		if(admiservices(sc)==1) {
        			return;
        		}
        	}else {
        		System.out.println(RED+"Credentials miss match please try again."+RESET);
        		if(count==2) {
        			System.out.println(RED+"Too many failed attempts try ofter some time."+RESET);
        			return;
        		}
        		count++;
        	}
    	}
    }
    public int admiservices(Scanner sc) {
    	boolean b=true;
    	int a=0;
    	while(b) {
    		System.out.println(YELLOW+"Select service."+RESET);
    		System.out.println(BLUE+"1.View Accounts"+RESET);
    		System.out.println(BLUE+"2.Delete Account"+RESET);
    		System.out.println(BLUE+"3.Logout"+RESET);
    		System.out.println(VIO+"Enter service number that you want: "+RESET);
    		int ser=sc.nextInt();
    		if(ser==1) {
    			viewAccounts();
    		}else if(ser==2) {
    			deleteAccount(sc);
    		}else {
    			System.out.println(GREEN+"Logout successfull."+RESET);
    			b=false;
    			a=1;
    		}
    	}
    	return a;
    }
    
    
    //user login
    public void userlogin(Scanner sc) {
    	try {
    		int count=0;
    		for(NewAccount ac:nc) {
    			if(ac!=null) {
    				count++;
    			}
    		}
    		if(count==0) {
    			throw new Exception(YELLOW+"There is no user in the database please create new account."+RESET);
    		}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return;
    	}
    	int count=0;
    	while(count<3) {
    		System.out.println(SKY+"Enter Account number: "+RESET);
        	long acnum=sc.nextLong();
        	System.out.println(SKY+"Enetr PIN: "+RESET);
        	int pin=sc.nextInt();
        	for(NewAccount ac:nc) {
        		if(ac!=null) {
        			if(((ac.getAcNumber()).equals(acnum)) && (ac.getpin()==pin)) {
        				System.out.println(GREEN+"Login successfull."+RESET);
        				if(userservices(ac,sc)==1) {
        					return;
        				}
        				}else {
        					System.out.println(RED+"Credentials miss match please try again."+RESET);
        	        		if(count==2) {
        	        			System.out.println(RED+"Too many failed attempts try ofter some time."+RESET);
        	        			return;
        	        		}
        	        		count++;
        				}
        			}
        		}
    	}
    	}
    	
    public int userservices(NewAccount ac,Scanner sc) {
    	boolean b=true;
    	int a=0;
		while(b) {
			System.out.println(YELLOW+"Select service that you want."+RESET);
			System.out.println(BLUE+"1.Withdraw money"+RESET);
			System.out.println(BLUE+"2.Deposite money"+RESET);
			System.out.println(BLUE+"3.Check Account Balance"+RESET);
			System.out.println(BLUE+"4.Logout"+RESET);
			System.out.println(VIO+"Enter servive number: "+RESET);
			int ser=sc.nextInt();
			if(ser==1) {
				withdraw(ac,sc);
			}else if(ser==2) {
				deposite(ac,sc);
			}else if(ser==3) {
				checkbalance(ac,sc);
			}else {
				System.out.println(GREEN+"Account logout Successfully."+RESET);
				b=false;
				a=1;
			}
		}
		return a;
    }


    //new account
    public void newaccount(Scanner sc) {
    	System.out.println(SKY+"Enter your name: "+RESET);
    	String name=sc.next();
    	System.out.println(SKY+"Enter your location: "+RESET);
    	String location=sc.next();
    	System.out.println(SKY+"Enter Account number: "+RESET);
    	long acnumber=sc.nextLong();
    	System.out.println(SKY+"Enter PIN: "+RESET);
    	int pin=sc.nextInt();
    	System.out.println(SKY+"Enter initial Balance: "+RESET);
    	double balance=sc.nextDouble();
    	double balval;
    	if(balance>0) {
    		balval=balance;
    	}else {
    		balval=0;
    	}
    	nc[usercount]=new NewAccount(name,location,acnumber,pin,balval);
    	System.out.println(GREEN+"Acconunt created successfully."+RESET);
    	usercount++;
    }
    
    //////////////////////////////////////////////////////////////////////
    public void withdraw(NewAccount ac,Scanner sc) {
    	System.out.println(SKY+"Enter Amount to withdraw: "+RESET);
    	double amount=sc.nextDouble();
    	double balance=ac.getinitialBalance()-amount;
    	ac.setbalance(balance);
    	System.out.println(GREEN+"Amount with draw successfully."+RESET);
    	System.out.println(BLUE+"Remaining balance :"+RESET+ac.getinitialBalance());
    }
    public void deposite(NewAccount ac,Scanner sc) {
    	System.out.println(SKY+"Enter amount to deposite: "+RESET);
    	double amount=sc.nextDouble();
    	double balance=ac.getinitialBalance()+amount;
    	ac.setbalance(balance);
    	System.out.println(GREEN+"Amount deposited successfully."+RESET);
    	System.out.println(BLUE+"Your current balance: "+RESET+ac.getinitialBalance());
    }
    public void checkbalance(NewAccount ac,Scanner sc) {
    	System.out.println(BLUE+"Your current balance: "+RESET+ac.getinitialBalance());
    }
    /////////////////////////////////////////////////////////////////////////////
    public int reuse() {
    	int a=0;
    	for(NewAccount ac:nc) {
    		if(ac!=null) {
    			System.out.println(BLUE+"Account Number: "+RESET+ac.getAcNumber()+"   "+BLUE+"user Name: "+RESET+ ac.getusername());
    			a++;
    		}
    	}
    	return a;
    }
    public void viewAccounts() {
    	if(reuse()==0) {
    		System.out.println(RED+"No accounts in database."+RESET);
    		return;
    	}
    }
    public void deleteAccount(Scanner sc) {
    	
    	if(reuse()==0) {
    		System.out.println(RED+"No accounts in database."+RESET);
    	}else {
    		System.out.println(SKY+"Enter Account number to delete: "+RESET);
        	long acnum=sc.nextLong();
        	for(int i=0;i<nc.length;i++) {
        		if(nc[i]!=null) {
        			if(nc[i].getAcNumber()==acnum) {
        				nc[i]=null;
        			}
        		}
        	}
        	System.out.println(BLUE+"Users ofter deletion: "+RESET);
        	reuse();
    	}
    }
    ////////////////////////////////////////////////////////////////////////////////
    
    public void display_Services(Scanner sc) {
    	while(b) {
    		System.out.println(YELLOW+"Select service that you want."+RESET);
    		System.out.println(BLUE+"1.Admin login"+RESET);
    		System.out.println(BLUE+"2.User login"+RESET);
    		System.out.println(BLUE+"3.New account"+RESET);
    		System.out.println(BLUE+"4.Exit"+RESET);
    		System.out.println(VIO+"Enter service number that you want: "+RESET);
    		int num=sc.nextInt();
    		if(num==1) {
    			adminlogin(sc);
    		}else if(num==2) {
    			userlogin(sc);
    		}else if(num==3) {
    			newaccount(sc);
    		}else {
    			System.out.println(GREEN+"Exit successfully done."+RESET);
    			b=false;
    		}
    	}
    }
    
public static void main(String[] args) {
	Services ser=new Services();
	Scanner sc=new Scanner(System.in);
	ser.display_Services(sc);
}
}
