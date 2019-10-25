package btl.simple.candidate;

public class CandidateFilterResult {

    private boolean result;

    private String reason;

    public CandidateFilterResult(boolean result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
