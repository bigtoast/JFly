/*
 * Copyright 2012 Andrew Headrick
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.bigtoast.jfly.api.purchase;

import com.github.bigtoast.jfly.api.JFlyCommand;

/**
 * A cart command does stuff to a cart. These are unsafe operations which may or may not be idempotent. 
 * 
 * @author andrew
 *
 * @param <C>
 */
public interface CartCommand< C extends CartCommand<C> > extends JFlyCommand, CartRequest<C> {

	public C withDoAllocate( DoAllocate doIt );
	
	public C withSetPayment( SetPaymentCommand payment );

}
