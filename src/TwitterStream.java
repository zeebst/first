import java.util.Date;

import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStream {
	
    public static void main(String[] query) {
    	
    	final String keywords[] = query;
    	OpenStream(OAuth(), keywords);
    	
    	    	
    }

	public static ConfigurationBuilder OAuth (){
		//OAuth Configuration
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("uQ0dukqqnh1PToOR72jGDYstO");
        cb.setOAuthConsumerSecret("KorVDWRrWnGX8ymfutHbwFdGaTFKwxTTnPqzq51rXPsw0TVIy5");
        cb.setOAuthAccessToken("392778422-Tu3iLbGNEXVmhRBMMgh7JvpHeOnOYRoVNDLVEaZ4");
        cb.setOAuthAccessTokenSecret("d2asz50i0zZhgIhe4JSH6ajVvoLXKZy21rXHaI7fhnAxL");
        return cb;
		
	}
	
	public static void OpenStream(ConfigurationBuilder cb, String[] keywords){
		
		//Create TwitterStream Object "twitterStream" with an Instance of TwitterStreamFactory (with OAuth Configuration.build)
        twitter4j.TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        
        //Create FilterQuery - with possible Parameters count, follow,    |||  track    |||  , locations, language:
        FilterQuery fq = new FilterQuery();
        fq.track(keywords);
        twitterStream.addListener(Listener());
        twitterStream.filter(fq); 
	}
	
	public static StatusListener Listener(){
		
		StatusListener listener = new StatusListener(){

			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

			public  void onStatus(Status status) {
				Object[] fields = CollectFields(status);
				System.out.println(fields[0]);
			}

			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}};
		
		return listener;
	}
	
	public static Object[] CollectFields(Status status){
		
		Object[] data = {1, 2, 3, 4, 5};
		
		//ToGetList
		//String[] getlist = {"getCreatedAt();", "getUser().getId();", "getId(); ", "getLang();", "getText();", "getUser().getName();"};

		//GetVariables2 + LOGIC
		data[0] = status.getCreatedAt();
		data[1] =  status.getUser().getId();
		data[2] =  status.getId(); 
		data[3] =  status.getLang();
		data[4] =  status.getText();
		//data[5] =  status.getUser().getName();
        //Verbreitung
		//data[6] =  status.getInReplyToStatusId();
		//data[7] =  status.getInReplyToUserId();
		//data[8] =  status.isRetweet();
		//data[9] =  status.getRetweetedStatus().getId();
		
		return data;
	}
        


    }
