package de.alpharogroup.event.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.event.system.daos.ProfileFederalstatesDao;
import de.alpharogroup.event.system.domain.ProfileFederalstate;
import de.alpharogroup.event.system.entities.ProfileFederalstates;
import de.alpharogroup.event.system.mapper.ProfileFederalstatesMapper;
import de.alpharogroup.event.system.service.api.ProfileFederalstateService;
import de.alpharogroup.service.domain.AbstractDomainService;

@Transactional
@Service("profileFederalstateDomainService")
public class ProfileFederalstateDomainService
extends
AbstractDomainService<Integer,
ProfileFederalstate,
ProfileFederalstates,
ProfileFederalstatesDao,
ProfileFederalstatesMapper>
implements
ProfileFederalstateService
{

	/**
	 * Sets the specific {@link ProfileFederalstatesMapper}.
	 *
	 * @param mapper
	 *            the new {@link ProfileFederalstatesMapper}.
	 */
	@Autowired
	public void setProfileFederalstatesMapper(ProfileFederalstatesMapper mapper) {
		setMapper(mapper);
	}

}
