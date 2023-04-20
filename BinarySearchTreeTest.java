// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
import java.io.*;
import java.util.*;




class BinarySearchTreeTest
{
    BinarySearchTree<String> btt;
    BinarySearchTree<String> btt1;
    BinarySearchTree<String> btt2;
    BinarySearchTree<String> bttP;
    public static void main ( String [] args )
    {


        BinarySearchTreeTest bt = new BinarySearchTreeTest();
        bt.readFile("dataset.txt");
        bt.userInterphase();
        System.out.println("Bye!");


    }

    public void userInterphase() {

        Scanner scannerObject = new Scanner(System.in);


        while (true) {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");


            // For the user to enter the choice they want to select,from options 1 -8
            System.out.print("Enter your choice: ");
            int choice = scannerObject.nextInt();


            switch (choice) {

                case 1:
                    System.out.print("Enter the account name: ");
                    String userAccount = scannerObject.next();
                    if (btt2.find(userAccount) == null){
                        System.out.println("No such account exists");
                        }
                    else{
                    BinaryTreeNode<String> node = btt.find(userAccount);
                    Account acc = new Account(node.data);
                    System.out.println("The profile description is: " + acc.description);
                    }
                    break;

                case 2:
                    System.out.println("The account list is as follows");
                    btt2.preOrder(btt2.root);
                    break;

                case 3:

                    Scanner sc = new Scanner(System.in);
                    String str;
                    System.out.println("Enter the account name: ");
                    str = sc.nextLine();
                    btt2.insert(str);
                    System.out.println("Enter the profile description: ");
                    str = str + " " + sc.nextLine();
                    btt.insert(str);
                    System.out.println("Account successfully created!");
                    
                    //btt.preOrder(btt.root);
                    break;

                case 4:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Enter the account name: ");
                    String str1 = sc1.next();
                    btt2.delete(str1);
                    System.out.println("Account successfully deleted!");
                    bttP.delete(str1);
                    //btt.preOrder();
                    break;

                case 5:
                    // Display all posts for a single account
                    System.out.print("Enter the account name: ");
                    String accountName = scannerObject.next();
                    if (btt2.find(accountName) == null){
                        System.out.println("No such account exists");
                        }
                    else if(bttP.find(accountName) == null){
                        System.out.println("Account does not have Posts");
                        }

                        
                    else{

                    // get all the posts for the account
                    ArrayList<String> posts = new ArrayList<String>();
                    posts = btt1.getPosts(accountName);
                    System.out.println("The posts for the account are: ");
                    for (int i = 1; i < posts.size(); i++) {
                        String[] postArray = posts.get(i).split(" ");
                        // title is all the words after the first 3
                        StringBuilder title = new StringBuilder();
                        for (int j = 3; j < postArray.length; j++) {
                            title.append(postArray[j]).append(" ");
                        }
                        System.out.println("Title: " + title + "\nVideo: " + postArray[1] + "\nNumber of likes: " + postArray[2]);
                    }
                    String[] postArray = posts.get(0).split(" ");
                    // title is all the words after the first 3
                    StringBuilder title = new StringBuilder();
                    for (int j = 3; j < postArray.length; j++) {
                        title.append(postArray[j]).append(" ");
                    }
                    System.out.println("Title: " + title + "\nVideo: " + postArray[1] + "\nNumber of likes: " + postArray[2]);

                   }

                    break;
                case 6:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Enter the account name: ");
                    String accountName1 = scannerObject.next();
                    
                    if (btt2.find(accountName1) == null){
                        System.out.println("No such account exists");
                        }
                    else{
                    
                    // Add a new post for an account
                    System.out.print("Enter the post: ");
                    String post = sc2.nextLine();
                    btt1.insert(accountName1 + " " + post);
                    }
                    break;
                case 7:
                    System.out.println("Enter the file name: ");
                    String fileName = scannerObject.next();
                    readFile(fileName);
                    break;
                    case 8:
                        System.out.println("Bye!");
                        System.exit(0);
                        break;

                default:
                    System.out.println("Dear User you have entered a wrong choice");


            }


        }
    }


           public void readFile(String filename)
        {
            btt = new BinarySearchTree<>();
            btt1 = new BinarySearchTree<>();
            btt2 = new BinarySearchTree<>();
            bttP = new BinarySearchTree<>();
            File Obj = new File(filename);
            try {

                Scanner Reader = new Scanner(Obj);
                while (Reader.hasNextLine()) {

                    String data = Reader.nextLine();

                    String parts[] =data.split(" ",3);

                    switch(parts[0]){

                        case "Create":
                            data = parts[1] + " " + parts[2];
                            String account = parts[1];
                            btt.insert(data);
                            btt2.insert(account);
                            break;
                        //}
                        case "Add":

                            data = parts[1] + " " + parts[2];
                            //String[] strArr= new String[]{userPosts};
                            //String str2 = strArr.toString();
                            //return str2;
                            account = parts[1];
                            btt1.insert(data);
                            bttP.insert(account);

                            break;

                    }
                    //BinaryTreeNode <String> node = bt.find("Yoda7");
                    //Account acc = new Account(node.data);
                    //System.out.println(acc.description);

                }
                Reader.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }

        }

}
