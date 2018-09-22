import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * @author utku
 *
 */
public class User
{
    private int userID;
    private String name;
    private String userName;
    private String password;
    private String dateOfBirth;
    private String lastLogIn;
    private String graduatedSchool;
    private ArrayList<User> blockedFriendList = new ArrayList<User>();
    private ArrayList<User> friendList = new ArrayList<User>();
    private ArrayList<TextPost> postList = new ArrayList<TextPost>();
    
    
    



	/**
	 * This is a constructor of Users class.
	 * @param name name of new user
	 * @param userName username of new user
	 * @param password password of new user
	 * @param dateOfBirth birthday of new user
	 * @param graduatedSchool graduated School of new user 
	 * @param myUserCollecetion  to work with objects in UserCollection class.
	 */
	public User(String name, String userName, String password, String dateOfBirth, String graduatedSchool,UserCollection myUserCollecetion)
    {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.graduatedSchool = graduatedSchool;
        this.userID = myUserCollecetion.getUserCount() + 1 ;
    }
	
	/**
	 * This is also a constructor but just for create objects, not initialize.
	 * 
	 */
	public User()
	{
		
	}
    

    /**
     * method for get Postlist
     * @return 
     */
    public ArrayList<TextPost> getPostList() 
    {
		return postList;
	}



	/**
	 * method for set Postlist
	 * @param postList 
	 */
	public void setPostList(ArrayList<TextPost> postList)
	{
		this.postList = postList;
	}



    /**
     * method for get Friendlist
     * @return
     */
    public ArrayList<User> getFriendList()
    {
        return friendList;
    }

    /**
     * method for set friendlist
     * @param friendList
     */
    public void setFriendList(ArrayList<User> friendList)
    {
        this.friendList = friendList;
    }

    /**
     * method for get BlockedFriendlist
     * @return
     */
    public ArrayList<User> getBlockedFriendList()
    {
        return blockedFriendList;
    }

    /**
     * method for set BlockedFriendlist
     * @param blockedUserList
     */
    public void setBlockedFriendList(ArrayList<User> blockedUserList)
    {
        this.blockedFriendList = blockedUserList;
    }

    /**
     * method for get user id
     * @return
     */
    public int getUserID() 
    {
        return userID;
    }

    /**
     * method for set user id
     * @param userID
     */
    private void setUserID(int userID) 
    {
        this.userID = userID;
    }

    /**
     * method for get name
     * @return 
     */
    public String getName() 
    {
        return name;
    }

    /**
     * method for set name
     * @param name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * method for get username
     * @return
     */
    public String getUserName() 
    {
        return userName;
    }

    /**method for set username
     * @param userName
     */
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    /**
     * method for get password
     * @return
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     * method for set password
     * @param password
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }

    /**
     * method for get birthday
     * @return
     */
    public String getDateOfBirth() 
    {
        return dateOfBirth;
    }

    /**
     * method for set birthday
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * method for get last login time.
     * @return
     */
    public String getLastLogIn() 
    {
        return lastLogIn;
    }

    /**
     * method for set last log in time
     * @param lastLogIn
     */
    public void setLastLogIn(String lastLogIn) 
    {
        this.lastLogIn = lastLogIn;
    }

    /**
     * method for get GraduatedSchool
     * @return
     */
    public String getGraduatedSchool() 
    {
        return graduatedSchool;
    }

    /**
     * method for set GraduatedSchool
     * @param graduatedSchool
     */
    public void setGraduatedSchool(String graduatedSchool) 
    {
        this.graduatedSchool = graduatedSchool;
    }



   
    @Override
	public String toString() {
		return "Name: " + this.name + "\n" + "Username: " + this.userName + "\n" + "Date of Birth : " + this.dateOfBirth + "\n" + "School: " + this.graduatedSchool + "\n" ;
	}


