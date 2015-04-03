package bean;

public class PeriodBean {
	private String periodID;
	private String startTime;
	private String endTime;

	public PeriodBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPeriodID() {
		return periodID;
	}

	public void setPeriodID(String periodID) {
		this.periodID = periodID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Period [periodID=" + periodID + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]\n";
	}

}
