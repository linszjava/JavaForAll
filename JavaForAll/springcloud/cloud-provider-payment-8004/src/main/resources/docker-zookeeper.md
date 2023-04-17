#拉取zookeeper镜像 最新的就行
docker pull zookeeper

#设置挂在目录
cd /usr/local && mkdir zookeeper && cd zookeeper
mkdir data

##部署
docker run -d -e TZ="Asia/Shanghai" -p 2181:2181 -v $PWD/data:/data --name zookeeper --restart always zookeeper

##zk命令行客户端连接zk
docker run -it --rm --link zookeeper:zookeeper zookeeper zkCli.sh -server zookeeper

## 使用 ls / 查看 如
ls /services