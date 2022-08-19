# Лабораторная работа Camunda BPM
## Бизнес-процесс регистрации пользователя

![N|Solid](https://sun9-41.userapi.com/impg/mM_M8yOE6woPrOvdoqwYZKAq6ZjB2-vfEnS18A/6EayCO7qO-g.jpg?size=936x348&quality=96&sign=9a8b5c6e19949dd345b9a4765c03a963&type=album)

Пользователь вводит данные в форму на отдельном ресурсе, который запускается из папки frontend. Данные приходят в Camunda Tasklist, менеджер определяет, одобрить регистрацию или отклонить. Ответ пользователю приходит на почту, указанную в форме. 

База данных в данном проекте - MySQL.

В папке frontend через терминал в папке server запускаем на локальном сервере html-страницу командами:
```sh
npm install
npm start
```

Одновременно запускаем проект EvstigneevProject. 
Пробуем!