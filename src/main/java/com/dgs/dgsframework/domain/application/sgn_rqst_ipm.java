package com.dgs.dgsframework.domain.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

// 결재 신청 IPM
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_rqst_ipm")
public class sgn_rqst_ipm {

  // 일련번호
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRI_KEY")
  private Long sriKey;
  // 결재신청키
  @Column(name="SR_KEY")
  private Long srKey;
  // 대상구분(NH_0022)
  @Column(name="TRGT_DVS_CD")
  private String trgtDvsCd;
  // 대상키
  @Column(name="TRGT_KEY")
  private Long trgtKey;
  // 대상명
  @Column(name="TRGT_NM")
  private String trgtNm;
  // 시스템명
  @Column(name="STM_NM")
  private String stmNm;
  // 신청 MAC주소
  @Column(name="MAC_ADDR")
  private String macAddr;
  // 신청IP수
  @Column(name="RQST_IP_CNT")
  private Long rqstIpCnt;
  // 시작일시
  @Column(name="RQST_STRT_DT")
  private Timestamp rqstStrtDt;
  // 종료일시
  @Column(name="RQST_END_DT")
  private Timestamp rqstEndDt;
  // 이관 IP
  @Column(name="TRNS_IP")
  private Long trnsIp;
  // 이관 일시
  @Column(name="TRNS_DT")
  private Timestamp trnsDt;
  // 반납 IP
  @Column(name="RTN_IP")
  private Long rtnIp;
  // 반납 일시
  @Column(name="RTN_DT")
  private Timestamp rtnDt;
  // 처리상태코드 (NH_0255)
  @Column(name="PRCS_ST_CD")
  private String prcsStCd;
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
  // 처리작업내용
  @Column(name="PRCS_CNTNT")
  private String prcsCntnt;
  // 등록일시
  @Column(name="REG_DT")
  private Timestamp regDt;
}
