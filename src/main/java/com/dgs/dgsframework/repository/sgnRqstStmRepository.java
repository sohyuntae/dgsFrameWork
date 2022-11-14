package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.application.sgn_rqst_stm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface sgnRqstStmRepository extends JpaRepository<sgn_rqst_stm, Long>, JpaSpecificationExecutor<sgn_rqst_stm>, sgnRqstStmRepositoryCustom {
}
