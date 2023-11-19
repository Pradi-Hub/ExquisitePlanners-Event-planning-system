package s_supplier;

import java.util.List;

//creation of the supplirDBModel interface
public interface s_supplierDBModelInterface {
	
	public boolean insertQuoteList(List<s_quote> s_quoteList, String quote_no, double totalPrice);
	public boolean deleteQuote(String qid);
	public boolean updateQuote(List<s_quote> s_quoteList, String qid, double totalPrice);
	
}
