```mermaid
sequenceDiagram
    autonumber
    actor 교수_Actor as 교수
    participant AddUI as <<boundary>><br>Add_Sungjuk_UI
    participant 교수클래스 as 교수
    participant 성적클래스 as 성적

    Note over 교수_Actor, 성적클래스:  성적입력
    
    교수_Actor->>AddUI: 성적입력요청(String 교수id, String 학생id, int 자바, int DB, int 보안)
    
    %% 교수 ID 체크 (교수 클래스의 행위)
    AddUI->>교수클래스: 교수체크(String 교수id)
    교수클래스-->>AddUI: 유효성 반환
    
    alt 교수id == "inha"
        %% 성적 입력 및 계산 (성적 클래스의 행위)
        AddUI->>성적클래스: 성적입력(String 학생id, int 자바, int DB, int 보안)
        성적클래스->>성적클래스: 총점계산()
        성적클래스->>성적클래스: 평균계산()
        성적클래스-->>AddUI: 입력성공 반환
        AddUI-->>교수_Actor: 완료 메시지 출력
    else 교수id != "inha"
        AddUI-->>교수_Actor: 권한오류 메시지 출력
    end