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
@Table(name = "sgn_rqst_file")
public class sgn_rqst_file {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SRF_SEQ")
  private Long srfSeq;
  @Column(name="SR_KEY")
  private Long srKey;
  @Column(name="FILE_PATH")
  private String filePath;
  @Column(name="SIZE_KB")
  private Long sizeKb;
  @Column(name="REG_DT")
  private Timestamp regDt;
}
