# Vaadin TODO

![screenshot](screenshot.png)

Live Demo [HEROKU](https://vaadin-todo-app.herokuapp.com/)
> Настроен автоматический сброс каждый час ;) 


В проекте используются:
- Spring boot [Spring initializr](https://start.spring.io/)
- Spring Data + H2 [Link](https://spring.io/projects/spring-data)
- Vaadin 14 [Project starter](https://vaadin.com/start)
- Библиотека для работы c ics [ICAL4j](https://github.com/ical4j/ical4j)

### Сборка проекта

Прописать в `application.properties` необходимые настройки
```
./mvnw package
```
Собранный **jar** файл будет находиться в `./target`

### Запуск
После сборки находясь в директории проекта
```
java -jar ./target/vaadin-todo-0.0.1-SNAPSHOT.jar
```

Запустить приложение 
```
http://localhost:8080
```

#### Howto Vaadin 14 deploy to Heroku
https://ramonak.io/posts/how-to-deploy-vaadin-14-app-to-heroku