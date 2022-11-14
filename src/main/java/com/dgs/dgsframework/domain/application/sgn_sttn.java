package com.dgs.dgsframework.domain.application;

import com.dgs.dgsframework.domain.cmn_dtl_code;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_sttn")
@IdClass(sgn_sttn_id.class)
public class sgn_sttn {

    @Id
    @Column(name = "SR_KEY")
    private Long srKey;
    @Id
    @Column(name = "SGNR_KEY")
    private Long sgnrKey;
    @Id
    @Column(name = "SGNR_DVS_CD")
    private String sgnrDvsCd;
    @Column(name = "SGN_STP")
    private Long sgnStp;
    @Column(name = "SGN_RSN")
    private String sgnRsn;
    @Column(name = "SGN_ST_CD")
    private String sgnStCd;
    @Column(name = "SGN_DT")
    private Timestamp sgnDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "'NH_0094'", referencedColumnName = "CGC_CD")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "SGNR_DVS_CD", referencedColumnName = "CDC_CD", insertable = false, updatable = false))
    })
    @NotFound(action = NotFoundAction.IGNORE)
    private cmn_dtl_code cmn_dtl_code_approvalType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "'NH_0095'", referencedColumnName = "CGC_CD")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "SGN_ST_CD", referencedColumnName = "CDC_CD", insertable = false, updatable = false))
    })
    @NotFound(action = NotFoundAction.IGNORE)
    private cmn_dtl_code cmn_dtl_code;

}
