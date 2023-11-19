package s_supplier;

public class s_quoteChild extends s_quote { // inherit from the parent class s_quote

	protected String quoteType;// declaring data members as protected

	public s_quoteChild() {

	}

	public s_quoteChild(String quoteId, String itemName, double quantity, double unitPrice, double itemPrice, // assign  the values to the super class 
																											  //and quote type
																												 																											
																												
		String quoteType) {
		super(quoteId, itemName, quantity, unitPrice, itemPrice);
		this.quoteType = quoteType;
	}

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

}
