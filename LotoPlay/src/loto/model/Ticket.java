package loto.model;

public class Ticket {

	private int id;
	private String dateTime;
	private Numbers numbers;
	
	public Ticket() {
		numbers = new Numbers();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Numbers getNumbers() {
		return numbers;
	}
	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}
	
	
}
