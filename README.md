
product_application — это приложение, разработанное с использованием Spring Boot, для управления продуктами.
Оно предоставляет REST API, который позволяет выполнять CRUD-операции (создание, чтение, обновление, удаление) и различные дополнительные действия, такие как уменьшение количества товаров, подсчёт общей стоимости продуктов по статусу или центру выполнения, 
а также удаление по определённым критериям.

Установка и запуск проекта:
Для запуска приложения необходимы:

Java 17 или выше
Maven 3.8 или выше
PostgreSQL
Git

Шаги установки
1.Клонирование репозитория
Склонируйте проект из GitHub:

git clone https://github.com/AlekseySieger/product_application.git
cd ProductProject

2.Создание базы данных
Убедитесь, что PostgreSQL запущен, и создайте базу данных:
CREATE DATABASE product;

3.Настройка подключения к базе данных
Проверьте, что в файле application.yml указаны следующие настройки:

url: jdbc:postgresql://localhost:5432/product
username: postgres
password: 12345

4.Соберите проект:
mvn clean install

5.Запустите приложение:
mvn spring-boot:run

Инициализация базы данных
При первом запуске Liquibase автоматически создаст таблицу product и заполнит её начальными данными из скрипта.

Доступ к приложению
После успешного запуска приложение будет доступно по адресу:
http://localhost:8080

Документация API
Swagger UI
После запуска приложения вы можете использовать Swagger UI для тестирования API. Оно доступно по адресу:
http://localhost:8080/swagger-ui.html

API документация
Подробное описание API доступно по адресу:
http://localhost:8080/v3/api-docs

Основные API-операции

1.Получение всех продуктов
Метод: GET
URL: /products/all
Возвращает полный список продуктов.

2.Получение продуктов по productId
Метод: GET
URL: /products/get/list/{productId}
Возвращает список продуктов с указанным productId.

3.Получение продукта по id
Метод: GET
URL: /products/get/one/{id}
Возвращает данные продукта по его уникальному id.

4.Добавление нового продукта
Метод: POST
URL: /products/add
Добавляет новый продукт в базу данных.

5.Обновление данных продукта
Метод: PUT
URL: /products/update/{id}
Изменяет информацию о существующем продукте.

6.Удаление продукта по id
Метод: DELETE
URL: /products/delete/{id}
Удаляет продукт с указанным id.

7.Удаление продуктов по productId
Метод: DELETE
URL: /products/delete/list/{productId}
Удаляет все продукты с определённым productId.

8.Фильтрация по статусу
Метод: GET
URL: /products/status
Возвращает список продуктов с указанным статусом.
Пример:
http://localhost:8080/products/status?status=Sellable

9.Общая стоимость продуктов со статусом "Sellable"
Метод: GET
URL: /products/value/status/sellable
Подсчитывает общую стоимость (value) всех продуктов со статусом Sellable.

10.Общая стоимость продуктов по указанному статусу
Метод: GET
URL: /products/value/status
Возвращает общую стоимость продуктов для заданного статуса.
Пример:
http://localhost:8080/products/value/status?status=Inbound

11.Общая стоимость продуктов для Fulfillment Center
Метод: GET
URL: /products/value/fulfillment_center
Возвращает общую стоимость продуктов для указанного Fulfillment Center.
Пример:
http://localhost:8080/products/value/fulfillment_center?ffmCenter=fc5

12.Уменьшение количества продуктов по productId
Метод: PUT
URL: /products/decrease/{productId}
Уменьшает количество продукта с указанным productId на единицу.

13.Уменьшение количества продуктов по id
Метод: PUT
URL: /products/decrease/one/{id}
Уменьшает количество продукта с указанным id на единицу.
