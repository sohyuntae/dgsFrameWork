package com.dgs.dgsframework.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cmn_grp_code")
public class cmn_grp_code {

  @Id
  @Column(name="CGC_CD")
  private String cgcCd;
  @Column(name="CGC_NM")
  private String cgcNm;
  @Column(name="CGC_DSCRB")
  private String cgcDscrb;
  // JeonHwan for OMA
  @Column(name="USE_YN")
  private String useYn;
  @Column(name="UDF_CD_CRT_AUTO_YN")
  private String udfCdCrtAutoYn;
  @Column(name="UDF_CD_LEN")
  private Long udfCdLen;
  //
  @Column(name="DLT_YN")
  private String dltYn;
  @Column(name="UPD_KEY")
  private Long updKey;
  @Column(name="UPD_DT")
  private Timestamp updDt;
  @Column(name="REG_KEY")
  private Long regKey;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
