# My pokedex documentation

## Deployment
For backend deploy I used AWS EC2 service. I followed the next steps:

1. Create a new EC2 t2.micro instance in [AWS Console](https://console.aws.amazon.com), I chosse an ubuntu instance.
2. Once configured the new ubuntu instance proced to connect via ssh to my server and update the operative system ~~~$ sudo apt update~~~ ~~~$ sudo apt upgrade~~~
3. Install maven for run my pokedex API ~~~$ sudo apt install maven~~~
4. Clone [backend repository](https://github.com/Yojanpardo/pokedex-backend) master branch in my EC2 Instance ~~~$ git clone https://github.com/Yojanpardo/pokedex-backend.git~~~
5. Install supervisor to serve pokedex API ~~~$ sudo apt install supervisor~~~
6. I configured supervisor for run my pokedex API with next command ~~~ mvn clean install spring-boot:run~~~
7. I configured an elastic ip address to void my instance change its ip address.