	/**
	 * this method uptades user profile
	 * @param name users new name
	 * @param date users new birthday
	 * @param graduatedSchool users new GraduatedSchool
	 * @param myCol to work with objects in UserCollection class.
	 */
	public void updateProfile(String name , String date , String graduatedSchool,UserCollection myCol)
    {
		System.out.println("-----------------------");
		System.out.println("Command: UPDATEPROFILE\t" + name + "\t" + date + "\t" + graduatedSchool);
        User curUser = myCol.findUser(name,myCol.getUserList());
        if(curUser == null )
        {
            System.out.println("Error: Please sign in and try again");
        }
        else
        {

            curUser.setDateOfBirth(date);
            curUser.setGraduatedSchool(graduatedSchool);
            System.out.println("Your user profile has been successfully updated.");
        }

    }

    /**
     * this method changes 
     * @param oldPassword  to confirm  with current password
     * @param newPassword users new password
     * @param myCol to work with objects in UserCollection class.
     */
    public void changePassword(String oldPassword, String newPassword, UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: CHPASS\t" + oldPassword + "\t" + newPassword);
        if(myCol.getCurrentUser() == null)
        {

            System.out.println("Error: Please sign in and try again.");
        }
        else if(myCol.getCurrentUser().getPassword().equals(oldPassword) )
        {
          myCol.getCurrentUser().setPassword(newPassword);
        }
        else if(myCol.getCurrentUser().getPassword() != oldPassword)
        {
            System.out.println("Password mismatch! Please try again.");
        }
    }

    /**
     * This method adds new users in currentuser's friends list 
     * @param userName username to be add
     * @param myCol to work with objects in UserCollection class.
     */
    public void addFriend( String userName, UserCollection myCol)
    {
    	
    	System.out.println("-----------------------");
    	System.out.println("Command: ADDFRIEND\t" + userName);
        User canditateFriend = myCol.findUser(userName,myCol.getUserList());
        if(myCol.getCurrentUser() == null)
        {
            System.out.println("Error: Please sign in and try again");
        }
        else if(canditateFriend == null)
        {
            System.out.println("No such user!");
        }
        else if(  myCol.findUser(userName,this.getFriendList()  ) != null )
        {
        	for (int i = 0; i<this.friendList.size();i++)
        	{
        		if(this.friendList.get(i).userName.equalsIgnoreCase(userName) )
                {
                    System.out.println("This user is already in your friend list!");
                    break;
                }
        	}
            

        }
        else if( canditateFriend != null )
        {
            myCol.getCurrentUser().getFriendList().add(canditateFriend);
            System.out.println(userName + " has been successfully added your friend list!");
        }
    }
    
    /**
     * This method deletes users from friend list
     * @param username username to be delete
     * @param myCol to work with objects in UserCollection class.
     */
    public void removeFriend(String username, UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: REMOVEFRIEND\t" + username);
    	User canditateFriend = myCol.findUser(userName,myCol.getUserList());
    	if(myCol.getCurrentUser()== null)
    	{
    		System.out.println("Error: Please sign in and try again.");
    	}
    	else if (canditateFriend == null)
    	{
    		System.out.println("No such user!");
    	}
    	else if (myCol.findUser(username, this.getFriendList() ) !=  null )
    	{
    		for(int i = 0; i<this.friendList.size(); )
    		{
    			if(this.friendList.get(i).userName.equalsIgnoreCase(username));
    			{
    				this.friendList.remove(i);
    				System.out.println("User has been successfully removed from your friend list.");
    				
    			}
    			i++;
    		}
    	}
    	else if (canditateFriend != null)
    	{
    		System.out.println("No such firend!");
    	}
    	
    }
    
    
    /**
     * This method lists all firiends
     * @param myCol to work with objects in UserCollection class.
     */
    public void listFriends(UserCollection myCol) 
    {	
    	System.out.println("-----------------------");
    	System.out.println("Command: LISTFRIENDS");
		if(myCol.getCurrentUser() != null)
		{
			if (friendList.size() != 0)
			{
				for( int i =0 ; i<friendList.size() ; i++)
				{
					System.out.println(friendList.get(i).toString());
					System.out.println("-----------------------");
				}
			}
			else
			{
				System.out.println("You haven't added any firends yet.");
			}			 
		}
		else
		{
			System.out.println("Error: Please sign in and try again. ");
		}	
    }
    
