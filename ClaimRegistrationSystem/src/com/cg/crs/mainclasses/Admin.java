package com.cg.crs.mainclasses;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.crs.exception.CRSException;
import com.cg.crs.model.UserRole;

public class Admin {
	public static void adminClient(UserRole user) throws CRSException, InputMismatchException {
		Scanner scanner = null;
		boolean adminFlag = false;
		System.out.println("===============================Admin Menu===============================");

		int choice = 0;
		do {
			scanner = new Scanner(System.in);
			System.out.println("1.New Profile Creation");
			System.out.println("2.Claim Creation");
			System.out.println("3.View Claim");
			System.out.println("4.Report Generation");
			System.out.println("Enter your choice:");
			try {
				choice = scanner.nextInt();
				adminFlag = true;
				switch (choice) {
				case 1:
					UserProfileCreation.profileCreation(user);
					break;
				case 2:
					AdminClaim.claimCreation(user);
					break;
				case 3:
					boolean viewFlag = false;
					int viewChoice = 0;
					do {
						scanner = new Scanner(System.in);
						System.out.println("1.View All Claims");
						System.out.println("2.View Claims Based on Username");
						System.out.println("3.View Claims Based on Claim Id");
						System.out.println("Enter your choice:");
						try {
							viewChoice = scanner.nextInt();
							switch (viewChoice) {
							case 1:
								AdminViewClaim.viewClaim(user);
								viewFlag = true;
								break;
							case 2:
								AgentViewClaim.agentViewClaim(user);
								viewFlag = true;
								break;
							case 3:
								ViewClaim.viewClaim(user);
								viewFlag = true;
								break;
							default:
								System.err.println("Enter Integer from 1 to 3");
								viewFlag = false;
								break;
							}
						} catch (InputMismatchException e) {
							System.err.println("Enter Only digits");
						}

					} while (!viewFlag);
					break;
				case 4:
					ReportGeneration.reportGeneration(user);
					break;
				default:
					adminFlag = false;
					System.err.println("Enter input from 1 to 4");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter Only digits");
			}
		} while (!adminFlag);

		scanner.close();
	}

}
