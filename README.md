# AREP-Exam-T2
AREP T2 Exam

## Miguel Angel Motta

### Usage
![](assets/img.png)

### Testing Cient
![](assets/img_1.png)

## Deploying in AWS
### Configuration

![](assets/img_2.png)
![](assets/img_5.png)
### Set up EC2
````shell
sudo yum install java -y
sudo yum install maven -y
yum install git -y
git clone https://github.com/MIGUEL-MOTTA-U/AREP-Exam-T2
cd ./AREP-Exam-T2 # I must specify if the server is proxy, by default it's not
mvn clean package
mvn spring-boot:run
````

![](assets/img_3.png)

![](assets/img_4.png)

Finally, I've to set up the proxy server with the deployed instances urls and declare the attribute as true (because it's not proxy by default):
![](assets/img_9.png)
### Testing
The proxy runs the application and the two servers:
![](assets/img_7.png)

It handled through the active server:
![](assets/img_8.png)

It handled through the passive server because I stopped the active server:
![](assets/img_6.png)