    /**
     * This method block users from currentuser's friend list.
     * @param username username to be block
     * @param myCol to work with objects in UserCollection class.
     */
    public void blockUser( String username,UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: BLOCK\t" + username);
    	User canditateFriend = myCol.findUser(username, this.getFriendList() );
    	
    	if(myCol.getCurrentUser() ==  null )
    	{
    		System.out.println("Error: Please sign in and try again");
    	}
    	else if (canditateFriend == null )
    	{
    		System.out.println("No such user!");
    	}
    	else if ( myCol.findUser(username, this.getFriendList()) != null )
    	{
    		for( int i = 0 ; i<this.friendList.size(); i++)
    		{
    			if(this.friendList.get(i).userName.equalsIgnoreCase(username));
    			{
    				myCol.getCurrentUser().getBlockedFriendList().add(canditateFriend);
        			myCol.getBlockedUserList().add(canditateFriend);
        			System.out.println(username+" has been successfully blocked.");
        			
    			}
    		}
    	}
    }
    
    /**
     * This method unblock user from current user's friend list
     * @param username username to be unblock
     * @param myCol to work with objects in UserCollection class.
     */
    public void unblockUser( String username, UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: UNBLOCK\t" + username);
    	User canditateFriend = myCol.findUser(username, this.getFriendList());
    	
    	if(myCol.getCurrentUser() == null )
    	{
    		System.out.println("Error: Please sign in and try again.");
    	}
    	
    	else if ( myCol.findUser(username, this.getBlockedFriendList()) == null)
    	{
    		System.out.println("No such user in your blocked users list!");
    	}
    	else if (myCol.findUser(username, this.getBlockedFriendList()) != null && canditateFriend != null )
    	{
    		for (int i = 0; i<this.friendList.size();i++)
    		{
    			if(this.friendList.get(i).userName.equalsIgnoreCase(userName) )
    			{
    				myCol.getCurrentUser().getBlockedFriendList().remove(i);
    	    		myCol.getBlockedUserList().remove(i);
    	    		System.out.println(username + " has been successfully unblocked");
    			}
    		}
    	}
    }
    
    /**
     * this method shows blocked friends
     * @param myCol to work with objects in UserCollection class.
     */
    public void showBlockedFriends(UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: SHOWBLOCKEDFRIENDS");
    	if(myCol.getCurrentUser() != null )
    	{
    		if (blockedFriendList.size() != 0 )
    		{
    			for (int i = 0; i<blockedFriendList.size(); i++)
    			{
    				System.out.println(blockedFriendList.get(i).toString());
    			}
    		}
    		else
    		{
    			System.out.println("You haven't blocked any users yet.");
    			System.out.println("You haven't blocked any friends yet.");
    		}
    	}
    	else 
    	{
    		System.out.println("Error: Please sign in and try again.");
    	}
    }
    
    /**
     * this method shows blocked users
     * @param myCol to work with objects in UserCollection class.
     */
    public void showBlockedUsers(UserCollection myCol)
    {
    	System.out.println("-----------------------");
    	System.out.println("Command: SHOWBLOCKEDUSERS");
    	if(myCol.getCurrentUser() != null )
    	{
    		if (myCol.getBlockedUserList().size() != 0 )
    		{
    			for (int i = 0; i<myCol.getBlockedUserList().size(); i++)
    			{
    				System.out.println(myCol.getBlockedUserList().get(i).toString());
    			}
    		}
    		else
    		{
    			System.out.println("You haven't blocked any users yet.");    			
    		}
    	}
    	else 
    	{
    		System.out.println("Error: Please sign in and try again.");
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
