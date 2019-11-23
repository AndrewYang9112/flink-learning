# Flink Practice

## Section 1

### 1.项目模板构建

```shell script
mvn archetype:generate                               \
      -DarchetypeGroupId=org.apache.flink              \
      -DarchetypeArtifactId=flink-quickstart-scala     \
      -DarchetypeVersion=1.9.1
```

### 2.POM简介

Active Profile

### 3.Flink程序基本结构

基本要素:Env

基本结构:Source->Calculation->Sink

### 4.WordCount

1. 计算逻辑
2. Parallelism
2. CountWindow
3. Source & Sink
4. TypeInformation & Implicit