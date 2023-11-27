package com.animeinfo.theapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository<ENTIDADE> extends JpaRepository<ENTIDADE, Long> {
}
