package com.achyut.backup;

public class Hand {
	private int fingers;

	public Hand() {
		fingers = 1;
	}

	public int getCount() {
		return fingers;
	}

	public void changeFingers(int num) {
		fingers = fingers + num;
	}

	public boolean checkIfOut() {
		if (fingers >= 5) {
			fingers = 0;
			return true;
		}
		return false;
	}

}
