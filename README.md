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

## Reflection API in Java

Reflection APIs in java allow you to access methods or other fields of an object without knowing the class of that object. You can also access private methods using reflection. Reflection is a runtime concept so which method to call is decided during runtime. 

Use-case 
- Reflection in used in unit testing for creating mocks
- Reflection is used in many libraries like serialization.

## Threads in Java

- Hardware threads vs software threads : every cpu has cores and threads fixed. These are hardware threads and these don't change.
- software threads are mapped to hardware threads for execution. Since software threads > hardware threads, time sharing happens between software threads. This is taken care by the scheduler.
- Hardware threads can actually run in parallel.
- Usually you have 2 threads per core. So a 4 core CPU will have 8 hardware threads.
- % CPU in task manager is the percentage utilization of 1 core in the last 5 seconds. So if a process is using more than 1 core, % CPU can go more than 100%.

### Use Case : you have to do a task on the end of a certain task.


What you need to do is that when a taskA ends, you need to then start taskB. This is a common usecase because there might be some tasks which are dependent on other tasks. You might want to execute them in order. To do this we can use the callback pattern.
- Create callback interface.
- inject the callback object using constructor or directly through the run method.
- then when calling the taskA, you specify what you want to do inside the callback.

```java
package com.scaler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncOperations {

    interface OnTaskEndListener {
        void onTaskEnd();
    }

    static class MockLongTask {
        private final String name;

        public MockLongTask(String name) {
            this.name = name;
        }

        void run(OnTaskEndListener listener) {
            new Thread(() -> {
                System.out.println("MockLongTask.run(" + name + ") started");
                var start = System.currentTimeMillis();
                // fake 10 sec delay
                // in real life, this would be a long running task
                while (System.currentTimeMillis() - start < 10000) {
                }
                System.out.println("MockLongTask.run(" + name + ") ended");
                if (listener != null) {
                    listener.onTaskEnd();
                }
            }).start();
        }

        void run() {
            run(null);
        }
    }

    public static void main(String[] args) {

        var taskA = new MockLongTask("1-download");
        var taskB = new MockLongTask("1-encrypt");
        var taskC = new MockLongTask("2-unrelated");

        taskA.run(() -> taskB.run()); // this is how to do something when some task has ended using callbacks.
        taskC.run();

        var executor = new ThreadPoolExecutor(
                1,
                4,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

    }
}
```

- Java doesn't provide this out of the box so you have to use callbacks. GoLang has better support for this as it has some good inhouse libraries.


### Thread executors 

Thread executor creates a pool of threads and uses those threads only to schedule tasks. For example, if you specify your thread executor to have 4 threads and pass 6 tasks to it, 2 tasks will be in the waiting state for any thread to pick them up.


## Web Frameworks

These frameworks are mostly MVC framework. 
- **Model** : Model is the data repository layer which contains the code to interact with database
- **View** : View is the layer which interacts with the front end. This contains controllers
- **Service** : This is the layer which is the middle layer and interacts with both Model and View. This contains the actually business logic.


