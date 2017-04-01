package edu.uprm.cse.bigdata.p1exam1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import java.io.IOException;

/**
 * Created by dabuddahn on 03-31-17.
 */
public class UserKeywordMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String rawTweet = value.toString();

        try {
            Status status = TwitterObjectFactory.createStatus(rawTweet);
            String keywords = status.getText().toUpperCase();
            //User user = status.getUser();
            //long id = user.getId();
            long tweet_id = status.getId();
            String str_id = Long.toString(tweet_id);

            if(keywords.contains("MAGA")){
                context.write(new Text("MAGA"), new Text(str_id));
            }
            if(keywords.contains("DICTATOR")){
                context.write(new Text("DICTATOR"), new Text(str_id));
            }
            if(keywords.contains("IMPEACH")){
                context.write(new Text("IMPEACH"), new Text(str_id));
            }
            if(keywords.contains("DRAIN")){
                context.write(new Text("DRAIN"), new Text(str_id));
            }
            if(keywords.contains("SWAMP")){
                context.write(new Text("SWAMP"), new Text(str_id));
            }
            if(keywords.contains("CHANGE")){
                context.write(new Text("CHANGE"), new Text(str_id));
            }
            else{

            }
        }

        catch(TwitterException e) {

        }
    }
}
