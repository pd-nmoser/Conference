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

package com.prodyna.pac.conference.ejb.api.service.talk;

import com.prodyna.pac.conference.ejb.api.datatype.Conference;
import com.prodyna.pac.conference.ejb.api.datatype.Room;
import com.prodyna.pac.conference.ejb.api.datatype.Speaker;
import com.prodyna.pac.conference.ejb.api.datatype.Talk;
import com.prodyna.pac.conference.ejb.api.exception.ServiceException;
import com.prodyna.pac.conference.ejb.api.service.Service;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

/**
 * Service responsible for managing (CRUD) Talk entites.
 * <p/>
 * Author: Nicolas Moser
 * Date: 11.09.13
 * Time: 16:43
 */
@Local
public interface TalkService extends Service {

	/**
	 * Find the Talk entity with the given ID.
	 *
	 * @param id
	 * 		the id of the talk entity
	 *
	 * @return the talk entity
	 *
	 * @throws ServiceException
	 * 		when the Talk entity with the given ID does not exist in the database
	 */
	Talk findTalkById(Long id) throws ServiceException;

	/**
	 * Find the Talk entity with the given Name.
	 *
	 * @param name
	 * 		the id of the talk entity
	 *
	 * @return the talk entity
	 *
	 * @throws ServiceException
	 * 		when the Talk entity with the given Name does not exist in the database
	 */
	Talk findTalkByName(String name) throws ServiceException;

	/**
	 * Find all Talk entity instances.
	 *
	 * @return the list of all existing talk instances
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getAllTalks() throws ServiceException;

	/**
	 * Find all Talk entity instances that hold a reference to the given conference.
	 *
	 * @param conference
	 * 		the conference holding the talks
	 *
	 * @return the list of all existing talk instances of the given conference
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getTalksByConference(Conference conference) throws ServiceException;

	/**
	 * Find all Talk entity instances that are presented in the given room.
	 *
	 * @param room
	 * 		the room holding the talks
	 *
	 * @return the list of all existing talk instances of the given room
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getTalksByRoom(Room room) throws ServiceException;

	/**
	 * Find all Talk entity instances that are presented in the given roomin the given time range.
	 *
	 * @param room
	 * 		the room holding the talks
	 * @param startTime
	 * 		the start time
	 * @param endTime
	 * 		the end time.
	 *
	 * @return the list of all existing talk instances of the given room
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getTalksByRoom(Room room, Date startTime, Date endTime) throws ServiceException;

	/**
	 * Find all Talk entity instances that are presented by the given speaker.
	 *
	 * @param speaker
	 * 		the speaker holding the talks
	 *
	 * @return the list of all existing talk instances of the given speaker
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getTalksBySpeaker(Speaker speaker) throws ServiceException;

	/**
	 * Find all Talk entity instances that are presented by the given speaker in the given time range.
	 *
	 * @param speaker
	 * 		the speaker holding the talks
	 * @param startTime
	 * 		the start time
	 * @param endTime
	 * 		the end time
	 *
	 * @return the list of all existing talk instances of the given speaker
	 *
	 * @throws ServiceException
	 * 		when the Talk query fails
	 */
	List<Talk> getTalksBySpeaker(Speaker speaker, Date startTime, Date endTime) throws ServiceException;

	/**
	 * Persists a non-persistent Talk entity to the database.
	 *
	 * @param Talk
	 * 		the talk entity to persist
	 *
	 * @return the persisted entity
	 *
	 * @throws ServiceException
	 * 		when the entity cannot be persisted
	 */
	Talk createTalk(Talk Talk) throws ServiceException;

	/**
	 * Updates an already persistent Talk entity to the database.
	 *
	 * @param Talk
	 * 		the talk entity to update
	 *
	 * @return the updated entity
	 *
	 * @throws ServiceException
	 * 		when the entity cannot be updated
	 */
	Talk updateTalk(Talk Talk) throws ServiceException;

	/**
	 * Removes an already persistent Talk entity from the database.
	 *
	 * @param Talk
	 * 		the talk entity to remove
	 *
	 * @return the removed entity
	 *
	 * @throws ServiceException
	 * 		when the entity cannot be removed
	 */
	Talk removeTalk(Talk Talk) throws ServiceException;

	/**
	 * Validate whether the talk collidates with another talk of any of the presenting speakers.
	 *
	 * @param talk
	 * 		the talk to validateTalk
	 *
	 * @throws ServiceException
	 * 		when the talk is not valid
	 */
	void validateTalk(Talk talk) throws ServiceException;

}
