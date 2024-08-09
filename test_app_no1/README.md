### 1. Maven local 라이브러리 로드 방법
#### 1. build.gradle.kts 수정
1. repositories 추가
```kotlin
repositories {
    mavenLocal()
}
```

2. 의존성 추가
- 라이브러리 이름은 settings.gradle.kts에 명시되어 있음
```kotlin
dependencies {
  // groupID:artifactId:version
  implementation("jy.library:custom_library:1.0")
}
```

3. 라이브러리 사용하기
```kotlin
package org.example

// 내 라이브러리 import하는 방법
import jy.library.*

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
    val customLib = Library()
    customLib.PrintName("Josua")
}
```

#### 2. 빌드
```
gradle build
gradle run
```

