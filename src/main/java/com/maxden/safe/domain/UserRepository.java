package com.maxden.safe.domain;

import com.maxden.safe.domain.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}