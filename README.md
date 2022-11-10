# dgsFrameWork
netflix DGS FramWork Test

# 신청 관련 내용 정리.

(saveCommonApplication)
신청 
 ㄴ 공통 정보 
 ㄴ 상세 정보
 ㄴ 결재 정보
 ㄴ 참조자 정보

-- 신청 관련 내용에 대해서만 저장 하고 결재로 넘긴다.
# 결재쪽으로 데이터를 넘길떄 필수값
 ㄴ 신청키
 ㄴ 자가 결재 여부
 ㄴ 결재 타입(사용자 : 1, 결재자 : 2)
 ㄴ 결재 정보

결재
 ㄴ 자가 결재
 ㄴ 사용자 결재 (승인 / 반려)
 ㄴ 관리자 결재 (승인 / 반려)

반려가 발생한 경우 기존 로직
 - 신청 정보의 상태값 반려로 변경.

참조자
 ㄴ 참조자 저장.

-- 결재에 대해서 상황을 보고 결재를 하고 처리단계로 넘어가야 되는 경우 처리로 전달.

-- 
처리
 ㄴ 관리자 자동 처리
 ㄴ 관리자 수동 처리 

-- 처리시, 자동 처리인 경우 자동 처리 프로세스로 이동 아닌 경우 그냥 상태값 처리.

변경 로직의 경우 SAM, ESM 기준으로 조회.


test

mutation {
  addApplication(
    addApplicationBasic: {applicationTitle: "test", CGC_CD: "1", CDC_CD: "1", applicationStatusCode: "1", registrarTypeCode: "1", registrarKey: 1}
    addApplicationDetail: {module: SAM}
    addAddition: []
    addApproval: []
    addReference: []
  )
}
