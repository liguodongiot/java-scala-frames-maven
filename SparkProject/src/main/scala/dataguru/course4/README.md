##SqlContext

###启动Spark-shell
```shell
bin/spark-shell --master spark://ubuntu:7077 --executor-memory 2g
```

###RDD演示
```scala

val sqlContext = new org.apache.spark.sql.SQLContext(sc)
//引入sparkContext的隐式函数
import sqlContext._

//姓名，年龄
case class Person(name:String,age:Int)

//读取文件
//根据逗号分隔
val people=sc.textFile("hdfs://hadoop1:8000/people.txt").map(_.split(",")).map(p=>Person(p(0),p(1).trim.toInt))

//注册
people.registerAsTable("people")

people.toDebugString


//对表进行操作
val teenagers = sqlContext.sql("select name from people where age>=13 and age <=19")

//Action
teenagers.map(t => "Name: " + t(0)).collect().foreach(println)

```

###DSL演示
```scala
//字段名要加引号
val teenagers_dsl = people.where('age>=10).where('age<=19).select('name)
teenagers_dsl.map(t => "Name: " + t(0)).collect().foreach(println)
```

###parquet演示
```
//import sqlContext.createSchemaRDD
//将people保存为parquet文件
people.saveAsParquetFile("hdfs://hadoop1:8000/people.parquet")

//读取
val parquetFile = sqlContext.parquetFile("hdfs://hadoop1:8000/people.parquet")

//注册
parquetFile.registerAsTable("parquetFile")


val teenagers = sqlContext.sql("SELECT name FROM parquetFile WHERE age >= 13 AND age <= 19")
teenagers.map(t => "Name: " + t(0)).collect().foreach(println)

```


###join演示
```
//从两个不同数据源来的数据进行混合查询
val jointbls = sqlContext.sql("SELECT people.name FROM people join parquetFile where people.name=parquetFile.name")

jointbls.map(t => "Name: " + t(0)).collect().foreach(println)

```

###另外的一个parquet演示
```
//val sqlContext = new org.apache.spark.sql.SQLContext(sc)

//读取
val wikiData = sqlContext.parquetFile("hdfs://hadoop1:8000/wiki_parquet")

wikiData.count()

wikiData.registerAsTable("wikiData")

val countResult = sqlContext.sql("SELECT COUNT(*) FROM wikiData").collect()

//group操作
sqlContext.sql("SELECT username, COUNT(*) AS cnt FROM wikiData
WHERE username <> '' GROUP BY username ORDER BY cnt DESC LIMIT 10").collect().foreach(println)

```

##HiveContext


###启动hive metasotre service
```
nohup bin/hive --service metastore > metastore.log 2>&1 &
```

注意：如果要使用hive，需要将hive-site.xml文件复制到conf/下


###启动spark-shell
```
bin/spark-shell --master spark://hadoop1:7077 --executor-memory 3g
```

###hive演示
```
//org.apache.spark.sql.hive.HiveContext(sc)出错，请更换支持hive的spark版本
val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)

hiveContext.hql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)")
hiveContext.hql("LOAD DATA LOCAL INPATH 'src/main/resources/kv1.txt' INTO TABLE src")
hiveContext.hql("FROM src SELECT key, value").collect().foreach(println)

```


###sogouQ数据演示
```
//查询有多少行数据
hiveContext.hql("Select count(*) from SOGOUQ1").collect().foreach(println)

//显示前10行数据
hiveContext.hql("select * from SOGOUQ1 limit 10").collect().foreach(println)

//session查询次数排行榜
hiveContext.hql("select WEBSESSION,count(WEBSESSION) as cw from SOGOUQ1
group by WEBSESSION order by cw desc limit 10").collect().foreach(println)

```

###销售数据演示

```
hiveContext.hql("use saledata").collect().foreach(println)
hiveContext.hql("show tables").collect().foreach(println)

//所有订单中总销售额
hiveContext.hql("select sum(tblStockDetail.amount) from tblStock
 join tblStockDetail on tblStock.ordernumber=tblStockDetail.ordernumber").collect().foreach(println)

hiveContext.hql("select sum(b.amount) from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber").collect().foreach(println)


//3个表链接
hiveContext.hql("select sum(tblStockDetail.amount) from tblStock
join tblStockDetail on tblStock.ordernumber=tblStockDetail.ordernumber
join tbldate on tblstock.dateid=tbldate.dateid").collect().foreach(println)

hiveContext.hql("select sum(b.amount) from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid").collect().foreach(println)



//所有订单中每年的销售单数、销售总额
hiveContext.hql("select c.theyear,count(distinct a.ordernumber),sum(b.amount) from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid
group by c.theyear order by c.theyear").collect().foreach(println)



//所有订单中每年最畅销货品
//第一步：
hiveContext.hql("select c.theyear,b.itemid,sum(b.amount) as sumofamount from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid group by c.theyear,b.itemid").collect().foreach(println)

//第二步:
hiveContext.hql("select d.theyear,max(d.sumofamount) as maxofamount from
(select c.theyear,b.itemid,sum(b.amount) as sumofamount from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid group by c.theyear,b.itemid) d
group by d.theyear").collect().foreach(println)

//第三步：
hiveContext.hql("select distinct  e.theyear,e.itemid,f.maxofamount from
(select c.theyear,b.itemid,sum(b.amount) as sumofamount from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid group by c.theyear,b.itemid) e
join (select d.theyear,max(d.sumofamount) as maxofamount from
(select c.theyear,b.itemid,sum(b.amount) as sumofamount from tblStock a
join tblStockDetail b on a.ordernumber=b.ordernumber
join tbldate c on a.dateid=c.dateid group by c.theyear,b.itemid) d
group by d.theyear) f on (e.theyear=f.theyear and e.sumofamount=f.maxofamount)
order by e.theyear").collect().foreach(println)


```
