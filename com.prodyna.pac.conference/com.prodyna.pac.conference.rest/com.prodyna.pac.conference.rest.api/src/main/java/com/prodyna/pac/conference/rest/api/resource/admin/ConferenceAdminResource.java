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

package com.prodyna.pac.conference.rest.api.resource.admin;

import com.prodyna.pac.conference.ejb.api.datatype.Conference;
import com.prodyna.pac.conference.rest.api.exception.RESTException;
import com.prodyna.pac.conference.rest.api.resource.ConferenceResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Resource to retrieve and administrate conference information.
 * <p/>
 * Author: Nicolas Moser
 * Date: 17.10.13
 * Time: 15:43
 */
@Path("secure/conference")
public interface ConferenceAdminResource extends ConferenceResource {

	/**
	 * Adds a new Conference resource.
	 *
	 * @param conference
	 * 		the conference to add
	 *
	 * @return the added conference
	 *
	 * @throws RESTException
	 * 		when the creation fails
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Conference createConference(Conference conference) throws RESTException;

	/**
	 * Updates an existing Conference resource.
	 *
	 * @param conference
	 * 		the conference to update
	 *
	 * @return the update conference
	 *
	 * @throws RESTException
	 * 		when the modification fails
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Conference updateConference(Conference conference) throws RESTException;

	/**
	 * Remvoves an existing Conference resource.
	 *
	 * @param id
	 * 		id of the conference to remove
	 *
	 * @return the removed conference
	 *
	 * @throws RESTException
	 * 		when the deletion fails
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Conference deleteConference(@PathParam("id") Long id) throws RESTException;
}
