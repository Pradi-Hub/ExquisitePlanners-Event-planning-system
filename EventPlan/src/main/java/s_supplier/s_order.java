package s_supplier;

public class s_order {     //order class creation
    
    private String orderId;      //declaring the private data members of the order class
    private String orders;
    private int supplierID;
    
    public s_order( String orderId, String orders, int supplierID) {    //creation of overloaded constructor
        super();
        this.orderId = orderId;
        this.orders = orders;
        this.supplierID = supplierID;
    }

    public int getSupplierID() {        //getters and setters creation to relevant data members.
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getOrderId() {
        return orderId;
    }

    public String getOrders() {
        return orders;
    }

}
