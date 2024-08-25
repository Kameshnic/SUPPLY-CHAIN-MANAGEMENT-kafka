package com.example.streams.generation;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSqlExample {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("Spark-Sql-Example");
		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
		Dataset<Row> df = spark.read().json("prod-info.json");
		df.printSchema();
		df.createOrReplaceTempView("trip");
		//Dataset<Row> res = spark.sql("select count(*) from trip where paymentMethod='paytm'");
		Dataset<Row> res = spark.sql("select count(*) from trip where sellerName='Rajesh'");

		res.write().json("paytm-trip-info");
	}
}
