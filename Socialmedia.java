import java.util.*;
 class User {
    String username;
    ArrayList<String> posts;
    ArrayList<User> friends;
    
    public User(String username) 
    {
        this.username = username;
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }
    
    public void addPost(String content) 
    {
        posts.add(content);
        System.out.println(username + " posted: " + content);
    }
    
    public void displayPosts() 
    {
        System.out.println("\n" + username + "'s Posts:");
        for (String post : posts) {
            System.out.println(" = " + post);
        }
    }

    public void addFriend(User user)
    {
        if (!friends.contains(user)) {
            friends.add(user);
            System.out.println(username + " and " + user.username + " are now friends!");
        } else {
            System.out.println(user.username + " is already your friend.");
        }
    }

    public void displayFriends() 
    {
        System.out.println("\n" + username + "'s Friends:");
        for (User friend : friends) 
        {
            System.out.println("- " + friend.username);
        }
    }
}

public class Socialmedia
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        
        while (true) 
        {
            System.out.println("\n \"INSTAGRAM\" - Social Media Platform ");
            System.out.println("1. Register User");
            System.out.println("2. Add Post");
            System.out.println("3. Add Friend");
            System.out.println("4. View Posts");
            System.out.println("5. View Friends");
            System.out.println("6. Exit");
            System.out.print("Select your choice ☺ : ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
                case 1: 
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    users.add(new User(username));
                    System.out.println(username + " has been registered.");
                    break;

                case 2: 
                    System.out.print("Enter your username: ");
                    String postUsername = scanner.nextLine();
                    User postUser = findUser(users, postUsername);
                    
                    if (postUser != null) {
                        System.out.print("Enter your post content: ");
                        String content = scanner.nextLine();
                        postUser.addPost(content);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your username: ");
                    String friendUsername = scanner.nextLine();
                    User friendUser = findUser(users, friendUsername);
                    
                    if (friendUser != null) {
                        System.out.print("Enter friend's username: ");
                        String friendName = scanner.nextLine();
                        User newFriend = findUser(users, friendName);
                        
                        if (newFriend != null) {
                            friendUser.addFriend(newFriend);
                        } else {
                            System.out.println("Friend not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter your username: ");
                    String viewPostsUsername = scanner.nextLine();
                    User viewPostsUser = findUser(users, viewPostsUsername);
                    
                    if (viewPostsUser != null) {
                        viewPostsUser.displayPosts();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter your username: ");
                    String viewFriendsUsername = scanner.nextLine();
                    User viewFriendsUser = findUser(users, viewFriendsUsername);
                    
                    if (viewFriendsUser != null) {
                        viewFriendsUser.displayFriends();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 6: 
                    System.out.println("Exiting the platform...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static User findUser(ArrayList<User> users, String username) 
    {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}

