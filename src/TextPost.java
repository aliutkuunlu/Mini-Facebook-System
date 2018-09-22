
public class TextPost extends Post {
	
	
	
	/**
	 * this method shows tagged friends
	 */
	public void showTaggedFriends()
	{
		for(String i : this.getTaggedFriends() )
		{
			System.out.println(i);
		}
	}
	
	/**
	 * this method show location.
	 */
	public void showLocation()
	{
		System.out.print(getLocation());
	}
	
	/**
	 * this method add text post
	 * @param text added text
	 * @param longitude location 
	 * @param latitude location 
	 * @param friends list of tageed friends
	 * @param myCol to work with objects in UserCollection class.
	 * @param myLoc to work with objects in Location class.
	 * @param myUser to work with objects in User class.
	 */
	public void addPostText(String text, double longitude, double latitude, String[] friends, UserCollection myCol, Location myLoc, User myUser)
	{
		TextPost mypost = new TextPost();
		System.out.println("-----------------------");
		System.out.print("Command: ADDPOST-TEXT\t" + text + "\t" + longitude + "\t" + latitude + "\t");
		for(int i = 0 ; i< friends.length; i++)
		{
			System.out.print(friends[i]);
			if(i +1== friends.length)
			{
				System.out.print("\n");
			}
			else
			{
				System.out.print(":");
			}
		}
		if(myCol.getCurrentUser() != null )
		{
			this.setText(text);
			myLoc.setLatitude(latitude);
			myLoc.setLongtitude(longitude);
			for(int i =0 ; i< friends.length ; i++)
			{
				User canditateFriend = myCol.findUser(friends[i], myUser.getFriendList());
				if(canditateFriend != null)
				{
					getTaggedFriends().add(friends[i]);
				}
				else
				{
					System.out.println("Username " +friends[i]+" is not your friend, and will not be tagged!");
				}
			}
			myCol.getCurrentUser().getPostList().add(mypost);
			System.out.println("The post has been successfully added.");			
		}
		else
		{
			System.out.println("Error: Please sign in and try again.");
		}
	}
	
	/**
	 * This method shows current user's posts
	 * @param username current user
	 * @param myCol  to work with objects in UserCollection class.
	 */
	public void showPosts(String username, UserCollection myCol)
	{
		System.out.println("-----------------------");
        System.out.println("Command: SHOWPOSTS\t" + username );
        System.out.println("*******************");
        System.out.println(myCol.getCurrentUser().getUserName() + "'s Posts");
        System.out.println("*******************");
        if(myCol.getCurrentUser() != null )
        {
        	if(myCol.getCurrentUser().getPostList().size() != 0 )
        	{
        		for(int i = 0 ;i<myCol.getCurrentUser().getPostList().size(); i++)
        		{
        			System.out.println(myCol.getCurrentUser().getPostList().get(i).getText());
        			System.out.println("Date: ");
        			System.out.println("Location: " + myCol.getCurrentUser().getPostList().get(i).getLocation());
        			if(getTaggedFriends().size() != 0)
        			{
        				System.out.println("Friends tagged in this post: ");
        				for (int j = 0; j<getTaggedFriends().size(); j++ )
        				{
        					System.out.print(getTaggedFriends().get(j));
        					if(j != getTaggedFriends().size())
        					{
        						System.out.print(" ,");
        					}
        				}
        				
        			}
        			
        		}
        	}
        	else
        	{
        		System.out.println(myCol.getCurrentUser().getName() + " does not have any post yet.");
        	}
        }
        else
        {
        	System.out.println("No such user!");
        }
	}
	
	/**
	 * This method removes current user's last post
	 * @param myCol to work with objects in UserCollection class.
	 */
	public void removeLastPost(UserCollection myCol)
	{
		System.out.println("-----------------------");
		System.out.println("Command: REMOVELASTPOST");
		if(myCol.getCurrentUser() != null )
		{
			if(myCol.getCurrentUser().getPostList().size() != 0)
			{
				myCol.getCurrentUser().getPostList().remove(myCol.getCurrentUser().getPostList().size()-1);
				System.out.println("Your last post has been successfully removed.");
			}
			else
			{
				System.out.println("Error: You don't have any posts.");
			}
		}
		else
		{
			System.out.println("Error: Please sign in and try again.");
		}
	}
}








