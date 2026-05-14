package C;

public class 교수 {
    private String 교수id;

    public 교수() {
        this.교수id = "inha"; 
    }

    public boolean 교수체크(String 입력id) {
        if (입력id != null && 입력id.equals(this.교수id)) {
            return true;
        }
        return false;
    }
}