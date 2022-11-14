package com.dgs.dgsframework.domain.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// null
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_ntc_set")
public class sgn_ntc_set {

  // 제품모듈키
  @Id
  @Column(name="PRDCT_OC_KEY")
  private Long prdctOcKey;
  // 결재 신청 알림 사용 여부
  @Column(name="SGN_RQST_NTC_USEYN")
  private String sgnRqstNtcUseyn;
  // 결재 신청 결재자 알림 여부
  @Column(name="SGN_RQST_APRV_NTC_YN")
  private String sgnRqstAprvNtcYn;
  // 결재 신청 참조자 알림 여부
  @Column(name="SGN_RQST_CC_NTC_YN")
  private String sgnRqstCcNtcYn;
  // 기초_결재 신청자 결재 알림 여부
  @Column(name="SGN_RQST_RQST_NTC_YN")
  private String sgnRqstRqstNtcYn;
  // 결재 신청 Agent 팝업 알림 여부
  @Column(name="SGN_RQST_AGENT_POPUP_NTC_YN")
  private String sgnRqstAgentPopupNtcYn;
  // 결재 신청 Email  여부
  @Column(name="SGN_RQST_EMAIL_YN")
  private String sgnRqstEmailYn;
  // 결재 신청 문자메시지 여부
  @Column(name="SGN_RQST_TXT_MSG_YN")
  private String sgnRqstTxtMsgYn;
  // 결재 신청 문자메시지 종류 코드 (NH_0270)
  @Column(name="SGN_RQST_TXT_MSG_DVS_CD")
  private String sgnRqstTxtMsgDvsCd;
  // 처리 완료 알림 사용 여부
  @Column(name="PRCS_CMPL_NTC_USEYN")
  private String prcsCmplNtcUseyn;
  // 처리 완료 알림 신청자 알림 여부
  @Column(name="PRCS_CMPL_RQST_NTC_YN")
  private String prcsCmplRqstNtcYn;
  // 처리 완료 알림 참조자 알림 여부
  @Column(name="PRCS_CMPL_RQST_CC_YN")
  private String prcsCmplRqstCcYn;
  // 기초_결재 결재자 결재 처리 알림 여부
  @Column(name="PRCS_CMPL_RQST_APRV_YN")
  private String prcsCmplRqstAprvYn;
  // 처리 완료 Agent 팝업 알림 여부
  @Column(name="PRCS_CMPL_AGENT_POPUP_NTC_YN")
  private String prcsCmplAgentPopupNtcYn;
  // 처리 완료 Email 여부
  @Column(name="PRCS_CMPL_EMAIL_YN")
  private String prcsCmplEmailYn;
  // 처리 완료 문자메시지 여부
  @Column(name="PRCS_CMPL_TXT_MSG_YN")
  private String prcsCmplTxtMsgYn;
  // 처리 완료 문자메시지 종류 코드 (NH_0270)
  @Column(name="PRCS_CMPL_TXT_MSG_DVS_CD")
  private String prcsCmplTxtMsgDvsCd;
}
