FROM selenium/standalone-chrome:latest

WORKDIR /app

# Install dependencies (Maven, JDK, Unzip)
RUN apt-get update && apt-get install -y maven openjdk-17-jdk unzip && \
    rm -rf /var/lib/apt/lists/*

# Set Java and Maven environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Copy project files
COPY . .

# Run tests
CMD ["mvn", "clean", "test"]
