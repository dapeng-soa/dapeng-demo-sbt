# dapeng-demo-sbt
Demo for dapeng-soa with scala and sbt plugin 

# Run with IDEA
1. import the project by IDEA.
2. create a sbt task from "Run" -> "Edit Configuration"
3. fill in ~runContainer within Tasks
4. enjoy run or debug with IDEA.

> the '~' make you run into the hot deploy mode, under this mode, changed code will take effect without restart Jvm process.

# Run with docker
First build a docker images with dapeng-sbt-plugin
```
sbt clean api/compile api/package docker
```

After that, an image named xxxx:5000/biz/hello_service:00d1735 will come out. 
**00d1735** is the last git commit id of the demo project.
Create a container with this image, and passing zookeeper host in as a env.
```
docker run --name hello -d  -e soa_zookeeper_host=172.16.17.222:2181 -e soa_container_ip=172.16.17.222 -e soa_container_port=9081 -p 9081:9081  docker.today36524.com.cn:5000/biz/hello_service:00d1735
```

# Testing
## Inner Document site
If you run the demo project inside IDEA, an inner document site will be up for you to read the service document and do some testing.

Just open http://localhost:8192 with your brower.

## Extenal Document site
You can use the [service document site](https://github.com/dapeng-soa/dapeng-api-doc) to feel the service and do some testing. 

```
docker run --name dapengApiDoc -d -e soa_zookeeper_host=192.168.10.131:2181 -p 8083:8080 dapengsoa/dapeng-api-doc
```
Then open http://localhost:8083 with your brower.
