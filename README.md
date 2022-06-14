## Сервис курсов валют
Сервис выполняет сравнение курсов валют (вчера/сегодня) результатом является gif.

Сервис использует внешние API:
 - https://api.giphy.com
 - https://openexchangerates.org
### API сервиса
http://localhost:8080/rates/{код_валюты}
например:
```sh
 http://localhost:8080/rates/RUB
 http://localhost:8080/rates/EUR
```
### Запуск приложения
Собрать проект, для этого в корне проект в командной строке выполнить:
```sh
grudle build
```
Сервис запускается в Docker, для этого в корне проекта в командной строке последовательно выполнить команды:
```sh
docker build -t alfatest .
docker-compose up -d
```
Для завершения работы и удаления контейнеров выполнить команду:
```sh
docker-compose down
```

#### Информация по используемым ресурсам:
 - REST API курсов валют - https://docs.openexchangerates.org/
 - REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide

#### Установка Gradle:
https://gradle.org/install/
