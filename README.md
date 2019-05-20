I've used this repo to get some practice with Docker.
Currently I have simple Java and Python examples with docker.

## Java Project
To build a docker **image** from the Java source code using the local **Dockerfile**, run:

```bash
docker build ./java/ -t my-tag
```

Now you've got the image available:

```bash
docker image ls
```

To run the container in **detached, interactive** mode with a terminal attached on port 80, run:

```bash
docker run -dit -p 80:8080 my-tag
```

The `8080` port listened to by the app and exposed by the docker container is mapped to port `80` on the local machine.

The docker container now spins up and you should be able to hit several endpoints at `localhost:80` (which is just `localhost`):
* `/` - default response
* `/kill` - kills the process
* `/echo/{name}/` - echoes back the input
* `/hello` - gives a "Hello there" response

## Python Project

The setup for the Python example is similar, except this app is listening on port `80`.
Thus, building the image and running the app would go like this:

```bash
docker build ./python/ -t my-tag
docker run -dit -p 80:80 my-tag
```

Now you should see the "Hello world" response when you hit `localhost`.

### Docker compose

The Python app also includes a `docker-compose.yml` file which enables spinning up an entire suite of services - in
this case the Redis service the app uses as well as a visualizer tool. We can also scale out our services very easily
using the `docker-compose` tool.

To start up our app with it's dependent services:

```bash
cd ./python/
docker-compose up
```

This python app is also published publically to Docker hub at `acrenwelge/getting-started:python-helloworld`. The image can be pulled and run thusly:

```bash
docker run -dit -p 80:80 acrenwelge/getting-started:python-helloworld
```

**Note**: For fresh Linux VMs, we need to download docker and docker-compose and add execute permissions to the binary.
Also, to run docker without `sudo`, we must also add ourselves to the `docker` group.
Finally, we need to start the docker daemon as a service.
We can do all the above with the following script:

```bash
sudo yum install docker -y
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo usermod -aG docker $USER
sudo service docker start
```
