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
@Table(name = "sgn_rqst_oa")
public class sgn_rqst_oa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRO_SEQ")
  private Long sroSeq;
  @Column(name="OAL_KEY")
  private Long oalKey;
  @Column(name="TERM_TYPE_CD")
  private String termTypeCd;
  @Column(name="SR_KEY")
  private Long srKey;
  @Column(name="SRO_STRT_DY")
  private Timestamp sroStrtDy;
  @Column(name="SRO_EXPR_DY")
  private Timestamp sroExprDy;
  @Column(name="SRO_EXPCT_DY")
  private Timestamp sroExpctDy;
  @Column(name="SRO_DONE_DT")
  private Timestamp sroDoneDt;
  @Column(name="REF_SRO_SEQ")
  private Long refSroSeq;
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
