package com.dgs.dgsframework.domain.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_rqst_oa_rsrv_job")
public class sgn_rqst_oa_rsrv_job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRORJ_SEQ")
  private Long srorjSeq;
  @Column(name="SRO_SEQ")
  private Long sroSeq;
  @Column(name="RSRV_STRT_DY")
  private Timestamp rsrvStrtDy;
  @Column(name="RSRV_END_DY")
  private Timestamp rsrvEndDy;
  @Column(name="SCS_YN")
  private String scsYn;
  @Column(name="EXCT_DT")
  private Timestamp exctDt;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
