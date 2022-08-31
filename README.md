
# Todo API

Маленькое REST API приложение для работы с списком дел.


## API Reference

#### Получение всех задач

```http
  GET /all
```

#### Добавление новой задачи

```http
  POST /new
```

| Body         | Type     | Description                       | Required |
| :----------- | :------- | :-------------------------------- | :------- |
| `title`      | `string` | Заголовок задачи                  |    true  |
| `body`       | `string` | Описание задачи                   |   true   |

## Installation

Запуск сервера для разработки

```bash
lein ring server-headless
```
    
## Roadmap

- Добавить удаление задач

- Добавить получение задач по айди

- Подключить NoSQL БД

- Добавить тесты

- Добавить дополнительные инструкции для раздела **Installation**