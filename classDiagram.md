```mermaid
classDiagram
    class 교수 {
        -String 교수id
        +교수체크(입력id: String) boolean
    }
    
    class 성적 {
        -String 학생id
        -int 자바
        -int DB
        -int 보안
        -int 총점
        -double 평균
        -String 학점
        +성적입력(입력교수id: String, 입력학생id: String, 입력자바: int, 입력DB: int, 입력보안: int) void
        +학점조회(입력교수id: String) String
    }
    
    class Add_SungJuk_UI {
        <<boundary>>
    }
    
    class Search_SungJuk_UI {
        <<boundary>>
    }

    Add_SungJuk_UI ..> 교수 : 교수id 검증 요청
    Add_SungJuk_UI ..> 성적 : 성적입력() 호출
    Search_SungJuk_UI ..> 교수 : 교수id 검증 요청
    Search_SungJuk_UI ..> 성적 : 학점조회() 호출