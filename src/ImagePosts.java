
public class ImagePosts extends TextPost {
	
	private String imageFileNmae;
	private String imageResolution;
	
	
	/**
	 * to getImageFileNma
	 * @return
	 */
	public String getImageFileNmae() 
	{
		return imageFileNmae;
	}
	/**
	 * to setImageFileNma
	 * @param imageFileNmae
	 */
	public void setImageFileNmae(String imageFileNmae) 
	{
		this.imageFileNmae = imageFileNmae;
	}
	/**
	 * to getImageResolution
	 * @return
	 */
	public String getImageResolution() 
	{
		return imageResolution;
	}
	/**
	 * to setImageResolution
	 * @param imageResolution
	 */
	public void setImageResolution(String imageResolution) 
	{
		this.imageResolution = imageResolution;
	}
	
	
	/**
	 * this method add image post
	 * @param text added text
	 * @param longitude location 
	 * @param latitude location 
	 * @param friends list of tageed friends
	 * @param filePath file path of image
	 * @param resolution  resolution of image
	 * @param myCol to work with objects in UserCollection class.
	 * @param myLoc to work with objects in Location class.
	 * @param myUser to work with objects in User class.
	 */
	public void AddPostImage(String text, double longitude, double latitude, String[] friends, String filePath ,String resolution, UserCollection myCol, Location myLoc, User myUser)
	{
		ImagePosts myImage = new ImagePosts();
		System.out.println("-----------------------");
		System.out.print("Command: ADDPOST-IMAGE\t" + text + "\t" + longitude + "\t" + latitude + "\t" );
		for(int i = 0 ; i< friends.length; i++)
        {
            System.out.print(friends[i]);
            if(i +1== friends.length)
            {
                System.out.print("\t");
            }
            else
            {
                System.out.print(":");
            }
        }
		System.out.print(filePath+ "\t");
		System.out.println(resolution);
		
		if(myCol.getCurrentUser() != null )
		{
			this.setText(text);
			myLoc.setLatitude(latitude);
			myLoc.setLongtitude(longitude);
			this.setImageFileNmae(filePath);
			for(int i = 0 ; i<friends.length ; i++)
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
			myCol.getCurrentUser().getPostList().add(myImage);
			System.out.println("The post has been successfully added."); 
			
		}
		else
		{
			System.out.println("Error: Please sign in and try again.");
		}
	}

}
