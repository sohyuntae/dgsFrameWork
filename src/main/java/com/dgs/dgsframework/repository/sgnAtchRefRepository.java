package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.application.sgn_atch_rfr;
import com.dgs.dgsframework.domain.application.sgn_atch_rfr_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface sgnAtchRefRepository extends JpaRepository<sgn_atch_rfr, sgn_atch_rfr_id>, JpaSpecificationExecutor<sgn_atch_rfr>, sgnAtchRefRepositoryCustom {
}
