
public class VideoPosts extends TextPost {
	private String videoFileNmae;
	private int  videoLength;
	
	
	/**
	 * to getVideoFileNmae
	 * @return
	 */
	public String getVideoFileNmae() 
	{
		return videoFileNmae;
	}
	/**
	 * to setVideoFileNmae
	 * @param videoFileNmae
	 */
	public void setVideoFileNmae(String videoFileNmae) 
	{
		this.videoFileNmae = videoFileNmae;
	}
	/**
	 * to getVideoLength
	 * @return
	 */
	public int getVideoLength()
	{
		return videoLength;
	}
	/**
	 * to setVideoLength
	 * @param videoLength
	 */
	public void setVideoLength(int videoLength) 
	{
		this.videoLength = videoLength;
	}

	
	/**
	 * this method add video post
	 * @param text added text
	 * @param longitude location 
	 * @param latitude location 
	 * @param friends list of tageed friends
	 * @param videoFileName file name of video
	 * @param videoLength length of video
	 * @param myCol to work with objects in UserCollection class.
	 * @param myLoc to work with objects in Location class.
	 * @param myUser to work with objects in User class.
	 */
	public void addPostVideo(String text, double longitude, double latitude, String[] friends, String videoFileName, int videoLength, UserCollection myCol,
			Location myLoc, User myUser )
	{
		VideoPosts myvideo = new VideoPosts();
		System.out.println("-----------------------");
		System.out.print("Command: ADDPOST-VIDEO\t" + text + "\t" + longitude + "\t" + latitude + "\t");
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
		System.out.print(videoFileName+"\t");
        System.out.println(videoLength);
		
		if(myCol.getCurrentUser() != null )
		{
			this.setText(text);
			myLoc.setLatitude(latitude);
			myLoc.setLongtitude(longitude);
			this.setVideoFileNmae(videoFileName);
			this.setVideoLength(videoLength);
			if(videoLength<=10)
			{
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
				myCol.getCurrentUser().getPostList().add(myvideo);
	            System.out.println("The post has been successfully added.");            
			}
			else
			{
				System.out.println("Error: your video exceeds maximum allowed duration of 10 minutes.");
			}
		}
		else
        {
            System.out.println("Error: Please sign in and try again.");
        }
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
