package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.application.sgn_rqst_file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface sgnRqstFileRepository extends JpaRepository<sgn_rqst_file, Long>, JpaSpecificationExecutor<sgn_rqst_file>, sgnRqstFileRepositoryCustom {
}
