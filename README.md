### Запуск: gradle clean test -DlocalOrRemote=local
## Проект по тестированию сайта "reqres.in"
> <a target="_blank" href="https://reqres.in/">Ссылка на сайт</a>

![Сайт](./design/images/regres.in.jpg "tricentis")

## Проект реализован с использованием
Java11, Gradle, IntelliJ IDEA, Selenide, Selenoid, JUnit5, Jenkins, Allure Report, Allure TestOps, Jira

![This is an image](./design/icons/Java.png)![This is an image](./design/icons/Gradle.png)![This is an image](./design/icons/Intelij_IDEA.png)![This is an image](./design/icons/Selenide.png)![This is an image](./design/icons/Selenoid.png)![This is an image](./design/icons/JUnit5.png)![This is an image](./design/icons/Jenkins.png)![This is an image](./design/icons/Allure_Report.png)![This is an image](./design/icons/AllureTestOps.png)![This is an image](./design/icons/Telegram.png)![This is an image](./design/icons/Jira.png)

## Запуск автотестов выполняется на локальном сервере Jenkins
![Jenkins](./design/images/Jenkins.jpg "Jenkins")

### Параметры сборки
#### Конфиденциальные данные размещены в файлах properties и вызываются в настройках Jenkins
#### Локальный запуск: gradle clean test -DlocalOrRemote=local

#### Удаленный запуск: gradle clean test -DlocalOrRemote=remote
![Confidential_data1](./design/images/Confidential_data.jpg)

## Настроена интеграция с Allure Report
![Allure_Report](./design/images/Allure_Report.jpg)

## Настроена интеграция с Allure TestOps
![Allure_testops](./design/images/Allure_testops.jpg)

## Результаты выполнения тестов интегрированы с Atlassian Jira
![Jira](./design/images/Jira.jpg)


