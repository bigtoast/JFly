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

import com.github.bigtoast.jfly.api.JFlyRequest;

/**
 * A cart request needs to 
 * create a cart by allocating inventory
 * update existing allocations
 * add new allocations
 * remove allocations
 * delete cart
 * set payment
 * set shipping address
 * purchase
 * 
 * get sale
 * 
 * @author andrew
 *
 */
public interface CartRequest< R extends CartRequest<R> > extends JFlyRequest {
	
	public R withCartId( String cartId );
	
}
