package com.dgs.dgsframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class cmn_dtl_code_id implements Serializable {
    private String cgcCd;
    private String cdcCd;
}
