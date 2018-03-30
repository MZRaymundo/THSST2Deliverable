package com.trial;

public class Field {

	private double x;
	private double y;
	
	private double width;
	private double height;
	
	private double question;
	private int score;
	
	private boolean isChecked;
	
	public Field(double x, double y, double width, double height, double question, int score) {
		this.setX(x);
		this.setY(y);
		
		this.setWidth(width);
		this.setHeight(height);
		
		this.setQuestion(question);
		this.setScore(score);
		
		this.setChecked(false);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getQuestion() {
		return question;
	}

	public void setQuestion(double question) {
		this.question = question;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
