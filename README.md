UI autotests

### Стек: Java 19, maven, junit5, selenium, selenium grid

### Реализованы:
1) [тест-кейсы](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/TestCases.txt) для [логина](https://www.way2automation.com/angularjs-protractor/registeration/#/login);
2) [автотесты](https://github.com/Idzanaagi/UI-1/tree/main/src/test/java/tests), в т.ч.:
- универсальный (параметризированный) [тест](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/UniversalLoginTest.java);
- использующий [куки](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/CookieAuthorizationTest.java);
- использующие [JavaScriptExecutor](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/tests/JSExecutorTest.java);
3) отчёты Allure (с поддержкой скриншотов на [падающих](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/utils/TestListener.java) тестах);
4) параллельный запуск тестов (число форков устанавливатся в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties));
5) [перезапуск](https://github.com/Idzanaagi/UI-1/blob/main/src/main/scripts/sh/restart-failed-tests.sh) упавших тестов;
6) [запуск](https://github.com/Idzanaagi/UI-1/blob/main/src/test/java/factory/DriverManager.java) автотестов в Chrome, Firefox, Edge, IE **локально и в гриде** (браузер устанавливается в [general.properties](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/general.properties));
7) [тесты](https://github.com/Idzanaagi/UI-1/blob/main/src/test/resources/cucumber/universalLogin.feature) с BDD (cucumber).

#### Отчёты Allure:
```
mvn clean test 
allure generate --clean
allure open
```

#### параллельный запуск тестов:
- **локально**:
```
mvn test -P parallel
```
-  **в grid**: 
```
 ./src/main/scripts/sh/start-hub.sh 
 ./src/main/scripts/sh/start-node.sh 
 mvn test -P parallel
```
или:
```
.\src\main\scripts\bat\start-hub.bat
.\src\main\scripts\bat\start-node.bat
 mvn test -P parallel
```

#### Структура проекта:
- test/java/pages - описание страниц
- test/java/tests - автотесты
- test/java/utils - утильные классы
- test/java/TestCases.txt - тест-кейсы

#### Чек-лист:
- валидные данные:
 - успешный login
 - успешный logout
- невалидные данные:
  - кнопка login не активна
    - заполнены только 2 поля
    - невалидная длина значения
  - сообщение при неудачном логине
  - сообщения при вводе данных 
  - переполнение полей
