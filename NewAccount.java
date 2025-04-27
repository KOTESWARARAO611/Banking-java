package ATM;

public class NewAccount {
	private String username;
	private String location;
	private Long AcNumber;
	private int pin;
	private double initialBalance;
	
	
	public NewAccount(String name,String location,Long acnumber,int pin,double balval) {
		this.username=name;
		this.location=location;
		this.AcNumber=acnumber;
		this.pin=pin;
		this.initialBalance=balval;	
	}
	public NewAccount(){
		
	}
	public String getusername() {
		return username;
	}
	public String getlocation() {
		return location;
	}
	public Long getAcNumber() {
		return AcNumber;
	}
	public int getpin() {
		return pin;
	}
	public double getinitialBalance() {
		return initialBalance;
	}
	public void setbalance(double balance) {
		this.initialBalance=balance;
	}
	public static void main(String[] args) {
		

	}

}
