package com.dgs.dgsframework.domain.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

// 결재 신청/신고 소프트웨어
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_rqst_sw")
public class sgn_rqst_sw {

  // 일련번호
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRS_SEQ")
  private Long srsSeq;
  // 결재신청키
  @Column(name="SR_KEY")
  private Long srKey;
  // 소프트웨어키
  @Column(name="OSW_KEY")
  private Long oswKey;
  // 기간유형코드 (SAM_006)
  @Column(name="TERM_TYPE_CD")
  private String termTypeCd;
  // null
  @Column(name="SRS_STRT_DY")
  private Timestamp srsStrtDy;
  // null
  @Column(name="SRS_EXPR_DY")
  private Timestamp srsExprDy;
  // 신청항목 실행일시
  @Column(name="SRS_DONE_DT")
  private Timestamp srsDoneDt;
  // 처리상태코드 (NH_0255)
  @Column(name="PRCS_ST_CD")
  private String prcsStCd;
  // 인가방식코드 (SAM_007)
  @Column(name="LICNS_TYPE_CD")
  private String licnsTypeCd;
  // 처리작업내용
  @Column(name="PRCS_CNTNT")
  private String prcsCntnt;
  // 신청자 알림여부
  @Column(name="RQST_ALRM_YN")
  private String rqstAlrmYn;
  // 처리자구분코드 (NH_0094)
  @Column(name="PRCSR_DVS_CD")
  private String prcsrDvsCd;
  // 처리자키
  @Column(name="PRCS_ADM_KEY")
  private Long prcsAdmKey;
  // 처리일시
  @Column(name="PRCS_DT")
  private Timestamp prcsDt;
  // 자동처리여부
  @Column(name="AUTO_PRCS_YN")
  private String autoPrcsYn;
  // 이관대상구분 (NH_0022)
  @Column(name="TRNS_DVS_CD")
  private String trnsDvsCd;
  // 이관대상키
  @Column(name="TRNS_TRGT_KEY")
  private Long trnsTrgtKey;
  // 이관SW라이선스ID
  @Column(name="TRNS_SW_LID")
  private String trnsSwLid;
  // 이관일자
  @Column(name="TRNS_DT")
  private Timestamp trnsDt;
  // 등록일시
  @Column(name="REG_DT")
  private Timestamp regDt;
  // 시스템키
  @Column(name="SI_KEY")
  private Long siKey;
}
