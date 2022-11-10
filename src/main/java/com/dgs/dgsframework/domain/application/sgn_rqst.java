package com.dgs.dgsframework.domain.application;

import com.dgs.dgsframework.domain.cmn_grp_code;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sgn_rqst")
public class sgn_rqst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SR_KEY")
    private Long srKey;
    @Column(name = "SR_PRNT_KEY")
    private Long srPrntKey;
    @Column(name = "CGC_CD")
    private String cgcCd;
    @Column(name = "CDC_CD")
    private String cdcCd;
    @Column(name = "DTL_RQST_ITM_CD")
    private String dtlRqstItmCd;
    @Column(name = "RQST_ST_CD")
    private String rqstStCd;
    @Column(name = "PRCS_ST_CD")
    private String prcsStCd;
    @Column(name = "SGN_ST_CD")
    private String sgnStCd;
    @Column(name = "RQSTR_DVS_CD")
    private String rqstrDvsCd;
    @Column(name = "RQST_USR_KEY")
    private Long rqstUsrKey;
    @Column(name = "SI_ALL_YN")
    private String siAllYn;
    @Column(name = "SI_KEY")
    private Long siKey;
    @Column(name = "SGN_WAY_CD")
    private String sgnWayCd;
    @Column(name = "PRCS_WAY_CD")
    private String prcsWayCd;
    @Column(name = "MNL_REG_YN")
    private String mnlRegYn;
    @Column(name = "SR_NM")
    private String srNm;
    @Column(name = "RTWT_KEY")
    private Long rtwtKey;
    @Column(name = "EQMNT_DVS_CD")
    private String eqmntDvsCd;
    @Column(name = "EQMNT_NM")
    private String eqmntNm;
    @Column(name = "PRD_CNT_DVS_CD")
    private String prdCntDvsCd;
    @Column(name = "DMS_CNT")
    private Long dmsCnt;
    @Column(name = "STRT_DT")
    private Timestamp strtDt;
    @Column(name = "END_DT")
    private Timestamp endDt;
    @Column(name = "RQST_RSN")
    private String rqstRsn;
    @Column(name = "RQST_DT")
    private Timestamp rqstDt;
    @Column(name = "PRCSR_DVS_CD")
    private String prcsrDvsCd;
    @Column(name = "PRCS_ADM_KEY")
    private Long prcsAdmKey;
    @Column(name = "PRCS_DT")
    private Timestamp prcsDt;
    @Column(name = "PRCS_CNTNT")
    private String prcsCntnt;
    @Column(name = "ARBTRY_KEY")
    private Long arbtryKey;
    @Column(name = "ARBTRY_SGN_RSN")
    private String arbtrySgnRsn;
    @Column(name = "ARBTRY_PRCS_CNTNT")
    private String arbtryPrcsCntnt;
    @Column(name = "REGR_DVS_CD")
    private String regrDvsCd;
    @Column(name = "REG_KEY")
    private Long regKey;
    @Column(name = "ARBTRY_DT")
    private Timestamp arbtryDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CGC_CD", referencedColumnName = "CGC_CD", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private cmn_grp_code cmn_grp_code;
}
