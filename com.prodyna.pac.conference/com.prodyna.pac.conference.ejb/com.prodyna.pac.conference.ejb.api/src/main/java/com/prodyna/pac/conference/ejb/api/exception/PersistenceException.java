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

import javax.ejb.ApplicationException;

/**
 * Raised when a persistence operation fails.
 * <p/>
 * Author: Nicolas Moser
 * Date: 11.09.13
 * Time: 16:44
 */
@ApplicationException(rollback = true)
public class PersistenceException extends Exception {

	/** Creates a new persistence exception without parameters. */
	public PersistenceException() {

		super();
	}

	/**
	 * Creates a new persistence exception with the given error message.
	 *
	 * @param message
	 * 		the error message
	 */
	public PersistenceException(String message) {

		super(message);
	}

	/**
	 * Creates a new persistence exception with the given error cause.
	 *
	 * @param cause
	 * 		the causing exception
	 */
	public PersistenceException(Exception cause) {

		super(cause);
	}

	/**
	 * Creates a new persistence exception with the given error message and cause.
	 *
	 * @param message
	 * 		the error message
	 * @param cause
	 * 		the causing exception
	 */
	public PersistenceException(String message, Exception cause) {

		super(message, cause);
	}

}
