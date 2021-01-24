package Hotel;

import java.util.Arrays;
import java.util.Scanner;

public class Function {
	Scanner sc = new Scanner(System.in);
	int choice, floor, room;
	String[][] hotel = new String[floor][room];
	
	void Select() {
		System.out.println("--------------- Hotel Management System ---------------");
		System.out.println("1- Check In");
		System.out.println("2- Checkout");
		System.out.println("3- Display");
		System.out.println("4- Exit");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.print("-> Choose option(1-4) : ");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			int Sfloor, Sroom;
			String name, enter;			
			
			System.out.println("-------------- Check in hotel ---------------");
			System.out.print("-> Enter floor number(1-" + floor +") : ");
			Sfloor = sc.nextInt();
				if(Sfloor < 1 || Sfloor > floor) {
					System.out.print("-> Enter floor number(1-" + floor +") : ");
					Sfloor = sc.nextInt();
				}
			System.out.print("-> Enter room number(1-" + room + ") : ");
			Sroom = sc.nextInt();
				if(Sroom < 1 || Sroom > room) {
					System.out.print("-> Enter room number(1-" + room + ") : ");
					Sroom = sc.nextInt();
				}
			if(hotel[Sfloor-1][Sroom-1] != null) {
				System.out.println("This room is already check in, Please find another room!");
			}else {
				System.out.print("-> Enter guest's name : ");
				name = sc.next();
				
				System.out.println(name + " check in succcessfully!");
				hotel[Sfloor-1][Sroom-1] = name;
				System.out.println();
				System.out.println("Press \"ENTER\" to continue...");
				enter = sc.nextLine();
			}
			break;
		case 2:
			int Cfloor, Croom;
			int Cnumber;
			
			System.out.println("--------------- Checkout from hotel ---------------");
			System.out.print("Enter floor number(1-" + floor +") : ");
			Cfloor = sc.nextInt();
				if(Cfloor < 1 || Cfloor > floor) {
					System.out.print("-> Enter floor number(1-" + floor +") : ");
					Cfloor = sc.nextInt();
				}
			System.out.print("Enter room number(1-" + room +") : ");
			Croom = sc.nextInt();
				if(Croom < 1 || Croom > room) {
					System.out.print("-> Enter room number(1-" + room + ") : ");
					Croom = sc.nextInt();
				}
			if(hotel[Cfloor-1][Croom-1] == null) {
				System.out.println("No one checkin in this room, you can't checkout!");
				System.out.println();
				System.out.println();
				System.out.println("Press \"ENTER\" to continue...");
			}else {
				System.out.print("Guest's Name : " + hotel[Cfloor-1][Croom-1] + ", Press 1 to checkout and 0 to cancel : ");
				Cnumber = sc.nextInt();
				if(Cnumber == 1) {
					System.out.println(hotel[Cfloor-1][Croom-1] + "has been checkout successfully!");
					hotel[Cfloor-1][Croom-1] = null;
				}else if(Cnumber == 0) {
					
				}else {
					
				}
			}
			break;
		case 3:
			System.out.println("--------------- Display hotel information ---------------");
			for(int i = 0; i < hotel.length; i++) {
				System.out.print("Floor " + (i+1) + " : ");
				System.out.print(Arrays.toString(hotel[i]));
				System.out.println();
			}
			System.out.println();
			System.out.println("Press \"ENTER\" to continue...");
			
			enter = sc.next();
	
			break;
		case 4:
			System.out.println("-> Good bye!");
			break;
	    }
	}
}
