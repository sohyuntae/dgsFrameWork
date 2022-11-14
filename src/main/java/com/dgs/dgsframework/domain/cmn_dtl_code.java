package com.dgs.dgsframework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cmn_dtl_code")
@IdClass(cmn_dtl_code_id.class)
public class cmn_dtl_code {

  @Id
  @Column(name="CGC_CD")
  private String cgcCd;
  @Id
  @Column(name="CDC_CD")
  private String cdcCd;
  @Column(name="CDC_NM")
  private String cdcNm;
  @Column(name="CDC_DSCRB")
  private String cdcDscrb;
  @Column(name="CDC_ORD")
  private Long cdcOrd;
  @Column(name="CDC_NOTE")
  private String cdcNote;
  @Column(name="UDF_CDC_CD")
  private String udfCdcCd;
  @Column(name="USR_TYPE_CD")
  private String usrTypeCd;
  @Column(name="IMG_FILE_PATH")
  private String imgFilePath;
  @Column(name="IMG_FILE_SIZE_KB")
  private Long imgFileSizeKb;
  @Column(name="IMG_FILE_HASH_VAL")
  private String imgFileHashVal;
  @Column(name="RSGT_PATH")
  private String rsgtPath;
  @Column(name="RSGT_NM")
  private String rsgtNm;
  @Column(name="UDF_CD_LEN")
  private Long udfCdLen;
  @Column(name="USE_YN")
  private String useYn;
  @Column(name="LNKG_YN")
  private String lnkgYn;
  @Column(name="DLT_YN")
  private String dltYn;
  @Column(name="FIX_YN")
  private String fixYn;
  @Column(name="UPD_KEY")
  private Long updKey;
  @Column(name="UPD_DT")
  private Timestamp updDt;
  @Column(name="REG_KEY")
  private Long regKey;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
