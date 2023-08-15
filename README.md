UI autotests

#### Технологии и инструменты: Java 19, Maven, JUnit 5, Selenium, Selenium Grid, Selenoid, Cucumber, Docker, Github Actions, Jenkins, Allure

### Реализованы:
1) [тест-кейсы](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/TestCases.txt) для [логина](https://www.way2automation.com/angularjs-protractor/registeration/#/login);
2) [автотесты](https://github.com/Idzanaagi/UI-1/tree/main/src/test/java/tests), в т.ч.:
- **параметризированный** [тест](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/UniversalLoginTest.java);
- использующий [куки](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/CookieAuthorizationTest.java);
- использующие [JavaScriptExecutor](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/JSExecutorTest.java);
3) отчёты **Allure** (с поддержкой скриншотов на [падающих](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/utils/TestListener.java) тестах);
4) **параллельное** тестирование (число форков устанавливается в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties));
5) [кроссбраузерное](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/factory/DriverManager.java) тестирование (Chrome, Firefox, Edge, IE) **локально и в гриде** (браузер устанавливается в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties));
6) [тесты](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/cucumber/universalLogin.feature) с **BDD** (Сucumber);
7) [перезапуск](https://github.com/Idzanaagi/UI-1/blob/main/src/main/scripts/sh/restart-failed-tests.sh) упавших тестов;
8) [пайплайн](https://github.com/Idzanaagi/UI-1/blob/main/.github/workflows/build-and-report.yml) для прогона тестов, формирования отчётов и рассылки результатов прогона на email (ВАЖНО! ключ remote в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties) должен иметь значение false);
9) [пайплайн](https://github.com/Idzanaagi/UI-1/blob/main/.github/workflows/docker.yml) для прогона тестов в связке **Docker/Selenoid** ([Dockerfile](https://github.com/Idzanaagi/UI-1/blob/main/Dockerfile), [docker-compose](https://github.com/Idzanaagi/UI-1/blob/main/docker-compose.yml)) (ВАЖНО! ключ remote в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties) должен иметь значение true).

#### Отчёты Allure:
```
mvn clean test (прогнать тесты)
allure generate --clean (сгенерировать отчёт)
allure open (открыть отчёт)
```

#### параллельный запуск тестов:
- **локально**:
```
mvn test -P parallel
```
-  **в grid**: 
```
 ./src/main/scripts/sh/start-hub.sh (развернуть хаб)
 ./src/main/scripts/sh/start-node.sh (развернуть ноду)
 mvn test -P parallel (прогнать тесты)
```
или:
```
.\src\main\scripts\bat\start-hub.bat
.\src\main\scripts\bat\start-node.bat
 mvn test -P parallel
```

#### Структура проекта:
- test/java/pages - описание страниц;
- test/java/tests - автотесты;
- test/java/utils - утильные классы;
- test/java/TestCases.txt - тест-кейсы;
- .github/workflows - пайплайны.
