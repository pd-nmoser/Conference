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

package com.prodyna.pac.conference.ejb.beans.service.speaker;

import com.prodyna.pac.conference.ejb.beans.EJBTest;
import com.prodyna.pac.conference.ejb.api.datatype.Speaker;
import com.prodyna.pac.conference.ejb.api.service.speaker.SpeakerService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * SpeakerServiceTest
 * <p/>
 * Author: Nicolas Moser
 * Date: 12.09.13
 * Time: 12:34
 */
@RunWith(Arquillian.class)
public class SpeakerServiceTest extends EJBTest {

	@Inject
	private SpeakerService service;

	@Test
	public void createReadUpdateDeleteSpeaker() throws Exception {

		Speaker speaker = new Speaker();
		speaker.setName("Adam Bien");
		speaker.setDescription(
				"Bien works with many companies as a Java architecture consultant for enterprise applications, helping organizations design and implement high-performance Java solutions and troubleshooting mission-critical problems. He’s also the author of eight books and more than 100 articles on Java, architectures, and best practices.");

		Speaker result = service.createSpeaker(speaker);

		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(0L, result.getVersion().longValue());
		Assert.assertEquals("Adam Bien", result.getName());

		System.out.println("Speaker ID: " + result.getId());
		System.out.println("Speaker Version: " + result.getVersion());

		result.setName("Jens Vogel");
		result = service.updateSpeaker(result);

		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
		Assert.assertNotNull(result.getVersion());
		Assert.assertEquals(1L, result.getVersion().longValue());
		Assert.assertEquals("Jens Vogel", result.getName());

		System.out.println("Speaker ID: " + result.getId());
		System.out.println("Speaker Version: " + result.getVersion());

		result = service.removeSpeaker(result);

		Assert.assertNotNull(result);

		result = service.findSpeakerById(result.getId());

		Assert.assertNull(result);
	}

}
