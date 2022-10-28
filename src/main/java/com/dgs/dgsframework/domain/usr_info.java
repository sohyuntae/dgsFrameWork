package com.dgs.dgsframework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usr_info")
public class usr_info {
  @Id
  @Column(name="UI_KEY")
  private Long uiKey;
  @Column(name="UI_ID")
  private String uiId;
  @Column(name="UI_PW")
  private String uiPw;
  @Column(name="UI_NM")
  private String uiNm;
  @Column(name="CPY_USR_NMBR")
  private String cpyUsrNmbr;
  @Column(name="GDR_CD")
  private String gdrCd;
  @Column(name="EMAIL")
  private String email;
  @Column(name="MBL_PHN_NMBR")
  private String mblPhnNmbr;
  @Column(name="CPY_PHN_NMBR")
  private String cpyPhnNmbr;
  @Column(name="CPY_ETS_NMBR")
  private String cpyEtsNmbr;
  @Column(name="JOB_GRP_CD")
  private String jobGrpCd;
  @Column(name="JOB_PST_CD")
  private String jobPstCd;
  @Column(name="JOB_DTY_CD")
  private String jobDtyCd;
  @Column(name="DVS_MNGR_YN")
  private String dvsMngrYn;
  @Column(name="GRP_LDR_YN")
  private String grpLdrYn;
  @Column(name="WRK_SAT_CD")
  private String wrkSatCd;
  @Column(name="BIZ_CRG")
  private String bizCrg;
  @Column(name="LI_KEY")
  private Long liKey;
  @Column(name="PCTR_FILE_PATH")
  private String pctrFilePath;
  @Column(name="CPY_STRT_DT")
  private Timestamp cpyStrtDt;
  @Column(name="CPY_EXPR_DT")
  private Timestamp cpyExprDt;
  @Column(name="UI_NOTE")
  private String uiNote;
  @Column(name="USR_TYPE_CD")
  private String usrTypeCd;
  @Column(name="WBMN_STR_KEY")
  private String wbmnStrKey;
  @Column(name="LNKG_CMPNY_CD")
  private String lnkgCmpnyCd;
  @Column(name="LNKG_EMP_CD")
  private String lnkgEmpCd;
  @Column(name="LNKG_UPD_DT")
  private Timestamp lnkgUpdDt;
  @Column(name="PW_INI_RQST_STRT_DT")
  private Timestamp pwIniRqstStrtDt;
  @Column(name="PW_INI_RQST_EXPR_DT")
  private Timestamp pwIniRqstExprDt;
  @Column(name="PW_INI_DT")
  private Timestamp pwIniDt;
  @Column(name="OT_CMPNY_NM")
  private String otCmpnyNm;
  @Column(name="UPD_KEY")
  private Long updKey;
  @Column(name="UPD_DT")
  private Timestamp updDt;
  @Column(name="REG_KEY")
  private Long regKey;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
