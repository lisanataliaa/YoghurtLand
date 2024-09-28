import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	int price=0; int choose=0; 
	String name, flavour, id;
	
	ArrayList<String> nameYog = new ArrayList<String>();
	ArrayList<String> baseFlav = new ArrayList<String>();
	ArrayList<Integer> priceYog = new ArrayList<Integer>();
	ArrayList<String> idYog = new ArrayList<String>();

	
		private void printMenu() {
			
		do {
			System.out.println("YOGHURT LAND");
			System.out.println("1. Create New Yogurt Creation");
			System.out.println("2. View Yoghurt List");
			System.out.println("3. Exit");
			System.out.println("Choose >>");
			choose = sc.nextInt();sc.nextLine();
			
			switch (choose) {
			case 1:
				newYogurt();
				break;
			case 2:
				viewYoghurt();
				break;
			case 3:
				System.out.println("Thank you for coming!");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			
		} while (choose !=3);
			
	}
		
		
		private void menu2() {
			
			do {
				System.out.println("1. Delete Yogurt");
				System.out.println("2. Update Yoghurt");
				System.out.println("3. Back to main menu");
				System.out.println("Choose >>");
				choose = sc.nextInt();sc.nextLine();
				
				switch (choose) {
				case 1:
					delete();
					break;
				case 2:
					update();
					break;
				case 3:
					printMenu();
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
				
			} while (choose !=3);
		}
		

		private void newYogurt() {
			do {
				System.out.println("Create Yogurt Name [more than 1 word] : ");
				name = sc.nextLine();
				if (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" ")) {
					System.out.println("Name must be more than 1 words");
				}
				
			} while (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" "));
			
			do {
				System.out.println("Choose base flavour [Original|Peach|Strawbery|Charcoal] : ");
				flavour = sc.nextLine();
			} while (!(flavour.equals("Original") || flavour.equals("Peach") || flavour.equals("Strawbery") || flavour.equals("Charcoal")));
			
			do {
				System.out.println("Input price [10000 ... 100000]: ");
				price = sc.nextInt();sc.nextLine();
			} while (price<10000 || price>100000);
		
			
			char a = (char) (rd.nextInt(26) + 'A');
			char b = (char) (rd.nextInt(26) + 'A');
			
			id = "" + a + b + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			
			nameYog.add(name);
			baseFlav.add(flavour);
			priceYog.add(price);
			idYog.add(id);
			
			
			if (nameYog.size() > 1) {
				for (int i = 0; i < nameYog.size() - 1; i++) {
					for (int j = 0; j < nameYog.size() - 1; j++) {
						if (nameYog.get(j+1).charAt(0) < nameYog.get(j).charAt(0)) {
							String swap = nameYog.get(j);
							nameYog.set(j, nameYog.get(j+1));
							nameYog.set(j+1, swap);
							
							swap = baseFlav.get(j);
							baseFlav.set(j, baseFlav.get(j+1));
							baseFlav.set(j+1, swap);
							
							int swap2 = priceYog.get(j);
							priceYog.set(j, priceYog.get(j+1));
							priceYog.set(j+1, swap2);
							
							swap = idYog.get(j);
							idYog.set(j, idYog.get(j+1));
							idYog.set(j+1, swap);
							
							
						}
					}
				}
			}
			System.out.println("Yoghurt succesfully added!");	
	}

		private void viewYoghurt() {
			if (nameYog.isEmpty()) {
				System.out.println("There's no yoghurt creation!");
			}else {
				for (int i = 0; i < nameYog.size(); i++) {
					System.out.println("No : " + (i+1));
					System.out.println("1. ID : " + idYog.get(i));
					System.out.println("2. Name : " + nameYog.get(i));
					System.out.println("3. Flavour : " + baseFlav.get(i));
					System.out.println("4. Price : " + priceYog.get(i));
					System.out.println("");
				}
				menu2();
			}
	}

		private void delete() {
			int delete = 0;
			
			do {
				System.out.println("Choose yogurt to delete [1 - " + nameYog.size() + "] : ");
				try {
					delete = sc.nextInt();
				} catch (Exception e) {
					delete = -1;
				} sc.nextLine();
			}while (delete<1 || delete>nameYog.size());
			
			nameYog.remove(delete-1);
			baseFlav.remove(delete-1);
			priceYog.remove(delete-1);
			System.out.println("Yoghurt succesfully deleted!");	
			
		}

		private void update() {
			int up = 0;
			
			do {
				System.out.println("Choose yoghurt to update [1 - " + nameYog.size() + "] : ");
				up = sc.nextInt();sc.nextLine();
			} while (up<1 || up>nameYog.size());
			
			do {
				System.out.println("Create Yogurt Name [more than 1 word] : ");
				name = sc.nextLine();
				if (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" ")) {
					System.out.println("Name must be more than 1 words");
				}
				
			} while (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" "));
			
			do {
				System.out.println("Choose base flavour [Original|Peach|Strawbery|Charcoal] : ");
				flavour = sc.nextLine();
			} while (!(flavour.equals("Original") || flavour.equals("Peach") || flavour.equals("Strawbery") || flavour.equals("Charcoal")));
			
			do {
				System.out.println("Input price [10000 ... 100000]: ");
				price = sc.nextInt();sc.nextLine();
			} while (price<10000 || price>100000);
		
			
			nameYog.set(up-1, name);
			baseFlav.set(up-1, flavour);
			priceYog.set(up-1, price);

			System.out.println("Yoghurt succesfully added!");


		}
		
	public Main() {
			printMenu();
		}

	public static void main(String[] args) {
		new Main();

	}

}
