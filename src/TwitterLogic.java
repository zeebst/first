// und jetzt kommt der test #


        	public String getTotal(Status status){
        		
        		//GetVariables
        		Date createDate = status.getCreatedAt();
                Long userId = status.getUser().getId();
                long tweetId = status.getId(); 
                String language = status.getLang();
                String text = status.getText();
                String name = status.getUser().getName();
                //Verbreitung
                long inReplyToStatus = status.getInReplyToStatusId();
                long inReplyToUser = status.getInReplyToUserId();
                boolean retweet = status.isRetweet();
                long retweetedstatus = status.getRetweetedStatus().getId();
                //GeoLocation
                String location2 = status.getUser().getLocation();
                GeoLocation geolocation = status.getGeoLocation();
                
                //Funktioniert nur, wenn geoLocation gefüllt ist
                String geo = "null";  
                if(geolocation != null){
              	geo = geolocation.toString();}
                
                //Categorize Tweet by Keyword 
                /*String keyword = "no_match";
                
                for (int i=0; i<keywords.length; i++) {
	                if (text.toLowerCase().contains(keywords[i])) {
	                	keyword = keywords[i];               	
	                	};
                }*/
        		
                //Remove LineBrakes and QuotationMarks (or problems with reading each Line as a JSON-Object may occur)
                text = text.replaceAll("\n"," ");
                text = text.replaceAll("\"","''");
                
                //CreateString total
        		String total = ("{" +
                		"\"created_at\":\""+createDate+"\"," +
                		"\"profil_ID\":\""+userId+"\"," +
                		"\"retweet\":\""+retweet+"\"," +
                		"\"retweetedstatus\":\""+retweetedstatus+"\"," +
                		"\"profil_name\":\""+name+"\"," +
                		"\"tweet_id\":\""+tweetId+"\"," +
                		"\"tweet_text\":\""+text+"\"," +
                		"\"tweet_lang\":\""+language+"\"," +
                		"\"tweet_location\":\""+geo+"\"," +
                		"\"profil_location\":\""+location2+"\"" +
                		"}\n");
        		
        		//return
				return total;
        		
        	};
        	//If Status is returned
            public void onStatus() {
            	
            	//Get TweetVariables
                Date createDate = status.getCreatedAt();
                Long userId = status.getUser().getId();
                long tweetId = status.getId(); 
                String userLocation = status.getUser().getLocation();
                String language = status.getLang();
                String text = status.getText();
                int year = 1900+createDate.getYear();
                int month = 1+createDate.getMonth();
                int day = createDate.getDate();
                int hour = createDate.getHours();  
                int minutes = createDate.getMinutes();
                
                String name = status.getUser().getName();
                int retweetcount = status.getRetweetCount();
                int followers = status.getUser().getFollowersCount();
                int friends = status.getUser().getFriendsCount();
                long inreply = status.getInReplyToStatusId();
                
                String total = getTotal(status);
                System.out.println(total);
                
                
                
                /*
                geo = geo.replaceAll("null"," ");
                geo = geo.replaceAll("GeoLocation{latitude="," ");
                geo = geo.replaceAll("longitude="," ");
                geo = geo.replaceAll("}"," ");
                geo = geo.replaceAll(" "," ");
                geo = geo+","+name;
                */ 
                
                //Remove LineBrakes and QuotationMarks (or problems with reading each Line as a JSON-Object may occur)
                text = text.replaceAll("\n"," ");
                text = text.replaceAll("\"","''");
                
                              
              //Categorize Tweet by Keyword 
                //If there is no match, "no_match" is filled in - this should never happen!
                String keyword = "no_match";
                
                /*for (int i=0; i<keywords.length; i++) {
	                if (text.toLowerCase().contains(keywords[i])) {
	                	keyword = keywords[i];               	
	                	};
                }*/

                //Merge Fields + MatchedKeyword to a 1Line-JSON output String
                //String total = getTotal(status);
                
                //Print StringToConsole
                System.out.println(text);

                
                /*
                //WriteToFileSystem
                //Configure FileSystem
            	Configuration config = new Configuration();
            	config.set("fs.defaultFS","hdfs://192.168.152.128:9000/");
            	try {
					//Specify FileSystem
            		FileSystem hdfs = FileSystem.get(config);
					
					//Set OutputDirectory
	            	Path src = new Path(hdfs.getWorkingDirectory()+"/StreamData/2506");
	            	BufferedWriter br = new BufferedWriter (new OutputStreamWriter(hdfs.append(src)));
	            	
	            	//Write Data and CloseStream
	            	br.write(total);
	            	br.close();
	                
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	*/
            	/*
                	//Write StringToFile
                try {
                //FileWriter out8 = new FileWriter("weltuntergang.txt", true);
				//out8.write(geo+"\r\n");
                //out8.close();
                FileWriter out9 = new FileWriter("F:/Data/wmfinal3.txt", true);
				out9.write(total+"\r\n");
                out9.close();
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
                /*
                for (int i=0; i<keywords.length; i++) {
                	if (keyword == keywords[i]){
		                try {
		                	
		                	
		                	FileWriter out = new FileWriter(keywords[i]+"_GeoAnalys.txt", true);
							out.write(geoanalyse);
			                out.close();
		                	 
			                FileWriter out2 = new FileWriter(keywords[i]+"_text.txt", true);
							out2.write(text+"\r\n");
			                out2.close();
			                
			                FileWriter out3 = new FileWriter(keywords[i]+"_langugage.txt", true);
							out3.write(language+"\r\n");
			                out3.close();
			                
			                FileWriter out4 = new FileWriter(keywords[i]+"_loc.txt", true);
							out4.write(geo+"\r\n");
			                out4.close();
			                			                
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
                }*/         
            }
            
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        
        //AddListener to TwitterStream Instance with OAuthConf -calls StatusListener OnStatus
        //+FilterQueryParameter (w Keywords) to TwitterStream
         