package com.animeinfo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository<ENTIDADE> extends JpaRepository<ENTIDADE, Long> {
}
