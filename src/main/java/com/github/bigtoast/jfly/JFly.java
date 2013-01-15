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
package com.github.bigtoast.jfly;

import com.github.bigtoast.jfly.api.event.EventMethods;
import com.github.bigtoast.jfly.api.org.OrgMethods;
import com.github.bigtoast.jfly.api.purchase.PurchaseMethods;
import com.github.bigtoast.jfly.api.purchase.PurchaseRequestFactory;
import com.github.bigtoast.jfly.api.venue.VenueMethods;

/**
 * JFly is the client interface to all things jfly. A client should never have to 
 * implement classes directly ( although they can it they want to be sadistic ). The
 * JFly api provides a dsl for requests, entity builders/types and command/request executions.
 * 
 * @author andrew
 *
 */
public interface JFly extends 
  EventMethods, 
  VenueMethods, 
  OrgMethods, 
  PurchaseMethods,
  PurchaseRequestFactory,
  EntityBuilderFactories {}
