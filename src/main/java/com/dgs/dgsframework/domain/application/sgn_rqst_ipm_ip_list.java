package com.dgs.dgsframework.domain.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// 결재 신청 IP 목록
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_rqst_ipm_ip_list")
@IdClass(sgn_rqst_ipm_ip_list_id.class)
public class sgn_rqst_ipm_ip_list {

  // 일련번호
  @Id
  @Column(name="SRI_KEY")
  private Long sriKey;
  // IP 키
  @Id
  @Column(name="IP_KEY")
  private Long ipKey;
}
