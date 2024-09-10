# Stock-Market Simulation
Learning Spring Boot with Google Cloud - GKE

#### Gradle Build 

~~~
./gradlew clean build
~~~

#### Run 

~~~
sh run-local.sh
~~~

#### Links

[http://localhost:10101/swagger-ui/index.html](http://localhost:10101/swagger-ui/index.html)

[http://localhost:10101/](http://localhost:10101/)

#### Docker
Build Image 
~~~
docker build -t stock-market:latest .
~~~
Save Image
~~~
docker save stock-market:latest | stock-market-latest.tar.gz
~~~
Run Image
~~~
docker run --rm -d -p 10101:10101 -t stock-market:latest
~~~

#### Minikube

~~~
$ minikube start

* minikube v1.25.2 on Microsoft Windows 11 Home Single Language 10.0.22000 Build 22000
* Using the docker driver based on existing profile
* Starting control plane node minikube in cluster minikube
* Pulling base image ...
* Downloading Kubernetes v1.23.3 preload ...
* Updating the running docker "minikube" container ...
* Preparing Kubernetes v1.23.3 on Docker 20.10.12 ...
  - kubelet.housekeeping-interval=5m
* Verifying Kubernetes components...
  - Using image kubernetesui/dashboard:v2.3.1
  - Using image kubernetesui/metrics-scraper:v1.0.7
  - Using image gcr.io/k8s-minikube/storage-provisioner:v5
* Enabled addons: dashboard, storage-provisioner, default-storageclass
* Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default

~~~

~~~
$ minikube dashboard

* Verifying dashboard health ...
* Launching proxy ...
* Verifying proxy health ...
* Opening http://127.0.0.1:51979/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/ in your default browser...

~~~
#### Important Note: do below Set docker env

For bash UNIX
~~~
eval $(minikube docker-env)
~~~       

For PowerShell 
~~~ 
minikube docker-env | Invoke-Expression
~~~

#### Docker Image v1 created
~~~
docker build -t stock-market:v1 .

Sending build context to Docker daemon  26.38MB
Step 1/6 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/6 : ARG JAR_FILE=build/libs/app.jar
 ---> Running in 870c13bce93d
Removing intermediate container 870c13bce93d
 ---> 92db70e5e1c5
Step 3/6 : WORKDIR /opt/app
 ---> Running in d10817dfd69a
Removing intermediate container d10817dfd69a
 ---> e60d29dd030a
Step 4/6 : COPY ${JAR_FILE} app.jar
 ---> 2529f0dcc9f8
Step 5/6 : ENV PORT 10101
 ---> Running in c86a50188e5f
Removing intermediate container c86a50188e5f
 ---> 32f2e69a21bd
Step 6/6 : ENTRYPOINT ["java","-server", "-Xmx300M", "-XX:+UseG1GC", "-jar", "app.jar", "--server.port=10101"]
 ---> Running in 2bb10ebde2e1
Removing intermediate container 2bb10ebde2e1
 ---> e6c259ebcebd
Successfully built e6c259ebcebd
Successfully tagged stock-market:v1
SECURITY WARNING: You are building a Docker image from Windows against a non-Windows Docker host. All files and directories added to build context will have '-rwxr-xr-x' permissions. It is recommended to double check and reset permissions for sensitive files and directories.
~~~

#### Create Minikube Deployment
~~~
$ kubectl create deployment stock-market --image=stock-market:v1
deployment.apps/stock-market created
~~~

#### Create Minikube Service for Deployment
~~~
$ kubectl expose deployment stock-market --type=NodePort --port=10101
service/stock-market exposed
~~~

#### Get Minikube Service for Deployment
~~~
$ kubectl get services stock-market
NAME           TYPE       CLUSTER-IP     EXTERNAL-IP   PORT(S)           AGE
stock-market   NodePort   10.99.140.47   <none>        10101:30298/TCP   27s
~~~

#### Get Minikube PODs for Deployment
~~~
$ kubectl get pods
NAME                              READY   STATUS    RESTARTS      AGE
hello-minikube-7bc9d7884c-mcwh2   1/1     Running   5 (29m ago)   29d
stock-market-54996bb844-dg5fd     1/1     Running   0             7m12s
~~~

#### Important step Expose service port  
~~~
$ kubectl port-forward service/stock-market 10101:10101

Forwarding from 127.0.0.1:10101 -> 10101
Forwarding from [::1]:10101 -> 10101
Handling connection for 10101
Handling connection for 10101
Handling connection for 10101
~~~

#### Open Web browser below URL
[http://localhost:10101/swagger-ui/index.html](http://localhost:10101/swagger-ui/index.html)

[http://localhost:10101/](http://localhost:10101/)

#### Deployment is successful into Minikube
