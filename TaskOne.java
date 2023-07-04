import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TaskOne {
    public static void main(String[] args) {
        Map<String,ArrayList> contacts = new HashMap<>() {
        {
            put("Ivanov", new ArrayList<Integer>() {
                    {
                        add(856397);
                        add(898247);
                    }
                });
            put("Petrov", new ArrayList<Integer>() {
                    {
                        add(896512);
                        add(898536);
                        add(874523);
                        add(875896);
                    }
                });
            put("Smirnov", new ArrayList<Integer>() {
                    {
                        add(895246);
                    }
                });
        }    
    };
    Scanner scan = new Scanner(System.in,"cp866");
    Boolean getOut = false;
    String command;
    while(!getOut){
        System.out.println("Enter your command: 1 - show my contacts, 2 - save contact, 3 - quit");
        command = scan.nextLine();
        switch (command) {
            case "1":
                sortedPrint(contacts);
                break;
            case "2":
                addContact(contacts);
                break;
            case "3":
                getOut = true;
                System.out.println();
                System.out.println("Good bye");
                System.out.println();
                break;
            default:
                break;
        }

    }
        
    }
    static void addContact(Map<String, ArrayList> map){
        Scanner sc = new Scanner(System.in,"cp866");
        String nameContact;
        String phoneContact;
        System.out.println("Enter name: ");
        nameContact = sc.nextLine();
        if (!map.containsKey(nameContact)){
            System.out.println("Enter phone numbers with comma: ");
            phoneContact = sc.nextLine();
            String[] arr = phoneContact.split(",");
            ArrayList<Integer> arrInt = new ArrayList<>();
            for (String item: arr) {
                arrInt.add(Integer.parseInt(item.trim())) ;
            }
            map.put(nameContact, arrInt);
            System.out.println();
        }
        else{
            System.out.println("Error. This name already have saved");
        }
    }
    
    static void sortedPrint(Map<String, ArrayList> map) {
     Set<String> keySet = map.keySet();
    int maxCount = 0;
    int minCount = 1_000_000;
        
    for (var item : map.entrySet()) {
        if (maxCount < item.getValue().size())
            maxCount = item.getValue().size();
        if (minCount > item.getValue().size())
            minCount = item.getValue().size();
   
    }
     
    Stack<String> st = new Stack<>();
    int num = minCount;
    while (num <= maxCount) {
        for (var item : map.entrySet()) {
            if (item.getValue().size() == num) {
                st.push(item.getKey());
            }  
        }
         num += 1;
    }

    String name;
    for (int i = 0; i < keySet.size(); i++) {
        name = st.pop();
        for (var item : map.entrySet()) {
            if (name == item.getKey()) {
                System.out.printf("%8s: ", item.getKey());
                System.out.println(item.getValue());
            }
        }
    }
    System.out.println();
    }
}