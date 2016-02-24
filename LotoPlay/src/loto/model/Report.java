package loto.model;

public class Report {

	private DateTime dateTime;
	private Numbers numbers;
	
	public Report() {
		dateTime = new DateTime();
		numbers  = new Numbers();
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Numbers getNumbers() {
		return numbers;
	}
	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}
	
	
}
