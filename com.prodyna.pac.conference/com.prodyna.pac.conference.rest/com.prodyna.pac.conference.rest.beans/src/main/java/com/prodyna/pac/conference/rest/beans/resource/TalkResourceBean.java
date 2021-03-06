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

package com.prodyna.pac.conference.rest.beans.resource;

import com.prodyna.pac.conference.ejb.api.datatype.Talk;
import com.prodyna.pac.conference.rest.api.exception.RESTException;
import com.prodyna.pac.conference.ejb.api.exception.ServiceException;
import com.prodyna.pac.conference.ejb.api.service.talk.TalkService;
import com.prodyna.pac.conference.rest.api.resource.TalkResource;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * TalkResourceBean
 * <p/>
 * Author: Nicolas Moser
 * Date: 19.09.13
 * Time: 18:28
 */
public class TalkResourceBean implements TalkResource {

	@Inject
	private TalkService talkService;

	@Override
	public Talk findTalk(@PathParam("id") Long id) throws RESTException {

		try {
			return this.getTalkService().findTalkById(id);
		} catch (ServiceException e) {
			throw new RESTException(e);
		}
	}

	@Override
	public List<Talk> getAllTalks() throws RESTException {

		try {
			return this.getTalkService().getAllTalks();
		} catch (ServiceException e) {
			throw new RESTException(e);
		}
	}

	/**
	 * Getter for the talk service EJB.
	 *
	 * @return the talk service
	 */
	protected TalkService getTalkService() {

		return this.talkService;
	}


}
