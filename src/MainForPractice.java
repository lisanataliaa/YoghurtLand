import java.util.*;

public class MainForPractice {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	String name, flavour, id;
	int price = 0;
	int choose = 0;
	
	ArrayList<String> nameYog = new ArrayList<>();
	ArrayList<String> flavourYog = new ArrayList<>();
	ArrayList<String> idYog = new ArrayList<>();
	ArrayList<Integer> priceYog = new ArrayList<>();
	
	private void menu() {
		do {
			System.out.println("YOGHURT LAND");
			System.out.println("==============================");
			System.out.println("1. Create New Yogurt Creation");
			System.out.println("2. View Yoghurt List");
			System.out.println("3. Exit");
			System.out.println("Choose >>");
			choose = sc.nextInt(); sc.nextLine();
			
		switch (choose) {
		case 1:
			newYoghurt();
			break;
		case 2:
			viewYoghurt();
			break;
		default:
			System.out.println("Invalid!");
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
			default:
				System.out.println("Invalid!");
				break;
				}	
		
		}while (choose!=3);
	}


	private void newYoghurt() {
		do {
			System.out.println("Create Yoghurt name : ");
			name = sc.nextLine();
			if (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" ")); {
				System.out.println("Name must be more than 1");
			}
		}while (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" "));
		
		
		do {
			System.out.println("Choose base flavour [Original|Peach|Strawbery|Charcoal] : ");
			flavour = sc.nextLine();
		} while (!(flavour.equals("Original") || flavour.equals("Peach") || flavour.equals("Strawbery") || flavour.equals("Charcoal")));
		
		do {
			System.out.println("Input price : ");
			price = sc.nextInt();sc.nextLine();
		} while (price<10000 || price>100000);
		
		char a = (char) (rd.nextInt(26)+65);
		char b = (char) (rd.nextInt(26)+65);
		
		id = "" +a+b + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
		
		nameYog.add(name);
		flavourYog.add(flavour);
		idYog.add(id);
		priceYog.add(price);
		
		if (nameYog.size() > 1) {
			for (int i = 0; i < nameYog.size()-1; i++) {
				for (int j = 0; j < nameYog.size()-1; j++) {
					if (nameYog.get(j+1).charAt(0) < nameYog.get(j).charAt(0)) {
						String tempA = nameYog.get(j);
						nameYog.set(j, nameYog.get(j+1));
						nameYog.set(j+1, tempA);
						
						String tempB = flavourYog.get(j);
						flavourYog.set(j, flavourYog.get(j+1));
						flavourYog.set(j+1, tempB);
						
						Integer tempC = priceYog.get(j);
						priceYog.set(j, priceYog.get(j+1));
						priceYog.set(j+1, tempC);
						
						String tempD = idYog.get(j);
						idYog.set(j, idYog.get(j+1));
						idYog.set(j+1, tempD);
					}
				}
			}
		}
		System.out.println("Yoghurt succesfully added!");	
	}
	
	
	private void viewYoghurt() {
		if (nameYog.isEmpty()) {
			System.out.println("Theres no yoghurt creation");
		} else {
			for (int i = 0; i < nameYog.size(); i++) {
				System.out.println("NO :" + (i+1));
				System.out.println("1. ID : " + idYog.get(i));
				System.out.println("2. Name : " + nameYog.get(i));
				System.out.println("3. Flavour : " + flavourYog.get(i));
				System.out.println("4. Price : " + priceYog.get(i));
				System.out.println("");
			}
		}
		menu2();
	}
	
	private void delete() {
		int del = 0;
		
		do {
			System.out.println("Choose yoghurt to delete : ");
			del = sc.nextInt();sc.nextLine();
		}while(del<1 || del>nameYog.size());
		
		nameYog.remove(del-1);
		flavourYog.remove(del-1);
		priceYog.remove(del-1);
		System.out.println("Yoghurt succesfully deleted!");	
	}


	private void update() {
		int up = 0;
		
		do {
			System.out.println("Create Yoghurt name : ");
			name = sc.nextLine();
			if (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" ")); {
				System.out.println("Name must be more than 1");
			}
		}while (!name.contains(" ") || name.endsWith(" ") || name.startsWith(" "));
		
		
		do {
			System.out.println("Choose base flavour [Original|Peach|Strawbery|Charcoal] : ");
			flavour = sc.nextLine();
		} while (!(flavour.equals("Original") || flavour.equals("Peach") || flavour.equals("Strawbery") || flavour.equals("Charcoal")));
		
		do {
			System.out.println("Input price : ");
			price = sc.nextInt();sc.nextLine();
		} while (price<10000 || price>100000);
		
		nameYog.set(up-1, name);
		flavourYog.set(up-1, flavour);
		priceYog.set(up-1, price);
		System.out.println("Yoghurt succesfully updated!");	
	}


	public MainForPractice() {
		menu();
	}

	public static void main(String[] args) {
		new MainForPractice();

	}

}
