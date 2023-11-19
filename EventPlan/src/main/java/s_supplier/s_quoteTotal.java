package s_supplier;

public class s_quoteTotal extends s_quote {
	
	protected double total;
	
	public s_quoteTotal() {};	
	
	public s_quoteTotal(double total) {
		super();
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
