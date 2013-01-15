package com.github.bigtoast.jfly.internal.json;

import java.math.BigDecimal;

import com.github.bigtoast.jfly.Charge;

public class ChargeImpl implements Charge {
	
	private static final long serialVersionUID = -5486266527601816369L;
	
	private BigDecimal amount;
	
	public ChargeImpl( double amount ){
		this.amount = new BigDecimal(amount);
	}
	
	public ChargeImpl( BigDecimal amount ){
		this.amount = amount;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

}
