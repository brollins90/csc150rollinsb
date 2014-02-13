package edu.neumont.csc150.lab8.rollinsb;

import java.awt.event.ActionListener;

public interface Field {

	public void clearField();
	public int getNumberOfColumns();
	public int getNumberOfRows();
	public boolean isLocationOnField(int testColumn, int testRow);
	public void placeBot(int column, int row);
	public void printField();
	public void addTimeListener(ActionListener tListener);
}
