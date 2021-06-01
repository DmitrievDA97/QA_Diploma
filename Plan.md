# ***План автоматизации тестирования покупки тура***
##  *Перечень автоматизируемых сценариев:*


### *Позитивные сценарии:*

№     | Название     | Шаги          | Ожидаемый результат
----- | ------------ | ------------- | -------------------
1 | Покупка по карте с достаточным балансом | 1. Нажать на кнопку "Купить" <br> 2. Ввести номер банковской карты с достаточным балансом <br> 3. Ввести месяц из двух цифр(от 01 до 12) <br> 4. Ввести год из двух цифр <br> 5. Ввести имя и фамилию владельца на латинице <br> 6. Ввести CVC/CVV код из трех цифр <br> 7. Нажать на кнопку "Продолжить"| Форма отправляется, в базе данных появляется запись о покупке со статусом "APPROVED", данные карты не сохраняются, клиент видит надпись "Успешно. Операция одобрена банком."
2 | Покупка в кредит по карте с достаточным балансом | 1. Нажать на кнопку "Купить в кредит" <br> 2. Ввести номер банковской карты с достаточным балансом <br> 3. Ввести месяц из двух цифр(от 01 до 12) <br> 4. Ввести год из двух цифр <br> 5. Ввести имя и фамилию владельца на латинице <br> 6. Ввести CVC/CVV код из трех цифр <br> 7. Нажать на кнопку "Продолжить"| Форма отправляется, в базе данных появляется запись о покупке в кредит со статусом "APPROVED", данные карты не сохраняются, клиент видит надпись "Успешно. Операция одобрена банком."



### *Негативные сценарии:*
№     | Название     | Шаги          | Ожидаемый результат
----- | ------------ | ------------- | -------------------
1 | Покупка по карте с не достаточным балансом | 1. Нажать на кнопку "Купить" <br> 2. Ввести номер банковской карты с не достаточным балансом <br> 3. Ввести месяц из двух цифр(от 01 до 12) <br> 4. Ввести год из двух цифр <br> 5. Ввести имя и фамилию владельца на латинице <br> 6. Ввести CVC/CVV код из трех цифр <br> 6. Нажать на кнопку "Продолжить"| Форма отправляется, в базе данных появляется запись о попытки покупки со статусом "DECLINED", данные карты не сохраняются, клиент видит надпись "Ошибка. Ошибка! Банк отказал в проведение операции."
2 | Покупка в кредит по карте с не достаточным балансом | 1. Нажать на кнопку "Купить в кредит" <br> 2. Ввести номер банковской карты с не достаточным балансом <br> 3. Ввести месяц из двух цифр(от 01 до 12) <br> 4. Ввести год из двух цифр <br> 5. Ввести имя и фамилию владельца на латинице <br> 6. Ввести CVC/CVV код из трех цифр <br> 6. Нажать на кнопку "Продолжить"| Форма отправляется, в базе данных появляется запись о попытки покупки в кредит со статусом "DECLINED", данные карты не сохраняются, клиент видит надпись "Ошибка. Ошибка! Банк отказал в проведение операции."
3 | Ввод невалидного номера карты в форме покупки | 1. Нажать на кнопку "Купить" <br> 2. Ввести невалидный номер карты (меньше 16 цифр) | Поле стало красным, появилась надпись "Неверный формат"
4 | Ввод невалидного месяца в форме покупки | 1. Нажать на кнопку "Купить" <br> 2.Ввести месяц из двух цифр(от 13 до 99) <br> 3. Ввести год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
5 | Ввод прошедшего месяца в форме покупки | 1. Нажать на кнопку "Купить" <br> 2.Ввести прошлый месяц из двух цифр <br> 3. Ввести текущий год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
6 | Ввод прошедшего года в форме покупки | 1. Нажать на кнопку "Купить" <br> 2.Ввести месяц из двух цифр (от 01 до 12) <br> 3. Ввести прошедший год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
7 | Ввод невалидного владельца карты в форме покупки | 1. Нажать на кнопку "Купить" <br> 2. Ввести невалидного владельца карты (на кириллице, с цифрами) | Поле стало красным, появилась надпись "Неверный формат"
8 | Ввод невалидного CVC/CVV кода карты в форме покупки | 1. Нажать на кнопку "Купить" <br> 2. Ввести невалидный CVC/CVV код карты (меньше трёх цифр) | Поле стало красным, появилась надпись "Неверный формат"
9 | Ввод невалидного номера карты в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2. Ввести невалидный номер карты (меньше 16 цифр) | Поле стало красным, появилась надпись "Неверный формат"
10 | Ввод невалидного месяца в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2.Ввести месяц из двух цифр(от 13 до 99) <br> 3. Ввести год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
11 | Ввод прошедшего месяца в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2.Ввести прошлый месяц из двух цифр <br> 3. Ввести текущий год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
12 | Ввод прошедшего года в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2.Ввести месяц из двух цифр (от 01 до 12) <br> 3. Ввести прошедший год из двух цифр <br> | Поля стали красными, появилась надпись "Неверно указан срок действия карты"
13 | Ввод невалидного владельца карты в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2. Ввести невалидного владельца карты (на кириллице, с цифрами) | Поле стало красным, появилась надпись "Неверный формат"
14 | Ввод невалидного CVC/CVV кода карты в форме покупки в кредит | 1. Нажать на кнопку "Купить в кредит" <br> 2. Ввести невалидный CVC/CVV код карты (меньше трёх цифр) | Поле стало красным, появилась надпись "Неверный формат"

## Перечень используемых инструментов
* **Intellij IDEA** - среда разработки для написания автотестов на языке Java
* **Gradle** - фреймворк для автоматизации сборки проектов
* **JUnit5** - платформа для написания автотестов и их запуска
* **Selenide** - фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver
* **Faker** - библиотека, которую можно использовать для создания широкого спектра реальных данных
* **AppVeyor** - распределённый веб-сервис непрерывной интеграции, предназначенный для сборки и тестирования программного обеспечения расположенного на GitHub
* **Docker** - для автоматизации развёртывания и управления приложениями в средах с поддержкой контейнеризации

## Перечень и описание возможных рисков при автоматизации
* Отсутствие доступа к СУБД приведет к невозможности полноценного тестирования
* Изменения в коде сервиса могут привести к неактуальности автотестов
* Отсутствие локаторов увеличит время написания автотестов

## Интервальная оценка с учётом рисков
* На автоматизацию тестирования сервиса понадобится от 72 до 80 часов (9-10 рабочих дней)

## План сдачи работ
* Автоматизация - 11.06.2021
* Отчётные документы по итогам тестирования - 15.06.2021
* Отчётные документы по итогам автоматизации - 16.06.2021