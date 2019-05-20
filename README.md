I've used this repo to practice with Docker.

To build a docker **image** from this source code using the local **Dockerfile**, run:

```bash
docker build . -t my-tag
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
