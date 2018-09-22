import java.util.ArrayList;

public class UserCollection {

	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<User> blockedUserList = new ArrayList<User>();
	private int userCount;
	private User currentUser;
	
	/**
	 *  to get blocked user list
	 * @return
	 */
	public ArrayList<User> getBlockedUserList() 
	{
		return blockedUserList;
	}

	/**
	 * to set blocked user list
	 * @param blockedUserList
	 */
	public void setBlockedUserList(ArrayList<User> blockedUserList)
	{
		this.blockedUserList = blockedUserList;
	}

	/**
	 * to getUserCount
	 * @return
	 */
	public int getUserCount() 
	{
		return userCount;
	}

	/**
	 * to setUserCount
	 * @param userCount
	 */
	public void setUserCount(int userCount) 
	{
		this.userCount = userCount;
	}

	/**
	 * to get user list
	 * @return
	 */
	public ArrayList<User> getUserList() 
	{
		return userList;
	}

	/**to set userlist
	 * @param userList
	 */
	public void setUserList(ArrayList<User> userList) 
	{
		this.userList = userList;
	}

	/**
	 * to getCurrentUse
	 * @return
	 */
	public User getCurrentUser() 
	{
		return currentUser;
	}

	/**
	 * to setCurrentUser
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) 
	{
		this.currentUser = currentUser;
	}

	/**
	 * this method add users to the database
	 * @param name name of new user
	 * @param userName username of new user
	 * @param password password of new user
	 * @param dateOfBirth birthday of new user
	 * @param graduatedSchool graduated  school of new user
	 * @param myUserCollection  to work with objects in UserCollection class.
	 */
	public void addUser(String name, String userName, String password, String dateOfBirth, String graduatedSchool,UserCollection myUserCollection)
	{
		System.out.println("-----------------------");
		System.out.println("Command: ADDUSER\t" + name + "\t" + userName + "\t" + password + "\t" + dateOfBirth + "\t"
				+ graduatedSchool);
		User user = new User(name, userName, password, dateOfBirth, graduatedSchool, myUserCollection);
		userList.add(user);
		userCount++;

		System.out.println(name + " has been succesfully added.");
	}

	/**
	 * this method removed user from database.
	 * @param userID user id to be removed
	 */
	public void removeUser(int userID) 
	{
		System.out.println("-----------------------");
		System.out.println("Command: REMOVEUSER\t" + userID);
		userList.remove(userID-1);

	}

	/**
	 * This method shows posts
	 * @param userName   username whose post will be shown
	 */
	public void showPosts(String userName) 
	{
		System.out.println("-----------------------");
		System.out.println("Command: SHOWPOSTS\t" + userName);
		System.out.println("***************");
		System.out.println(userName + "'s Posts");
		System.out.println("***************");
	}

	/**
	 * this method log in to system
	 * @param userName username of to be sign in user
	 * @param password password of to be sign in user
	 */
	public void signIn(String userName, String password) 
	{
		System.out.println("-----------------------");
		System.out.println("Command: SIGNIN\t" + userName + "\t" + password);
		currentUser = findUser(userName, this.userList);
		if (currentUser != null) {
			if (password.equals(currentUser.getPassword())) {
				System.out.println("You have succesfuly signed in");
			} else {
				System.out.println("Invalid username or password");
			}

		}
		else 
		{
			System.out.println("No such user!");
		}
	}

	/**
	 * this method logout from system
	 * @param currentUser user who will be log out
	 */
	public static void signOut(User currentUser) 
	{
		System.out.println("-----------------------");
		System.out.println("Command: SIGNOUT");
		if (currentUser == null) {
			// Wrong behaviour, shouldn't be signed out

		} else {
			System.out.println("You have successfully signed out.");
		}
	}

	/**
	 * This method searches user if he/she in userlist.
	 * @param name name of seached user
	 * @param userList List of users
	 * @return
	 */
	public User findUser(String name, ArrayList<User> userList) 
	{
		int sign = 0;
		User tempUser = null;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserName().equalsIgnoreCase(name)) {
				sign = 1;
				tempUser = userList.get(i);
				break;
			}

		}
		if (sign == 0) 
		{
			return null;
		}
		
		else 
		{
			return tempUser;
		}
	}
	
	/**
	 * This method remove users from database.
	 * @param id id of to be removed
	 * @param myCol  to work with objects in UserCollection class.
	 */
	public void removeUser(int id, UserCollection myCol) 
	{

    	System.out.println("-----------------------");
    	System.out.println("Command: REMOVEUSER\t" + id);
		for (User i : myCol.getUserList()) {
			if (i.getUserID() == (id)) {
				myCol.getUserList().remove(i);
				System.out.println("User has been successfully removed");
				break;
			} else {
				System.out.println("No such user!");
			}
		}
	}

	/**
	 * This method list all users.
	 * 
	 */
	public void listUsers() 
	{
		System.out.println("-----------------------");
		System.out.println("Command LISTUSERS");
		if(this.currentUser != null)
		{

			 for(int i=0 ; i< userList.size(); i++)
			 {
				 System.out.println(userList.get(i).toString());
			 	 System.out.println("-----------------------");
			 }
		}
		else
		{
			System.out.println("Error: Please sign in and try again.");
		}
		

	}

}
