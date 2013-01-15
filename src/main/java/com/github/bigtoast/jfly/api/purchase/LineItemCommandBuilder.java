package com.github.bigtoast.jfly.api.purchase;

public interface LineItemCommandBuilder  {

	public UpdateLineItemCommand update();
	
	public DeleteLineItemCommand delete();
	
	public GetLineItemRequest get();
}
