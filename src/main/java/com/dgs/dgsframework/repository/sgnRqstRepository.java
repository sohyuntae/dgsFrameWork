package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.application.sgn_rqst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface sgnRqstRepository extends JpaRepository<sgn_rqst, Long>, JpaSpecificationExecutor<sgn_rqst>, sgnRqstRepositoryCustom {
}
