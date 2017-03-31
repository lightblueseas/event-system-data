/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.event.system.rest.client;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.event.system.rest.api.CategoriesResource;
import de.alpharogroup.event.system.rest.api.EventLocationDatasResource;
import de.alpharogroup.event.system.rest.api.EventLocationsResource;
import de.alpharogroup.event.system.rest.api.EventMessagesResource;
import de.alpharogroup.event.system.rest.api.EventRatingsResource;
import de.alpharogroup.event.system.rest.api.EventTemplatesResource;
import de.alpharogroup.event.system.rest.api.EventTopicsResource;
import de.alpharogroup.event.system.rest.api.OfferedEventLocationsResource;
import de.alpharogroup.event.system.rest.api.ProfileFederalstatesResource;
import de.alpharogroup.event.system.rest.api.ProfileTopicsResource;
import de.alpharogroup.event.system.rest.api.RatingDescriptionsResource;
import de.alpharogroup.event.system.rest.api.TopicsResource;
import de.alpharogroup.event.system.rest.api.UserContactsAllowedContactmethodsResource;
import de.alpharogroup.event.system.rest.api.UsereventsResource;
import lombok.Getter;

public class EventSystemRestClient extends AbstractRestClient {
	/**
	 * The {@link CategoriesResource}.
	 */
	@Getter
	private final CategoriesResource categoriesResource;

	/**
	 * The {@link EventLocationDatasResource}.
	 */
	@Getter
	private final EventLocationDatasResource eventLocationDatasResource;

	/**
	 * The {@link EventLocationsResource}.
	 */
	@Getter
	private final EventLocationsResource eventLocationsResource;

	/**
	 * The {@link EventMessagesResource}.
	 */
	@Getter
	private final EventMessagesResource eventMessagesResource;

	/**
	 * The {@link EventRatingsResource}.
	 */
	@Getter
	private final EventRatingsResource eventRatingsResource;

	/**
	 * The {@link EventTemplatesResource}.
	 */
	@Getter
	private final EventTemplatesResource eventTemplatesResource;

	/**
	 * The {@link EventTopicsResource}.
	 */
	@Getter
	private final EventTopicsResource eventTopicsResource;

	/**
	 * The {@link OfferedEventLocationsResource}.
	 */
	@Getter
	private final OfferedEventLocationsResource offeredEventLocationsResource;

	/**
	 * The {@link ProfileFederalstatesResource}.
	 */
	@Getter
	private final ProfileFederalstatesResource profileFederalstatesResource;

	/**
	 * The {@link ProfileTopicsResource}.
	 */
	@Getter
	private final ProfileTopicsResource profileTopicsResource;

	/**
	 * The {@link RatingDescriptionsResource}.
	 */
	@Getter
	private final RatingDescriptionsResource ratingDescriptionsResource;

	/**
	 * The {@link TopicsResource}.
	 */
	@Getter
	private final TopicsResource topicsResource;

	/**
	 * The {@link UserContactsAllowedContactmethodsResource}.
	 */
	@Getter
	private final UserContactsAllowedContactmethodsResource userContactsAllowedContactmethodsResource;

	/**
	 * The {@link UsereventsResource}.
	 */
	@Getter
	private final UsereventsResource usereventsResource;

	/**
	 * Instantiates a new {@link EventSystemRestClient} with the default base
	 * url.
	 */
	public EventSystemRestClient() {
		this(DEFAULT_BASE_HTTPS_URL);
	}

	/**
	 * Instantiates a new {@link EventSystemRestClient} with the given base url.
	 *
	 * @param baseUrl
	 *            the base url
	 */
	public EventSystemRestClient(final String baseUrl) {
		super(baseUrl);
		categoriesResource = newResource(CategoriesResource.class);
		eventLocationDatasResource = newResource(EventLocationDatasResource.class);
		eventLocationsResource = newResource(EventLocationsResource.class);
		eventMessagesResource = newResource(EventMessagesResource.class);
		eventRatingsResource = newResource(EventRatingsResource.class);
		eventTemplatesResource = newResource(EventTemplatesResource.class);
		eventTopicsResource = newResource(EventTopicsResource.class);
		offeredEventLocationsResource = newResource(OfferedEventLocationsResource.class);
		profileFederalstatesResource = newResource(ProfileFederalstatesResource.class);
		profileTopicsResource = newResource(ProfileTopicsResource.class);
		ratingDescriptionsResource = newResource(RatingDescriptionsResource.class);
		topicsResource = newResource(TopicsResource.class);
		userContactsAllowedContactmethodsResource = newResource(UserContactsAllowedContactmethodsResource.class);
		usereventsResource = newResource(UsereventsResource.class);
	}

}
