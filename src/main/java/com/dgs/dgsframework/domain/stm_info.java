package com.dgs.dgsframework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "stm_info")
public class stm_info {
    @Id
    @Column(name="SI_KEY")
    private Long siKey;
    @Column(name="GU_KEY")
    private Long guKey;
    @Column(name="OG_KEY")
    private Long ogKey;
    @Column(name="SI_NM")
    private String siNm;
    @Column(name="SI_IP")
    private String siIp;
}
