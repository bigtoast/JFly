package com.github.bigtoast.jfly;

public interface EntityBuilder<E> {

	public E build();
	public boolean isValid();
}
