package com.cg.crs.mainclasses;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.crs.exception.CRSException;
import com.cg.crs.model.ClaimCreationEntity;
import com.cg.crs.model.UserRole;
import com.cg.crs.service.CRSService;
import com.cg.crs.service.implementation.CRSServiceImpl;
import com.cg.crs.ui.MainUI;

public class AdminViewClaim {

	public static void viewClaim(UserRole user) throws CRSException {
		Scanner scanner = new Scanner(System.in);
		CRSService service = new CRSServiceImpl();
		List<ClaimCreationEntity> list;
		try {
			list = service.viewAllClaim();
			System.out.println("All Claims");
			if (!list.isEmpty()) {

				for (ClaimCreationEntity entity : list) {
					System.out.println("\nClaim Number:    " + entity.getClaimNumber() + "\nClaim Reason:    "
							+ entity.getClaimReason() + "\nAccident Street: " + entity.getAccidentLocationStreet()
							+ "\nAccident City:   " + entity.getAccidentCity() + "\nAccident State   "
							+ entity.getAccidentState() + "\nAccident Zip     " + entity.getAccidentZip()
							+ "\nClaim Type       " + entity.getClaimType() + "\nPolicy Number   "
							+ entity.getPolicyNumber());
				}
			} else {
				System.err.println("No data found in database");
			}
		} catch (CRSException e) {
			System.err.println("Problem Occured while Viewing Claim Status");
		}

		boolean menuFlag = false;
		do {
			System.out.println(" ");
			System.out.println(
					"Press 1 to go back to main menu (or) Press 2 to go back to previous menu (or) Press 0 to Exit ");
			try {
				int menu = scanner.nextInt();
				if (menu == 1) {
					menuFlag = true;
					String[] args = null;
					MainUI.main(args);
				} else if (menu == 2) {
					menuFlag = true;
					Admin.adminClient(user);
				} else if (menu == 0) {
					menuFlag = true;
					System.out.println("Thank You");
					System.exit(0);
				} else {
					menuFlag = false;
					System.err.println("Enter Valid Details");
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter Only Integers");

			}
		} while (!menuFlag);

		scanner.close();
	}

}
