package Hotel;

import java.util.*;

public class HotelManagement {
	static String[][] hotel;//field about array
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// Use for input
		int floor, room;
		
		System.out.println("--------------- Setting up hotel ---------------");
		System.out.print("-> Enter number of floors : ");
		floor = sc.nextInt();
		System.out.print("-> Enter number of rooms in each floor : ");
		room = sc.nextInt();
		System.out.print("=> Hotel is already setup with " + floor + " floors and " + room + " rooms successfully" );
		hotel = new String[floor][room]; // according to floor, room -> we make hotel matrix
		
		System.out.println();
		System.out.println();
		System.out.println("Press \"ENTER\" to continue...");
		Function(floor, room);// for recursive function 
	}
	public static void Function(int kfloor, int kroom) { 
		int choice;
		String str;
		Scanner sc = new Scanner(System.in);
		String readString = sc.nextLine();
		
		System.out.println("--------------- Hotel Management System ---------------");
		System.out.println("1- Check In");
		System.out.println("2- Checkout");
		System.out.println("3- Display");
		System.out.println("4- Exit");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.print("-> Choose option(1-4) : ");
		while(true) {
			try {
				choice = sc.nextInt();
				if(choice < 1 || choice > 4) {
					System.out.println("Please input number 1 to 4");
					System.out.print("-> Choose option(1-4) : ");
					choice = sc.nextInt();
				}
				break;
			}
			catch(InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("VALUE IS INVALID");
				System.out.print("-> Choose option(1-4) : ");
			}
		}
		switch(choice) {
		case 1: //Check In
			int Sfloor, Sroom;
			String name, enter;			
			
			System.out.println("-------------- Check in hotel ---------------");
			System.out.print("-> Enter floor number(1-" + kfloor +") : ");
			Sfloor = sc.nextInt();
				if(Sfloor < 1 || Sfloor > kfloor) {
					System.out.print("-> Enter floor number(1-" + kfloor +") : ");
					Sfloor = sc.nextInt();
				}
			System.out.print("-> Enter room number(1-" + kroom + ") : ");
			Sroom = sc.nextInt();
				if(Sroom < 1 || Sroom > kroom) {
					System.out.print("-> Enter room number(1-" + kroom + ") : ");
					Sroom = sc.nextInt();
				}
			if(hotel[Sfloor-1][Sroom-1] != null) {
				System.out.println("This room is already check in, Please find another room!");
				System.out.println();
				if(readString.isEmpty()) {
					System.out.println("Press \"ENTER\" to continue...");
				}
				if(sc.hasNextLine()) {
					readString = sc.nextLine();
				}else {
					readString = null;
				}
				Function(kfloor, kroom);
			}else if(hotel[Sfloor-1][Sroom-1] == null){
				System.out.print("-> Enter guest's name : ");
				name = sc.next();
				
				System.out.println(name + " check in succcessfully!");
				hotel[Sfloor-1][Sroom-1] = name;
				System.out.println();
				if(readString.isEmpty()) {
					System.out.println("Press \"ENTER\" to continue...");
				}
				if(sc.hasNextLine()) {
					readString = sc.nextLine();
				}else {
					readString = null;
				}
				Function(kfloor, kroom);
			}
			break;
		case 2: //Checkout
			int Cfloor, Croom;
			int Cnumber;
			
			
			System.out.println("--------------- Checkout from hotel ---------------");
			System.out.print("Enter floor number(1-" + kfloor +") : ");
			Cfloor = sc.nextInt();
				if(Cfloor < 1 || Cfloor > kfloor) {
					System.out.print("-> Enter floor number(1-" + kfloor +") : ");
					Cfloor = sc.nextInt();
				}
			System.out.print("Enter room number(1-" + kroom +") : ");
			Croom = sc.nextInt();
				if(Croom < 1 || Croom > kroom) {
					System.out.print("-> Enter room number(1-" + kroom + ") : ");
					Croom = sc.nextInt();
				}
			if(hotel[Cfloor-1][Croom-1] == null) {
				System.out.println("No one checkin in this room, you can't checkout!");
				System.out.println();
				if(readString.isEmpty()) {
					System.out.println("Press \"ENTER\" to continue...");
				}
				if(sc.hasNextLine()) {
					readString = sc.nextLine();
				}else {
					readString = null;
				}
				Function(kfloor, kroom);
			}else {
				System.out.print("Guest's Name : " + hotel[Cfloor-1][Croom-1] + ", Press 1 to checkout and 0 to cancel : ");
				Cnumber = sc.nextInt();
				if(Cnumber == 1) {
					System.out.println(hotel[Cfloor-1][Croom-1] + " has been checkout successfully!");
					hotel[Cfloor-1][Croom-1] = null;
					System.out.println();
					if(readString.isEmpty()) {
						System.out.println("Press \"ENTER\" to continue...");
					}
					if(sc.hasNextLine()) {
						readString = sc.nextLine();
					}else {
						readString = null;
					}
					Function(kfloor, kroom);
				}else if(Cnumber == 0) {
					System.out.println();
					if(readString.isEmpty()) {
						System.out.println("Press \"ENTER\" to continue...");
					}
					if(sc.hasNextLine()) {
						readString = sc.nextLine();
					}else {
						readString = null;
					}
					Function(kfloor, kroom);
				}			
			}
			break;
		case 3: //Display
			System.out.println("--------------- Display hotel information ---------------");
			for(int i = 0; i < hotel.length; i++) {
				System.out.print("Floor " + (i+1) + " : ");
				System.out.print(Arrays.toString(hotel[i]));
				System.out.println();
			}
			System.out.println();
			if(readString.isEmpty()) {
				System.out.println("Press \"ENTER\" to continue...");
			}
			if(sc.hasNextLine()) {
				readString = sc.nextLine();
			}else {
				readString = null;
			}
			Function(kfloor, kroom);

			break;
		case 4: //Exit
			System.out.println("-> Good bye!");
			break;
		}
	}
}
