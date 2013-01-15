package com.github.bigtoast.jfly.internal.http.purchase;

import com.github.bigtoast.jfly.api.purchase.LineItemCommand;

public class LineItemCommandImpl implements LineItemCommand {
	
	private long accessId;
	private int quantity;
	private String deliveryType;
	private String promoCode;
	
	public static String ACCESS_ID     = "accessId";
	public static String QUANTITY      = "quantity";
	public static String DELIVERY_TYPE = "delivery";
	public static String PROMO_CODE    = "promoCode";

	@Override
	public LineItemCommand withAccessId(long accessId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineItemCommand withQuantity(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineItemCommand withDeliveryType(String deliveryType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineItemCommand withPromoCode(String promoCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
