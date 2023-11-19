package s_supplier;

public class s_quote { // creation of quotation parent class
	protected String quoteId; // declaring the protected data members in the s_quote class
	protected String itemName;
	protected double quantity;
	protected double unitPrice;
	protected double itemPrice;
	protected double total;

	

	public s_quote() { // creation of s_quote default constructor

	}

	public s_quote(String quoteId, String itemName, double quantity, double unitPrice, double itemPrice) { // values
																											// assigning
																											// from
																											// overloaded
																											// constructor
		super();
		this.quoteId = quoteId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemPrice = itemPrice;
	}

	public String getQuoteId() { // getters and setters creation for relevant data members
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
