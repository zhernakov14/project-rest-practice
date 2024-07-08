REST-API проект на Spring Boot.
В БД две сущности - сенсоры и измерения с этих сенсоров.
Возможности:  
  1) регистрация нового сенсора - POST /sensors/registration;
  2) добавление нового измерения - POST /measurements/add
     формат JSON
     ![image](https://github.com/zhernakov14/project-rest-practice/assets/54941157/4fc005ab-864b-492f-b1cb-9f72011a7758)
  3) получение всех измерений - GET /measurements;
  4) получение количества дождлиавых дней - GET /measurements/rainyDaysCount.

Реализованы следующие модули взаимодействия:
Клиент <-> Сервис <-> Репозиторий

Для передачи данных используются DTO, также существует валидация на полях.        
