package de.alpharogroup.event.system.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.alpharogroup.db.dao.jpa.JpaEntityManagerDao;
import de.alpharogroup.event.system.entities.RatingDescriptions;
import lombok.Getter;
import lombok.Setter;

@Repository("ratingDescriptionsDao")
public class RatingDescriptionsDao extends
		JpaEntityManagerDao<RatingDescriptions, java.lang.Integer> {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The entity manager. */
	@PersistenceContext
	@Getter
	@Setter
	private EntityManager entityManager;
}
