```mermaid
graph LR
    %% Actor 설정
    Professor((교수))

    %% Use Case 및 시스템 경계
    subgraph 성적관리시스템
        UC1(성적입력)
        UC2(학점조회)
        UC3(교수체크)
    end

    %% 관계 설정
    Professor --> UC1
    Professor --> UC2

    %% Include 관계 (성적입력과 학점조회 시 반드시 교수체크가 선행됨)
    UC1 -.->|&lt&ltinclude&gt&gt| UC3
    UC2 -.->|&lt&ltinclude&gt&gt| UC3