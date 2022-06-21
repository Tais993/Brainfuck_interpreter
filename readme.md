## Requirements

### Compiling
- JDK 17 or higher (See [adoptium](https://adoptium.net/), other JDK's are fine too)
- Gradle (see [gradle.org/install](https://gradle.org/install/))

### Running

- Java 17 or higher ([java.com/download](https://www.java.com/download/ie_manual.jsp))


## Compiling

Use the pre-compiled binaries at the [Releases tab on GitHub](https://github.com/Tais993/Brainfuck_interpreter/releases), alternatively compile yourself.

Go in the projects directory, after this. \
Run `gradle wrapper` to prepare the build \
Follow this with `gradlew build`, to build the project.

The jar can now be found at `./build/libs/Brainfuck_interpreter-1.0.jar`

## Running

Running can be done using the following command:
`java -jar brainfuck-interpreter.jar`

After this follow the console's instructions in console. \
The console will be used for input and output