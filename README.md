# 📚 Book Rental Service (Spring Boot)

Простое RESTful-приложение для управления библиотекой, позволяющее добавлять книги, авторов, регистрировать пользователей и арендовать книги. Реализована авторизация с использованием Bearer токенов.

## 🛠 Стек

- Java 21
- Spring Boot 3.5.3
- Gradle
- PostgreSQL (TODO) (или in-memory-хранилище в dev-профиле)
- Swagger / OpenAPI
- JUnit + RestAssured
- Lombok

## 🧱 Архитектура проекта
Слои:

- **Controller** — приём и обработка HTTP-запросов
- **Exception** - Кастомные исключения и глобальный обработчик ошибок
- **DTO / Entity / Mapper** — передача и преобразование данных
- **Repository** — доступ к данным (in-memory или PostgreSQL)
- **Service** — бизнес-логика

Слои разделены по пакетам и не пересекаются напрямую.

### ✅ Примеры запросов
#### ⭐ Author - Операции с каталогом авторов книг
<details>
<summary>📡 GET /author - Получение список имеющихся авторов книг (Не требует авторизации)</summary>

Тело ответа:
```
[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "authorName": "string"
  }
]
```
</details>

<details>
<summary>📡 POST /author Добавить автора книги (Требуется авторизация)</summary>

Заголовок запроса (Bearer авторизация):
```
Authorization: Bearer your_token
```
Тело запроса:
```
{
  "authorName": "string"
}
```
Тело ответа:
```
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "authorName": "string"
}
```
</details>

#### ⭐ Book - Операции с каталогом названий книг
<details>
<summary>📡 GET /book Получение список имеющихся книг (Не требует авторизации)</summary>

Тело ответа:
```
[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "authorId": "3fa85f64-5717-4562-b3fc-2c963f66afa6", (TODO: добавить расшифровку автора)
    "bookName": "string"
  }
]
```
</details>

<details>
<summary>📡 POST /book Добавить книгу в каталог книг (Требуется авторизация)</summary>

Заголовок запроса (Bearer авторизация):
```
Authorization: Bearer your_token
```
Тело запроса:
```
{
  "authorId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "bookName": "string"
}
```
Тело ответа:
```
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "authorId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "bookName": "string"
}
```
</details>

#### ⭐ BookShelf - Операции с книжной полкой
<details>
<summary>📡 POST /bookshelf/addToBookShelf - Добавить книгу в библиотеку (Требуется авторизация)</summary>

Заголовок запроса (Bearer авторизация):
```
Authorization: Bearer your_token
```
Тело запроса:
```
{
  "bookId": "3fa85f64-5717-4562-b3fc-2c963f66afa6"
}
```
Тело ответа:
```
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "bookId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "rentedByUserId": "3fa85f64-5717-4562-b3fc-2c963f66afa6"
}
```
</details>

#### ⭐ User - Пользовательские операции
<details>
<summary>📡 POST /user/register - Регистрация нового пользователя</summary>

Тело запроса: 
```
{
  "userName": "string",
  "password": "string",
  "age": 0 (TODO: изменить на дату рождения)
}
```
Тело ответа:
```
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "userName": "string",
  "age": 0
}
```

</details>

<details>
<summary>📡 POST /user/getToken - Получить токен авторизации</summary>

Тело запроса:
```
{
  "userName": "string",
  "password": "string"
}
```
Тело ответа:
```
{
  "token": "string"
}
```
</details>

<details>
<summary>📡 GET /user/userInfo - Получить информацию о текущем пользователе</summary>

Заголовок запроса (Bearer авторизация):
```
Authorization: Bearer your_token
```
Тело ответа:
```
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "userName": "string",
  "age": 0
}
```
</details>

## 🗃 Структура базы данных
authors (id, name)\
books (id, title, authorId)\
bookshelf (id, bookId, rentedByUserId)\
users (id, username, password, age)\
userTokens (id, userId, token)

## 🧪 Тестирование

В проекте реализованы **интеграционные тесты**, которые проверяют работу REST API через реальные HTTP-запросы.

Тестирование выполняется с использованием:

- **RestAssured** — для отправки запросов и проверки ответов
- **Java Faker** — для генерации тестовых данных

Все тесты расположены в папке `src/test/java`.

## 🚀 Запуск проекта
1. Клонировать проект ```https://github.com/sergey-dubinin-work/qaguru_basic_homeTask_custom_Spring_API_Service_BookLibrary.git```
2. Запустить сервис ```./gradlew bootRun```
3. Swagger доступен по адресу: ```http://localhost:8081/swagger-ui/index.html```

## TODO (планы на будущее):
1. Добавить проверку наличия дубликатов при создании сущностей (Author, Book)
2. В библиотеке может быть несколько одинаковых книг, каждая из которых берётся в аренду отдельно
3. Найти все книги по автору
4. Посмотреть доступность книг
5. Добавить возможность работы с базами данных (PostgreSql)
6. Шифровать пароли
7. Добавить срок действия токена