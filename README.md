## Для запуска автотестов необходимо:
### 1. Установить на ПК:
* **Java** - версии не ниже 8
* **Intellij IDEA Ultimate**
* **Docker Desktop**
### 2. Клонировать [репозиторий](https://github.com/DmitrievDA97/QA_Diploma)
### 3. Запустить контейнеры Node.js, MySQL командой: `docker-compose up -d`
### 4. Запустить приложение командой: `java -jar artifacts/aqa-shop.jar`
### 5. Запустить автотесты командами `gradlew clean test allureReport` <br> `gradlew allureServe`