import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This is a Main class.
 * @author utku
 * @version 1.2
 * @since 28/04/2017
 *
 */
public class Main {



    /**
     * @param args Main takes arguments as inputs
     */
    public static void main(String[] args)
    {
        UserCollection myCol = new UserCollection();
        TextPost myPost= new TextPost();
        User myUser = new User();
        Location myLoc = new Location();
        ImagePosts myImage = new ImagePosts();
        VideoPosts myVideo = new VideoPosts();
        

        try
        {
        	
            Scanner scanner = new Scanner (new File(args[0]));

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String [] tokens = line.split("\t");
                createUsers(tokens,myCol);
            }

            scanner.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("No File Found!");
        }

        try
        {

            Scanner command = new Scanner (new File(args[1]));

            while (command.hasNextLine())
            {
                String line = command.nextLine();
                String [] tokens = line.split("\t");
                controlCommands(tokens,myCol, myPost, myLoc, myUser, myImage, myVideo );
            }

            command.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("No File Found!");
        }

    }
    /**
     * This method initialize users.
     * @param tokens It takes tokens as inputs.
     * @param myUserCollection to work with objects in UserCollection class.
     */
    public static void createUsers (String [] tokens,UserCollection myUserCollection)
    {
    	
        User user = new User(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],myUserCollection);
        myUserCollection.setUserCount(myUserCollection.getUserCount() + 1);
        myUserCollection.getUserList().add(user);
    }
    /**
     * This method read commands and execute.
     * @param tokens 
     * @param myUserCollection to work with objects in UserCollection class.
     * @param myPost to work with objects in TextPost class.
     * @param myLoc to work with objects in Location class.
     * @param myUser to work with objects in User class.
     * @param myImagePosts to work with objects in ImagePost class.
     * @param myVideoPost to work with objects in CideoPost class.
     */
    public static void controlCommands (String [] tokens, UserCollection myUserCollection, TextPost myPost, Location myLoc, User myUser, ImagePosts myImagePosts, VideoPosts myVideoPost)
    {
    	
        if (tokens[0].equals("ADDUSER"))
        {
            myUserCollection.addUser(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],myUserCollection);
        }
        else if (tokens[0].equals("REMOVEUSER"))
        {
        	myUserCollection.removeUser(Integer.parseInt(tokens[1]), myUserCollection);
        }
        else if (tokens[0].equals("SIGNIN"))
        {
            myUserCollection.signIn(tokens[1], tokens[2] );
        }
        else if (tokens[0].equals("LISTUSERS"))
        {
            myUserCollection.listUsers();
        }
        else if (tokens[0].equals("UPDATEPROFILE"))
        {
            myUserCollection.getCurrentUser().updateProfile(tokens[1],tokens[2], tokens[3],myUserCollection );
        }
        else if (tokens[0].equals("CHPASS"))
        {
            myUserCollection.getCurrentUser().changePassword(tokens[1],tokens[2],myUserCollection);
        }
        else if (tokens[0].equals("ADDFRIEND"))
        {
            myUserCollection.getCurrentUser().addFriend(tokens[1],myUserCollection);
        }
        else if (tokens[0].equals("REMOVEFRIEND"))
        {
            myUserCollection.getCurrentUser().removeFriend(tokens[1], myUserCollection);
        }
        else if (tokens[0].equals("LISTFRIENDS"))
        {
            myUserCollection.getCurrentUser().listFriends(myUserCollection);
        }
        else if (tokens[0].equals("ADDPOST-TEXT"))
        {
        	String [] list = tokens[4].split(":");
            myPost.addPostText(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), list, myUserCollection,  myLoc, myUser);
        }
        else if (tokens[0].equals("ADDPOST-IMAGE"))
        {
        	String [] list = tokens[4].split(":");
           myImagePosts.AddPostImage(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), list, tokens[5], tokens[6], myUserCollection, myLoc, myUser);
        }
        else if (tokens[0].equals("ADDPOST-VIDEO"))
        {
        	String [] list = tokens[4].split(":");
            myVideoPost.addPostVideo(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), list, tokens[5], Integer.parseInt(tokens[6]), 
            		myUserCollection, myLoc, myUser);
            		
        }
        else if (tokens[0].equals("REMOVELASTPOST"))
        {
            myPost.removeLastPost(myUserCollection);
        }
        else if (tokens[0].equals("SHOWPOSTS"))
        {
            myPost.showPosts(tokens[1], myUserCollection);
        }
        else if (tokens[0].equals("BLOCK"))
        {
            myUserCollection.getCurrentUser().blockUser(tokens[1],myUserCollection);
        }
        else if (tokens[0].equals("SHOWBLOCKEDFRIENDS"))
        {
            myUserCollection.getCurrentUser().showBlockedFriends(myUserCollection);
        }
        else if (tokens[0].equals("UNBLOCK"))
        {
            myUserCollection.getCurrentUser().unblockUser(tokens[1], myUserCollection);
        }
        else if (tokens[0].equals("SHOWBLOCKEDUSERS"))
        {
            myUserCollection.getCurrentUser().showBlockedUsers(myUserCollection);
        }
        else if (tokens[0].equals("SIGNOUT"))
        {
            UserCollection.signOut(myUserCollection.getCurrentUser());

        }
        else
        {
            System.out.println("!!ERROR!! Undefined command.!!");
        }



    }




}














