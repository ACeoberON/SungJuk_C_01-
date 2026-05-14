package C;

public class 성적 {
    private String 학생id;
    private int 자바;
    private int DB;
    private int 보안;
    private int 총점;
    private double 평균;
    private String 학점;

    // 기존 '성적입력' 클래스의 역할 수행
    public String 성적입력요청(교수 교수객체, String 교수id, String 입력학생id, int 입력자바, int 입력DB, int 입력보안) {
        if (교수객체.교수체크(교수id)) {
            this.학생id = 입력학생id;
            this.자바 = 입력자바;
            this.DB = 입력DB;
            this.보안 = 입력보안;
            
            총점계산();
            평균계산();
            
            return "[성적입력 성공] 학생(" + 학생id + ")의 성적이 등록되었습니다.";
        } else {
            return "[성적입력 실패] 권한 오류: 해당 교수 ID(" + 교수id + ")는 성적 입력 권한이 없습니다.";
        }
    }

    private void 총점계산() {
        this.총점 = this.자바 + this.DB + this.보안;
    }

    private void 평균계산() {
        this.평균 = this.총점 / 3.0;
    }

    // 기존 '학점조회' 클래스의 역할 수행
    public String 학점조회요청(교수 교수객체, String 교수id, String 조회학생id) {
        if (교수객체.교수체크(교수id)) {
            if (this.학생id != null && this.학생id.equals(조회학생id)) {
                if (this.평균 >= 90) {
                    this.학점 = "A";
                } else if (this.평균 >= 80) {
                    this.학점 = "B";
                } else {
                    this.학점 = "C";
                }
                return "[학점조회 성공] 학생(" + 조회학생id + ")의 최종 학점은 [" + this.학점 + "] 입니다.";
            }
            return "[학점조회 실패] 해당 학생의 성적 정보가 없습니다.";
        } else {
            return "[학점조회 실패] 권한 오류: 해당 교수 ID(" + 교수id + ")는 학점 조회 권한이 없습니다.";
        }
    }
}