package com.maxden.safe.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserJobRepository extends CrudRepository<UserJobInfo, Long> {
}