<h1 align="left"><img src="https://github.com/vadimsa3/contact-book/blob/master/src/main/resources/raw/image.gif" height="70"/></h1>
<h1 align="center">КОНТАКТЫ</h1>
<h2 align="center">Консольное приложение с возможностью добавлять контакты в базу, редактировать контакты, удалять контакты из базы.</h2>

## **СОДЕРЖАНИЕ:** ##
* [ПОДГОТОВКА К ЗАПУСКУ](#инструкция_по_запуску)
* [ЗАПУСК И РАБОТА ПРИЛОЖЕНИЯ](#запуск_и_работа)
  
<a name="инструкция_по_запуску"></a>
## **ИНСТРУКЦИЯ ПО ЗАПУСКУ** ##

**1. Проверьте установлены-ли следующие компоненты и установите при их отсутствии:**
* Java Development Kit (JDK) версии 17 или выше.
* Apache Maven фреймворк для автоматизации сборки проектов.

**2. Клонируйте репозиторий.**  
Клонируйте репозиторий с кодом проекта на свой локальный компьютер:  
git clone https://github.com/vadimsa3/contact-book/

**3. Настройте Ваш файл конфигурации application.yaml.**  

* Внесите корректировки в абсолютный путь к Вашему файлу - базе контактов (загружаемой при выборе активного профиля default-contacts.txt и contacts.txt) и базе контактов (сохраняемой при завершении работы contacts.txt):
    пример: file-load: D:\\SAVCHUK\\SKILLBOX\\Spring\\contact-book\\src\\main\\resources\\default-contacts.txt
* Выберите предпочтительный активный профиль:
    - init - будут загружены контакты из default-contacts.txt (список контактов по умолчанию)
    - read - будут загружены контакты из contacts.txt (список контактов из contacts.txt, сохраненного в предыдущем сеансе)
    - default - профиль по умолчанию, при отсутствии явно выбранного профиля (будут загружены контакты из contacts.txt, сохраненного в предыдущем сеансе)
      
<a name="запуск_и_работа"></a>  
## **ЗАПУСК И РАБОТА ПРИЛОЖЕНИЯ** ##

1. Запустите приложение:
   - посредством IntelliJ IDEA
   - запуск JAR-файла из командной строки: 
       java -jar D:\SAVCHUK\SKILLBOX\Spring\contact-book\target\contact-book-1.0-SNAPSHOT.jar - для Windows (с учетом правильного расположения файла)
     
3. Следуйте командам главного меню.
   
   ![Изображение](https://github.com/vadimsa3/contact-book/blob/master/src/main/resources/raw/MainMenu.jpg "Главное меню")

Перечень команд для работы с контактами:
 * 1 Получение списка контактов.
       Будут выведены все имеющиеся контакты в формате «Ф. И. О. | Номер телефона | Адрес электронной почты».
 *   2 Добавление нового контакта в список.
       Будет добавлен новый контакт в список контактов. Формат ввода: Ф. И. О. номер телефона адрес электронной почты.
 *   3 Удаление контакта по email.
       Будет удален контакт из списка по введенному email.
 *   4 Поиск контакта по email.
       Будет найден контакт из списка по введенному email.
 *  5 Выход (с сохранением изменений).
       Будет сохранено текущее состояние списка контактов в текстовый файл и завершена работа программы.

   ![](https://img.shields.io/badge/ВНИМАНИЕ!-FF0000) ***При принудительном завершении работы программы текущее состояние списка контактов сохранено не будет.***
