# Отчет о проведенном тестировании


## Описание:
### Было проведено тестирование веб-сервиса покупки путешествия с двумя способами оплаты. В основном тесты были направлены на проверку пользовательского интерфейса, а так же на исполнение платежей
### В ходе тестирования было составлено *18 тест-кейсов*, по 9 на каждый из способов оплаты
### Из них *55.5%* тестов были успешно пройдены, а *44.5%* тестов провалились
## Рекомендации
* Ознакомиться с [баг-репортами](https://github.com/DmitrievDA97/QA_Diploma/issues) по результатам тестирования и исправить
* Исправить ошибку в названии страницы
* Добавить отображение ошибок сразу при выходе из полей, а не после отправки формы
* Добавить отображение оплачиваемой сумму
* Скрывать символы CVC/CVV кода при вводе

Для просмотра отчета *Allure* нужно в терминале ввести команду `gradlew allureServe`