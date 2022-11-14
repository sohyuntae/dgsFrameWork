package com.dgs.dgsframework.domain.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class sgn_rqst_ipm_ip_list_id implements Serializable {

  // 일련번호
  private Long sriKey;
  // IP 키
  private Long ipKey;
}
