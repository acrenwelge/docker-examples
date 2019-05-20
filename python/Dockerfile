# Python runtime is the parent image
FROM python:2.7-slim

# set working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages from requirements.txt
RUN pip install --trusted-host pypi.python.org -r requirements.txt

# Make port 80 available to the world outside this container
EXPOSE 80

# Define environment variables
ENV NAME World

# Run app.py when container launches
CMD ["python", "app.py"]

