```mermaid
sequenceDiagram
    actor 교수
    participant UI as <<boundary>><br/>학점조회
    participant P as :교수
    participant S as :성적

    교수->>UI: 1: 학점조회요청(교수id, 학생id)
    activate UI

    UI->>P: 2: 교수체크(교수id)
    activate P

    P->>P: 2.1: id == "inha" 검증

    P-->>UI: 3: 검증결과 반환(boolean)
    deactivate P

    alt 교수체크 성공
        UI->>S: 4: 학점조회(학생id)
        activate S

        S->>S: 4.1: 평균 >= 90 → "A"
        S->>S: 4.2: 평균 >= 80 → "B"
        S->>S: 4.3: 평균 < 80 → "C"

        S-->>UI: 5: 학점 반환(grade: String)
        deactivate S

        UI-->>교수: 6: 조회결과 출력(JSP)
    else 교수체크 실패
        UI-->>교수: 권한 없음 메시지 출력
    end

    deactivate UI