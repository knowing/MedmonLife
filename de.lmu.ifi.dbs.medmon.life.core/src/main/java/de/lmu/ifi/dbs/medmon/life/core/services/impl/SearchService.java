package de.lmu.ifi.dbs.medmon.life.core.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.medmon.life.core.services.ISearchService;
import de.lmu.ifi.dbs.medmon.life.core.services.Search;
import de.lmu.ifi.dbs.medmon.services.IEntityManagerService;

public class SearchService implements ISearchService {

	private static final Logger log = LoggerFactory.getLogger(ISearchService.class);

	private IEntityManagerService emService;

	@Override
	public Search getSearchSession() {
		return new Search(emService.createEntityManager());
	}

	protected void bindEntityManagerService(IEntityManagerService emService) {
		this.emService = emService;
	}

	protected void unbindEntityManagerService(IEntityManagerService emService) {
		this.emService = null;
	}

	protected void activate() {
		log.info("SearchService activated");
	}
}
