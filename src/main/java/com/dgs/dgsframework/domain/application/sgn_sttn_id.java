package com.dgs.dgsframework.domain.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class sgn_sttn_id implements Serializable
{

    private Long srKey;
    private Long sgnrKey;
    private String sgnrDvsCd;
}
