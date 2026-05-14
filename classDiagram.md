classDiagram

    class 교수 {
        -String 교수id
        +교수체크(교수id: String) boolean
    }

    class 성적 {
        -String 학생id
        -int 자바
        -int DB
        -int 보안
        -int 총점
        -double 평균
        -String 학점
        +성적입력(학생id: String, 자바: int, DB: int, 보안: int) void
        +학점조회(학생id: String) String
        -총점계산() void
        -평균계산() void
    }

    class 성적입력 {
        <<boundary>>
    }

    class 학점조회 {
        <<boundary>>
    }

    성적입력 ..> 교수 : 2: 교수체크() 호출
    성적입력 ..> 성적 : 4: 성적입력() 호출
    학점조회 ..> 교수 : 2: 교수체크() 호출
    학점조회 ..> 성적 : 4: 학점조회() 호출