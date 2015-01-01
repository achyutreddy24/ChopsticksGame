package com.achyut.main;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Hand l1 = new Hand();
		Hand r1 = new Hand();
		Hand l2 = new Hand();
		Hand r2 = new Hand();
		Scanner s = new Scanner(System.in);

		boolean keepPlaying = true;
		boolean handPick = true;
		boolean actionPick = true;
		int counter = 0;
		int whichHand;
		int whichAction;
		int transferNum;
		boolean onePlayer;
		int playerNum;
		
		System.out.println("Pick an Option:\n1) One Player\n2) Two Players");
		playerNum = s.nextInt();
		if(playerNum == 1){
			//Execute Main
		}else if(playerNum == 2){
			
		}else{
			System.out.println("Invalid");
		}
		

		System.out.println("Player 2's Hands    Left:" + l2.getCount()
				+ " Right:" + r2.getCount());
		System.out.println("Player 1's Hands    Left:" + l1.getCount()
				+ " Right:" + r1.getCount());

		while (keepPlaying) {
			counter++;
			if (counter % 2 == 1) {
				System.out
						.println("Player one, pick a hand, \n1)Left\n2)Right");
				whichHand = s.nextInt();
				handPick = true;
				while (handPick) {
					if (whichHand == 1 && l1.getCount() != 0) {
						System.out
								.println("What would you like to do? \n1)Transfer \n2)Hit Left \n3)Hit Right");
						whichAction = s.nextInt();
						actionPick = true;

						while (actionPick) {
							if (whichAction == 1) {
								System.out
										.println("How many would you like to transfer?");
								transferNum = s.nextInt();
								if (transferNum <= l1.getCount()) {
									r1.changeFingers(transferNum);
									l1.changeFingers(-transferNum);
									actionPick = false;
								} else {
									System.out
											.println("You cannot transfer that");
									actionPick = true;
								}
							} else if (whichAction == 2) {
								l2.changeFingers(l1.getCount());
								actionPick = false;
							} else if (whichAction == 3) {
								r2.changeFingers(l1.getCount());
								actionPick = false;
							} else {
								actionPick = true;
							}
						}

						handPick = false;
					} else if (whichHand == 2 && r1.getCount() != 0) {
						System.out
								.println("What would you like to do? \n1)Transfer \n2)Hit Left \n3)Hit Right");
						whichAction = s.nextInt();
						actionPick = true;

						while (actionPick) {
							if (whichAction == 1) {
								System.out
										.println("How many would you like to transfer?");
								transferNum = s.nextInt();
								if (transferNum <= r1.getCount()) {
									l1.changeFingers(transferNum);
									r1.changeFingers(-transferNum);
									actionPick = false;
								} else {
									System.out
											.println("You cannot transfer that");
									actionPick = true;
								}
							} else if (whichAction == 2) {
								l2.changeFingers(r1.getCount());
								actionPick = false;
							} else if (whichAction == 3) {
								r2.changeFingers(r1.getCount());
								actionPick = false;
							} else {
								actionPick = true;
							}
						}

						handPick = false;
					} else {
						System.out.println("Invalid Response, Try Again");
						handPick = true;
					}
				}
			} else {
				System.out
						.println("Player two, pick a hand, \n1)Left\n2)Right");
				whichHand = s.nextInt();
				handPick = true;
				while (handPick) {
					if (whichHand == 1 && l2.getCount() != 0) {
						System.out
								.println("What would you like to do? \n1)Transfer \n2)Hit Left \n3)Hit Right");
						whichAction = s.nextInt();
						actionPick = true;

						while (actionPick) {
							if (whichAction == 1) {
								System.out
										.println("How many would you like to transfer?");
								transferNum = s.nextInt();
								if (transferNum <= l2.getCount()) {
									r2.changeFingers(transferNum);
									l2.changeFingers(-transferNum);
									actionPick = false;
								} else {
									System.out
											.println("You cannot transfer that");
									actionPick = true;
								}
							} else if (whichAction == 2) {
								l1.changeFingers(l2.getCount());
								actionPick = false;
							} else if (whichAction == 3) {
								r1.changeFingers(l2.getCount());
								actionPick = false;
							} else {
								actionPick = true;
							}
						}

						handPick = false;
					} else if (whichHand == 2 && r2.getCount() != 0) {
						System.out
								.println("What would you like to do? \n1)Transfer \n2)Hit Left \n3)Hit Right");
						whichAction = s.nextInt();
						actionPick = true;

						while (actionPick) {
							if (whichAction == 1) {
								System.out
										.println("How many would you like to transfer?");
								transferNum = s.nextInt();
								if (transferNum <= r2.getCount()) {
									l2.changeFingers(transferNum);
									r2.changeFingers(-transferNum);
									actionPick = false;
								} else {
									System.out
											.println("You cannot transfer that");
									actionPick = true;
								}
							} else if (whichAction == 2) {
								l1.changeFingers(r2.getCount());
								actionPick = false;
							} else if (whichAction == 3) {
								r1.changeFingers(r2.getCount());
								actionPick = false;
							} else {
								actionPick = true;
							}
						}

						handPick = false;
					} else {
						System.out.println("Invalid Response, Try Again");
						handPick = true;
					}
				}
			}

			l1.checkIfOut();
			r1.checkIfOut();
			l2.checkIfOut();
			r2.checkIfOut();

			if (l1.getCount() == 0 && r1.getCount() == 0) {
				keepPlaying = false;
				System.out.println("Player 2 wins!  Game took " + counter + " turns");
			} else if (l2.getCount() == 0 && r2.getCount() == 0) {
				keepPlaying = false;
				System.out.println("Player 1 wins!  Game took " + counter + " turns");

			}

			System.out.println("Player 2's Hands    Left:" + l2.getCount()
					+ " Right:" + r2.getCount());
			System.out.println("Player 1's Hands    Left:" + l1.getCount()
					+ " Right:" + r1.getCount());
		}
	}
}