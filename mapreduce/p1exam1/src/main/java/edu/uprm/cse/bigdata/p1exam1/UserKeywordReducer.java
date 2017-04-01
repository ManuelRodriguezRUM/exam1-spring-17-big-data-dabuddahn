package edu.uprm.cse.bigdata.p1exam1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by dabuddahn on 03-31-17.
 */
public class UserKeywordReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        String all_IDs = " ";
        System.out.println("Key: " + key);

        for (Text value : values){
            System.out.println(value.toString());
            all_IDs = all_IDs.concat(value.toString()) + " ";
        }
        context.write(key, new Text(all_IDs));
    }
}
