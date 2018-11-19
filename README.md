# dapeng-demo-sbt
Demo for dapeng-soa with scala and sbt plugin 

# run with IDEA
1. import the project by IDEA.
2. create a sbt task from "Run" -> "Edit Configuration"
3. fill in ~runContainer within Tasks
4. enjoy run or debug with IDEA.

> the '~' make you run into the hot deploy mode, under this mode, changed code will take effect without restart Jvm process.

# run with docker
First build a docker images with dapeng-sbt-plugin
```
sbt clean api/compile api/package docker
```

After that, an image named xxxx:5000/biz/hello_service:00d1735 will come out. 
**00d1735** is the last git commit id of the demo project.
Create a container with this image, and passing zookeeper host in as a env.
```
docker run --name hello -d  -e soa_zookeeper_host=172.16.17.222:2181 docker.today36524.com.cn:5000/biz/hello_service:00d1735
```

Then the demo service is up. You can use the [service document site](https://github.com/dapeng-soa/dapeng-api-doc) to feel the service and do some testing. 
