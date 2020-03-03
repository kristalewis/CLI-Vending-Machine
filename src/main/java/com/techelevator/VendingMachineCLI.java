package com.techelevator;


import java.util.Scanner;


import com.techelevator.objects.VendingMachine;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_QUIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money (dollar amount in numbers)";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String SALES_REPORT_MENU_OPTION_PRINT_SALES_REPORT = "Print Sales Report";
	private static final String SALES_REPORT_MENU_OPTION_DELETE_A_SALES_REPORT = "Delete A Sales Report";
	private static final String SALES_REPORT_MENU_OPTION_QUIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
														MAIN_MENU_OPTION_QUIT, MAIN_MENU_OPTION_SALES_REPORT };

	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
															PURCHASE_MENU_FINISH_TRANSACTION };
	
	private static final String[] SALES_REPORT_MENU_OPTIONS = { SALES_REPORT_MENU_OPTION_PRINT_SALES_REPORT, 
						SALES_REPORT_MENU_OPTION_DELETE_A_SALES_REPORT, SALES_REPORT_MENU_OPTION_QUIT };

	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine("VendingMachine.txt");
	
	private Scanner userInput = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean done = false;
		while (done == false) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS, MAIN_MENU_OPTION_SALES_REPORT);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vendingMachine.getInventory());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean purchaseDone = false;
				while (purchaseDone == false) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						handleFeedMoney();
					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						System.out.println(vendingMachine.getInventory());
						handlePurchase();
					} else if (purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						handleExit();
						purchaseDone = true;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_QUIT)) {
				done = true;
			} else if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)) {
				boolean salesReportDone = false;
				while (salesReportDone == false) {
					String salesChoice = (String) menu.getChoiceFromOptions(SALES_REPORT_MENU_OPTIONS);
					
					if (salesChoice.equals(SALES_REPORT_MENU_OPTION_PRINT_SALES_REPORT)) {
						System.out.println(vendingMachine.writeSalesReport());
					} else if (salesChoice.equals(SALES_REPORT_MENU_OPTION_DELETE_A_SALES_REPORT)) {
						handleDeleteSpecificSalesReport();
					} else if (salesChoice.equals(SALES_REPORT_MENU_OPTION_QUIT)) {
						salesReportDone = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	private void handlePurchase() {
		System.out.println("Select purchase");
		String selector = userInput.nextLine().toUpperCase();
		System.out.println(vendingMachine.processPurchase(selector));
	}
	
	private void handleFeedMoney() {
		System.out.print("Please insert currency >>> ");
		System.out.println(vendingMachine.getMoney(userInput.nextLine()));
	}
	
	private void handleExit() {
		System.out.println(vendingMachine.getChange());
	}
	
	private void handleDeleteSpecificSalesReport() {
		System.out.println("Select the number index of the sales report to delete(as an integer)");
		String selector = userInput.nextLine();
		System.out.println(vendingMachine.deleteSpecificSalesReport(selector));
	}
}
