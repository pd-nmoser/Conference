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

package com.prodyna.pac.conference.jsf.converter;

import com.prodyna.pac.conference.ejb.api.datatype.Room;
import com.prodyna.pac.conference.ejb.api.exception.ServiceException;
import com.prodyna.pac.conference.jsf.admin.TalkAdminBean;
import org.slf4j.Logger;

import javax.annotation.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Converts a room name to the related room instance and vice versa.
 * <p/>
 * Author: Nicolas Moser
 * Date: 09.10.13
 * Time: 18:17
 */
@ManagedBean
@Named("roomConverter")
public class RoomConverter implements Converter {

	@Inject
	private TalkAdminBean talkAdminBean;

	@Inject
	private Logger logger;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value != null && !value.isEmpty()) {

			try {
				List<Room> rooms = talkAdminBean.getRooms();

				for (Room room : rooms) {

					if (room.getName().equals(value)) {
						return room;
					}
				}
			} catch (ServiceException e) {
				logger.error("Error loading rooms.", e);
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof Room) {
			return ((Room) value).getName();
		}

		return null;
	}
}
