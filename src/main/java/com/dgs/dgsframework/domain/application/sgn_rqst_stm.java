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
@Table(name = "sgn_rqst_stm")
public class sgn_rqst_stm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRC_SEQ")
  private Long srcSeq;
  @Column(name="SR_KEY")
  private Long srKey;
  @Column(name="SI_KEY")
  private Long siKey;
  @Column(name="GU_KEY")
  private Long guKey;
  @Column(name="STRT_DT")
  private Timestamp strtDt;
  @Column(name="END_DT")
  private Timestamp endDt;
  @Column(name="PRCS_ST_CD")
  private String prcsStCd;
  @Column(name="PRCS_CNTNT")
  private String prcsCntnt;
  @Column(name="RQST_ALRM_YN")
  private String rqstAlrmYn;
  @Column(name="PRCSR_DVS_CD")
  private String prcsrDvsCd;
  @Column(name="PRCS_ADM_KEY")
  private Long prcsAdmKey;
  @Column(name="PRCS_DT")
  private Timestamp prcsDt;
  @Column(name="AUTO_PRCS_YN")
  private String autoPrcsYn;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
