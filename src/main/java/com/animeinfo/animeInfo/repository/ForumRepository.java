package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.Forum;
import com.animeinfo.theapi.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends CrudRepository<Forum> {
}
