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
@Table(name = "sgn_atch_rfr")
@IdClass(sgn_atch_rfr_id.class)
public class sgn_atch_rfr {

  @Id
  @Column(name="SR_KEY")
  private Long srKey;
  @Id
  @Column(name="SAR_KEY")
  private Long sarKey;
  @Id
  @Column(name="SAR_DVS_CD")
  private String sarDvsCd;
  @Column(name="CHECK_DT")
  private Timestamp checkDt;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
