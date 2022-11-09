package com.dgs.dgsframework.repository;

import com.dgs.dgsframework.domain.testApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface testApplicationRepository extends JpaRepository<testApplication, Long>, JpaSpecificationExecutor<testApplication> {
}
