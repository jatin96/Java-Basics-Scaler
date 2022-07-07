# Java-Basics-Scaler


## Why do companies have packages / groups name as opposite of domain  ? 

This is done to make folder hierarchy simple. This way you can easily identity which company has created what projects. For example, google can name its project package as 
1. com.google.android
2. com.google.mail
3. com.google.keep

This tells us that google has created android, mail and keep. In future, google can add more products easily using this structure. 

It is not necessary to have the domain registered for this naming convention. It's just a convention which people have been following.

## Gradle

Gradle is one of the build systems widely used for Java. 
- If you have gradle installed then you can run gradle build
- Every gradle project also has a gradlew folder which contains gradle script. This is useful in case you want to do CI / CD. You can run gradle without installing using gradlew build

## How to run jar ?

```shell
java -jar <name-of-file>.jar
```

## OkHttp library

This library is used to make http calls in a java project.

## Creating a fat jar in Gradle

By default jar you build in gradle do not include imported libraries like OkHttp. You need to add the below line to include it into the jar :

```groovy
from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
```

