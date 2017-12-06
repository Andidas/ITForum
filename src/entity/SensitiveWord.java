package entity;

/**
 * 敏感词
 * @author lwy
 *
 */
public class SensitiveWord {
	public SensitiveWord(int wid, String word) {
		super();
		this.wid = wid;
		this.word = word;
	}
	public SensitiveWord() {
		super();
	}
	private int wid;
	private String word;
	@Override
	public String toString() {
		return "SensitiveWord [wid=" + wid + ", word=" + word + "]";
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
}
