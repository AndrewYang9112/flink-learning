package com.hypers.practice

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}

object WordCount extends App {

  val env = StreamExecutionEnvironment.getExecutionEnvironment

  // Source
  val source: DataStream[String] = env.readTextFile("src/main/resources/words.txt")

  // Calculation
  val counts: DataStream[(String, Int)] = source
    // split up the lines in pairs (2-tuples) containing: (word,1)
    // \W matches a char in [^A-Za-z0-9_]
    .flatMap(_.toLowerCase.split("\\W+"))
    .filter(_.nonEmpty)
    .map((_, 1))
    // group by the tuple field "0" and sum up tuple field "1"
    .keyBy(0)
    .sum(1)

  // Sink
  counts.print()

  env.execute("Word Count Stream Job")

}
