# selenium-framework-poc
Example of a mini-framework to execute automated tests using Selenium, Spring, Cucumber.

#### Run the tests

`mvn clean test -Denvironment=prod
`

```
version: '3'

services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.0.0
    environment:
      - cluster.name=docker-cluster
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    ports:
      - "9200:9200"
  kibana:
    image: docker.elastic.co/kibana/kibana:7.0.0
    ports:
      - "5601:5601"
```


 `     
docker-compose up -d
`

Remove all stopped containers: 
 `
docker container ls -a --filter status=exited --filter status=created 
 `
 
  `
$ screen ~/Library/Containers/com.docker.docker/Data/vms/0/tty
 `
On the blank screen, press RETURN.

Then configure the sysctl setting as you would for Linux:
 `
sysctl -w vm.max_map_count=262144
 `
Exit by Control-A Control-\
