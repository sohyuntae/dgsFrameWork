package com.dgs.dgsframework.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "nh_adm_info")
public class nh_adm_info {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="NAI_KEY")
  @JsonBackReference
  private Long naiKey;
  @Column(name="NAI_ID")
  private String naiId;
  @Column(name="NAI_PW")
  private String naiPw;
  @Column(name="NAI_NM")
  private String naiNm;
  @Column(name="ADM_DVS_CD")
  private String admDvsCd;
  @Column(name="PCTR_FILE_PATH")
  private String pctrFilePath;
  @Column(name="EMAIL")
  private String email;
  @Column(name="CPY_PHN_NMBR")
  private String cpyPhnNmbr;
  @Column(name="CPY_ETS_NMBR")
  private String cpyEtsNmbr;
  @Column(name="MBL_NMBR")
  private String mblNmbr;
  @Column(name="USE_DSGN_YN")
  private String useDsgnYn;
  @Column(name="USE_STRT_DT")
  private Timestamp useStrtDt;
  @Column(name="USE_EXPR_DT")
  private Timestamp useExprDt;
  @Column(name="ACS_SCRT_USE_YN")
  private String acsScrtUseYn;
  @Column(name="NAI_NOTE")
  private String naiNote;
  @Column(name="NAI_PRNT_KEY")
  private Long naiPrntKey;
  @Column(name="NSI_STR_KEY")
  private String nsiStrKey;
  @Column(name="OG_STR_KEY")
  private String ogStrKey;
  @Column(name="PRDCT_WHL_ATHRTY_YN")
  private String prdctWhlAthrtyYn;
  @Column(name="POS_PRDCT_STR_KEY")
  private String posPrdctStrKey;
  @Column(name="ATHRTY_PRDCT_STR_KEY")
  private String athrtyPrdctStrKey;
  @Column(name="PW_INI_RQST_STRT_DT")
  private Timestamp pwIniRqstStrtDt;
  @Column(name="PW_INI_RQST_EXPR_DT")
  private Timestamp pwIniRqstExprDt;
  @Column(name="PW_INI_DT")
  private Timestamp pwIniDt;
  @Column(name="STOP_YN")
  private String stopYn;
  @Column(name="DLT_YN")
  private String dltYn;
  @Column(name="CMPNY_NM")
  private String cmpnyNm;
  @Column(name="DEPT_NM")
  private String deptNm;
  @Column(name="GNRL_PHN_NMBR")
  private String gnrlPhnNmbr;
  @Column(name="STRT_PRDCT_KEY")
  private Long strtPrdctKey;
  @Column(name="LGIN_FAIL_CNT")
  private Long lginFailCnt;
  @Column(name="LGIN_LST_FAIL_DT")
  private Timestamp lginLstFailDt;
  @Column(name="UPD_KEY")
  private Long updKey;
  @Column(name="UPD_DT")
  private Timestamp updDt;
  @Column(name="REG_KEY")
  private Long regKey;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
