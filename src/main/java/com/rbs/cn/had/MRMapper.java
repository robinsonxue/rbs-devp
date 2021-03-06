package com.rbs.cn.had;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by fengtao.xue on 2018/1/11.
 */
public class MRMapper extends Mapper<Object, Text, Text, Text> {

    static Logger logger = LoggerFactory.getLogger(MRMapper.class);

    @Override
    protected void setup(Mapper<Object, Text, Text, Text>.Context context)
            throws IOException, InterruptedException {
        super.setup(context);
    }

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String v = value.toString();
        logger.debug("map input key:{}", key);
        logger.debug("map input value:{}", v);
        String line = value.toString();
        String year = line.substring(0, 4);
        String temperature = line.substring(8);
        context.write(new Text(year), new Text(temperature));
    }


}
