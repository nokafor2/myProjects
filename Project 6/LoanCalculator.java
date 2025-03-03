public class LoanCalculator implements java.io.Serializable{
	private double annIntRate;
	private int numOfYrs;
	private double loanAmt;
	
	public LoanCalculator(double annIntRate, int numOfYrs, double loanAmt){
		this.annIntRate = annIntRate;
		this.numOfYrs = numOfYrs;
		this.loanAmt = loanAmt;
		
	}

	public double getAnnIntRate(){
		return annIntRate;
	}
	
	public void setAnnIntRate(double annIntRate){
		this.annIntRate = annIntRate;
	}
	
	public int getNumOfYrs(){
		return numOfYrs;
	}
	
	public void setNumOfYrs(int numOfYrs){
		this.numOfYrs = numOfYrs;
	}
	
	public double getLoanAmt(){
		return loanAmt;
	}
	
	public void setLoanAmt(int loanAmt){
		this.loanAmt = loanAmt;
	}
	
	public double getMonthlyPayment(){
		double monthlyInterestRate = annIntRate / 1200;
		double monthlyPayment = loanAmt * monthlyInterestRate / (1 -
				(Math.pow(1 / (1 + monthlyInterestRate), numOfYrs * 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment(){
		double totalPayment = getMonthlyPayment() * numOfYrs * 12;
		return totalPayment;
	}
}

