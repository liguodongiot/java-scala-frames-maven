启动Hadoop：
bin/start-all.sh

启动Hive：
bin/start-all.sh

启动hiveserver2：
./bin/hive --service hiveserver2  &

远程模式：
beeline -u jdbc:hive2://192.168.133.147:10000  -n root  -p liguodong

启动metastore：
hive --service metastore