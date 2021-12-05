package vo;

public class PointVO {
	private String artistId; // 참가자 번호
	private String artistName; // 참가자이름
	private String birth; // 참가자 생일
	private int point; // 점수
	private String grade; // 등급
	private String mentoName; // 평균
	private float average; // 멘토 이름
	private int rank; // 순위

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMentoName() {
		return mentoName;
	}

	public void setMentoName(String mentoName) {
		this.mentoName = mentoName;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
