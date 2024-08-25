package com.example.streams.generation.consumers;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.from_json;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkStructuredStreamingWithTripInfo {
	public static void main(String[] args) throws TimeoutException, StreamingQueryException {

		SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkStructuredStreamingWithKafka");
		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");

		List<StructField> fields = new ArrayList<>();

		fields.add(DataTypes.createStructField("product", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("sellerName", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("customerName", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("location", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("status", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("warehouse", DataTypes.StringType, true));

		StructType structType = DataTypes.createStructType(fields);

		Dataset<Row> df = spark
				.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092")
				.option("subscribe", "test")
				.load();

		Dataset<Row> res = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
				.withColumn("value", from_json(col("value"), structType))
				.select(col("value.*"));

		res.createOrReplaceTempView("temp");

		res.writeStream()
				.format("console")
				.outputMode(OutputMode.Append()) // Changed to Append mode
				.start()
				.awaitTermination();
	}
}
