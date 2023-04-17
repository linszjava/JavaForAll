## 拉取镜像
docker pull consul

## 运行

docker run -d -p 8500:8500 --restart=always --name=consul consul:latest agent -server -bootstrap -ui -node=1 -client='0.0.0.0'


## 关闭防火墙
systemctl stop firewalld

## 宿主机上面访问8500即可 如
http://172.16.48.133:8500
