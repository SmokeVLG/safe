package com.maxden.safe.domain;

import com.maxden.safe.domain.model.UserJobInfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserJobInfoRepository extends CrudRepository<UserJobInfo, Long> {

    @Query("select *  from user_job_info where user_id = :userId")
    Optional<List<UserJobInfo>> findByUserId(Long userId);

    @Query("select *  from user_job_info where id_company = :companyId")
    Optional<List<UserJobInfo>> findByCompanyId(Long companyId);


    @Query(value = "INSERT INTO user_job_info (id_company, user_id, description, is_activity,created,updated) VALUES ( :id_company, :user_id, :description, :is_activity,:created, :updated) RETURNING ID")
    Long saveAll(
            @Param("id_company") Long idCompany,
            @Param("user_id") Long userId,
            @Param("description") String description,
            @Param("is_activity") Boolean isActivity,
            @Param("created") Date created,
            @Param("updated") Date updated
    );


    @Modifying
    @Query(value = "TRUNCATE TABLE user_job_info")
    void truncateAll();
}