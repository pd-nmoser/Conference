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

package com.prodyna.pac.conference.rest.api.resource;

import com.prodyna.pac.conference.ejb.api.datatype.Speaker;
import com.prodyna.pac.conference.rest.api.exception.RESTException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Resource to retrieve speaker information.
 * <p/>
 * Author: Nicolas Moser
 * Date: 17.10.13
 * Time: 15:46
 */
@Path("speaker")
public interface SpeakerResource extends Resource {

	/**
	 * Retrieve the speaker with the given ID.
	 *
	 * @param id
	 * 		the speaker ID
	 *
	 * @return the speaker or null if no speaker with the given ID exists
	 *
	 * @throws RESTException
	 * 		when the search fails
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Speaker findSpeaker(@PathParam("id") Long id) throws RESTException;

	/**
	 * Retrieves all existing speakers.
	 *
	 * @return the speaker list
	 *
	 * @throws RESTException
	 * 		when the search fails
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Speaker> getAllSpeakers() throws RESTException;

}
