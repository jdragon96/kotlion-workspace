## 참고자료
https://docs.gradle.org/current/samples/sample_building_kotlin_libraries.html

## 실행
### 1. gradle 환경 초기화
```
gradle init
```

### 2. gradle 프로젝트 생성
```
Select type of build to generate:
  1: Application
  2: Library
  3: Gradle plugin
  4: Basic (build structure only)
Enter selection (default: Application) [1..4] 2

Select implementation language:
  1: Java
  2: Kotlin
  3: Groovy
  4: Scala
  5: C++
  6: Swift
Enter selection (default: Java) [1..6] 2

Enter target Java version (min: 7, default: 21): 21

Project name (default: lib2):

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 1

Select test framework:
  1: kotlin.test
  2: JUnit Jupiter 
  
enter selection (default: kotlin.test) [1..2] 1
```

### 3. build.gradle.kts 수정
1. plugins 변경사항
```kotlin
plugins {
    `maven-publish`
}
```

2. repositoeis 변경사항
```kotlin
repositories {
    mavenLocal()
}
```

3. java 수정
- [TODO]: 왜 필요한지 설명 필요
```kotlin
java {
    withSourcesJar()
}
```

4. tasks.jar를 통해 manifest 속성 추가
```kotlin
tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
                         "Implementation-Version" to project.version))
    }
}
```

5. publishing 변경
- local maven 저장소에 라이브러리 추가
```kotlin
publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])
    }
  }
}
```


### 4. 빌드
```
gradle build
```

### 5. 로컬 라이브러리 업로드
```
gradle clean publishToMavenLocal
```