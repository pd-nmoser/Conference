/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Nicolas Moser
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.prodyna.pac.conference.ejb.api.exception;

import java.io.Serializable;

/**
 * A single constraint violation item with property name and message.
 * <p/>
 * Author: Nicolas Moser
 * Date: 17.10.13
 * Time: 00:55
 */
public class ValidationItem implements Serializable {

	private String propertyName;

	private String message;

	/**
	 * Creates a new validation item.
	 *
	 * @param propertyName
	 * 		the property name
	 * @param message
	 * 		the validation message
	 */
	public ValidationItem(String propertyName, String message) {

		this.propertyName = propertyName;
		this.message = message;
	}

	/**
	 * Getter for the property propertyName.
	 *
	 * @return the property propertyName or null
	 */
	public String getPropertyName() {

		return this.propertyName;
	}

	/**
	 * Getter for the validation message.
	 *
	 * @return the validation message
	 */
	public String getMessage() {

		return message;
	}
}
