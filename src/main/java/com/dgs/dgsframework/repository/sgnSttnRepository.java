package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.application.sgn_sttn;
import com.dgs.dgsframework.domain.application.sgn_sttn_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface sgnSttnRepository extends JpaRepository<sgn_sttn, sgn_sttn_id>, JpaSpecificationExecutor<sgn_sttn>, sgnSttnRepositoryCustom {
}
