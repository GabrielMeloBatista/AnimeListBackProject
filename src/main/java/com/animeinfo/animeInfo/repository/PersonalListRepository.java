package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.PersonalList;
import com.animeinfo.theapi.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalListRepository extends CrudRepository<PersonalList> {
}
